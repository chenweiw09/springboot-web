package com.xiaomi.chen.springboottest.scheduler;

import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.TimeUnit;

/**
 * @author chenwei
 * @version 1.0
 * @date 2018/12/11
 * @description
 */
public class SpringTaskScheduler {

    private final ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();

    public SpringTaskScheduler(Runnable task){
        scheduler.setPoolSize(2);
        scheduler.initialize();
        scheduler.scheduleWithFixedDelay(task, 2000);
    }

    private int i =0;


    public static void main(String[] args) {

        Runnable task = () ->{
            System.out.println("a");
        };
        SpringTaskScheduler springTaskScheduler = new SpringTaskScheduler(task);

    }
}
