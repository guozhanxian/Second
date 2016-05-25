package com.ralph.second;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

/**
 * Created by 果占先 on 2016/5/19.
 */
public class Ex11Activity extends ListActivity {
    String[] arr = {"沈阳","北京","哈尔滨","上海","深圳"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter ad = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arr);
        setListAdapter(ad);
    }
}
