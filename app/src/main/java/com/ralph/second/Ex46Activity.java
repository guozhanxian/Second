package com.ralph.second;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Toast;

/**
 * Created by 果占先 on 2016/6/7.
 */
public class Ex46Activity extends BaseActivity {
    Ex46Service.CountBinder binder;

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            binder = (Ex46Service.CountBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    };

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex46_layout);
    }

    public void startBind(View view)
    {
        Intent i = new Intent(this,Ex46Service.class);
        bindService(i,conn, Service.BIND_AUTO_CREATE);
    }

    public void stopBind(View view)
    {
        unbindService(conn);
    }

    public void getData(View view)
    {
        int num = binder.getCount();
        Toast.makeText(Ex46Activity.this, "取到的数字是："+num, Toast.LENGTH_LONG).show();
    }
}
