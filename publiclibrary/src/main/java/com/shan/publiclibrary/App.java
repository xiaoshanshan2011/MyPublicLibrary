package com.shan.publiclibrary;

import android.app.Application;

/**
 * Created by 陈俊山 on 2016/7/5.
 */
public class App extends Application {
    private static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = (App) getApplicationContext();
    }

    /**
     * 获取Application
     *
     * @return
     */
    public static App getApp() {
        return app;
    }
}
