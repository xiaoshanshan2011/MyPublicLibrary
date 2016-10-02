package com.shan.mypubliclibrary.fragment_tab;

import android.view.View;

import com.shan.mypubliclibrary.R;
import com.shan.mypubliclibrary.databinding.FragmentBBinding;
import com.shan.mypubliclibrary.BaseFragment;
import com.shan.publiclibrary.utils.ToastUtils;

/**
 * Created by 陈俊山 on 2016/8/31.
 */

public class BFragment extends BaseFragment<FragmentBBinding,Object> {
    @Override
    public int bindLayout() {
        return R.layout.fragment_b;
    }

    @Override
    public void initOnCreate() {
        ToastUtils.toast("BFragment");
    }

    @Override
    public void initTitleBar() {
        setTitleBarVisibility(View.GONE);
    }
}
