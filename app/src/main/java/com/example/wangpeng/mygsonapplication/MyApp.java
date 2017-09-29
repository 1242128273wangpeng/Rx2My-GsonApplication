package com.example.wangpeng.mygsonapplication;

import android.app.Application;
import android.support.annotation.Nullable;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wangpeng on 2017/9/21.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }
}
