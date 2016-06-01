package com.ralph.second;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by 果占先 on 2016/6/1.
 */
public class Ex35Activity extends BaseActivity {
    ImageView iv;

    AnimationDrawable ad;

    MediaPlayer music;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex35_layout);

        iv = (ImageView) findViewById(R.id.animIv);
        ad = (AnimationDrawable) iv.getBackground();
    }

    public void play(View view)
    {
        ad.start();
        if(music == null)
        {
            music = MediaPlayer.create(this,R.raw.bomb);
        }
        music.start();
    }

    public void stop(View view)
    {
        ad.stop();
    }
}
