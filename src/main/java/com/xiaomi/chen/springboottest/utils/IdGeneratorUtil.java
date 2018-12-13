package com.xiaomi.chen.springboottest.utils;

import com.google.common.base.Preconditions;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;

/**
 * @author chenwei
 * @version 1.0
 * @date 2018/11/19
 * @description snowflake : 0-00000000000000000000000000000000000000000-0000000000-000000000000
 */
public class IdGeneratorUtil {
    /**
     * 时间偏移量，从2016年1月1日零点开始
     */
    public static final long EPOCH;

    /**
     * 自增量占用比特
     */
    private static final long SEQUENCE_BITS = 12L;
    /**
     * 工作进程ID比特
     */
    private static final long WORKER_ID_BITS = 10L;
    /**
     * 自增量掩码（最大值）
     */
    private static final long SEQUENCE_MASK = (1 << SEQUENCE_BITS) - 1;
    /**
     * 工作进程ID左移比特数（位数）
     */
    private static final long WORKER_ID_LEFT_SHIFT_BITS = SEQUENCE_BITS;
    /**
     * 时间戳左移比特数（位数）
     */
    private static final long TIMESTAMP_LEFT_SHIFT_BITS = WORKER_ID_LEFT_SHIFT_BITS + WORKER_ID_BITS;
    /**
     * 工作进程ID最大值
     */
    private static final long WORKER_ID_MAX_VALUE = 1L << WORKER_ID_BITS;

    /**
     * 工作进程ID
     */
    private static long workerId;

    /**
     * 最后自增量
     */
    private long sequence;
    /**
     * 最后生成编号时间戳，单位：毫秒
     */
    private long lastTime;

    static {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, Calendar.FEBRUARY, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        EPOCH = calendar.getTimeInMillis();
    }

    /**
     * 设置工作线程id
     * @param workerId
     */
    public static void setWorkerId(final long workerId){
        IdGeneratorUtil.workerId = workerId;
    }


    /**
     * 生成Id.
     *
     * @return 返回@{@link Long}类型的Id
     */

    public synchronized Number generateKey() {
        // 保证当前时间大于最后时间。时间回退会导致产生重复id
        long currentMillis = System.currentTimeMillis();
        Preconditions.checkState(lastTime <= currentMillis, "时间不正确, last time is %d milliseconds, current time is %d milliseconds", lastTime, currentMillis);
        // 获取序列号
        if (lastTime == currentMillis) {
            // 当获得序号超过最大值时，归0，并去获得新的时间
            if (0L == (sequence = ++sequence & SEQUENCE_MASK)) {
                currentMillis = waitUntilNextTime(currentMillis);
            }
        } else {
            sequence = 0;
        }
        // 设置最后时间戳
        lastTime = currentMillis;

        return ((currentMillis - EPOCH) << TIMESTAMP_LEFT_SHIFT_BITS) | (workerId << WORKER_ID_LEFT_SHIFT_BITS) | sequence;
    }

    /**
     * 不停获得时间，直到大于最后时间
     * @param lastTime 最后时间
     * @return 时间
     */
    private long waitUntilNextTime(final long lastTime) {
        long time = System.currentTimeMillis();
        while (time <= lastTime) {
            time = System.currentTimeMillis();
        }
        return time;
    }


    /**
     * 通过IP地址获取线程id，但是如果系统都是在同一台服务器上，所以这个方法不行(这里我们直接指定)
     */
    public static void initWorkId(){
        InetAddress address;

        try {
            address = InetAddress.getLocalHost();
        } catch (final UnknownHostException e) {
            throw new IllegalStateException("Cannot get LocalHost InetAddress, please check your network!");
        }

        byte[] ipAddressByteArray = address.getAddress();
        long workerId = 0L;

        // IPV4
        if (ipAddressByteArray.length == 4) {
            for (byte byteNum : ipAddressByteArray) {
                workerId += byteNum & 0xFF;
            }
            // IPV6
        } else if (ipAddressByteArray.length == 16) {
            for (byte byteNum : ipAddressByteArray) {
                workerId += byteNum & 0B111111;
            }
        } else {
            throw new IllegalStateException("获取IP异常!");
        }
        IdGeneratorUtil.setWorkerId(workerId);
    }



}

