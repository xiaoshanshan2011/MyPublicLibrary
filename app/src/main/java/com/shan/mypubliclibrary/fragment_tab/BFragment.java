package com.shan.mypubliclibrary.fragment_tab;

import com.shan.mypubliclibrary.R;
import com.shan.mypubliclibrary.fragment.BaseFragment;
import com.shan.publiclibrary.utils.ToastUtil;

/**
 * Created by 陈俊山 on 2016/8/31.
 */

public class BFragment extends BaseFragment {
    @Override
    public int bindLayout() {
        return R.layout.fragment_b;
    }

    @Override
    public void getDatas() {
        ToastUtil.toast("BFragment");
    }

    @Override
    public void bindDatas() {

    }
}