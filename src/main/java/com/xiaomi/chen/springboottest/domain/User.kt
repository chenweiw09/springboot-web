package com.xiaomi.chen.springboottest.domain

import java.util.*
import javax.persistence.*

/**
 * @author chenwei
 * @version 1.0
 * @date 2018/12/12
 * @description
 */
@Entity
@Table(name="user")
class User{
    @Id
    @GeneratedValue
    @Column(name="id")
    var id = 0

    @Column(name="user_id")
    var userId=0L

    @Column(name="user_name")
    var userName=""

    @Column(name="nick_name")
    var nickName=""

    @Column(name="password")
    var password=""

    @Column(name="create_time")
    var createTime: Date ?=null

    @Column(name="update_time")
    var updateTime: Date ? = null
}
