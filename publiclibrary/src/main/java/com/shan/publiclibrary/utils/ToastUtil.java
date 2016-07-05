package com.shan.publiclibrary.utils;

import android.widget.Toast;

import com.shan.publiclibrary.App;

/**
 * Created by 陈俊山 on 2016/7/5.
 */
public class ToastUtil {
    private static Toast toast;

    /**
     * 短时间Toast
     *
     * @param msg
     */
    public static void toast(String msg) {
        if (toast == null) {
            toast = Toast.makeText(App.getInstance(), msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
        }
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }

    /**
     * 长时间Toast
     * @param msg
     */
    public static void toastlong(String msg) {
        if (toast == null) {
            toast = Toast.makeText(App.getInstance(), msg, Toast.LENGTH_LONG);
        } else {
            toast.setText(msg);
        }
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }

}
