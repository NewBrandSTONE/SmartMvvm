package com.young.android.oz.lib.net;

import com.young.android.oz.lib.common.exceptions.BaseException;

/**
 * 包含两个回调方法
 *
 * @author O.z Young
 * @version 2019-12-02
 */
public interface RequestMultiplyCallBack<T> extends RequestCallBack<T> {

    void onFail(BaseException exception);

}
