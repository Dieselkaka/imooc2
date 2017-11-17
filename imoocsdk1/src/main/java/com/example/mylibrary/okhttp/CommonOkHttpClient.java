/*
 * Created by gisStation on 2017/11/9.
 */
package com.example.mylibrary.okhttp;


import com.example.mylibrary.okhttp.cookie.SimpleCookieJar;
import com.example.mylibrary.okhttp.https.HttpsUtiles;
import com.example.mylibrary.okhttp.response.CommonJsonCallback;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * 项目名:    imooc2
 * 包名:      com.example.mylibrary.okhttp
 * 文件名:    CommonOkHttpClient
 * 创建者:    Diesel
 * 创建时间:     2017/11/9 16:30
 * 描述:      请求的发送，请求参数的配置，https支持
 * 修改时间:
 * 修改备注:
 */
public class CommonOkHttpClient {

    private static final int TIME_OUT = 30;//超时参数
    private static OkHttpClient mOkHttpClinent;

    //为我们的client去配置参数
    static {
        //创建我们client对象的构建者
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
        //是为构建者填充超时时间
        okHttpBuilder.cookieJar(new SimpleCookieJar());
        okHttpBuilder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpBuilder.readTimeout(TIME_OUT,TimeUnit.SECONDS);
        okHttpBuilder.writeTimeout(TIME_OUT,TimeUnit.SECONDS);

        okHttpBuilder.followRedirects(true);
        //https支持
        okHttpBuilder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String s, SSLSession sslSession) {
                return true;
            }
        });
        okHttpBuilder.sslSocketFactory(HttpsUtiles.getSslSocketFactory());
        mOkHttpClinent = okHttpBuilder.build();
    }

    /**
     * 发送具体的http/https请求
     *
     * @param request
     * @param commCallback
     * @return Call
     */
    public static Call sendRequest(Request request, CommonJsonCallback commCallback){
        Call call = mOkHttpClinent.newCall(request);
        call.enqueue(commCallback);

        return call;
    }
}
