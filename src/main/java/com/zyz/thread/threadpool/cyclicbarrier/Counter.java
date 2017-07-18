package com.zyz.thread.threadpool.cyclicbarrier;/**
 * Created by zyz46160 on 2017/7/16.
 */

/**
 * User: 张月忠
 * Date: 2017/7/16  14:02
 */
public class Counter implements Runnable {
    private Result result;

    public Counter(Result result) {
        this.result = result;
    }

    @Override
    public void run() {
        int counter = 0;
        for(int i:result.getData()){
            counter+= i;
        }
        System.out.println("real:"+counter);
    }
}
