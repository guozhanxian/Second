package com.ralph.second;

import android.app.Application;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushManager;
import com.baidu.mapapi.SDKInitializer;

/**
 * Created by 果占先 on 2016/6/16.
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        SDKInitializer.initialize(getApplicationContext());
        PushManager.startWork(getApplicationContext(), PushConstants.LOGIN_TYPE_API_KEY,"TPr2fI9C9YCBQvnPZQhqpDXw");
        PushManager.enableLbs(getApplicationContext());
        super.onCreate();
    }
}
