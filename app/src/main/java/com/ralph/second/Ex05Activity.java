package com.ralph.second;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by 果占先 on 2016/5/17.
 */
public class Ex05Activity  extends BaseActivity{

    public int[] a = {R.drawable.icon_11,R.drawable.icon_28,R.drawable.icon_30,R.drawable.icon_33,R.drawable.icon_37};

    public int i = 0;
    int alpha = 255;
    ImageView imgView;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex05_layout);
        imgView = (ImageView)findViewById(R.id.myimage);
        imgView.setImageResource(a[0]);
    }

   public void last(View view){
       imgView.setImageResource(a[Math.abs(--i)%5]);
   }
    public void next(View view){
        imgView.setImageResource(a[Math.abs(++i)%5]);
    }
    public void tjia(View view){
        alpha+=10;
        if(alpha > 255){
            imgView.setImageAlpha(255);
            alpha = 255;
        }else{
            imgView.setImageAlpha(alpha);
        }

    }
    public void tjian(View view){
        alpha-=10;
        if(alpha < 0){
            imgView.setImageAlpha(0);
            alpha=0;
        }else{
            imgView.setImageAlpha(alpha);
        }
    }

}
