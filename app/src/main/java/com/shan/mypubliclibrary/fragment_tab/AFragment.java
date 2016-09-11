package com.shan.mypubliclibrary.fragment_tab;

import android.content.Intent;

import com.shan.mypubliclibrary.R;
import com.shan.mypubliclibrary.bean.MovieBean;
import com.shan.mypubliclibrary.bean.MovieBean.ShowapiResBodyBean.DatalistBean;
import com.shan.mypubliclibrary.databinding.ItemBinding;
import com.shan.mypubliclibrary.fragment.BaseFragment;
import com.shan.mypubliclibrary.fragment.TestFragment;
import com.shan.mypubliclibrary.net.HttpRequestBuilder;
import com.shan.mypubliclibrary.net.SubscriberCallBack;
import com.shan.publiclibrary.activity.CommonActivity;
import com.shan.publiclibrary.utils.ToastUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 陈俊山 on 2016/8/31.
 */

public class AFragment extends BaseFragment<ItemBinding, DatalistBean> {
    @Override
    public int bindItemLayout() {
        return R.layout.item;
    }

    @Override
    public void initOnCreate() {
        super.initOnCreate();
        showPullRefresh();
    }

    @Override
    public void getDatas() {
        Map<String, String> map = new HashMap<>();
        map.put("showapi_appid", "4670");
        map.put("showapi_timestamp", "20160830093034");
        map.put("showapi_sign", "fa3ff656162cb3bdfa31866fbb25e962");
        SubscriberCallBack<MovieBean> subscriber = new SubscriberCallBack<MovieBean>(getActivity(), this) {
            @Override
            protected void onSuccess(MovieBean phoneQueryBean) {
                setData(phoneQueryBean.getShowapi_res_body().getDatalist());
            }

            @Override
            protected void onFailure(Throwable e) {
                ToastUtils.toast(e.getMessage());
            }
        };
        subscription = HttpRequestBuilder.getInstance().execute(HttpRequestBuilder.httpService.movie(map), subscriber);
    }

    @Override
    protected void getListVewItem(ItemBinding binding, DatalistBean item) {
        super.getListVewItem(binding, item);
        binding.textView.setText(item.getMovieName());
        binding.textView2.setText(item.getPrice() + "元");
    }

    @Override
    protected void itemOnclick(int position) {
        ToastUtils.toast(position + "");
        Intent intent = new Intent(getActivity(), CommonActivity.class);
        intent.putExtra(CommonActivity.FRAGMENT_CLASS, TestFragment.class);
        startActivity(intent);
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        Map<String, String> map = new HashMap<>();
        map.put("showapi_appid", "4670");
        map.put("showapi_timestamp", "20160830093034");
        map.put("showapi_sign", "fa3ff656162cb3bdfa31866fbb25e962");
        SubscriberCallBack<MovieBean> subscriber = new SubscriberCallBack<MovieBean>() {
            @Override
            protected void onSuccess(MovieBean phoneQueryBean) {
                setData(phoneQueryBean.getShowapi_res_body().getDatalist());
                lvBinding.refreshLayout.setRefreshing(false);
            }

            @Override
            protected void onFailure(Throwable e) {
                ToastUtils.toast(e.getMessage());
                lvBinding.refreshLayout.setRefreshing(false);
            }
        };
        subscription = HttpRequestBuilder.getInstance().execute(HttpRequestBuilder.httpService.movie(map), subscriber);
    }
}
