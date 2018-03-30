package com.example.gztest.http;

import com.example.gztest.bean.CheckBean;
import com.example.gztest.bean.IdBean;
import com.example.gztest.bean.UpCheckBean;
import com.example.gztest.bean.UpSfz;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;


/**
 * Created by Administrator on 2017/1/10.
 */

public interface ApiService {
    @FormUrlEncoded
    @POST("idcard/v1/ocr")
    Observable<IdBean> upsfzInfo(
            @Field("frontPhoto") String frontPhoto,
            @Field("backPhoto") String backPhoto);


    @FormUrlEncoded
    @POST("idcard/v1/face/check")
    Observable<CheckBean> checkuser(
            @Field("dataPackage") String frontPhoto,
            @Field("baseImg") String baseImg,
            @Field("idCardNo") String idCardNo,
            @Field("idName") String idName);



    @Headers("Content-type: application/json")
    @POST("api/v1/idcard/ocr")
    Observable<IdBean> upInfo(@Body UpSfz string);

    @Headers("Content-type: application/json")
    @POST("api/v1/face/check")
    Observable<CheckBean> checkuserInfo(@Body UpCheckBean upCheckBean);


}
