package com.shan.mypubliclibrary.test;

import android.animation.PropertyValuesHolder;
import android.view.View;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.shan.mypubliclibrary.R;
import com.shan.mypubliclibrary.activity.BaseActivity;
import com.shan.mypubliclibrary.databinding.TestanimatoractivityBinding;
import com.shan.publiclibrary.manager.AnimatorManager;
import com.shan.publiclibrary.utils.ToastUtils;

/**
 * Created by 陈俊山 on 2016/7/22.
 */

public class TestAnimatorActivity extends BaseActivity<TestanimatoractivityBinding, Object> {

    @Override
    public int bindLayout() {
        return R.layout.testanimatoractivity;
    }

    @Override
    public void initOnCreate() {
        ImageLoader.getInstance().displayImage("http://pic1a.nipic.com/2008-10-08/2008108135051971_2.jpg", mBinding.image);
        //获取缓存文件
        /*String path = ImageLoader.getInstance().getDiskCache().get("http://pic1a.nipic.com/2008-10-08/2008108135051971_2.jpg").getAbsolutePath();
        LogUtil.i(path);
        Bitmap bitmap = BitmapFactory.decodeFile(path);
        mBinding.image.setImageBitmap(bitmap);*/

        mBinding.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtils.toast("我被点中了，嘻嘻");
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

                PropertyValuesHolder p1 = PropertyValuesHolder.ofFloat(AnimatorManager.ROTATION, 0f, 360f);
                PropertyValuesHolder p2 = PropertyValuesHolder.ofFloat(AnimatorManager.TRANSLATIONX, 0f, 200f);
                PropertyValuesHolder p3 = PropertyValuesHolder.ofFloat(AnimatorManager.TRANSLATIONY, 0f, 200f);
                AnimatorManager.startMultiAnimotion(mBinding.imageView, 1000, p1, p2, p3);
            }
        });
    }

}
