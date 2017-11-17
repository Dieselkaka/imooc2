package com.example.mylibrary.okhttp.listener;
/*
 * Created by gisStation on 2017/11/13.
 */

/**
 * 自定义时间监听
 */

public interface DisposeDataListener {
    public void onSuccess(Object responseObj);

    public void onFailure(Object reasonObj);
}
