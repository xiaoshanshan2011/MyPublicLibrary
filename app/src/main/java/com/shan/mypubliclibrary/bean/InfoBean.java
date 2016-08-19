package com.shan.mypubliclibrary.bean;

/**
 * Created by 大唐天下 on 2016/8/19.
 */

public class InfoBean {

    /**
     * code : 401
     * message : 访问成功
     * data : {}
     */

    private int code;
    private String message;

    @Override
    public String toString() {
        return "InfoBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
