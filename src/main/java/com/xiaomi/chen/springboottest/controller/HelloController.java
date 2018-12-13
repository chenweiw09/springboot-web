package com.xiaomi.chen.springboottest.controller;

import com.xiaomi.chen.springboottest.service.HelloService;
import com.xiaomi.chen.springboottest.view.HelloView;
import com.xiaomi.chen.springboottest.view.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenwei
 * @version 1.0
 * @date 2018/9/27
 * @description
 */
@RestController
public class HelloController {

    @Resource
    private HelloService helloService;

    @GetMapping("/test")
    public HelloView hello(@RequestParam String parmId){
        System.out.println(parmId);
        List<Student> list = helloService.getStudentList(2);
        System.out.println(list.get(0).getStudentNo());
        HelloView view = new HelloView();
        view.setCode(0);
        view.setMsg("ok");
        view.setData(list);
        return view;
    }

    @GetMapping("/exp")
    public HelloView exp(){
       throw new RuntimeException("test controller advice");
    }

}
