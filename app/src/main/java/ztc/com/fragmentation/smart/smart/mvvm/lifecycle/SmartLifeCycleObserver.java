package ztc.com.fragmentation.smart.smart.mvvm.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

import com.orhanobut.logger.Logger;

/**
 * LifeCycle类文件
 * 1.编写自己的LifeCycle观察者，并实现监听方法。
 * 2.通过注解实现对生命周期的监听。
 * 3.在被监控的Activity或者Fragment中注册。
 *
 * @author 01380154
 * @version 2019/11/26
 */
public class SmartLifeCycleObserver implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResumeListener() {
        Logger.d("onResumeListener...");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPauseListener() {
        Logger.d("onPauseListener...");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroyListener() {
        Logger.d("onDestroyListener...");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreateListener() {
        Logger.d("onCreateListener...");
    }

}
