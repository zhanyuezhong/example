package com.zyz.thread.threadpool.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: 张月忠
 * Date: 2017/8/3
 * Time: 下午4:48
 * To change this template use File | Settings | File Templates.
 */

public class AtomicIntegerTask implements Runnable {

    private AtomicInteger  counter;

    private String name;

    public AtomicIntegerTask(AtomicInteger counter, String name) {
        this.counter = counter;
        this.name = name;
    }

    @Override
    public void run() {
        //if("A")
        while (true){
            counter.incrementAndGet();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name+"..."+counter.get());
            if("A".equals(name)&&counter.get()==5){
                System.out.println("A thread exit");
                break;
            }else if("B".equals(name)&&counter.get()==6){
                System.out.println("B thread exit");
                break;
            }else if("C".equals(name)&&counter.get()==7){
                System.out.println("C thread exit");
                break;
            }
        }
    }
}
