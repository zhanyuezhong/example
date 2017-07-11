package com.zyz.threadpool;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * User: 张月忠
 * Date: 2017/7/11
 * Time: 下午8:22
 * To change this template use File | Settings | File Templates.
 */

public class Task implements Runnable {
    private String name;

    private Date initDate;

    public Task(String name) {
        this.name = name;
        this.initDate = new Date();
    }

    @Override
    public void run() {
        System.out.printf("name:%s \n",name);
        System.out.printf("initDate :%s \n",initDate.toLocaleString());

        long time = (long)(Math.random()*30);


        try {
            TimeUnit.SECONDS.sleep(time);
            System.out.printf("doing job in %d \n",time);
            System.out.printf("%s thread done \n",Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
