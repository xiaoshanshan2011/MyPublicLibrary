package com.shan.mypubliclibrary.net;

import com.shan.mypubliclibrary.bean.MovieBean;

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
    //电影排行
    @FormUrlEncoded
    @POST("578-6")
    Observable<MovieBean> movie(@FieldMap Map<String, String> params);

    //电影排行
    @GET("578-6")
    Observable<MovieBean> movie(@Query("showapi_appid") String showapi_appid, @Query("showapi_timestamp") String showapi_timestamp, @Query("showapi_sign") String showapi_sign);

}
