package com.shan.mypubliclibrary.fragment_tab;

import android.view.View;

import com.shan.mypubliclibrary.BaseFragment;
import com.shan.mypubliclibrary.bean.MovieBean;
import com.shan.mypubliclibrary.bean.MovieBean.ShowapiResBodyBean.DatalistBean;
import com.shan.mypubliclibrary.databinding.ItemBinding;
import com.shan.mypubliclibrary.presenter.APresenterImpl;
import com.shan.mypubliclibrary.view.AView;
import com.shan.publiclibrary.utils.ToastUtils;

import static com.shan.mypubliclibrary.R.layout.item;

/**
 * Created by 陈俊山 on 2016/8/31.
 */

public class AFragment extends BaseFragment<ItemBinding, DatalistBean> implements AView {
    @Override
    public int bindItemLayout() {
        return item;
    }

    private APresenterImpl aPresenter;

    @Override
    public void initOnCreate() {
        super.initOnCreate();
        showPullRefresh();
        aPresenter = new APresenterImpl(this, getActivity());
        aPresenter.getMovieData();
    }

    @Override
    public void initTitleBar() {
        super.initTitleBar();
        setTitleBarVisibility(View.GONE);
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
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        aPresenter.getMovieData();
    }

    @Override
    public void onSuccess(MovieBean phoneQueryBean) {
        closeRefresh();
        setData(phoneQueryBean.getShowapi_res_body().getDatalist());
    }

    @Override
    public void onFailure(Throwable e) {
        closeRefresh();
        ToastUtils.toast(e.getMessage());
    }
}
