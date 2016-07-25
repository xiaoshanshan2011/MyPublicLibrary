package com.shan.mypubliclibrary.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import com.shan.mypubliclibrary.R;
import com.shan.mypubliclibrary.broadcast.CommonBCReceiver;
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
        CommonBCReceiver.getReceiver().registerAction(this, CommonBCReceiver.NOTIFICATION);
    }


    @Override
    protected void initDatas() {
        File file = new File(Environment.getExternalStorageDirectory(), "shanshan");
        if (!file.exists()) {
            file.mkdir();
        }
        file = new File(file, "abc.png");
        Bitmap bitmap = ImageUtil.getSmallBitmap(file.getAbsolutePath(), 480, 780);
        mBinding.image.setImageBitmap(bitmap);
    }

    @Override
    protected void initEvents() {
        super.initEvents();
        mBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, A1.class));
                /*Intent intent = new Intent(CommonBCReceiver.NOTIFICATION);
                intent.putExtra("content", "我发送了一条广播给你");
                sendBroadcast(intent);*/
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(CommonBCReceiver.getReceiver());
    }
}
