/*
 * Created by gisStation on 2017/11/16.
 */
package com.example.mylibrary.okhttp.response;

import android.os.Handler;
import android.os.Looper;

import com.example.mylibrary.loopj.androidhttp.commonhttp.ResponseEntityToModule;
import com.example.mylibrary.okhttp.exception.OkHttpException;
import com.example.mylibrary.okhttp.listener.DisposeDataHandle;
import com.example.mylibrary.okhttp.listener.DisposeDataListener;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 项目名:    imooc2
 * 包名:      com.example.mylibrary.okhttp.response
 * 文件名:    CommonJsonCallback
 * 创建者:    Diesel
 * 创建时间:     2017/11/16 19:03
 * 描述:      专门处理JSON的回调响应
 * 修改时间:
 * 修改备注:
 */
public class CommonJsonCallback implements Callback{

    //与服务器返回的字段的一个对应关系
    protected  final  String RESULT_CODE = "ecode";//有返回则对于http请求来说是成功的，但还有可能是业务逻辑上的错误
    protected final int RESULT_CODE_VALUE = 0;
    protected final String ERROR_MSG = "emsg";
    protected final String EMPTY_MSG = "";

    /**
     * 自定义异常类型
     */
    protected final int NETWORK_ORROR = -1;
    protected final int JSON_ERROR = -2;
    protected final int OTHER_ERROR = -3;

    private Handler mDeliveryHandler;//进行消息的转发
    private DisposeDataListener mListener;
    private Class<?> mClass;

    public CommonJsonCallback(DisposeDataHandle handle) {
        this.mListener = handle.mListener;
        this.mClass = handle.mClass;
        this.mDeliveryHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void onFailure(Call call, final IOException e) {
/**
 * 此时还在非UI线程，因此转发
 */
        mDeliveryHandler.post(new Runnable() {
            @Override
            public void run() {
                mListener.onFailure(new OkHttpException(NETWORK_ORROR,e));
            }
        });
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        final String result = response.body().string();
        mDeliveryHandler.post(new Runnable() {
            @Override
            public void run() {
                handleResponse(result);
            }
        });

    }

    private void handleResponse(Object responseObj) {
        //为了保证代码的健壮性
        if (responseObj == null && responseObj.toString().trim().equals("")) {
            mListener.onFailure(new OkHttpException(NETWORK_ORROR, EMPTY_MSG));
            return;
        }

        try{
            JSONObject result = new JSONObject(responseObj.toString());

            //开始尝试解析json
            if (result.has(RESULT_CODE)){
                //从json对象中去除我们的响应码，若为0，则是正确的响应
                if (result.getInt(RESULT_CODE) == RESULT_CODE_VALUE){
                    if (mClass == null){
                        //不需要解析，直接返回到应用层
                        mListener.onSuccess(responseObj);
                    }else {
                        //即，需要我们将json对象转化为实体对象
                        Object obj = ResponseEntityToModule.parseJsonObjectToModule(result,mClass);
                        //标明正确的转为了实体对象
                        if (obj != null){
                            mListener.onSuccess(obj);
                        }else {
                            //返回的不是合法的json
                            mListener.onFailure(new OkHttpException(JSON_ERROR,EMPTY_MSG));
                        }
                    }
                }
            }else {
                mListener.onFailure(new OkHttpException(OTHER_ERROR,result.get(RESULT_CODE)));
            }
        }catch (Exception e){
            mListener.onFailure(new OkHttpException(OTHER_ERROR,e.getMessage()));
        }
    }
}
