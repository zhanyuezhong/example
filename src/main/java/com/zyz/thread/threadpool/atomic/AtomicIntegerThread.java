package com.zyz.thread.threadpool.atomic;/**
 * Created by zyz46160 on 2017/8/5.
 */

import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: 张月忠
 * Date: 2017/8/5  13:16
 */
public class AtomicIntegerThread extends Thread {
    AtomicInteger integer;
    String name;
    public AtomicIntegerThread(String name, AtomicInteger integer) {
        super(name);
        this.integer = integer;
        this.name = name;
    }

    @Override
    public void run() {
        int i = integer.incrementAndGet();
        System.out.println(name+"===="+i);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        i = integer.get();
        System.out.println(name+"===="+i);
    }
}
