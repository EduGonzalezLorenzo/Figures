package com.liceu.geom.DAO;

import com.liceu.geom.model.User;

public interface UserDao {
    void login(User user);
    void saveUser(User user);
    User getUser(String userName);
}
