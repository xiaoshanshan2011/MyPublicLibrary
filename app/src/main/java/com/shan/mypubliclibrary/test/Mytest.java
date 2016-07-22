package com.shan.mypubliclibrary.test;

import android.content.Intent;

import com.shan.mypubliclibrary.MyApp;

/**
 * Created by 大唐天下 on 2016/7/22.
 */

public class Mytest {

    /**
     * 发送广播
     *
     * @param action
     */
    public static void sendBroadCast(String action) {
        Intent intent = new Intent(action);
        MyApp.getInstance().sendBroadcast(intent);
    }
}
