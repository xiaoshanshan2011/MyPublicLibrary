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

        List<TestBean2> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new TestBean2("http://pic1.5442.com/2015/0715/05/01.jpg","ssssssss"));
        }
        setData(list);
    }

    @Override
    public void initTitleBar() {
        super.initTitleBar();
        setTitle("TestListView");
    }

    @Override
    protected void getListVewItem(ItemLayoutBinding binding, TestBean2 item) {
        super.getListVewItem(binding, item);
        ImageLoader.getInstance().displayImage(item.getIvUrl(),binding.imageView);
        binding.textView.setText(item.getText());
    }

    @Override
    protected void itemOnclick(int position) {
        super.itemOnclick(position);

    }

}
