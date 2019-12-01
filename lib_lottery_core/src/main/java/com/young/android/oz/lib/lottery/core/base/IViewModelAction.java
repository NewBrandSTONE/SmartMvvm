package com.young.android.oz.lib.lottery.core.base;

import androidx.lifecycle.MutableLiveData;

/**
 * 控制ViewModel基类定义方法
 *
 * @author O.z Young
 * @version 2019-12-01
 */
public interface IViewModelAction {

    void startLoading();

    void startLoading(String message);

    void dismissLoading();

    void showToast(String message);

    void finish();

    void finishWithResultOk();

    MutableLiveData<BaseActionEvent> getActionLiveData();

}
