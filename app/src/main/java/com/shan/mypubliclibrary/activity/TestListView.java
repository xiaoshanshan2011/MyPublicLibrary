package com.shan.mypubliclibrary.activity;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.shan.mypubliclibrary.R;
import com.shan.mypubliclibrary.bean.TestBean2;
import com.shan.mypubliclibrary.databinding.ItemLayoutBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 陈俊山 on 2016/9/10.
 */

public class TestListView extends BaseActivity<ItemLayoutBinding, TestBean2> {
    @Override
    public int bindItemLayout() {
        return R.layout.item_layout;
    }

    @Override
    public void initOnCreate() {
        super.initOnCreate();
        showPullRefresh();
    }

    @Override
    public void getDatas() {
        super.getDatas();
        List<TestBean2> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new TestBean2("http://attimg.dospy.com/img/day_141110/20141110_23a804e3b8b212d5e206T7B7haQowGII.jpg", "sssssssssssssssssd"));
        }
        setData(list);
    }

    @Override
    protected void getListVewItem(ItemLayoutBinding binding, TestBean2 item) {
        super.getListVewItem(binding, item);
        ImageLoader.getInstance().displayImage(item.getIvUrl(), binding.imageView);
        binding.textView.setText(item.getText());
    }
}
