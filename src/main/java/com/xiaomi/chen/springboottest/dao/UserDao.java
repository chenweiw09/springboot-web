package com.xiaomi.chen.springboottest.dao;

import com.xiaomi.chen.springboottest.domain.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

/**
 * @author chenwei
 * @version 1.0
 * @date 2018/12/12
 * @description
 */

public interface UserDao extends PagingAndSortingRepository<User, Long>,JpaSpecificationExecutor<User> {

    Optional<User> findOneByUserName(String userName);
}
