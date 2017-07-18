package com.zyz.thread.threadpool.cyclicbarrier;
/**
 * Created by zyz46160 on 2017/7/16.
 */

import java.util.Random;

/**
 * User: 张月忠
 * Date: 2017/7/16  13:22
 * 模拟矩阵
 */
public class MetrixMock {

    private int[][] data;


    public MetrixMock(int size,int rowLength,int searchKey){

        data = new int[size][rowLength];

        int counter= 0;

        Random random = new Random();

        for(int i = 0;i<size;i++){
            for(int j=0;j<rowLength;j++){
                int value = random.nextInt(10);
                if(value ==searchKey){
                    counter++;
                }
                data[i][j] = value;

            }
        }

        System.out.printf("共有%d个%d\n",counter,searchKey);

    }


    public int[] getRow(int index){
        if(index>=0&&index<data.length){
            return data[index];
        }
        return  null;
    }

}
