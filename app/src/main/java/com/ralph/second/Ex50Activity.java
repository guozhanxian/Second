package com.ralph.second;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.io.IOException;

/**
 * Created by 果占先 on 2016/6/8.
 */
public class Ex50Activity extends BaseActivity implements View.OnClickListener {
    SurfaceView sv;
    Button play;
    Button pause;
    Button stop;

    MediaPlayer player;

    int position;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex50_layout);

        sv = (SurfaceView) findViewById(R.id.surfaceView);
        play = (Button) findViewById(R.id.playBtn);
        pause = (Button) findViewById(R.id.pauseBtn);
        stop = (Button) findViewById(R.id.stopBtn);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);

        player = new MediaPlayer();

        sv.getHolder().setKeepScreenOn(true);
        sv.getHolder().addCallback(new SurfaceListener());
    }

    @Override
    public void onClick(View v) {
        try{
            switch (v.getId())
            {
                case R.id.playBtn:
                    play();
                    break;
                case R.id.pauseBtn:
                    if(player.isPlaying())
                    {
                        player.pause();
                    }else{
                        player.start();
                    }
                    break;
                case R.id.stopBtn:
                    if(player.isPlaying())
                        player.stop();
                    break;
            }
        }catch(Exception e){
            Log.e("error",e.getMessage());
        }
    }

    public void play() throws IOException {
        player.reset();
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);
        player.setDataSource("/mnt/sdcard/mm.mp4");

        player.setDisplay(sv.getHolder());
        player.prepare();

        DisplayMetrics dm = getResources().getDisplayMetrics();
        sv.setLayoutParams(new LinearLayout.LayoutParams(dm.widthPixels,player.getVideoHeight()*dm.widthPixels/player.getVideoWidth()));

        player.start();
    }

    public class SurfaceListener implements SurfaceHolder.Callback
    {

        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            if(position>0)
            {
                try{
                    play();
                    player.seekTo(position);
                    position = 0;
                }catch(Exception e){
                    Log.e("error",e.getMessage());
                }
            }
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {

        }
    }

    @Override
    protected void onPause() {
        if(player.isPlaying())
        {
            position = player.getCurrentPosition();
            player.stop();
        }
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        if(player.isPlaying())
            player.stop();
        player.release();
        super.onDestroy();
    }
}
