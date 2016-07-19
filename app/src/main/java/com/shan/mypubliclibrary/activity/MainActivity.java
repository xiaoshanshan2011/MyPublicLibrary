package com.shan.mypubliclibrary.activity;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import com.shan.mypubliclibrary.R;
import com.shan.mypubliclibrary.databinding.ActivityMainBinding;
import com.shan.publiclibrary.utils.ImageUtil;
import com.shan.publiclibrary.utils.LogUtil;
import com.shan.publiclibrary.utils.ToastUtil;

import java.io.File;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindContentView(R.layout.activity_main);
    }


    @Override
    protected void initDatas() {
        File file = new File(Environment.getExternalStorageDirectory(), "shanshan");
        if (!file.exists()) {
            file.mkdir();
        }
        file = new File(file, "abc.png");
        Bitmap bitmap = ImageUtil.getSmallBitmap(file.getAbsolutePath());
        mBinding.image.setImageBitmap(bitmap);
    }

    @Override
    protected void initEvents() {
        super.initEvents();
        mBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.toast("33333333333331111111111111");
            }
        });
    }
}
