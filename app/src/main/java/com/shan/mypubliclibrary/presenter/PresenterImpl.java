package com.shan.mypubliclibrary.presenter;

import com.shan.mypubliclibrary.net.CancelRequestListener;

import rx.Subscription;

/**
 * Created by root on 16-10-2.
 */

public class PresenterImpl implements CancelRequestListener {
    protected Subscription subscription;

    @Override
    public void cancelRequest() {
        if (subscription != null) {
            //取消Http请求
            subscription.unsubscribe();
        }
    }
}
