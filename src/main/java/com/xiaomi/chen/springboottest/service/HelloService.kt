package com.xiaomi.chen.springboottest.service

import com.xiaomi.chen.springboottest.view.Student
import org.springframework.stereotype.Service

import java.util.LinkedList

/**
 * @author chenwei
 * @version 1.0
 * @date 2018/9/27
 * @description
 */
@Service
class HelloService {

    fun getStudentList(i: Int): List<Student> {
        val list = LinkedList<Student>()
        for (j in 0 until i) {
            list.add(initStudent(null))
        }

        return list

    }


    private fun initStudent(student: Student?): Student {
        return when(student) {
            null -> {
                Student().apply {
                    name = "chenwei"
                    age = 20
                    amount = 7858956L
                    studentNo = 2264
                }
            }

            else -> {
                student.studentNo += 1
                student
            }
        }
    }
}
