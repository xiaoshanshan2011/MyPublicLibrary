package com.shan.mypubliclibrary.fragment_tab;

import android.view.View;

import com.shan.mypubliclibrary.R;
import com.shan.mypubliclibrary.BaseFragment;
import com.shan.publiclibrary.utils.ToastUtils;

/**
 * Created by 陈俊山 on 2016/8/31.
 */

public class DFragment extends BaseFragment {
    @Override
    public int bindLayout() {
        return R.layout.fragment_d;
    }

    @Override
    public void initOnCreate() {
        ToastUtils.toast("DFragment");
    }

    @Override
    public void initTitleBar() {
        setTitleBarVisibility(View.GONE);
    }
}
