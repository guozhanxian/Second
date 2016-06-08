package com.ralph.second;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 果占先 on 2016/6/8.
 */
public class Ex48Activity extends BaseActivity {
    Map<Integer,Integer> map = new HashMap<Integer,Integer>();

    SoundPool pool;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex48_layout);

//        AudioAttributes attr = new AudioAttributes.Builder()
//                .setUsage(AudioAttributes.USAGE_GAME)
//                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
//                .build();
        pool = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);

        map.put(1,pool.load(this,R.raw.arrow,1));
        map.put(2,pool.load(this,R.raw.bomb,1));
        map.put(3,pool.load(this,R.raw.shot,1));
    }

    public void bomb(View view)
    {
        pool.play(map.get(2),1,1,0,0,1);
    }

    public void shot(View view)
    {
        pool.play(map.get(3),1,1,0,0,1);
    }

    public void arrow(View view)
    {
        pool.play(map.get(1),1,1,0,0,1);
    }
}
