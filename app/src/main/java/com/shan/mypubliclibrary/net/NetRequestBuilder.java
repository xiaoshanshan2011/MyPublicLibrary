package com.shan.mypubliclibrary.net;

import android.nfc.Tag;
import android.text.TextUtils;

import com.shan.mypubliclibrary.bean.CallBean;

import java.io.IOException;
import java.util.LinkedList;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by 陈俊山 on 2016/8/19.
 */

public class NetRequestBuilder {

    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(NetService.BASEURL)
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static final NetService netservice = retrofit.create(NetService.class);

    public static NetService getNetService() {
        return netservice;
    }

    public static <T> void execute(String TAG, Call<T> call, NetCallback<T> netCallback) {
        pushCall(new CallBean(TAG, call));
        call.enqueue(netCallback);
    }

    private static OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .addHeader("PRAGMA-APPID", "12345678")
                                .addHeader("User-Agent", "xiaoshanshan")
                                .build();
                        return chain.proceed(request);
                    }
                })
                .addInterceptor(new MyInterceptor());
        return builder.build();
    }

    private static LinkedList<CallBean> list = new LinkedList();

    private static void pushCall(CallBean callBean) {
        list.push(callBean);
    }

    /**
     * 根据call移除请求
     *
     * @param call
     */
    public static void removeCall(Call call) {
        if (call == null || list.size() < 1) {
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCall().equals(call)) {
                call.cancel();
                list.remove(i);
                break;
            }
        }
    }

    /**
     * 根据tag移除请求
     *
     * @param tag
     */
    public static void removeCall(String tag) {
        if (TextUtils.isEmpty(tag) || list.size() < 1) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTag().equals(tag)) {
                list.get(i).getCall().cancel();
                list.remove(i);
            }
        }
    }

}
