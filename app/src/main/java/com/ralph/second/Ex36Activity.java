package com.ralph.second;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by 果占先 on 2016/6/2.
 */
public class Ex36Activity extends BaseActivity {
    SurfaceHolder holder;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex36_layout);

        SurfaceView sv = (SurfaceView) findViewById(R.id.myview);
        holder = sv.getHolder();

        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                Canvas can = holder.lockCanvas();
                can.drawColor(Color.WHITE);
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.airplane);
                can.drawBitmap(bitmap,0,0,null);
                holder.unlockCanvasAndPost(can);

                holder.lockCanvas(new Rect(0,0,0,0));
                holder.unlockCanvasAndPost(can);
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });
    }
}
