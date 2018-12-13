package com.xiaomi.chen.springboottest.service

import java.util.concurrent.ConcurrentHashMap

/**
 * Created by Wei Chen on 20:59 2018/12/12.
 */

data class User(val id:Int, val groupId:Int)

fun main() {
    val a = ConcurrentHashMap<Int, Set<Int>>()

    val users = listOf<User>()

    users.forEach {
        a.compute(it.groupId) {_, userIds ->
            (userIds ?: emptySet()) + it.id
        }
    }



}