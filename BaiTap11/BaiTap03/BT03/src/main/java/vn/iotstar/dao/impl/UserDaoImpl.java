package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.dao.UserDao;
import vn.iotstar.model.User;

public class UserDaoImpl implements UserDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public User get(String username) {

		String sql = "SELECT * FROM [User] WHERE username = ?";

		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);

			rs = ps.executeQuery();

			if (rs.next()) {

				User user = new User(rs.getString("email"), rs.getString("username"), rs.getString("fullname"),
						rs.getString("password"), rs.getString("avatar"), rs.getInt("roleid"), rs.getString("phone"),
						rs.getTimestamp("createddate"));

				user.setId(rs.getInt("id"));

				user.setOtp(rs.getString("otp"));
				user.setOtpExpiry(rs.getTimestamp("otp_expiry"));
				user.setActive(rs.getBoolean("is_active"));

				return user;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void insert(User user) {

		String sql = "INSERT INTO dbo.[User] " + "(email, username, fullname, password, avatar, roleid, "
				+ "phone, createddate, otp, otp_expiry, is_active) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {

			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);

			ps.setString(1, user.getEmail());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getFullName());
			ps.setString(4, user.getPassWord());
			ps.setString(5, user.getAvatar());
			ps.setInt(6, user.getRoleid());
			ps.setString(7, user.getPhone());

			ps.setTimestamp(8, new java.sql.Timestamp(user.getCreatedDate().getTime()));

			ps.setString(9, user.getOtp());

			if (user.getOtpExpiry() != null) {
				ps.setTimestamp(10, new java.sql.Timestamp(user.getOtpExpiry().getTime()));
			} else {
				ps.setNull(10, java.sql.Types.TIMESTAMP);
			}

			ps.setBoolean(11, user.isActive());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		String query = "select * from [user] where email = ?";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String query = "select * from [User] where username = ?";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	@Override
	public boolean checkExistPhone(String phone) {
		String sql = "SELECT 1 FROM [User] WHERE phone = ?";

		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, phone);

			rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean verifyOtp(String email, String otp) {

		String sql = "SELECT * FROM [User] " + "WHERE email = ? AND otp = ? AND otp_expiry > GETDATE()";

		try {
			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, otp);

			rs = ps.executeQuery();

			if (rs.next()) {

				String updateSql = "UPDATE [User] " + "SET is_active = 1, otp = NULL, otp_expiry = NULL "
						+ "WHERE email = ?";

				ps = conn.prepareStatement(updateSql);
				ps.setString(1, email);

				ps.executeUpdate();

				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public User getByEmail(String email) {

		String sql = "SELECT * FROM [User] WHERE email = ?";

		try {
			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);

			ps.setString(1, email);

			rs = ps.executeQuery();

			if (rs.next()) {

				User user = new User(rs.getString("email"), rs.getString("username"), rs.getString("fullname"),
						rs.getString("password"), rs.getString("avatar"), rs.getInt("roleid"), rs.getString("phone"),
						rs.getTimestamp("createddate"));

				user.setId(rs.getInt("id"));
				user.setOtp(rs.getString("otp"));
				user.setOtpExpiry(rs.getTimestamp("otp_expiry"));
				user.setActive(rs.getBoolean("is_active"));

				return user;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean updateOtp(String email, String otp, java.util.Date expiry) {

		String sql = "UPDATE [User] " + "SET otp = ?, otp_expiry = ? " + "WHERE email = ?";

		try {

			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);

			ps.setString(1, otp);

			ps.setTimestamp(2, new java.sql.Timestamp(expiry.getTime()));

			ps.setString(3, email);

			int result = ps.executeUpdate();

			return result > 0;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean verifyForgotPasswordOtp(String email, String otp) {

		String sql = "SELECT * FROM [User] " + "WHERE email = ? " + "AND otp = ? " + "AND otp_expiry > GETDATE()";

		try {

			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);

			ps.setString(1, email);
			ps.setString(2, otp);

			rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean updatePassword(String email, String newPassword) {

		String sql = "UPDATE [User] " + "SET password = ?, " + "otp = NULL, " + "otp_expiry = NULL "
				+ "WHERE email = ?";

		try {

			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);

			ps.setString(1, newPassword);

			ps.setString(2, email);

			int result = ps.executeUpdate();

			return result > 0;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}
}
