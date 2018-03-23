package com.example.gztest.http;



import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Created by Administrator on 2017/2/13.
 */

public class HttpHelper {

    //读超时长，单位：毫秒
    public static final int READ_TIME_OUT = 10000;
    //连接时长，单位：毫秒
    public static final int CONNECT_TIME_OUT = 10000;
    public Retrofit retrofit;
    public ApiService movieService;

    private static class Holder{
        private  static HttpHelper mInstance = new HttpHelper();
    }


    //构造方法私有
    private HttpHelper() {
        //开启Log
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(READ_TIME_OUT, TimeUnit.MILLISECONDS)
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
                .addInterceptor(logInterceptor)
                .build();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("http://122.144.133.37:8083/")
                .build();
        movieService = retrofit.create(ApiService.class);
    }


    /**
     * @param
     */
    public static ApiService getDefault() {
        HttpHelper retrofitManager = Holder.mInstance;
        if (Holder.mInstance == null) {
            retrofitManager = new HttpHelper();
        }
        return retrofitManager.movieService;
    }
    public static Observable<ResponseBody> upSfzInfo(String fromPhoto,String backPhoto) {
        return getDefault().upsfzInfo(fromPhoto,backPhoto).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

}
