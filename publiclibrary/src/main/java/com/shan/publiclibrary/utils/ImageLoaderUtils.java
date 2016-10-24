package com.shan.publiclibrary.utils;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.shan.publiclibrary.R;

/**
 * Created by root on 16-10-16.
 */

public class ImageLoaderUtils {

    private static DisplayImageOptions options = null;

    private static DisplayImageOptions getDisplayImageOptions() {
        if (options == null) {
            options = new DisplayImageOptions.Builder()
                    // 设置图片在下载期间显示的图片
                    .showImageOnLoading(R.drawable.ic_delete_photo)
                    // 设置图片Uri为空或是错误的时候显示的图片
                    .showImageForEmptyUri(R.drawable.ic_delete_photo)
                    // 设置图片加载/解码过程中错误时候显示的图片
                    .showImageOnFail(R.drawable.ic_delete_photo)
                    .showStubImage(R.drawable.ic_delete_photo)
                    // 加载图片前重新恢复View
                    .resetViewBeforeLoading(true)
                    // 缓存到SD卡
                    .cacheOnDisk(true)
                    // 缓存到内存
                    .cacheInMemory(true)
                    // 是否考虑JPEG图像EXIF参数（旋转，翻转）
                    .considerExifParams(true)
                    .build();
        }
        return options;
    }

    /**
     * 加载头像
     *
     * @param imageView
     * @param url
     */
    public static void load(final ImageView imageView, String url) {
        if (TextUtils.isEmpty(url) || (!url.contains(".jpg") && !url.contains(".png"))) {
            imageView.setImageResource(R.drawable.ic_delete_photo);
            return;
        }
        final ImageSize imageSize = new ImageSize(100, 80);
        ImageLoader.getInstance().loadImage(url, imageSize, getDisplayImageOptions(), new SimpleImageLoadingListener() {
            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                super.onLoadingComplete(imageUri, view, loadedImage);
                if (loadedImage == null) {
                    imageView.setImageResource(R.drawable.ic_delete_photo);
                } else {
                    imageView.setImageBitmap(loadedImage);
                }

            }
        });
    }
}
