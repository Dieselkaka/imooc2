/*
 * Created by gisStation on 2017/11/8.
 */
package com.example.gisstation.imooc2.application;

import android.app.Application;

/**
 * 项目名:    imooc2
 * 包名:      com.example.gisstation.imooc2.application
 * 文件名:    MyApplication
 * 创建者:    Diesel
 * 创建时间:     2017/11/8 13:01
 * 描述:      TODO
 * 修改时间:
 * 修改备注:
 */
public class MyApplication extends Application{

    private static MyApplication myApplication = null;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
    }

    public static MyApplication getInstance() {
        return myApplication;
    }
}
