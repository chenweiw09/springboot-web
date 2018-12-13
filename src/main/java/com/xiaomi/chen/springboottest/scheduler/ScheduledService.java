package com.xiaomi.chen.springboottest.scheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author chenwei
 * @version 1.0
 * @date 2018/12/11
 * @description
 */
public class ScheduledService {

    final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);

    final Runnable beeper = () -> {
        int randomInt = ThreadLocalRandom.current().nextInt(10);
        System.out.println(randomInt);
    };

    public ScheduledService(){
        scheduledExecutorService.scheduleWithFixedDelay(beeper, 3,5, TimeUnit.SECONDS);
        while (!scheduledExecutorService.isShutdown()){

        }
    }

    public static void main(String[] args) {

        ScheduledService scheduledService = new ScheduledService();
    }


}
