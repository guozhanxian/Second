package com.ralph.second;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 果占先 on 2016/6/1.
 */
public class Ex33Activity extends BaseActivity {
    Bitmap b;
    ImageView img;
    int n=0;

    String[] arr = {"http://img.mp.itc.cn/upload/20160530/75a59ee8d2d84212a4cdbcdda8cd028a_th.jpg",
    "http://d.youth.cn/shrgch/201605/W020160531368443687519.jpg",
    "http://img.mp.itc.cn/upload/20160530/18552133911448c08e1ba12fee52199b_th.jpg",
    "http://img.mp.itc.cn/upload/20160530/d663cb505b0e45e68184059a2298289d_th.jpg",
    "http://news.k618.cn/history/lsqw/201605/W020160531288646546985.jpg"};

    Handler h = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            BitmapDrawable bd = (BitmapDrawable) img.getDrawable();
            if(bd!=null && !bd.getBitmap().isRecycled())
            {
                bd.getBitmap().recycle();
            }
            img.setImageBitmap(b);
        }
    };

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex33_layout);
        img = (ImageView) findViewById(R.id.imagehehe);
    }

    public void next(View view){
        (new Thread() {
            @Override
            public void run() {
                try {
                    URL url = new URL(arr[(n++)%arr.length]);
                    b = BitmapFactory.decodeStream(url.openStream());
                    Message m = new Message();
                    h.sendMessage(m);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                super.run();
            }
        }).start();
    }
}
