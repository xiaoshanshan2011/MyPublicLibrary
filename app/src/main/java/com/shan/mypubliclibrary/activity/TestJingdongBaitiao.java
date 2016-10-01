package com.shan.mypubliclibrary.activity;

import android.view.Gravity;

import com.shan.mypubliclibrary.R;
import com.shan.mypubliclibrary.databinding.FragmentTestjingdongbaitiaoBinding;
import com.shan.mypubliclibrary.fragment.BaseFragment;

/**
 * Created by 陈俊山 on 16-9-27.
 */

public class TestJingdongBaitiao extends BaseFragment<FragmentTestjingdongbaitiaoBinding, Object> {
    @Override
    public int bindLayout() {
        return R.layout.fragment_testjingdongbaitiao;
    }

    @Override
    public void initOnCreate() {
        super.initOnCreate();
    }

    @Override
    public void initTitleBar() {
        super.initTitleBar();
        setTitle("白条");
        titleBinding.tvTitle.setGravity(Gravity.LEFT|Gravity.CENTER);
    }
}
