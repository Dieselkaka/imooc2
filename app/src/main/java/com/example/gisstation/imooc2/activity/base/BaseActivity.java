/*
 * Created by gisStation on 2017/11/8.
 */
package com.example.gisstation.imooc2.activity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * 项目名:    imooc2
 * 包名:      com.example.gisstation.imooc2.activity.base
 * 文件名:    BaseActivity
 * 创建者:    Diesel
 * 创建时间:     2017/11/8 19:06
 * 描述:      TODO
 * 修改时间:
 * 修改备注:
 */
public class BaseActivity extends AppCompatActivity {

    public String TAG;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = getComponentName().getShortClassName();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
