package com.shan.mypubliclibrary.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.shan.mypubliclibrary.R;
import com.shan.mypubliclibrary.broadcast.CommonBCReceiver;
import com.shan.mypubliclibrary.databinding.ActivityMainBinding;

/**
 * Created by 大唐天下 on 2016/7/22.
 */

public class A1 extends BaseActivity<ActivityMainBinding> {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindContentView(R.layout.activity_main);
        CommonBCReceiver.getReceiver().registerAction(this,CommonBCReceiver.ACTIVITYFINISH);
        mBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(A1.this,A2.class));
            }
        });
    }

    @Override
    protected void initDatas() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(CommonBCReceiver.getReceiver());
    }
}
