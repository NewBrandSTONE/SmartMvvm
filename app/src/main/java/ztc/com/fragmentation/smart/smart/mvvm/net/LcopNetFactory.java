package ztc.com.fragmentation.smart.smart.mvvm.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ztc.com.fragmentation.smart.smart.mvvm.BuildConfig;

/**
 * 请求工厂类
 *
 * @author 01380154
 * @version 2019/12/3
 */
public class LcopNetFactory {

    private static final String BASE_URL = "http://ztc-ioms-tx.sit.sf-express.com/lcop/";

    private LcopNetFactory() {
    }

    public static LcopApi get() {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS);

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            clientBuilder.addInterceptor(httpLoggingInterceptor);
        }

        OkHttpClient okHttpClient = clientBuilder.build();
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(new SmartLiveDataCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(LcopApi.class);
    }

}
