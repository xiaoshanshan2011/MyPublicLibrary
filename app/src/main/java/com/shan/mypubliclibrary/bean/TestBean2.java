package com.shan.mypubliclibrary.bean;

/**
 * Created by 大唐天下 on 2016/9/10.
 */

public class TestBean2 {
    private String ivUrl;
    private String text;

    public TestBean2(String ivUrl, String text) {
        this.ivUrl = ivUrl;
        this.text = text;
    }

    public String getIvUrl() {
        return ivUrl;
    }

    public void setIvUrl(String ivUrl) {
        this.ivUrl = ivUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
