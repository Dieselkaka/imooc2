/*
 * Created by gisStation on 2017/11/16.
 */
package com.example.mylibrary.okhttp.listener;

/**
 * 项目名:    imooc2
 * 包名:      com.example.mylibrary.okhttp.listener
 * 文件名:    DisposeDataHandle
 * 创建者:    Diesel
 * 创建时间:     2017/11/16 17:05
 * 描述:      TODO
 * 修改时间:
 * 修改备注:
 */
public class DisposeDataHandle {
    public DisposeDataListener mListener = null;
    public Class<?> mClass = null;

    public DisposeDataHandle(DisposeDataListener mListener) {
        this.mListener = mListener;
    }

    public DisposeDataHandle(DisposeDataListener mListener, Class<?> mClass) {
        this.mListener = mListener;
        this.mClass = mClass;
    }
}
