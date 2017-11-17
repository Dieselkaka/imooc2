/*
 * Created by gisStation on 2017/11/16.
 */
package com.example.mylibrary.okhttp.exception;

/**
 * 项目名:    imooc2
 * 包名:      com.example.mylibrary.okhttp.exception
 * 文件名:    OkHttpException
 * 创建者:    Diesel
 * 创建时间:     2017/11/16 19:36
 * 描述:      TODO
 * 修改时间:
 * 修改备注:
 */
public class OkHttpException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * the server return code
     */
    private int ecode;

    /**
     * the server return error message
     */
    private Object emsg;

    public OkHttpException(int ecode, Object emsg) {
        this.ecode = ecode;
        this.emsg = emsg;
    }

    public int getEcode() {
        return ecode;
    }

    public Object getEmsg() {
        return emsg;
    }
}
