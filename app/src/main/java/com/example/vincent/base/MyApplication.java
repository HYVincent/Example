package com.example.vincent.base;

import android.app.Application;

import com.vincent.libary.log.MyLog;


/**
 * Created by Vincent on 2016/10/25.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MyLog.init("sample");//初始化 must
        MyLog.setSwitch(true);//日志开关，默认为关，debug模式需要手动打开

    }

}
