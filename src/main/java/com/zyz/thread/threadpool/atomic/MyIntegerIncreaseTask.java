package com.zyz.thread.threadpool.atomic;

/**
 * User: 张月忠
 * Date: 2017/8/3
 * Time: 下午5:18
 * To change this template use File | Settings | File Templates.
 */

public class MyIntegerIncreaseTask implements Runnable {
    private MyInteger myInteger;

    public MyIntegerIncreaseTask(MyInteger myInteger) {
        this.myInteger = myInteger;
    }

    @Override
    public void run() {
        while (true){
            int i = myInteger.incrementAndGet();
            System.out.println("current...."+i);
            if(i>10)
                break;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
