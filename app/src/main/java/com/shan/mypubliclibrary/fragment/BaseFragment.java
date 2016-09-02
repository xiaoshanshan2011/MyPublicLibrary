package com.shan.mypubliclibrary.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shan.mypubliclibrary.net.CancelRequestListener;
import com.shan.publiclibrary.listener.BindFragmentListener;

import rx.Subscription;

/**
 * Created by 陈俊山 on 2016/8/30.
 */

public abstract class BaseFragment<T extends ViewDataBinding> extends Fragment implements CancelRequestListener, BindFragmentListener {
    protected final String TAG = this.getClass().getName();
    protected Subscription subscription;
    //绑定布局文件并执行常用方法
    protected T mBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (bindLayout() == 0) {
            return null;
        }
        if (mBinding == null) {
            mBinding = DataBindingUtil.inflate(inflater, bindLayout(), container, false);
            getDatas();
            bindDatas();
        }
        ViewGroup parent = (ViewGroup) mBinding.getRoot().getParent();
        if (parent != null) {
            parent.removeView(mBinding.getRoot());
        }
        return mBinding.getRoot();
    }

    @Override
    public void cancelRequest() {
        if (subscription != null) {
            //取消Http请求
            subscription.unsubscribe();
        }
    }

}
