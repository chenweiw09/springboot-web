package com.xiaomi.chen.springboottest.service

import com.xiaomi.chen.springboottest.dao.UserDao
import com.xiaomi.chen.springboottest.domain.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * @author chenwei
 * @version 1.0
 * @date 2018/12/12
 * @description
 */
@Service
class UserService ( @Autowired private val userDao: UserDao){

    fun saveUser(user: User): User {
        return userDao.save(user)
    }

    fun getUserByUserName(userName: String): User {
        return userDao.findOneByUserName(userName).get()
    }
}