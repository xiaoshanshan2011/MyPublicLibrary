package com.shan.mypubliclibrary.fragment;

import android.view.View;

import com.shan.mypubliclibrary.BaseFragment;
import com.shan.mypubliclibrary.R;
import com.shan.mypubliclibrary.bean.TestBean;
import com.shan.mypubliclibrary.databinding.ItemBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 陈俊山 on 2016/9/10.
 */

public class LeftDrawerFragment extends BaseFragment<ItemBinding, TestBean> {
    @Override
    public int bindItemLayout() {
        return R.layout.item;
    }

    @Override
    public void getDatas() {
        super.getDatas();
        List<TestBean> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new TestBean("ssxssxssssss", 222));
        }
        setData(list);
    }

    @Override
    public void initTitleBar() {
        setTitleBarVisibility(View.GONE);
    }

    @Override
    protected void getListVewItem(ItemBinding binding, TestBean item) {
        super.getListVewItem(binding, item);
        binding.textView.setText(item.getName());
        binding.textView2.setText(item.getAge() + "");
    }
}
