package com.zyz.cyclicbarrier;/**
 * Created by zyz46160 on 2017/7/16.
 */

/**
 * User: 张月忠
 * Date: 2017/7/16  13:42
 * 用来存储每行数据出现searchkey的次数
 */
public class Result {

    private int[] data;

    public Result (int size){
        data =new int[size];
    }

    public void setData(int index,int times){
        data[index] = times;
    }

    public int[] getData(){
        return  data;
    }

}
