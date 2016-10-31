package com.shan.mypubliclibrary.activity;

import com.shan.mypubliclibrary.BaseActivity;
import com.shan.mypubliclibrary.R;
import com.shan.mypubliclibrary.databinding.ActivityTestBinding;

/**
 * Created by root on 16-10-24.
 */

public class TestActivity extends BaseActivity<ActivityTestBinding,Object> {
    @Override
    public int bindLayout() {
        return R.layout.activity_test;
    }

    @Override
    public void initOnCreate() {
        super.initOnCreate();

    }
}
