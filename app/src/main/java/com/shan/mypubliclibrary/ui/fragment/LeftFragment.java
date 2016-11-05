package com.shan.mypubliclibrary.ui.fragment;

import android.view.View;

import com.shan.mypubliclibrary.BaseFragment;
import com.shan.mypubliclibrary.R;
import com.shan.mypubliclibrary.databinding.FragmentLeftBinding;

/**
 * Created by 陈俊山 on 2016/11/5.
 */

public class LeftFragment extends BaseFragment<FragmentLeftBinding,Object> implements View.OnClickListener{
    @Override
    public int bindLayout() {
        return R.layout.fragment_left;
    }

    @Override
    public void initOnCreate() {
        super.initOnCreate();
        mBinding.ll.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
