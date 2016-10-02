package com.shan.mypubliclibrary.listener;

/**
* Created by MVPHelper on 2016/10/02
*/

public interface RequestListener<T>{
    void onSuccess(T t);

    void onFailure(Throwable e);
}