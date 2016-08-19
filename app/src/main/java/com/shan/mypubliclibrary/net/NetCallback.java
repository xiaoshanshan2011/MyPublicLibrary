package com.shan.mypubliclibrary.net;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 陈俊山 on 2016/8/19.
 */

public abstract class NetCallback<T> implements Callback<T> {

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.code() != 200) {
            onFailure(call, new RuntimeException(response.code() + ""));
            return;
        }
        onSuccess(response.body());
    }

    protected abstract void onSuccess(T result);


}
