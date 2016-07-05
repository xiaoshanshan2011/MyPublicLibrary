package com.shan.publiclibrary;

import android.app.Application;

/**
 * Created by Administrator on 2016/7/5.
 */
public class App extends Application {
    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = (App) getApplicationContext();
    }

    /**
     * 获取Application
     *
     * @return
     */
    public static App getInstance() {
        return instance;
    }
}
