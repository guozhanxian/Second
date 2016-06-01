package com.ralph.second;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by 果占先 on 2016/6/1.
 */
public class Ex34View extends View implements View.OnTouchListener{
    Bitmap bitmap;

    Matrix matrix;

    float degrees;

    int width;

    int height;

    int screenWidth;
    int screenHeight;

    public Ex34View(Context context) {
        super(context);
        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.airplane);
        matrix = new Matrix();
        degrees = 0.0f;

        width = bitmap.getWidth();
        height = bitmap.getHeight();

        DisplayMetrics mm = getResources().getDisplayMetrics();
        screenWidth = mm.widthPixels;
        screenHeight = mm.heightPixels;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        matrix.reset();
        matrix.setTranslate((screenWidth-width)/2,(screenHeight-height)/2);
        matrix.setRotate(degrees);
        //Bitmap b = Bitmap.createBitmap(bitmap,0,0,width,height,matrix,false);
        Paint p = new Paint();
        canvas.drawBitmap(bitmap,matrix,p);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float x = event.getX();
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                if(x<screenWidth/2)
                {
                    degrees -= 10;
                }else {
                    degrees += 10;
                }
                invalidate();
                break;
        }
        return false;
    }
}
