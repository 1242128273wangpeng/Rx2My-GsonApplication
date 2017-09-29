package com.example.wangpeng.mygsonapplication;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wangpeng on 2017/9/21.
 */

public class RetrofitHelper {
    private Retrofit mRetrofit;
    private static RetrofitHelper instance;

    private RetrofitHelper() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.e(this.getClass().getSimpleName(), message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        InterceptorCustom interceptorCustom = new InterceptorCustom();

        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder()
                .writeTimeout(3, TimeUnit.SECONDS)
                .readTimeout(3, TimeUnit.SECONDS)
                .addInterceptor(interceptorCustom)
                .addInterceptor(loggingInterceptor);

        OkHttpClient okHttpClient = okHttpClientBuilder.build();

        mRetrofit = new Retrofit.Builder().baseUrl(Constant.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient).build();
    }

    class InterceptorCustom implements Interceptor {
        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request original = chain.request();
            Request.Builder builder = original.newBuilder();
//            HttpUrl httpUrl = original.url()
//                    .newBuilder()
//                    .addQueryParameter("key", Constant.KEY)
//                    .build();
//            builder.addHeader("contentType", "application/json");
//            builder.url(httpUrl);

            FormBody.Builder bodybuilder = new FormBody.Builder();
            RequestBody requestBody = bodybuilder.add("key",Constant.KEY).build();
            builder.post(requestBody);
            Request after = builder.build();
            return chain.proceed(after);
        }
    }

    public static RetrofitHelper getInstance() {
        if (instance == null) {
            synchronized (RetrofitHelper.class) {
                if (instance == null) {
                    instance = new RetrofitHelper();
                }
            }
        }
        return instance;
    }

    public Retrofit getRetrofit() {
        if (mRetrofit == null) {
            Log.i("getRetrofit", "null");
        } else {
            Log.i("getRetrofit", "not null");
        }
        return mRetrofit;
    }
}
