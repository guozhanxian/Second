package com.ralph.second;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by 果占先 on 2016/6/7.
 */
public class Ex45Service extends Service {
    MediaPlayer player;

    @Override
    public void onCreate() {
        player = MediaPlayer.create(this,R.raw.wish);
        player.start();
    }

    @Override
    public void onDestroy() {
        player.stop();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
