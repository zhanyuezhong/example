package com.zyz.thread.threadpool.atomic;

/**
 * User: 张月忠
 * Date: 2017/8/3
 * Time: 下午5:09
 * To change this template use File | Settings | File Templates.
 */

public class MyIntegerTask implements Runnable {
    private String name;
    private MyInteger myInteger;

    public MyIntegerTask(String name, MyInteger myInteger) {
        this.name = name;
        this.myInteger = myInteger;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name+"..."+myInteger.getValue());
            if("A".equals(name)&&myInteger.getValue()==5){
                System.out.println("A thread exit");
                break;
            }else if("B".equals(name)&&myInteger.getValue()==6){
                System.out.println("B thread exit");
                break;
            }else if("C".equals(name)&&myInteger.getValue()==7){
                System.out.println("C thread exit");
                break;
            }
        }
    }
}
