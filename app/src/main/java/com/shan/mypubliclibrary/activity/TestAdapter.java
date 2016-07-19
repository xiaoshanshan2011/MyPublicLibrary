package com.shan.mypubliclibrary.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.shan.mypubliclibrary.R;
import com.shan.mypubliclibrary.bean.testbean;
import com.shan.mypubliclibrary.databinding.ActivityTestadapterBinding;
import com.shan.publiclibrary.adapter.CommonAdapter;
import com.shan.publiclibrary.adapter.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 陈俊山 on 2016/7/11.
 */

public class TestAdapter extends BaseActivity {
    private List<testbean> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTestadapterBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_testadapter);

        list = new ArrayList<>();
        list.add(new testbean("11111111111111"));
        list.add(new testbean("11111111111112"));
        list.add(new testbean("11111111111113"));
        list.add(new testbean("11111111111114"));
        list.add(new testbean("11111111111115"));
        list.add(new testbean("11111111111116"));
        list.add(new testbean("11111111111117"));
        list.add(new testbean("11111111111118"));
        list.add(new testbean("11111111111119"));
        list.add(new testbean("111111111111110"));
        list.add(new testbean("111111111111111"));
        list.add(new testbean("111111111111112"));
        list.add(new testbean("111111111111113"));
        list.add(new testbean("111111111111114"));
        list.add(new testbean("111111111111115"));
        list.add(new testbean("111111111111116"));
        list.add(new testbean("111111111111117"));
        list.add(new testbean("111111111111118"));


        binding.lv.setAdapter(new CommonAdapter<testbean>(this, list, R.layout.item) {
            @Override
            public void convert(ViewHolder holder, testbean bean) {
                holder.setText(R.id.textView, bean.getName());
            }
        });

    }

    @Override
    protected void initDatas() {

    }
}
