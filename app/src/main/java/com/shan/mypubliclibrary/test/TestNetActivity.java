package com.shan.mypubliclibrary.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.shan.mypubliclibrary.R;
import com.shan.mypubliclibrary.activity.BaseActivity;
import com.shan.mypubliclibrary.bean.PostTestBean;
import com.shan.mypubliclibrary.databinding.TestnetactivityBinding;
import com.shan.mypubliclibrary.net.NetCallback;
import com.shan.mypubliclibrary.net.NetRequestBuilder;
import com.shan.publiclibrary.utils.LogUtil;
import com.shan.publiclibrary.utils.ToastUtil;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;

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
        /*NetRequest.execute(NetRequest.getNetService().GetUser(), new NetCallback<InfoBean>() {
            @Override
            protected void onSuccess(InfoBean result) {
                if (result.getCode() == 401) {
                    ToastUtil.toast(result.getMessage());
                } else {
                    ToastUtil.toast(result.getMessage());
                    return;
                }
                mBinding.textView.setText(result.toString());
            }

            @Override
            public void onFailure(Call<InfoBean> call, Throwable t) {
                ToastUtil.toast("访问失败");
            }
        });*/

        Map params = new HashMap();
        params.put("u_id", "88888888");
        params.put("name", "xiaoshanshan");
        params.put("age", "26");
        params.put("sex", "男");
        params.put("headimage", "hhhhhhhhhhhhhhhh");

        NetRequestBuilder.execute(TAG, NetRequestBuilder.getNetService().PostTest(params), new NetCallback<PostTestBean>() {
            @Override
            protected void onSuccess(PostTestBean result) {
                if (result.getCode() == 401) {
                    ToastUtil.toast(result.getMessage());
                } else {
                    ToastUtil.toast(result.getMessage());
                    return;
                }
                mBinding.textView.setText(result.toString());
            }

            @Override
            public void onFailure(Call<PostTestBean> call, Throwable t) {
                ToastUtil.toast("访问失败");
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        NetRequestBuilder.removeCall(TAG);
    }
}
