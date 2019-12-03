package com.young.android.oz.lib.net;

/**
 * 定义请求回调方法
 *
 * @author O.z Young
 * @version 2019-12-02
 */
public interface RequestCallBack<T> {

    void onSuccess(T t);

}
