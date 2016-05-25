package com.ralph.second;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by 果占先 on 2016/5/13.
 */
public class TestActivity extends Activity {

    int[] i={R.drawable.icon_11,R.drawable.icon_28,R.drawable.icon_30,R.drawable.icon_33,R.drawable.icon_37};
    int num=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);
        final ImageView iv= (ImageView) findViewById(R.id.image);
        iv.setImageResource(i[0]);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               iv.setImageResource(i[(++num)%5]);
            }
        });
    }
}
