package com.ralph.second;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by 果占先 on 2016/5/24.
 */
public class Ex19Activity extends Activity {
    int[] imgs = {R.drawable.icon_11,R.drawable.icon_13,R.drawable.icon_16,R.drawable.icon_18,
    R.drawable.icon_28,R.drawable.icon_30,R.drawable.icon_31,R.drawable.icon_33,R.drawable.icon_34,
    R.drawable.icon_37,R.drawable.icon_40,R.drawable.icon_41};
    List<Map<String ,Object>> list = new ArrayList<Map<String , Object>>();
    ImageSwitcher switcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex19_layout);

        GridView gv = (GridView) findViewById(R.id.grid);
        for(int i=0;i<imgs.length;i++){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("id",imgs[i]);
            list.add(map);
        }
        SimpleAdapter sa=new SimpleAdapter(this,list,R.layout.img_layout,new String[]{"id"},new int []{R.id.image});
        gv.setAdapter(sa);

        switcher = (ImageSwitcher) findViewById(R.id.switcher);
        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView view = new ImageView(Ex19Activity.this);
                view.setScaleType(ImageView.ScaleType.FIT_CENTER);
                view.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                return view;
            }
        });

        gv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switcher.setImageResource(imgs[position]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switcher.setImageResource(imgs[position]);
            }
        });
    }
}
