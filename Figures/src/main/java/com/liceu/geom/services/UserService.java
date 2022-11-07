package com.liceu.geom.services;

import com.liceu.geom.DAO.UserDao;
import com.liceu.geom.DAO.UserDaoImpl;
import com.liceu.geom.model.User;

public class UserService {
    UserDao userDao = new UserDaoImpl();

    public void login(String userName) {
        User user = new User(userName);
        userDao.login(user);
    }

    public User getUser(String userName) {
        return userDao.getUser(userName);
    }

}
