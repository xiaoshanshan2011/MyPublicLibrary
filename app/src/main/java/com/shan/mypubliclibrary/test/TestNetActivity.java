package com.shan.mypubliclibrary.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.shan.mypubliclibrary.R;
import com.shan.mypubliclibrary.activity.BaseActivity;
import com.shan.mypubliclibrary.bean.GetStudentBean;
import com.shan.mypubliclibrary.bean.PersonBean;
import com.shan.mypubliclibrary.config.UrlConfig;
import com.shan.mypubliclibrary.databinding.TestnetactivityBinding;
import com.shan.publiclibrary.net.VolleyManager;
import com.shan.publiclibrary.utils.LogUtil;
import com.shan.publiclibrary.utils.MD5Util;
import com.shan.publiclibrary.utils.ToastUtil;

import java.util.HashMap;
import java.util.Map;

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
        mBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDatas();
            }
        });
    }

    @Override
    protected void getDatas() {
        super.getDatas();
        //GET请求
        /*VolleyManager.newInstance().GsonGetRequest(TAG, UrlConfig.mJsonUrl, PersonBean.class,
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
                });*/

        //POST请求
        Map<String, String> map = new HashMap<>();
        map.put("name", "xiaoshanshan");

        VolleyManager.newInstance().GsonPostRequest(TAG, map, UrlConfig.getStudent, GetStudentBean.class, new Response.Listener<GetStudentBean>() {
            @Override
            public void onResponse(GetStudentBean response) {
                mBinding.textView.setText(response.toString());
                ImageLoader.getInstance().displayImage(response.getData().getHeadimage(), mBinding.imageView);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                ToastUtil.toast(error.getMessage());
            }
        });
        mBinding.textView.append("\n");
        mBinding.textView.append(MD5Util.encryption("11111111111"));
    }
}
