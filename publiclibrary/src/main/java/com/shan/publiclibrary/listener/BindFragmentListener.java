package com.shan.publiclibrary.listener;

/**
 * 绑定Frgment Layout
 * Created by 陈俊山 on 2016/8/30.
 */

public interface BindFragmentListener {
    /*绑定布局*/
    int bindLayout();

    /*获取数据*/
    void getDatas();

    /*绑定数据*/
    void bindDatas();
}
