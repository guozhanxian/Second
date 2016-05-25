package com.ralph.second;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by 果占先 on 2016/5/12.
 */
public class Ex02Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyView vv = new MyView(this);
        vv.setOnTouchListener(vv);
//        vv.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                vv.x = event.getX();
//                vv.y = event.getY();
//                v.invalidate();
//                return true;
//            }
//        });

        setContentView(vv);
    }
}
