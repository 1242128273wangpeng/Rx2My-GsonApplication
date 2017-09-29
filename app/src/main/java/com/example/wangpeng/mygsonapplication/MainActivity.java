package com.example.wangpeng.mygsonapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        RetrofitHelper.getInstance().getRetrofit().create(APIService.class).getListNewsNoKey()
//                .doOnSubscribe(new Consumer<Disposable>() {
//                    @Override
//                    public void accept(Disposable disposable) throws Exception {
//                        Log.i("MainActivity", "doOnSubscribe:" + disposable.isDisposed());
//                    }
//                }).doOnNext(new Consumer<ResultList>() {
//            @Override
//            public void accept(@NonNull ResultList resultList) throws Exception {
//                Log.i("MainActivity", "doOnNext:" + resultList.toString());
//            }
//        }).doOnComplete(new Action() {
//            @Override
//            public void run() throws Exception {
//                Log.i("MainActivity", "doOnComplete");
//            }
//        }).doOnError(new Consumer<Throwable>() {
//            @Override
//            public void accept(@NonNull Throwable throwable) throws Exception {
//                Log.i("MainActivity", "doOnError:" + throwable.toString());
//            }
//        }).observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .safeSubscribe(new Observer<ResultList>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.i("MainActivity", "onSubscribe:" + d.isDisposed() + "");
//                    }
//
//                    @Override
//                    public void onNext(ResultList resultList) {
//                        Log.i("MainActivity", "onNext:" + resultList.toString());
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        if (e == null) {
//                            Log.i("MainActivity", "onError为空指针");
//                        } else {
//                            Log.i("MainActivity", "onError:" + e.toString());
//                        }
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.i("MainActivity", "onComplete");
//                    }
//                });

        Observer<ResultList> observer = new Observer<ResultList>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i("MainActivity", "onSubscribe:" + d.isDisposed() + "");
            }

            @Override
            public void onNext(ResultList resultList) {
                Log.i("MainActivity", "onNext:" + resultList.toString());
            }

            @Override
            public void onError(Throwable e) {
                if (e == null) {
                    Log.i("MainActivity", "onError为空指针");
                } else {
                    Log.i("MainActivity", "onError:" + e.toString());
                }
            }

            @Override
            public void onComplete() {
                Log.i("MainActivity", "onComplete");
            }
        };

        Subscriber<ResultList> subscriber = new Subscriber<ResultList>() {
            @Override
            public void onSubscribe(Subscription s) {
                Log.i("MainActivity", "onSubscribe:" + s);
            }

            @Override
            public void onNext(ResultList resultList) {
                Log.i("MainActivity", "onNext:" + resultList.toString());
            }

            @Override
            public void onError(Throwable t) {
                if (t == null) {
                    Log.i("MainActivity", "onError为空指针");
                } else {
                    Log.i("MainActivity", "onError:" + t.toString());
                }
            }

            @Override
            public void onComplete() {
                Log.i("MainActivity", "onComplete");
            }
        };

        RetrofitHelper.getInstance().getRetrofit().create(APIService.class).getListNewsNoKey()
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        Log.i("MainActivity", "doOnSubscribe:" + disposable.isDisposed() + "--" + Thread.currentThread().getName());
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnNext(new Consumer<ResultList>() {
                    @Override
                    public void accept(@NonNull ResultList resultList) throws Exception {
                        Log.i("MainActivity", "doOnNext:" + resultList.toString() + "--" + Thread.currentThread().getName());
                    }
                }).doOnComplete(new Action() {
            @Override
            public void run() throws Exception {
                Log.i("MainActivity", "doOnComplete" + "--" + Thread.currentThread().getName());
            }
        }).doOnError(new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                Log.i("MainActivity", "doOnError:" + throwable.toString() + "--" + Thread.currentThread().getName());
            }
        }).observeOn(Schedulers.io())
                .map(new Function<ResultList, List<String>>() {
                    @Override
                    public List<String> apply(@NonNull ResultList resultList) throws Exception {
                        return resultList.getString();
                    }
                })
                .flatMap(new Function<List<String>, ObservableSource<ResultDetail>>() {
                    @Override
                    public ObservableSource<ResultDetail> apply(@NonNull List<String> strings) throws Exception {
                        return Observable.fromIterable(strings).flatMap(new Function<String, ObservableSource<ResultDetail>>() {
                            @Override
                            public ObservableSource<ResultDetail> apply(@NonNull String s) throws Exception {
                                return RetrofitHelper.getInstance().getRetrofit().create(APIService.class).getDetailsNewsNoKey(s);
                            }
                        });
                    }
                }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<ResultDetail>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i("MainActivity", "getListDetailsNewsNoKey--onSubscribe" + "--" + Thread.currentThread().getName());
            }

            @Override
            public void onNext(ResultDetail resultDetail) {
                Log.i("MainActivity", "resultDetail" + resultDetail.toString());
                Log.i("MainActivity", "resultDetail->size" + resultDetail.getResult().size() + "  getListDetailsNewsNoKey--onNext" + "--" + Thread.currentThread().getName());
            }

            @Override
            public void onError(Throwable e) {
                Log.i("MainActivity", "getListDetailsNewsNoKey--onError" + "--" + Thread.currentThread().getName());
            }

            @Override
            public void onComplete() {
                Log.i("MainActivity", "getListDetailsNewsNoKey--onComplete" + "--" + Thread.currentThread().getName());
            }
        });

//        RetrofitHelper.getInstance().getRetrofit().create(APIService.class).getListNewsNoKeyByFlowAble()
//                .doOnSubscribe(new Consumer<Subscription>() {
//                    @Override
//                    public void accept(@NonNull Subscription subscription) throws Exception {
//                        Log.i("MainActivity", "doOnSubscribe:" + subscription);
//                    }
//                }).doOnNext(new Consumer<ResultList>() {
//            @Override
//            public void accept(@NonNull ResultList resultList) throws Exception {
//                Log.i("MainActivity", "doOnNext:" + resultList.toString());
//            }
//        }).doOnComplete(new Action() {
//            @Override
//            public void run() throws Exception {
//                Log.i("MainActivity", "doOnComplete");
//            }
//        }).doOnError(new Consumer<Throwable>() {
//            @Override
//            public void accept(@NonNull Throwable throwable) throws Exception {
//                Log.i("MainActivity", "doOnError:" + throwable.toString());
//            }
//        }).observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(subscriber);

    }
}
