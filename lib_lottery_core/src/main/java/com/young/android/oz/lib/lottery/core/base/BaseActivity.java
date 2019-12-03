package com.young.android.oz.lib.lottery.core.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;

import com.blankj.utilcode.util.ToastUtils;

import java.util.ArrayList;
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
@SuppressWarnings("unused")
public abstract class BaseActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewModelEvent();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dismissLoadingDialog();
    }

    protected abstract ViewModel initViewModel();

    protected List<ViewModel> initViewModelList() {
        return new ArrayList<>();
    }

    private void initViewModelEvent() {
        List<ViewModel> viewModels = initViewModelList();
        if (viewModels.isEmpty()) {
            ViewModel viewModel = initViewModel();
            if (viewModel != null) {
                List<ViewModel> modelList = new ArrayList<>();
                modelList.add(viewModel);
                observeEvent(modelList);
            }
        } else {
            observeEvent(viewModels);
        }
    }

    private void observeEvent(List<ViewModel> viewModels) {
        if (viewModels == null || viewModels.isEmpty()) {
            return;
        }
        for (ViewModel viewModel : viewModels) {
            if (viewModel instanceof IViewModelAction) {
                IViewModelAction viewModelAction = (IViewModelAction) viewModel;
                viewModelAction.getActionLiveData().observe(this, baseActionEvent -> {
                    switch (baseActionEvent.getAction()) {
                        case BaseActionEvent.SHOW_LOADING_DIALOG:
                            startLoadingDialog(baseActionEvent.getMessage());
                            break;
                        case BaseActionEvent.DISMISS_LOADING_DIALOG:
                            dismissLoadingDialog();
                            break;
                        case BaseActionEvent.SHOW_TOAST:
                            showToast(baseActionEvent.getMessage());
                            break;
                        case BaseActionEvent.FINISH:
                            finish();
                            break;
                        case BaseActionEvent.FINISH_WITH_RESULT_OK:
                            finishWithResultOk();
                            break;
                        default:
                            break;
                    }
                });
            }
        }
    }

    private void finishWithResultOk() {
        setResult(RESULT_OK);
        finish();
    }

    private void startLoadingDialog(String message) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setCancelable(false);
            progressDialog.setCanceledOnTouchOutside(false);
        }
        progressDialog.setTitle(message);
        progressDialog.show();
    }

    private void dismissLoadingDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    private void showToast(String message) {
        ToastUtils.showShort(message);
    }

    protected Context getContext() {
        return BaseActivity.this;
    }

    protected void startActivity(Class clz) {
        startActivity(new Intent(getContext(), clz));
    }

    public void startActivityForResult(Class clz, int requestCode) {
        startActivityForResult(new Intent(getContext(), clz), requestCode);
    }

    protected boolean isFinishingOrDestory() {
        return isFinishing() || isDestroyed();
    }
}
