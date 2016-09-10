package com.shan.mypubliclibrary.fragment_tab;

import com.shan.mypubliclibrary.R;
import com.shan.mypubliclibrary.activity.BaseActivity;
import com.shan.mypubliclibrary.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding, Object> {
    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initOnCreate() {
        super.initOnCreate();
        TabManager tabManager = new TabManager(this, TabConstant.MAIN_FRAGMENT, TabConstant.MAIN_IAMGEVIEW, TabConstant.MAIN_TEXTVIEW);
        tabManager.initTab();
    }
}
