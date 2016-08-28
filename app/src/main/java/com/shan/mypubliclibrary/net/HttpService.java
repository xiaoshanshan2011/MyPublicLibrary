package com.shan.mypubliclibrary.net;

import com.shan.mypubliclibrary.bean.PhoneQueryBean;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 陈俊山 on 2016/8/18.
 */

public interface HttpService {
    //手机归属地查询
    @FormUrlEncoded
    @POST("6-1")
    Observable<PhoneQueryBean> phoneQuery(@FieldMap Map<String, String> params);

    //手机归属地查询
    @GET("6-1")
    Observable<PhoneQueryBean> registerOpenfire(@Query("num") String num, @Query("showapi_appid") String showapi_appid, @Query("showapi_timestamp") String showapi_timestamp, @Query("showapi_sign") String showapi_sign);
}
