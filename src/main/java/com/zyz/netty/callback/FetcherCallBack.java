package com.zyz.netty.callback;

/**
 * User: 张月忠
 * Date: 2017/7/18
 * Time: 下午5:09
 * To change this template use File | Settings | File Templates.
 */

public interface FetcherCallBack {
    /**
     *
     * @param data
     * @throws Exception
     */
    void OnData(Data data) throws Exception;

    void OnError(Throwable t);
}
