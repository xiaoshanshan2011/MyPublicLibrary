package com.shan.mypubliclibrary.broadcast;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import com.shan.publiclibrary.utils.ToastUtil;

/**
 * 公共广播
 * Created by 陈俊山 on 2016/7/22.
 */

public class CommonBCReceiver extends BroadcastReceiver {
    public static final String ACTIVITYFINISH = "com.shan.activityfinish";
    public static final String NOTIFICATION = "com.shan.notification";

    private CommonBCReceiver() {
    }

    private static CommonBCReceiver receiver = new CommonBCReceiver();

    public static CommonBCReceiver getReceiver() {
        return receiver;
    }

    //动态注册
    public void registerAction(Context mContext, String action) {
        IntentFilter filter = new IntentFilter();
        filter.addAction(action);
        mContext.registerReceiver(receiver, filter);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        //销毁所有注册该广播的Activity
        if (intent.getAction() == "com.shan.activityfinish") {
            Activity activity = (Activity) context;
            activity.finish();
        }
        //通知
        if (intent.getAction() == "com.shan.notification") {
            String content = intent.getStringExtra("content");
            ToastUtil.toast(content);
        }
    }
}
