package com.shan.mypubliclibrary.net;

import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;

import com.shan.mypubliclibrary.bean.BaseBean;
import com.shan.publiclibrary.utils.PDUtil;

import rx.Subscriber;

/**
 * 处理请求回调
 * Created by 陈俊山 on 2016/8/28.
 */

public abstract class SubscriberCallBack<T extends BaseBean> extends Subscriber<T> {
    private PDUtil pdUtil = null;
    private CancelRequestListener cancelRequestListener;

    //不启动ProgressDialog
    public SubscriberCallBack() {
    }

    //启动ProgressDialog，并注册取消请求监听
    public SubscriberCallBack(Context context, CancelRequestListener cancelRequestListener) {
        pdUtil = new PDUtil(context);
        pdUtil.setOnKeyListener(new DialogOnKeyListener());
        this.cancelRequestListener = cancelRequestListener;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (pdUtil != null && !pdUtil.isShowing()) {
            pdUtil.show();
        }
    }

    @Override
    public void onCompleted() {
        if (pdUtil != null && pdUtil.isShowing()) {
            pdUtil.dismiss();
        }
    }

    @Override
    public void onError(Throwable e) {
        onFailure(e);
        if (pdUtil != null && pdUtil.isShowing()) {
            pdUtil.dismiss();
        }
    }

    @Override
    public void onNext(T t) {
        if (t.getShowapi_res_code() != 0) {
            onError(new RuntimeException("哈哈哈，我错了"));
            return;
        }
        onSuccess(t);
    }

    protected abstract void onSuccess(T t);

    protected abstract void onFailure(Throwable e);

    private class DialogOnKeyListener implements DialogInterface.OnKeyListener {

        @Override
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == KeyEvent.KEYCODE_BACK) {
                onError(new RuntimeException("取消请求"));
                cancelRequestListener.cancelRequest();
            }
            return false;
        }
    }

}