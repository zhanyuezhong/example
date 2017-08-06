package com.zyz.thread.threadpool.atomic;

/**
 * User: 张月忠
 * Date: 2017/8/3
 * Time: 下午5:06
 * To change this template use File | Settings | File Templates.
 */

public class MyInteger {
    private int value;

    public MyInteger(int initValue) {
        this.value = value;
    }

    public synchronized int getValue() {
        return value;
    }

    public synchronized void setValue(int value) {
        this.value = value;
    }

    public synchronized int incrementAndGet(){
        int old = this.getValue();
        int newVal = old+1;
        this.setValue(newVal);
        return  newVal;
    }
}
