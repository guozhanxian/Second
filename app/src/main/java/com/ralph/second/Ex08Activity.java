package com.ralph.second;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by 果占先 on 2016/5/18.
 */
public class Ex08Activity extends BaseActivity {
    String[] arr = {"沈阳","北京","哈尔滨","上海","深圳"};
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex08_layout);

        ListView view = (ListView) findViewById(R.id.cityList);
        ArrayAdapter ad = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arr);
        view.setAdapter(ad);

    }
}
