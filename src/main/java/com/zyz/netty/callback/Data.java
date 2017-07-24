package com.zyz.netty.callback;

/**
 * User: 张月忠
 * Date: 2017/7/18
 * Time: 下午5:09
 * To change this template use File | Settings | File Templates.
 */

public class Data {
    private int m;
    private int n;

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "Data{" +
                "m=" + m +
                ", n=" + n +
                '}';
    }
}
