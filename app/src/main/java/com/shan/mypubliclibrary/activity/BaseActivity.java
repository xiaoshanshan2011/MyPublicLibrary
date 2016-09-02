package com.shan.mypubliclibrary.activity;

import android.content.pm.ActivityInfo;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.shan.mypubliclibrary.net.CancelRequestListener;

import rx.Subscription;

/**
 * Created by 陈俊山 on 4/7/2559.
 */
public abstract class BaseActivity<T extends ViewDataBinding> extends FragmentActivity implements CancelRequestListener {
    protected final String TAG = this.getClass().getName();
    protected Subscription subscription;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //禁止横竖屏切换
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    //绑定布局文件并执行常用方法
    protected T mBinding;

    protected void bindContentView(int layoutRes) {
        mBinding = DataBindingUtil.setContentView(this, layoutRes);
    }

    @Override
    public void cancelRequest() {
        if (subscription != null) {
            //取消Http请求
            subscription.unsubscribe();
        }
    }
}
