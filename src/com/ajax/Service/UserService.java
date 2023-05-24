package com.ajax.Service;

import com.ajax.dao.UserDao;
import com.ajax.entity.User;

/**
 * @author 马海鑫
 * @version 1.0
 */

//UserService提供业务方法
public class UserService {

    private UserDao userDao = new UserDao();

    public User getUserByName(String username){
        User user = userDao.querySingle("select * from `user` where username=?", User.class, username);

        return user;
    }
}
