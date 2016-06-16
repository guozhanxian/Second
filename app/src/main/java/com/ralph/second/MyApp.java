package com.ralph.second;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by 果占先 on 2016/6/16.
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        SDKInitializer.initialize(getApplicationContext());
        super.onCreate();
    }
}
