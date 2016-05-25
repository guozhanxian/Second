package com.ralph.second;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 果占先 on 2016/5/24.
 */
public class Ex20Activity extends Activity {
    String[] str = {"橘子", "苹果", "香蕉"};
    TextSwitcher ts;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex20_layout);

        ts = (TextSwitcher) findViewById(R.id.txtSwitch);
        ts.setFactory(new ViewSwitcher.ViewFactory()
        {
            @Override
            public View makeView()
            {
                TextView view = new TextView(Ex20Activity.this);
                view.setTextSize(30);
                view.setText(str[i++]);
                view.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                return view;
            }
        });
    }

    public void next(View view)
    {
        ts.setText(str[(i++) % 3]);

        Toast t = new Toast(Ex20Activity.this);
        LinearLayout layout = new LinearLayout(Ex20Activity.this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        ImageView image = new ImageView(Ex20Activity.this);
        image.setImageResource(R.drawable.airplane);
        TextView tv = new TextView(Ex20Activity.this);
        tv.setTextSize(50);
        tv.setText("飞机");

        layout.addView(image);
        layout.addView(tv);

        t.setView(layout);
        t.show();
    }
}


