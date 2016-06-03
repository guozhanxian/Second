package com.ralph.second;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Created by 果占先 on 2016/6/3.
 */
public class Ex39Activity extends BaseActivity implements GestureDetector.OnGestureListener{
    ImageView iv;

    int[] data = {R.drawable.icon_41,R.drawable.icon_40,R.drawable.icon_37,R.drawable.icon_34,R.drawable.cake_icon_32};

    int index = 0;

    GestureDetector detector;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex39_layout);
        iv = (ImageView) findViewById(R.id.img);
        iv.setImageResource(data[index]);
        detector = new GestureDetector(this,this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return detector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        //向左是下一张
        //向右是上一张
        float x1 = e1.getX();
        float x2 = e2.getX();
        if(x2-x1>=50)
        {
            if(index>0)
            {
                iv.setImageResource(data[--index]);
            }
        }else if(x2-x1<=-50)
        {
            if(index<data.length-1)
            {
                iv.setImageResource(data[++index]);
            }
        }
        return true;
    }
}
