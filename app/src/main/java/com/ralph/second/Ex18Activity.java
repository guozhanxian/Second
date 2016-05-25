package com.ralph.second;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.SeekBar;

/**
 * Created by 果占先 on 2016/5/23.
 */
public class Ex18Activity extends Activity {
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex18_layout);

        image = (ImageView) findViewById(R.id.img);
        SeekBar sb = (SeekBar) findViewById(R.id.seek);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                image.setImageAlpha(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        RatingBar rb = (RatingBar) findViewById(R.id.starRate);
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                image.setImageAlpha((int) (rating*255/5));
            }
        });
    }
}
