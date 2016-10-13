package com.shan.mypubliclibrary.fragment;

import android.view.View;

import com.shan.mypubliclibrary.BaseFragment;
import com.shan.mypubliclibrary.R;
import com.shan.mypubliclibrary.databinding.FragmentLeftDrawerBinding;

/**
 * Created by 陈俊山 on 2016/9/10.
 */

public class LeftDrawerFragment extends BaseFragment<FragmentLeftDrawerBinding, Object> implements View.OnClickListener {
    @Override
    public int bindLayout() {
        return R.layout.fragment_left_drawer;
    }

    @Override
    public void initTitleBar() {
        setTitleBarVisibility(View.GONE);
    }

    @Override
    public void initOnCreate() {
        super.initOnCreate();
        mBinding.ll.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}
