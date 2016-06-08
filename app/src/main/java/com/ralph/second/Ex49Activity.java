package com.ralph.second;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.File;

/**
 * Created by 果占先 on 2016/6/8.
 */
public class Ex49Activity extends BaseActivity {
    VideoView vv;
    MediaController mc;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex49_layout);
        vv = (VideoView) findViewById(R.id.videoView);
        mc = new MediaController(this);

        File file = new File("/mnt/sdcard/mm.mp4");
        if(file.exists())
        {
            vv.setVideoPath(file.getAbsolutePath());

            vv.setMediaController(mc);
            mc.setMediaPlayer(vv);

            vv.requestFocus();
        }
    }
}
