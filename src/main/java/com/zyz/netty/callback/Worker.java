package com.zyz.netty.callback;

/**
 * User: 张月忠
 * Date: 2017/7/18
 * Time: 下午5:14
 * To change this template use File | Settings | File Templates.
 */

public class Worker {

    public static void doWork(){
        Fetcher fetcher = new MyFetcher();
        fetcher.fetcher(new FetcherCallBack() {
            @Override
            public void OnData(Data data) throws Exception {
                System.out.println("getData:"+data.toString());
            }

            @Override
            public void OnError(Throwable t) {
                System.out.println(t.getMessage());
            }
        });

        System.out.println("不会阻塞......");

    }
    public  static void main(String[] args){
        doWork();
    }

}
