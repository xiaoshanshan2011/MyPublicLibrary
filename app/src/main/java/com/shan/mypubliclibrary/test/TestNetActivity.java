package com.shan.mypubliclibrary.test;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.shan.mypubliclibrary.R;
import com.shan.mypubliclibrary.activity.BaseActivity;
import com.shan.mypubliclibrary.bean.PersonBean;
import com.shan.mypubliclibrary.config.UrlConfig;
import com.shan.mypubliclibrary.databinding.TestnetactivityBinding;
import com.shan.publiclibrary.net.VolleyManager;
import com.shan.publiclibrary.utils.LogUtil;

/**
 * Created by 陈俊山 on 2016/7/26.
 */

public class TestNetActivity extends BaseActivity<TestnetactivityBinding> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindContentView(R.layout.testnetactivity);
        LogUtil.d(TAG);
    }

    @Override
    protected void initDatas() {
        //GET请求
        VolleyManager.newInstance().GsonGetRequest(TAG, UrlConfig.mJsonUrl, PersonBean.class,
                new Response.Listener<PersonBean>() {
                    @Override
                    public void onResponse(PersonBean person) {
                        LogUtil.d(person.toString());
                        mBinding.textView.setText(person.toString());
                        //mBinding..setText(person.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        LogUtil.e(error.getMessage());
                    }
                });
        //POST请求
        //VolleyManager.newInstance().GsonPostRequest(TAG,,UrlConfig.mMovieJsonUrl,)
    }
}
