package com.young.android.oz.lib.lottery.core.base;

import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;

import java.util.List;

/**
 * BaseActivity通过监听BaseViewModel中的ActionLiveData的数据变化
 * 在网络请求开始时加载loading，在网络加载结束之后dismissLoading。
 * <p>
 * 一般情况下一个Activity对应有一个ViewModel,因此initViewModel()变成了抽象方法,
 * 而initViewModel()默认返回Null
 *
 * @author O.z Young
 * @version 2019-12-02
 */
public abstract class BaseActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewModelEvent();
    }

    private void initViewModelEvent() {
        List<ViewModel> viewModels = initViewModel();
        if (viewModels == null && viewModels.isEmpty()) {

        } else {
            observeEvent(viewModels);
        }
    }

    private void observeEvent(List<ViewModel> viewModels) {

    }

    protected List<ViewModel> initViewModel() {
        return null;
    }
}
