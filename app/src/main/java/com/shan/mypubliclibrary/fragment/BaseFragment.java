package com.shan.mypubliclibrary.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.shan.mypubliclibrary.R;
import com.shan.mypubliclibrary.adapter.CommonAdapter;
import com.shan.mypubliclibrary.databinding.ListviewLayoutBinding;
import com.shan.mypubliclibrary.net.CancelRequestListener;
import com.shan.publiclibrary.listener.BindFragmentListener;

import java.util.List;

import rx.Subscription;

/**
 * Created by 陈俊山 on 2016/8/30.
 *
 * @param <T> ViewDataBinding
 * @param <D> ListVIew Item数据类型
 */

public abstract class BaseFragment<T extends ViewDataBinding, D> extends Fragment implements CancelRequestListener, BindFragmentListener, SwipeRefreshLayout.OnRefreshListener {
    protected final String TAG = this.getClass().getName();
    protected Subscription subscription;
    protected ListviewLayoutBinding lvBinding;//当子类是列表的时候这个才可用
    protected T mBinding;
    private View view = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (bindLayout() != 0) {
            if (view == null) {
                mBinding = DataBindingUtil.inflate(inflater, bindLayout(), container, false);
                initOnCreate();
                getDatas();
                bindDatas();
                view = mBinding.getRoot();
            }
        } else if (bindItemLayout() != 0) {
            if (view == null) {
                lvBinding = DataBindingUtil.inflate(inflater, R.layout.listview_layout, container, false);
                initPullRefresh();
                initOnCreate();
                getDatas();
                bindDatas();
                view = lvBinding.getRoot();
            }
        } else {
            return null;
        }

        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null) {
            parent.removeView(view);
        }
        return view;
    }

    @Override
    public void cancelRequest() {
        if (subscription != null) {
            //取消Http请求
            subscription.unsubscribe();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cancelRequest();
    }

    @Override
    public void initOnCreate() {

    }

    @Override
    public void getDatas() {

    }

    @Override
    public void bindDatas() {

    }

    @Override
    public int bindItemLayout() {
        return 0;
    }

    @Override
    public int bindLayout() {
        return 0;
    }

    /**
     * 获取ListView中的每一个Item
     *
     * @param binding
     * @param item
     */
    protected void getListVewItem(T binding, D item) {
    }

    /**
     * 获取ListViewd Item的每个点击事件
     *
     * @param position
     */
    protected void itemOnclick(int position) {
    }

    protected CommonAdapter<T, D> adapter = null;

    public void setData(List<D> datas) {
        if (datas == null) {
            return;
        }
        if (lvBinding == null)
            return;

        if (adapter == null) {
            adapter = new CommonAdapter<T, D>(getActivity(), bindItemLayout(), datas) {
                @Override
                protected void getItem(T binding, D item) {
                    getListVewItem(binding, item);
                }
            };
            lvBinding.listView.setAdapter(adapter);
            lvBinding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    itemOnclick(position);
                }
            });
        } else {
            adapter.updata(datas);
        }
    }

    /**
     * 初始化下拉刷新
     */
    private void initPullRefresh() {
        //关闭下拉刷新
        lvBinding.refreshLayout.setEnabled(false);
    }

    /**
     * 开启下拉刷新
     */
    public void showPullRefresh() {
        if (lvBinding == null) {
            return;
        }
        lvBinding.refreshLayout.setColorSchemeResources(
                R.color.light_sea_green,
                R.color.light_pink,
                R.color.light_sea_green,
                R.color.light_pink);
        lvBinding.refreshLayout.setEnabled(true);//开启下拉刷新
        lvBinding.refreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onPause() {
        super.onPause();
        if (lvBinding != null && lvBinding.refreshLayout.isRefreshing()) {
            lvBinding.refreshLayout.setRefreshing(false);
            cancelRequest();
        }
    }
}
