package com.zyz.cyclicbarrier;/**
 * Created by zyz46160 on 2017/7/16.
 */

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * User: 张月忠
 * Date: 2017/7/16  13:49
 */
public class Searcher implements Runnable {

    private int firstRow;
    private int lastRow;

    private MetrixMock metrixMock;

    private CyclicBarrier cyclicBarrier;

    private int searchKey;

    private Result result;

    public Searcher(int firstRow, int lastRow, MetrixMock metrixMock, CyclicBarrier cyclicBarrier, int searchKey, Result result) {
        this.firstRow = firstRow;
        this.lastRow = lastRow;
        this.metrixMock = metrixMock;
        this.cyclicBarrier = cyclicBarrier;
        this.searchKey = searchKey;
        this.result = result;
    }

    @Override
    public void run() {
        //searcher


        for(int i =firstRow;i<lastRow;i++){
            int row[] = metrixMock.getRow(i);
            int counter = 0;
            for(int j=0;j<row.length;j++){
                if(searchKey == row[j]){
                    counter++;
                }
            }

            result.setData(i,counter);
        }
        System.out.println(Thread.currentThread().getName()+"end:");
        //searche End
        try {
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
