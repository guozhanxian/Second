package com.ralph.second;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by 果占先 on 2016/5/23.
 */
public class PlaneView extends View implements View.OnTouchListener{
    Bitmap plane;

    float curX;
    float curY;

    float dx;
    float dy;

    public PlaneView(Context context) {
        super(context);
        plane = BitmapFactory.decodeResource(getResources(),R.drawable.airplane);
        setOnTouchListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint p = new Paint();
        canvas.drawBitmap(plane,curX,curY,p);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                if(!(x>=curX && x<=curX+plane.getWidth()) || !(y>=curY && y<=curY+plane.getHeight()))
                {
                    return true;
                }
                dx = x - curX;
                dy = y - curY;
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_CANCEL:
                curX = x - dx;
                curY = y - dy;
                invalidate();
                return true;
        }
        return true;
    }
}
