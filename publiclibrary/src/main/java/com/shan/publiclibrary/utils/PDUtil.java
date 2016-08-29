package com.shan.publiclibrary.utils;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by 陈俊山 on 2016/8/29.
 */

public class PDUtil extends ProgressDialog{

    public PDUtil(Context context) {
        super(context);
        this.setMessage("数据加载中...");
        this.setProgressStyle(ProgressDialog.STYLE_SPINNER);
    }
}
