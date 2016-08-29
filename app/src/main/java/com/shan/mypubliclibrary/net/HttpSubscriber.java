package com.shan.mypubliclibrary.net;

import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;

import com.shan.mypubliclibrary.bean.BaseBean;
import com.shan.publiclibrary.utils.PDUtil;
import com.shan.publiclibrary.utils.ToastUtil;

import rx.Subscriber;

/**
 * Created by 陈俊山 on 2016/8/28.
 */

public abstract class HttpSubscriber<T extends BaseBean> extends Subscriber<T> {
    private PDUtil pdUtil = null;

    public HttpSubscriber() {
    }

    public HttpSubscriber(Context context) {
        pdUtil = new PDUtil(context);
        pdUtil.setOnKeyListener(new DialogOnKeyListener());
    }

    @Override
    public void onStart() {
        super.onStart();
        if (pdUtil != null) {
            pdUtil.show();
        }
    }

    @Override
    public void onCompleted() {
        if (pdUtil != null) {
            pdUtil.dismiss();
        }
    }

    @Override
    public void onError(Throwable e) {
        onFailure(e);
        if (pdUtil != null) {
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

    private static class DialogOnKeyListener implements DialogInterface.OnKeyListener {

        @Override
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == KeyEvent.KEYCODE_BACK) {
                ToastUtil.toast("点击了返回");
            }
            return false;
        }
    }

}
