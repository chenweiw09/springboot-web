package com.xiaomi.chen.springboottest.view


/**
 * Created by Wei Chen on 18:15 2018/9/27.
 */


class HelloView {
    var code = 0
    var msg = ""
    var data = listOf<Student>()

}


open class Person{
    var name = ""
    var age = 0
    var amount=0L
}


class Student : Person() {
    var studentNo = 0L

}