/*
 * Created by gisStation on 2017/11/17.
 */
package com.example.mylibrary.imageloader;

/**
 * 项目名:    imooc2
 * 包名:      com.example.mylibrary.imageloader
 * 文件名:    ImageLoaderManager
 * 创建者:    Diesel
 * 创建时间:     2017/11/17 13:44
 * 描述:      初始化UniversityImagerLoader，并用来加载图片
 * 修改时间:
 * 修改备注:
 */
public class ImageLoaderManager {

    private  static final int THREAD_COUNT = 4;//标明我们的UIL最多可以有多少条线程
    private static final int PROPRITY = 2;//标明我们图片加载的一个优先级
    private static final int DISK_CACHE_SIZE = 50 * 1024;//标明UIL最多可以缓存多少图片
    private static final int CONNECTION_TIME_OUT = 5*1000;//连接的超时时间
    private static final int READ_TIME_OUT = 30*1000;//读取的超时时间
}
