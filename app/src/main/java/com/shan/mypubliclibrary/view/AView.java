package com.shan.mypubliclibrary.view;

import com.shan.mypubliclibrary.bean.MovieBean;

/**
* Created by MVPHelper on 2016/10/02
*/

public interface AView{
    void onSuccess(MovieBean phoneQueryBean);

    void onFailure(Throwable e);
}