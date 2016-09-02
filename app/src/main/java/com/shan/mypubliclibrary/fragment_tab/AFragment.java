package com.shan.mypubliclibrary.fragment_tab;

import com.shan.mypubliclibrary.R;
import com.shan.mypubliclibrary.bean.MovieBean;
import com.shan.mypubliclibrary.databinding.FragmentABinding;
import com.shan.mypubliclibrary.fragment.BaseFragment;
import com.shan.mypubliclibrary.net.HttpRequestBuilder;
import com.shan.mypubliclibrary.net.SubscriberCallBack;
import com.shan.publiclibrary.adapter.CommonAdapter;
import com.shan.publiclibrary.adapter.ViewHolder;
import com.shan.publiclibrary.utils.ToastUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 陈俊山 on 2016/8/31.
 */

public class AFragment extends BaseFragment<FragmentABinding> {
    @Override
    public int bindLayout() {
        return R.layout.fragment_a;
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
                mBinding.listView.setAdapter(new CommonAdapter<MovieBean.ShowapiResBodyBean.DatalistBean>(getActivity(), phoneQueryBean.getShowapi_res_body().getDatalist(), R.layout.item) {
                    @Override
                    public void convert(ViewHolder holder, MovieBean.ShowapiResBodyBean.DatalistBean bean) {
                        holder.setText(R.id.textView, bean.getMovieName());
                        holder.setText(R.id.textView2, bean.getPrice() + "元");
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

    @Override
    public void bindDatas() {

    }
}
