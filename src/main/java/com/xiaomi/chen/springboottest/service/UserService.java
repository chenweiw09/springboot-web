package com.xiaomi.chen.springboottest.service;

import com.xiaomi.chen.springboottest.dao.UserDao;
import com.xiaomi.chen.springboottest.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenwei
 * @version 1.0
 * @date 2018/12/12
 * @description
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User saveUser(User user) {
        return userDao.save(user);
    }

    public User getUserByUserName(String userName) {
        return userDao.findOneByUserName(userName).get();
//    }

//        public User getUserByUserName(String userName){
//            User user = new User();
//            user.setUserName(userName);
//            user.setPassword("123");
//            user.setUserId(1);
//            return user;
//    }
    }
}