package com.example.gztest.http;

import android.content.Context;

import com.google.gson.JsonParseException;


import org.json.JSONException;

import java.net.ConnectException;
import java.text.ParseException;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;


/**
 * des:订阅封装
 * Created by norton
 * on 2016.09.10:16
 */


public abstract class MySubscriber<T> implements Observer<T> {

    private Context mContext;
    private CompositeDisposable mDisposables;

    //对应HTTP的状态码
    private static final int UNAUTHORIZED = 401;
    private static final int FORBIDDEN = 403;
    private static final int NOT_FOUND = 404;
    private static final int REQUEST_TIMEOUT = 408;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final int BAD_GATEWAY = 502;
    private static final int SERVICE_UNAVAILABLE = 503;
    private static final int GATEWAY_TIMEOUT = 504;


    public MySubscriber(Context context, CompositeDisposable mDisposables) {
        this.mContext = context;
        this.mDisposables = mDisposables;
        ;

    }


    @Override
    public void onError(Throwable e) {
        //网络
        /*if (!NetWorkUtils.isNetConnected(App.getAppContext())) { //没有网络
            _onError("网络不可用");
        }else*/
        if (e instanceof HttpException) { //HTTP 错误
            HttpException httpException = (HttpException) e;
            switch (httpException.code()) {
                case UNAUTHORIZED:
                case FORBIDDEN:
                case NOT_FOUND:
                case REQUEST_TIMEOUT:
                case GATEWAY_TIMEOUT:
                case INTERNAL_SERVER_ERROR:
                case BAD_GATEWAY:
                case SERVICE_UNAVAILABLE:
                default:
                    _onError("网络错误");
                    break;
            }
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {
            _onError("解析错误");
        } else if (e instanceof ConnectException) {
            _onError("连接失败");
        } else if (e instanceof ApiException) {
            ApiException serverException = (ApiException) e;

        } else {
            _onError("未知错误" + e.getMessage());
        }

    }

    @Override
    public void onSubscribe(Disposable d) {
        mDisposables.add(d);
    }

    @Override
    public void onNext(T t) {
        _onNext(t);
    }


    /**
     * 错误回调
     */
    protected abstract void _onError(String msg);

    protected abstract void _onNext(T t);


}
