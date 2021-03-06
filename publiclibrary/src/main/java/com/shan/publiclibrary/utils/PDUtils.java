package com.shan.publiclibrary.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.shan.publiclibrary.R;

/**
 * Created by 陈俊山 on 2016/9/7.
 */

public class PDUtils extends Dialog {

    public PDUtils(Context context, boolean isCancel) {
        super(context);
        View view = LayoutInflater.from(context).inflate(R.layout.loading_layout, null);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//取消标题
        this.setCanceledOnTouchOutside(isCancel);//点击屏幕消失
        this.setContentView(view);
        Window dialogwWindow = this.getWindow();
        WindowManager.LayoutParams lp = dialogwWindow.getAttributes();
        dialogwWindow.setGravity(Gravity.CENTER);
        dialogwWindow.setAttributes(lp);
        dialogwWindow.setBackgroundDrawableResource(R.drawable.dialog_square_shape);
    }
}
