package com.zyz.jvm.oom;/**
 * Created by zyz46160 on 2017/7/16.
 */


/**
 * User: 张月忠
 * Date: 2017/7/16  19:06
 * -Xss128K  设置栈内存容量
 */
public class JVMStatcSOF {

    private int stackLength = 1;

    public void stackLeek(){
        stackLength++;
        stackLeek();
    }
    public static void main(String[] args){
        JVMStatcSOF sof = new JVMStatcSOF();
        try {
            sof.stackLeek();
        }catch (Throwable e){
            e.printStackTrace();
            System.out.println(sof.stackLength);
        }
    }
}
