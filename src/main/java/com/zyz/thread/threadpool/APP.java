package com.zyz.thread.threadpool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * User: 张月忠
 * Date: 2017/7/11
 * Time: 下午8:34
 * To change this template use File | Settings | File Templates.
 */

public class APP {
    public static void main(String[] args){
        Long startTime = System.currentTimeMillis();
        Integer integer = startJob();
        Long end = System.currentTimeMillis();

        System.out.println("*******返回了结果 我可以做其他事情了,线程创建了"+(end-startTime)) ;
    }

    public static Integer startJob(){
        Server server = new Server();
        for(int i=0;i<3;i++){
            Task task = new Task("task"+i);
            server.execute(task);
        }

        try {

            while (server.getThreadPoolExecutor().getCompletedTaskCount()<3){
                TimeUnit.SECONDS.sleep(2);
            }
            System.out.println("做完了。。。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        server.shutDown();
        return  1;
    }
}
