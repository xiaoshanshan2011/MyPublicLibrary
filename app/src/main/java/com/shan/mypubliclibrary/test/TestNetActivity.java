package com.shan.mypubliclibrary.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;

import com.shan.mypubliclibrary.R;
import com.shan.mypubliclibrary.activity.BaseActivity;
import com.shan.mypubliclibrary.bean.PhoneQueryBean;
import com.shan.mypubliclibrary.databinding.TestnetactivityBinding;
import com.shan.mypubliclibrary.net.HttpRequestBuilder;
import com.shan.mypubliclibrary.net.HttpSubscriber;
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
    }

    @Override
    protected void initDatas() {

    }

    @Override
    protected void initEvents() {
        super.initEvents();
        mBinding.button.setOnClickListener(this);
    }

    @Override
    protected void getDatas() {
        super.getDatas();
        String name = mBinding.editText.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            ToastUtil.toast("请输入手机号码");
            return;
        }
        Map<String, String> map = new HashMap<>();
        map.put("num", name);
        map.put("showapi_appid", "4670");
        map.put("showapi_timestamp", "20160828093616");
        map.put("showapi_sign", "0dd87eedd76d374e184e6437755dfa72");
        HttpSubscriber<PhoneQueryBean> subscriber = new HttpSubscriber<PhoneQueryBean>() {
            @Override
            protected void onSuccess(PhoneQueryBean phoneQueryBean) {
                mBinding.textView.setText(phoneQueryBean.toString());
            }

            @Override
            protected void onFailure(Throwable e) {
                ToastUtil.toast(e.getMessage());
            }
        };
        HttpRequestBuilder.getInstance().execute(HttpRequestBuilder.httpService.phoneQuery(map), subscriber);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                getDatas();
                break;
        }
    }
}
