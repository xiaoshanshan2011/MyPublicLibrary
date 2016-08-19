package com.shan.mypubliclibrary.bean;

import retrofit2.Call;

/**
 * Created by 陈俊山 on 2016/8/19.
 */

public class CallBean {
    private String tag;
    private Call call;

    public CallBean(String tag, Call call) {
        this.tag = tag;
        this.call = call;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Call getCall() {
        return call;
    }

    public void setCall(Call call) {
        this.call = call;
    }
}
