package com.zyz.thread.threadpool.atomic;


/**
 * User: 张月忠
 * Date: 2017/8/3
 * Time: 下午5:11
 * To change this template use File | Settings | File Templates.
 */

public class MyIntegerTest {
    public static void main(String[] args) throws InterruptedException {
        MyInteger integer = new MyInteger(0);
        Thread[] threads = new Thread[3];

        threads[0] = new Thread(new MyIntegerTask("A",integer));
        threads[1] = new Thread(new MyIntegerTask("B",integer));
        threads[2] = new Thread(new MyIntegerTask("C",integer));
        for(Thread thread:threads){
            thread.start();
        }

        new Thread(new MyIntegerIncreaseTask(integer)).start();

        Thread.sleep(1000*10);
        System.out.println("end...");
    }
}
