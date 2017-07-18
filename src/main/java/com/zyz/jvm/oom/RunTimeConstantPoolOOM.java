package com.zyz.jvm.oom;/**
 * Created by zyz46160 on 2017/7/16.
 */

/**
 * User: 张月忠
 * Date: 2017/7/16  19:16
 */
public class RunTimeConstantPoolOOM {

    public static void main(String[] args){

        String sb = new StringBuffer("z").append("y").append("z").toString();
        System.out.println(sb==sb.intern());
        String java = new StringBuffer("java").toString();
        System.out.println(java==java.intern());
    }
}
