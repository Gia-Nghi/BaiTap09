package vn.iotstar.service.impl;

import vn.iotstar.dao.UserDao;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.model.User;
import vn.iotstar.service.UserService;
import vn.iotstar.util.SendEmail;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();

	@Override
	public User login(String username, String password) {
		User user = this.get(username);
		if (user != null && password.equals(user.getPassWord())) {
			return user;
		}
		return null;
	}

	@Override
	public User get(String username) {
		return userDao.get(username);
	}

	@Override
	public boolean register(String username, String password, String email, String fullname, String phone) {

		if (userDao.checkExistUsername(username)) {
			return false;
		}

		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);

		User user = new User(email, username, fullname, password, null, 5, phone, date);

		String otp = String.valueOf((int) (Math.random() * 900000) + 100000);

		user.setOtp(otp);

		user.setOtpExpiry(new java.util.Date(System.currentTimeMillis() + 5 * 60 * 1000));

		user.setActive(false);

		userDao.insert(user);

		SendEmail.sendOtp(email, otp);

		return true;
	}

	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}

	@Override
	public void insert(User user) {
		userDao.insert(user);
	}

	@Override
	public boolean verifyOtp(String email, String otp) {
		return userDao.verifyOtp(email, otp);
	}

	@Override
	public boolean forgotPassword(String email) {

		if (!userDao.checkExistEmail(email)) {
			return false;
		}

		String otp = String.valueOf((int) (Math.random() * 900000) + 100000);

		java.util.Date expiry = new java.util.Date(System.currentTimeMillis() + 5 * 60 * 1000);

		boolean updated = userDao.updateOtp(email, otp, expiry);

		if (updated) {

			SendEmail.sendOtp(email, otp);

			return true;
		}

		return false;
	}

	@Override
	public boolean verifyForgotPasswordOtp(String email, String otp) {

		return userDao.verifyForgotPasswordOtp(email, otp);
	}

	@Override
	public boolean resetPassword(String email, String newPassword) {

		return userDao.updatePassword(email, newPassword);
	}

}