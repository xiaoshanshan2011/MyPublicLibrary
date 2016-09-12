package com.shan.mypubliclibrary.test;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.shan.mypubliclibrary.R;
import com.shan.mypubliclibrary.adapter.CommonAdapter;
import com.shan.mypubliclibrary.bean.TestBean2;
import com.shan.mypubliclibrary.databinding.GriditemBinding;
import com.shan.mypubliclibrary.fragment_tab.MainActivity;
import com.shan.publiclibrary.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/12.
 */

public class TestGridView extends Activity {
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test1);

        gridView = (GridView) findViewById(R.id.gridview);


        List<TestBean2> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new TestBean2("http://pic1.5442.com/2015/0715/05/01.jpg", "嘎嘎嘎"));
        }

        CommonAdapter<GriditemBinding, TestBean2> adapter = new CommonAdapter<GriditemBinding, TestBean2>(this, R.layout.griditem, list) {
            @Override
            protected void getItem(GriditemBinding binding, TestBean2 bean) {
                ImageLoader.getInstance().displayImage(bean.getIvUrl(), binding.imageView);
                binding.textView.setText(bean.getText());
            }
        };

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ToastUtils.toast(position+"");
                switch (position){
                    case 0:
                        startActivity(new Intent(TestGridView.this, MainActivity.class));
                        break;
                }
            }
        });
    }
}
