package com.zyz.thread.threadpool;

/**
 * User: 张月忠
 * Date: 2017/7/11
 * Time: 下午8:34
 * To change this template use File | Settings | File Templates.
 */

public class APP {
    public static void main(String[] args){
        Server server = new Server();

        for(int i=0;i<5;i++){
            Task task = new Task("task"+i);
            server.execute(task);
        }

        server.shutDown();
    }
}
