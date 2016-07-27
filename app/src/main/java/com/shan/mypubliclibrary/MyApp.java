package com.shan.mypubliclibrary;

import android.graphics.Bitmap;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;
import com.shan.publiclibrary.App;

import java.io.File;

import cn.finalteam.galleryfinal.CoreConfig;
import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.ThemeConfig;

/**
 * Created by 陈俊山 on 2016/7/5.
 */
public class MyApp extends App {
    private static MyApp instance;

    public static MyApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    /**
     * MyApp初始化操作
     */
    private void init() {
        instance = (MyApp) getApplicationContext();
    }
}
