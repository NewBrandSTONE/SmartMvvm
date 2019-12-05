package com.young.android.oz.lib.net;

import com.young.android.oz.lib.common.exceptions.TokenInvalidException;
import com.young.android.oz.lib.common.http.HttpCode;
import com.young.android.oz.lib.excepitons.ServerResultException;
import com.young.android.oz.lib.models.BaseResponseBody;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit管理类
 * 为了应对可能有多个BaseUrl的需求，这里使用Map保存Retrofit的实例
 *
 * @author 01380154
 * @version 2019/12/5
 */
public class RetrofitManager {

    private static final int READ_TIME_OUT = 6;
    private static final int WRITE_TIME_OUT = 6;
    private static final int CONNECT_TIME_OUT = 6;

    private final Map<String, Object> serviceMap = new ConcurrentHashMap<>();

    private RetrofitManager() {

    }

    private RetrofitManager newInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static final RetrofitManager INSTANCE = new RetrofitManager();
    }

    private Retrofit createRetrofit(String url) {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder.readTimeout(READ_TIME_OUT, TimeUnit.SECONDS);
        clientBuilder.writeTimeout(WRITE_TIME_OUT, TimeUnit.SECONDS);
        clientBuilder.connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS);
        clientBuilder.retryOnConnectionFailure(true);

        Retrofit.Builder builder = new Retrofit.Builder();
        return builder
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(clientBuilder.build())
                .build();
    }

    <T> ObservableTransformer<BaseResponseBody<T>, T> applySchedulers() {
        return Observable -> Observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(result -> {
                    switch (result.getCode()) {
                        case HttpCode.CODE_SUCCESS:
                            return createData(result.getData());
                        case HttpCode.CODE_TOKEN_INVALID:
                            throw new TokenInvalidException();
                        default:
                            throw new ServerResultException(result.getCode(), result.getMsg());
                    }
                });
    }

    private <T> ObservableSource<? extends T> createData(T data) {
        return Observable.create(emitter -> {
            try {
                emitter.onNext(data);
                emitter.onComplete();
            } catch (Exception e) {
                emitter.onError(e);
            }
        });
    }

    <T> T getService(Class<T> clz, String host) {
        T value;
        if (serviceMap.containsKey(host)) {
            Object obj = serviceMap.get(host);
            if (obj == null) {
                value = createRetrofit(host).create(clz);
                serviceMap.put(host, value);
            } else {
                value = (T) obj;
            }
        } else {
            value = createRetrofit(host).create(clz);
            serviceMap.put(host, value);
        }
        return value;
    }
}
