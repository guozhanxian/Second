package com.ralph.second;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends BaseActivity {
    String[] names = {"Hello World","画心形图像","获取短信验证码","Chronometer倒计时和保修期计算"
    ,"循环显示五张图片","Preference配置"};
    Class[] clazz = {Ex01Activity.class,Ex02Activity.class,Ex03Activity.class,Ex04Activity.class
    ,Ex05Activity.class,Ex29Activity.class};
    ListView listView;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_list_item_1,names);
        listView.setAdapter(aa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this,clazz[position]);
                startActivity(i);
            }
        });
    }
}
