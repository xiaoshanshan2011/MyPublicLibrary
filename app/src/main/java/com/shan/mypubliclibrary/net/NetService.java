package com.shan.mypubliclibrary.net;

import com.shan.mypubliclibrary.bean.InfoBean;
import com.shan.mypubliclibrary.bean.PostTestBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by 陈俊山 on 2016/8/18.
 */

public interface NetService {

    public static final String BASEURL = "http://192.168.16.62/";

    @GET("project/MyPhpProjectTest/app/GetUser.php")
    Call<InfoBean> GetUser();

    @FormUrlEncoded
    @POST("project/MyPhpProjectTest/app/PostTest.php")
    Call<PostTestBean> PostTest(@FieldMap Map<String, String> params);


}
