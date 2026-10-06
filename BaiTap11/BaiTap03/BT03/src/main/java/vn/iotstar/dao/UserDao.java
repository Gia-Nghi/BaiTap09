package vn.iotstar.dao;

import vn.iotstar.model.User;

public interface UserDao {

	User get(String username);

	void insert(User user);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

	boolean checkExistPhone(String phone);

	boolean verifyOtp(String email, String otp);

	boolean updateOtp(String email, String otp, java.util.Date expiry);

	boolean verifyForgotPasswordOtp(String email, String otp);

	boolean updatePassword(String email, String newPassword);

	User getByEmail(String email);
}