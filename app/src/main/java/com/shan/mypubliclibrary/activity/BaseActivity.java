package com.shan.mypubliclibrary.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

/**
 * Created by 陈俊山 on 4/7/2559.
 */
public abstract class BaseActivity<T extends ViewDataBinding> extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //绑定布局文件并执行常用方法
    protected T mBinding;
    protected void bindContentView(int layoutRes){
        mBinding = DataBindingUtil.setContentView(this,layoutRes);
        initDatas();
        initEvents();
        getDatas();
        bindDatas();
    }

    /**
     * 获取数据
     */
    protected abstract void initDatas();
    /**
     * 初始化事件
     */
    protected void initEvents(){}
    /**
     * 获取数据
     */
    protected void getDatas(){}
    /**
     * 绑定数据
     */
    protected void bindDatas(){}

}
