package com.shan.mypubliclibrary.net;

import com.shan.mypubliclibrary.bean.BaseBean;
import com.shan.publiclibrary.utils.LogUtil;

import rx.Subscriber;

/**
 * Created by 陈俊山 on 2016/8/28.
 */

public abstract class HttpSubscriber<T extends BaseBean> extends Subscriber<T> {
    @Override
    public void onStart() {
        super.onStart();
        LogUtil.d("弹起ProgressDialog.........................");
    }

    @Override
    public void onCompleted() {
        LogUtil.d("关闭ProgressDialog.........................");
    }

    @Override
    public void onError(Throwable e) {
        LogUtil.d("关闭ProgressDialog.........................");
        onFailure(e);
    }

    @Override
    public void onNext(T t) {
        if (t.getShowapi_res_code() != 0) {
            onError(new Throwable());
            return;
        }
        onSuccess(t);
    }

    protected abstract void onSuccess(T t);

    protected abstract void onFailure(Throwable e);

}
