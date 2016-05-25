package com.ralph.second;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Map;

/**
 * Created by 果占先 on 2016/5/24.
 */
public class Ex09Activity2 extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex09_layout2);

        Bundle b = getIntent().getBundleExtra("data");
        Map<String,Object> map = (Map<String, Object>) b.getSerializable("student");

        TextView name = (TextView) findViewById(R.id.studName);
        TextView age = (TextView) findViewById(R.id.studAge);
        ImageView img = (ImageView) findViewById(R.id.studImg);

        name.setText((String) map.get("studName"));
        age.setText((String) map.get("studAge"));
        img.setImageResource((Integer) map.get("studPic"));
    }
}
