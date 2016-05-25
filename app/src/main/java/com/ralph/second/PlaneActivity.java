package com.ralph.second;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

/**
 * Created by 果占先 on 2016/5/23.
 */
public class PlaneActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DisplayMetrics dm = getResources().getDisplayMetrics();
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        PlaneView p = new PlaneView(this);
        p.curX = width/2;
        p.curY = height/2;
        setContentView(p);
    }
}
