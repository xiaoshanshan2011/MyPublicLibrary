package com.shan.mypubliclibrary.activity;

import android.content.pm.ActivityInfo;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.AdapterView;

import com.shan.mypubliclibrary.R;
import com.shan.mypubliclibrary.adapter.CommonAdapter;
import com.shan.mypubliclibrary.databinding.ListviewLayoutBinding;
import com.shan.mypubliclibrary.net.CancelRequestListener;
import com.shan.publiclibrary.listener.BindFragmentListener;
import com.shan.publiclibrary.manager.StatusBar;

import java.util.List;

import rx.Subscription;

/**
 * Created by 陈俊山 on 4/7/2559.
 */
public abstract class BaseActivity<T extends ViewDataBinding, D> extends FragmentActivity implements CancelRequestListener, BindFragmentListener, SwipeRefreshLayout.OnRefreshListener {
    protected final String TAG = this.getClass().getName();
    protected Subscription subscription;
    protected T mBinding;//绑定布局文件并执行常用方法
    protected ListviewLayoutBinding lvBinding;//当子类是列表的时候这个才可用

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //禁止横竖屏切换
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //设置状态栏颜色
        StatusBar.showStatusBar(this, R.color.white);
        if (bindLayout() != 0) {
            mBinding = DataBindingUtil.setContentView(this, bindLayout());
        } else if (bindItemLayout() != 0) {
            lvBinding = DataBindingUtil.setContentView(this, R.layout.listview_layout);
            initPullRefresh();
        }
        initOnCreate();
        getDatas();
        bindDatas();
    }

    @Override
    public void cancelRequest() {
        if (subscription != null) {
            //取消Http请求
            subscription.unsubscribe();
        }
    }

    @Override
    protected void onDestroy() {
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
            adapter = new CommonAdapter<T, D>(this, bindItemLayout(), datas) {
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
    protected void onPause() {
        super.onPause();
        if (lvBinding != null && lvBinding.refreshLayout.isRefreshing()) {
            lvBinding.refreshLayout.setRefreshing(false);
            cancelRequest();
        }
    }
}
