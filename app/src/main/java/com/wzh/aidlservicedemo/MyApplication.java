package com.wzh.aidlservicedemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by 99210 on 2017/7/8.
 */

public class MyApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context getContext(){
        return context;
    }
}
