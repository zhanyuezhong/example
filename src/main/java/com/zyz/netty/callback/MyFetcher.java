package com.zyz.netty.callback;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * User: 张月忠
 * Date: 2017/7/18
 * Time: 下午5:15
 * To change this template use File | Settings | File Templates.
 */

public class MyFetcher implements Fetcher {
    @Override
    public void fetcher(FetcherCallBack callBack) {
        try{
            Random random = new Random();
            int i = random.nextInt(10);
            TimeUnit.SECONDS.sleep(i);
            if(i>5){
                Exception e= new Exception("fetch TimeOut");
                callBack.OnError(e);
            }else {
                Data data = new Data();
                data.setM(i);
                data.setN(2*i);
                callBack.OnData(data);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
