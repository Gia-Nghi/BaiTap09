package vn.iotstar.de1_22133037.service;

import vn.iotstar.de1_22133037.dao.UserDAO_22133037;
import vn.iotstar.de1_22133037.dao.UserDAOImpl_22133037;
import vn.iotstar.de1_22133037.entity.User_22133037;

import java.security.MessageDigest;
import java.time.LocalDateTime;

public class UserService_22133037 {

    private final UserDAO_22133037 dao =
            new UserDAOImpl_22133037();

    public User_22133037 login(
            String email,
            String password) {

        return dao.login(
                email,
                md5(password)
        );
    }

    public User_22133037 findByEmail(
            String email) {

        return dao.findByEmail(email);
    }

    public void register(
            User_22133037 user) {

        user.setPasswd(
                md5(user.getPasswd())
        );

        user.setSignupDate(
                LocalDateTime.now()
        );

        user.setIsAdmin(false);

        dao.save(user);
    }

    public void updateLastLogin(
            User_22133037 user) {

        user.setLastLogin(
                LocalDateTime.now()
        );

        dao.update(user);
    }

    public String md5(String text) {

        try {

            MessageDigest md =
                    MessageDigest.getInstance("MD5");

            byte[] bytes =
                    md.digest(
                            text.getBytes()
                    );

            StringBuilder sb =
                    new StringBuilder();

            for (byte b : bytes) {

                sb.append(
                        String.format(
                                "%02x",
                                b
                        )
                );
            }

            return sb.toString();

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }
}