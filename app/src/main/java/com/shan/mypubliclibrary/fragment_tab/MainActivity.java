package com.shan.mypubliclibrary.fragment_tab;

import android.content.Intent;
import android.view.View;

import com.shan.mypubliclibrary.R;
import com.shan.mypubliclibrary.BaseActivity;
import com.shan.mypubliclibrary.activity.TestJingdongBaitiao;
import com.shan.mypubliclibrary.databinding.ActivityMainBinding;
import com.shan.mypubliclibrary.listener.TitleBarListener;
import com.shan.publiclibrary.activity.CommonActivity;

public class MainActivity extends BaseActivity<ActivityMainBinding, Object> implements TitleBarListener {
    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initOnCreate() {
        super.initOnCreate();
        TabManager tabManager = new TabManager(this, mBinding.tabhost, TabConstant.MAIN_FRAGMENT, TabConstant.MAIN_IAMGEVIEW, TabConstant.MAIN_TEXTVIEW);
        tabManager.initTab();
    }

    @Override
    public void initTitleBar() {
        super.initTitleBar();
        setTitle("应用");
        setTitleRightIcon(R.mipmap.email);
    }

    @Override
    public void setTitleBarTitle(int position) {
        setTitle(TabConstant.MAIN_TEXTVIEW[position]);
    }

    @Override
    public void onClickRight(View view) {
        super.onClickRight(view);
        Intent intent = new Intent(MainActivity.this, CommonActivity.class);
        intent.putExtra(CommonActivity.FRAGMENT_CLASS, TestJingdongBaitiao.class);
        startActivity(intent);
    }
}
