package ztc.com.fragmentation.smart.smart.mvvm;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.os.Bundle;
import android.support.annotation.NonNull;

import ztc.com.fragmentation.smart.smart.mvvm.lifecycle.SmartLifeCycleObserver;

/**
 * 未实现LifeCycle的Activity,需要自己实现LifeCycle的接口
 *
 * @author 01380154
 * @version 2019/11/26
 */
public class SmartActivity extends Activity implements LifecycleOwner {

    private LifecycleRegistry mLifecycleRegistry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 创建LifecycleRegistry对象
        mLifecycleRegistry = new LifecycleRegistry(this);
        // 添加标记
        mLifecycleRegistry.markState(Lifecycle.State.CREATED);
        // 添加观察者
        mLifecycleRegistry.addObserver(new SmartLifeCycleObserver());
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return mLifecycleRegistry;
    }

    @Override
    public void onStart() {
        super.onStart();
        //做标记
        mLifecycleRegistry.markState(Lifecycle.State.STARTED);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //做标记
        mLifecycleRegistry.markState(Lifecycle.State.RESUMED);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //做标记
        mLifecycleRegistry.markState(Lifecycle.State.DESTROYED);
    }
}
