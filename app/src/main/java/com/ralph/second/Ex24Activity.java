package com.ralph.second;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by 果占先 on 2016/5/24.
 */
public class Ex24Activity extends BaseActivity {
    NotificationManager nm;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex24_layout);

        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    public void sendMsg(View view)
    {
        Intent intent = new Intent(Ex24Activity.this,Ex23Activity.class);
        PendingIntent p = PendingIntent.getActivity(this,99,intent,0);

        Notification n = new Notification.Builder(this)
                .setAutoCancel(true)
                .setTicker("你有信息的消息--蝈蝈")
                .setSmallIcon(R.drawable.icon_18)
                .setContentTitle("明天换教室")
                .setContentText("太好了，终于换教室了，而且电脑也升级了！")
                .setWhen(System.currentTimeMillis())
                .setContentIntent(p)
                .build();

        nm.notify(0x987,n);
    }

    public void delMsg(View view)
    {
        nm.cancel(0x987);
    }
}
