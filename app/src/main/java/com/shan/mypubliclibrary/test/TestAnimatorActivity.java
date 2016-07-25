package com.shan.mypubliclibrary.test;

import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.shan.mypubliclibrary.R;
import com.shan.mypubliclibrary.activity.BaseActivity;
import com.shan.mypubliclibrary.databinding.TestanimatoractivityBinding;
import com.shan.publiclibrary.manager.AnimatorManager;
import com.shan.publiclibrary.utils.ToastUtil;

/**
 * Created by 陈俊山 on 2016/7/22.
 */

public class TestAnimatorActivity extends BaseActivity<TestanimatoractivityBinding> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindContentView(R.layout.testanimatoractivity);
    }

    boolean status = true;

    @Override
    protected void initDatas() {
        mBinding.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.toast("我被点中了，嘻嘻");
            }
        });

        mBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*if (status){
                    status = false;
                    AnimatorManager.startAnimotion(mBinding.imageView,90f,270f,500,AnimatorManager.ROTATION);
                }else {
                    status = true;
                    AnimatorManager.startAnimotion(mBinding.imageView,270f,90f,500,AnimatorManager.ROTATION);
                }*/

                PropertyValuesHolder p1 = PropertyValuesHolder.ofFloat(AnimatorManager.ROTATION,0f,360f);
                PropertyValuesHolder p2 = PropertyValuesHolder.ofFloat(AnimatorManager.TRANSLATIONX,0f,200f);
                PropertyValuesHolder p3 = PropertyValuesHolder.ofFloat(AnimatorManager.TRANSLATIONY,0f,200f);
                AnimatorManager.startMultiAnimotion(mBinding.imageView,1000,p1,p2,p3);
            }
        });
    }
}
