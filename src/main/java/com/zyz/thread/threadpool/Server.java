package com.zyz.thread.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * User: 张月忠
 * Date: 2017/7/11
 * Time: 下午8:29
 * To change this template use File | Settings | File Templates.
 */

public class Server {

    private ThreadPoolExecutor threadPoolExecutor;

    public Server() {
        this.threadPoolExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    }

    public void execute(Task task){

        System.out.printf("pool size %d \n",threadPoolExecutor.getPoolSize());
        System.out.printf("pool active %d \n",threadPoolExecutor.getActiveCount());
        System.out.printf("pool compelete %d \n",threadPoolExecutor.getCompletedTaskCount());

        threadPoolExecutor.execute(task);
        System.out.println("=================done==============");
        System.out.printf("pool active %d \n",threadPoolExecutor.getActiveCount());
        System.out.printf("pool compelete %d \n",threadPoolExecutor.getCompletedTaskCount());

    }

    public void shutDown(){
        System.out.println("=================shutdown==============");
        threadPoolExecutor.shutdown();
    }

    public ThreadPoolExecutor getThreadPoolExecutor() {
        return threadPoolExecutor;
    }

    public void setThreadPoolExecutor(ThreadPoolExecutor threadPoolExecutor) {
        this.threadPoolExecutor = threadPoolExecutor;
    }
}
