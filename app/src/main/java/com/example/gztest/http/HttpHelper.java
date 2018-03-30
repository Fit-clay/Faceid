package com.example.gztest.http;



import android.util.Log;

import com.example.gztest.bean.CheckBean;
import com.example.gztest.bean.IdBean;
import com.example.gztest.bean.UpCheckBean;
import com.example.gztest.bean.UpSfz;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;

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
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://idauth.517eshop.com/")
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
    public static Observable<IdBean> upSfzInfo(String fromPhoto, String backPhoto) {
        return getDefault().upsfzInfo(fromPhoto,backPhoto).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
    public static Observable<IdBean> upSfz(String fromPhoto, String backPhoto) {
        JSONObject jb=new JSONObject();
        try {
            jb.put("fromPhoto", fromPhoto);
            jb.put("backPhoto", backPhoto);
            MediaType JSON= MediaType.parse("application/json;charset=utf-8");
            Log.d("===============",jb.toString());
            RequestBody body = RequestBody.create(JSON,jb.toString());
            UpSfz upSfz=new UpSfz();
            upSfz.setFrontPhoto(fromPhoto);
            upSfz.setBackPhoto(backPhoto);
            return getDefault().upInfo(upSfz).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }

  /* public static Observable<CheckBean> upSfzInfo(String dataPackage, String baseImg, String idCardNo, String idName) {
        return getDefault().checkuser(dataPackage,baseImg,idCardNo,idName).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }*/
    public static Observable<CheckBean> upSfzInfo(String dataPackage, String baseImg, String idCardNo, String name) {
            UpCheckBean bean=new UpCheckBean();
            bean.setDataPackage(dataPackage);
            bean.setBaseImg(baseImg);
            bean.setIdCardNo(idCardNo);
            bean.setIdName(name);
            return getDefault().checkuserInfo(bean).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());

    }


}
