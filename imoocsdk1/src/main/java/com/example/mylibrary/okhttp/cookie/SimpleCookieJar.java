/*
 * Created by gisStation on 2017/11/13.
 */
package com.example.mylibrary.okhttp.cookie;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * 项目名:    imooc2
 * 包名:      com.example.mylibrary.okhttp.cookie
 * 文件名:    SimpleCookieJar
 * 创建者:    Diesel
 * 创建时间:     2017/11/13 18:41
 * 描述:      TODO
 * 修改时间:
 * 修改备注:
 */
public final class SimpleCookieJar implements CookieJar{
    private final List<Cookie> allCookies = new ArrayList<>();

    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        allCookies.addAll(cookies);
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        List<Cookie> result = new ArrayList<>();
        for (Cookie cookie : allCookies){
            if (cookie.matches(url)){
                result.add(cookie);
            }
        }
        return result;
    }
}
