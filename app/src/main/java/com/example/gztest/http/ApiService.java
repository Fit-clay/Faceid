package com.example.gztest.http;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


/**
 * Created by Administrator on 2017/1/10.
 */

public interface ApiService {
    @FormUrlEncoded
    @POST("idcard/v1/ocr?accessToken=xxx")
    Observable<ResponseBody> upsfzInfo(
            @Field("frontPhoto") String frontPhoto,
            @Field("backPhoto") String backPhoto);

    @FormUrlEncoded
    @POST("idcard/v1/face/check?accessToken=xxx")
    Observable<ResponseBody> checkuser(
            @Field("dataPackage") String frontPhoto,
            @Field("baseImg") String baseImg,
            @Field("idCardNo") String idCardNo,
            @Field("idName") String idName);


}
