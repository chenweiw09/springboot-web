package com.xiaomi.chen.springboottest.dao

import com.xiaomi.chen.springboottest.domain.User
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.PagingAndSortingRepository

import java.util.Optional

/**
 * @author chenwei
 * @version 1.0
 * @date 2018/12/12
 * @description
 */

interface UserDao : PagingAndSortingRepository<User, Long>, JpaSpecificationExecutor<User> {

    fun findOneByUserName(userName: String): Optional<User>
}
