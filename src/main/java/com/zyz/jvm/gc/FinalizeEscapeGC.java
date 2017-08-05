package com.zyz.jvm.gc;/**
 * Created by zyz46160 on 2017/7/16.
 */

/**
 * User: 张月忠
 * Date: 2017/7/16  20:12
 */
public class FinalizeEscapeGC {

    private  FinalizeEscapeGC save_hook;

    public void isAlived(){
        System.out.println("yes i am is alive...");
    }
    public static void main(String[] args){
        FinalizeEscapeGC gc = new FinalizeEscapeGC();
        System.out.println(gc);
        gc.testGc();


    }

    private  void testGc() {
        save_hook = new FinalizeEscapeGC();
        System.out.println(save_hook);

        save_hook = null;
        ///////第一次拯救
        System.gc();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(save_hook!=null){
            save_hook.isAlived();
        }else{
            System.out.println("dead");
        }
        ///////第一次拯救

        save_hook = null;
        System.gc();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(save_hook!=null){
            save_hook.isAlived();
        }else {
            System.out.println("dead");

        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method execute");
        System.out.println(this);
        save_hook = this;
    }
}
