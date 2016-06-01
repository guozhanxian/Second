package com.ralph.second;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by 果占先 on 2016/6/1.
 */
public class Ex34Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Ex34View view = new Ex34View(this);
        view.setOnTouchListener(view);
        setContentView(view);
    }
}
