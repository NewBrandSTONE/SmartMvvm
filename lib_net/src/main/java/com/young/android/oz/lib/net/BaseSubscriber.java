package com.young.android.oz.lib.net;

import com.young.android.oz.lib.callback.RequestCallBack;
import com.young.android.oz.lib.callback.RequestMultiplyCallBack;
import com.young.android.oz.lib.common.exceptions.BaseException;
import com.young.android.oz.lib.common.holders.ToastHolder;
import com.young.android.oz.lib.common.http.HttpCode;

import io.reactivex.observers.DisposableObserver;

public class BaseSubscriber<T> extends DisposableObserver<T> {

    private RequestCallBack<T> mRequestCallBack;

    public BaseSubscriber(RequestCallBack<T> requestCallBack) {
        this.mRequestCallBack = requestCallBack;
    }

    @Override
    public void onNext(T t) {
        if (mRequestCallBack != null) {
            mRequestCallBack.onSuccess(t);
        }
    }

    @Override
    public void onError(Throwable e) {
        if (mRequestCallBack instanceof RequestMultiplyCallBack) {
            RequestMultiplyCallBack<T> callBack = (RequestMultiplyCallBack<T>) this.mRequestCallBack;
            if (e instanceof BaseException) {
                callBack.onFail((BaseException) e);
            } else {
                callBack.onFail(new BaseException(HttpCode.CODE_UNKNOWN, e.getMessage()));
            }
        } else {
            ToastHolder.showToast(e.getMessage());
        }
    }

    @Override
    public void onComplete() {

    }
}
