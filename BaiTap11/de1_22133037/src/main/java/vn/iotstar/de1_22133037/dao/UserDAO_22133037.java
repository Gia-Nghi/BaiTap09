package vn.iotstar.de1_22133037.dao;

import vn.iotstar.de1_22133037.entity.User_22133037;

public interface UserDAO_22133037 {

    User_22133037 login(
            String email,
            String password
    );

    User_22133037 findByEmail(String email);

    User_22133037 save(User_22133037 user);

    void update(User_22133037 user);
}