package com.zyz.cyclicbarrier;/**
 * Created by zyz46160 on 2017/7/16.
 */

import java.util.concurrent.CyclicBarrier;

/**
 * User: 张月忠
 * Date: 2017/7/16  14:04
 */
public class Main {

    private final static int ROWS =1000;
    private final  static int ROW_LENGTH =1000;
    private final static int searchKey = 3;
    private final  static int threadNumber = 10;
    private final static int threadLine = 100;

    /***
     * CyclicBarrier:
     * 并发辅助类，  可以让多个线程在某个点等待。所有的线程执行完成后，会回调子线程。
     * 原理：内部维护这一个计数器，一个线程完成造作后调用 await()操作，等待其他线程完成。
     * 当所有的线程都进行await操作后， 主线程回调其他线程。
     * @param args
     */
    public static void main(String[] args){
        MetrixMock metrixMock = new MetrixMock(ROWS,ROW_LENGTH,searchKey);

        Result result = new Result(ROWS);

        Counter counter = new Counter(result);

        CyclicBarrier cyclicBarrier = new CyclicBarrier(threadNumber,counter);

        for(int i=0;i<threadNumber;i++){
            int startRow = i*threadLine;
            int lastRow = (i+1)*threadLine;
            Searcher searcher = new Searcher(startRow,lastRow,metrixMock,cyclicBarrier,searchKey,result);
            Thread thread = new Thread(searcher);
            thread.start();
        }

        System.out.println("主线程结束....");

    }
}
