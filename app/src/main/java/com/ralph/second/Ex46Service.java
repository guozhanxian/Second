package com.ralph.second;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by 果占先 on 2016/6/7.
 */
public class Ex46Service extends Service {

    private boolean flag;

    private int count;

    private CountBinder binder = new CountBinder();

    public class CountBinder extends Binder
    {
        public int getCount()
        {
            return count;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void onCreate() {
        (new Thread(){
            @Override
            public void run() {
                while(!flag)
                {
                    try{
                        Thread.sleep(1000);
                    }catch(Exception e){
                        Log.e("error",e.getMessage());
                    }
                    count++;
                }
            }
        }).start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.flag = true;
    }
}
