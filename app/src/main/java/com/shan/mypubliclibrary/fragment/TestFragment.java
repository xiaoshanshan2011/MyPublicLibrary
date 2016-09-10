package com.shan.mypubliclibrary.fragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.view.LayoutInflater;

import com.shan.mypubliclibrary.R;
import com.shan.mypubliclibrary.activity.TestListView;
import com.shan.mypubliclibrary.bean.TestBean;
import com.shan.mypubliclibrary.databinding.AaaaaaaaaaaaaaaaaaaaaaaaaaaaaaBinding;
import com.shan.mypubliclibrary.databinding.ItemBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 陈俊山 on 2016/8/30.
 */

public class TestFragment extends BaseFragment<ItemBinding, TestBean> {
    private Handler handler = new Handler();

    @Override
    public int bindItemLayout() {
        return R.layout.item;
    }

    @Override
    public void initOnCreate() {
        showPullRefresh();
    }

    @Override
    public void getDatas() {
        super.getDatas();
        AaaaaaaaaaaaaaaaaaaaaaaaaaaaaaBinding HeadBing = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), R.layout.aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa, null, false);
        lvBinding.listView.addHeaderView(HeadBing.getRoot());
        List<TestBean> list = new ArrayList<>();
        list.add(new TestBean("xiaosham", 12));
        list.add(new TestBean("xiaosham", 13));
        list.add(new TestBean("xiaosham", 14));
        list.add(new TestBean("xiaosham", 15));
        list.add(new TestBean("xiaosham", 16));
        list.add(new TestBean("xiaosham", 17));
        list.add(new TestBean("xiaosham", 18));
        setData(list);
    }

    @Override
    protected void getListVewItem(ItemBinding binding, TestBean item) {
        super.getListVewItem(binding, item);
        binding.textView.setText(item.getName());
        binding.textView2.setText(item.getAge() + "");
    }

    @Override
    protected void itemOnclick(int position) {
        super.itemOnclick(position);
        Intent intent = new Intent(getActivity(), TestListView.class);
        startActivity(intent);
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                lvBinding.refreshLayout.setRefreshing(false);
            }
        }, 2000);
    }
}
