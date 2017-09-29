package com.example.wangpeng.mygsonapplication;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by wangpeng on 2017/9/21.
 */

public interface APIService {
    @POST("news/query")
    Observable<ResultDetail> getDetailsNews(@Query("key") String key, @Query("q") String q);

    @POST("news/words")
    Observable<ResultList> getListNews(@Query("key") String key);

    @POST("news/query")
    Observable<ResultDetail> getDetailsNewsNoKey(@Query("q") String q);

    @POST("news/query")
    Observable<ResultDetail> getListDetailsNewsNoKey(@Query("q") String q);


    @POST("news/words")
    Observable<ResultList> getListNewsNoKey();

    @POST("news/words")
    Flowable<ResultList> getListNewsNoKeyByFlowAble();
}
