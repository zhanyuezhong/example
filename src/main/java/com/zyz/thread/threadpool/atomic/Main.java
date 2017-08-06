package com.zyz.thread.threadpool.atomic;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: 张月忠
 * Date: 2017/8/3
 * Time: 下午4:58
 * To change this template use File | Settings | File Templates.
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger integer = new AtomicInteger(0);
        Thread[] threads = new Thread[3];
        threads[0] = new Thread(new AtomicIntegerTask(integer,"A"));
        threads[1] = new Thread(new AtomicIntegerTask(integer,"B"));
        threads[2] = new Thread(new AtomicIntegerTask(integer,"C"));
        for(Thread thread:threads){
            thread.start();
        }
        Thread.sleep(1000*10);
        System.out.println("end...");
    }
}
