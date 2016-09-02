package com.shan.mypubliclibrary.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;

import com.shan.mypubliclibrary.R;
import com.shan.mypubliclibrary.activity.BaseActivity;
import com.shan.mypubliclibrary.bean.MovieBean;
import com.shan.mypubliclibrary.databinding.TestnetactivityBinding;
import com.shan.mypubliclibrary.fragment.TestFragment;
import com.shan.mypubliclibrary.net.HttpRequestBuilder;
import com.shan.mypubliclibrary.net.SubscriberCallBack;
import com.shan.publiclibrary.activity.CommonActivity;
import com.shan.publiclibrary.adapter.CommonAdapter;
import com.shan.publiclibrary.adapter.ViewHolder;
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
        getDatas();
        mBinding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(TestNetActivity.this, CommonActivity.class);
                intent.putExtra(CommonActivity.FRAGMENT_CLASS, TestFragment.class);
                intent.putExtra("flag", "xiaoshanshan");
                startActivity(intent);
            }
        });
    }

    private void getDatas() {
        Map<String, String> map = new HashMap<>();
        map.put("showapi_appid", "4670");
        map.put("showapi_timestamp", "20160830093034");
        map.put("showapi_sign", "fa3ff656162cb3bdfa31866fbb25e962");
        SubscriberCallBack<MovieBean> subscriber = new SubscriberCallBack<MovieBean>(this,this) {
            @Override
            protected void onSuccess(MovieBean phoneQueryBean) {
                mBinding.listView.setAdapter(new CommonAdapter<MovieBean.ShowapiResBodyBean.DatalistBean>(TestNetActivity.this, phoneQueryBean.getShowapi_res_body().getDatalist(), R.layout.item) {
                    @Override
                    public void convert(ViewHolder holder, MovieBean.ShowapiResBodyBean.DatalistBean bean) {
                        holder.setText(R.id.textView, bean.getMovieName());
                        holder.setText(R.id.textView2, bean.getPrice()+"元");
                    }
                });
            }

            @Override
            protected void onFailure(Throwable e) {
                ToastUtil.toast(e.getMessage());
            }
        };
        subscription = HttpRequestBuilder.getInstance().execute(HttpRequestBuilder.httpService.movie(map), subscriber);
    }
}
