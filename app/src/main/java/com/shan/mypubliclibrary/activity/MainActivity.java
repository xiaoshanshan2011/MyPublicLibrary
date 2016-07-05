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

import java.io.File;

public class MainActivity extends BaseActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    @Override
    protected void setLayoutId() {
        File file = new File(Environment.getExternalStorageDirectory(), "shanshan");
        if (!file.exists()) {
            file.mkdir();
        }
        file = new File(file, "abc.png");
        Bitmap bitmap = ImageUtil.getSmallBitmap(file.getAbsolutePath());
        binding.image.setImageBitmap(bitmap);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtil.i("111111111111111111111111");
            }
        });
    }
}
