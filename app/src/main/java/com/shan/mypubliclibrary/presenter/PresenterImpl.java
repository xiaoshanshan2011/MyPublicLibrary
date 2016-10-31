package com.shan.mypubliclibrary.presenter;

import com.shan.mypubliclibrary.net.CancelRequestListener;
import com.shan.mypubliclibrary.net.HttpRequestBuilder;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/**
 * Created by 陈俊山 on 16-10-2.
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

    public <T> void startReust(Observable observable, Subscriber<T> subscriber) {
        subscription = HttpRequestBuilder.getInstance().execute(observable, subscriber);
    }
}
