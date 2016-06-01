package com.ralph.second;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.StackView;

/**
 * Created by 果占先 on 2016/5/19.
 */
public class Ex16Activity extends BaseActivity {
    int[] i={R.drawable.icon_11,R.drawable.icon_28,R.drawable.icon_30,R.drawable.icon_33,R.drawable.icon_37};
    StackView sv;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex16_layout);
          sv= (StackView) findViewById(R.id.myview);
        BaseAdapter b=new BaseAdapter() {
            @Override
            public int getCount() {
                return i.length;
            }

            @Override
            public Object getItem(int position) {
                return i[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView iv=new ImageView(Ex16Activity.this);
                iv.setImageResource(i[position]);
                return iv;
            }
        };
        sv.setAdapter(b);
    }
    public  void last(View view){
        sv.showPrevious();
    }
    public  void next(View view){
    sv.showNext();
    }
}
