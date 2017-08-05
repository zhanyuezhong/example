package com.zyz.thread.threadpool.atomic;/**
 * Created by zyz46160 on 2017/8/5.
 */

import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: 张月忠
 * Date: 2017/8/5  13:23
 */
public class AtomicTest {
    public static void main(String[] args){
        AtomicInteger integer = new AtomicInteger(0);
        Thread[] threads = new Thread[3];
        for(int i=0;i<3;i++){
            threads[i] = new AtomicIntegerThread(i+"",integer);
            threads[i].start();
        }


    }
}
