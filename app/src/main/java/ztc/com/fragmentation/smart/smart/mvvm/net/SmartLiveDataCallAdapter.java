package ztc.com.fragmentation.smart.smart.mvvm.net;

import android.arch.lifecycle.LiveData;

import com.blankj.utilcode.util.StringUtils;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;
import ztc.com.fragmentation.smart.smart.mvvm.base.BaseResponse;

public class SmartLiveDataCallAdapter<T> implements CallAdapter<T, LiveData<T>> {

    private Type responseType;


    public SmartLiveDataCallAdapter(Type responseType) {
        this.responseType = responseType;
    }

    @Override
    public Type responseType() {
        return responseType;
    }

    @Override
    public LiveData<T> adapt(Call<T> call) {
        return new LiveData<T>() {

            private AtomicBoolean started = new AtomicBoolean(false);

            @Override
            protected void onActive() {
                super.onActive();
                if (started.compareAndSet(false, true)) {
                    // 确保执行一次
                    call.enqueue(new Callback<T>() {

                        @Override
                        public void onResponse(Call<T> call, Response<T> response) {
                            postValue(response.body());
                        }

                        @Override
                        public void onFailure(Call<T> call, Throwable t) {
                            BaseResponse<T> baseResponse = new BaseResponse<>();
                            baseResponse.setCode("999");
                            baseResponse.setMsg(StringUtils.isEmpty(t.getMessage()) ? "" : t.getMessage());
                            postValue((T) baseResponse);
                        }

                    });
                }
            }
        };
    }
}
