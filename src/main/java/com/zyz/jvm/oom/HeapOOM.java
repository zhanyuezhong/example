package com.zyz.jvm.oom;/**
 * Created by zyz46160 on 2017/7/16.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * User: 张月忠
 * Date: 2017/7/16  18:43
 * vm args: -Xms1m -Xmx1m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {

    public static void main(String[] args){
        List<HeapOOM> heapOOMS = new ArrayList<>();
        while (true){
            heapOOMS.add(new HeapOOM());
        }
    }
}
