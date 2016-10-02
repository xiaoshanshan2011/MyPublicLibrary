package com.shan.mypubliclibrary.presenter;


import android.content.Context;

import com.shan.mypubliclibrary.bean.MovieBean;
import com.shan.mypubliclibrary.net.HttpRequestBuilder;
import com.shan.mypubliclibrary.net.SubscriberCallBack;
import com.shan.mypubliclibrary.view.AView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MVPHelper on 2016/10/02
 */

public class APresenterImpl extends PresenterImpl implements APresenter {
    private AView aView;
    private Context context;

    public APresenterImpl(AView aView, Context context) {
        this.aView = aView;
        this.context = context;
    }


    @Override
    public void getMovieData() {
        Map<String, String> map = new HashMap<>();
        map.put("showapi_appid", "4670");
        map.put("showapi_timestamp", "20160830093034");
        map.put("showapi_sign", "fa3ff656162cb3bdfa31866fbb25e962");
        SubscriberCallBack<MovieBean> subscriber = new SubscriberCallBack<MovieBean>(context, this) {
            @Override
            protected void onSuccess(MovieBean movieBean) {
                aView.onSuccess(movieBean);
            }

            @Override
            protected void onFailure(Throwable e) {
                aView.onFailure(e);
            }
        };
        subscription = HttpRequestBuilder.getInstance().execute(HttpRequestBuilder.httpService.movie(map), subscriber);
    }
}