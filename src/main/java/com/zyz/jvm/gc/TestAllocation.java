package com.zyz.jvm.gc;

import java.util.concurrent.TimeUnit;

/**
 * User: 张月忠
 * Date: 2017/7/18
 * Time: 上午11:20
 * vmargs  ：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -Xloggc:/var/lib/tomcat7/logs/gc.log
 */

public class TestAllocation {

    private static final int MB = 1024*1024;
    public static void main(String[] args) throws InterruptedException {

        byte[] allocation1,allocation2,allocation3,allocation4;
        TimeUnit.SECONDS.sleep(120);
        allocation1 = new byte[2*MB];
        allocation2 = new byte[8*MB];
        allocation3 = new byte[3*MB];
        allocation4 = new byte[4*MB];


    }
}
