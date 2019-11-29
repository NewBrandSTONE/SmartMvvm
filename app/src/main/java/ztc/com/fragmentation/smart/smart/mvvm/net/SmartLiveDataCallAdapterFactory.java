package ztc.com.fragmentation.smart.smart.mvvm.net;

import android.arch.lifecycle.LiveData;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import ztc.com.fragmentation.smart.smart.mvvm.base.BaseResponse;

public class SmartLiveDataCallAdapterFactory extends CallAdapter.Factory {

    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {

        if (getRawType(returnType) != LiveData.class) {
            return null;
        }

        Type parameterUpperBound = getParameterUpperBound(0, (ParameterizedType) returnType);
        Class<?> rawType = getRawType(parameterUpperBound);

        if (rawType != BaseResponse.class) {
            throw new IllegalArgumentException("return type must be BaseResponse...");
        }

        return new SmartLiveDataCallAdapter<>(parameterUpperBound);
    }
}
