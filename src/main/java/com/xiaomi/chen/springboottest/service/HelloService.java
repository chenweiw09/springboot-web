package com.xiaomi.chen.springboottest.service;

import com.xiaomi.chen.springboottest.view.Student;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author chenwei
 * @version 1.0
 * @date 2018/9/27
 * @description
 */
@Service
public class HelloService {

    public List<Student> getStudentList(int i){
        List<Student> list = new LinkedList<>();
        for(int j=0;j<i;j++){
            list.add(initStudent(null));
        }

        return list;

    }


    private Student initStudent(Student student){
        if(student == null){
            student = new Student();
            student.setName("chenwei");
            student.setAge(30);
            student.setAmount(88978L);
            student.setStudentNo(2284);
        }else{
            student.setStudentNo(student.getStudentNo()+1);
        }

        System.out.println("init student--------"+student.toString());
        return student;

    }
}
