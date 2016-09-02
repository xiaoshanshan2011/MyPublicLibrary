package com.shan.mypubliclibrary.fragment;

import com.shan.mypubliclibrary.R;
import com.shan.mypubliclibrary.bean.MovieBean;
import com.shan.mypubliclibrary.databinding.TestfragmentBinding;
import com.shan.mypubliclibrary.net.HttpRequestBuilder;
import com.shan.mypubliclibrary.net.SubscriberCallBack;
import com.shan.publiclibrary.utils.ToastUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 陈俊山 on 2016/8/30.
 */

public class TestFragment extends BaseFragment<TestfragmentBinding> {

    @Override
    public int bindLayout() {
        return R.layout.testfragment;
    }

    @Override
    public void getDatas() {
        String s = getActivity().getIntent().getStringExtra("flag");

        Map<String, String> map = new HashMap<>();
        map.put("showapi_appid", "4670");
        map.put("showapi_timestamp", "20160830093034");
        map.put("showapi_sign", "fa3ff656162cb3bdfa31866fbb25e962");
        SubscriberCallBack<MovieBean> subscriber = new SubscriberCallBack<MovieBean>(getActivity(),this) {
            @Override
            protected void onSuccess(MovieBean phoneQueryBean) {
                mBinding.textView.setText(phoneQueryBean.toString());
            }

            @Override
            protected void onFailure(Throwable e) {
                ToastUtil.toast(e.getMessage());
            }
        };
        subscription = HttpRequestBuilder.getInstance().execute(HttpRequestBuilder.httpService.movie(map), subscriber);
    }

    @Override
    public void bindDatas() {

    }
}
