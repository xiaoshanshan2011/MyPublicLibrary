package com.shan.mypubliclibrary.activity;

import com.shan.mypubliclibrary.BaseActivity;
import com.shan.mypubliclibrary.R;
import com.shan.mypubliclibrary.bean.BaseBean;
import com.shan.mypubliclibrary.databinding.LlBinding;

/**
 * Created by root on 16-11-11.
 */

public class Test extends BaseActivity<LlBinding, BaseBean> {
    @Override
    public int bindItemLayout() {
        return R.layout.ll;
    }

    @Override
    public void initOnCreate() {
        super.initOnCreate();
    }

    @Override
    protected void getListVewItem(LlBinding binding, BaseBean item, int position) {
        super.getListVewItem(binding, item, position);
        binding.textView.setText(item.getShowapi_res_code());
        binding.textView2.setText(item.getShowapi_res_error());
    }

    @Override
    protected void itemOnclick(int position) {
        super.itemOnclick(position);

    }
}
