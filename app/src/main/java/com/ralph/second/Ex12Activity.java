package com.ralph.second;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

/**
 * Created by 果占先 on 2016/5/19.
 */
public class Ex12Activity extends Activity {
    String[] arr = {"aaa","aab","aac","abb","bbc","bbd","bca","caa","cdd","ccc"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex12_layout);

        AutoCompleteTextView txt = (AutoCompleteTextView) findViewById(R.id.searchTxt);
        ArrayAdapter ad = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arr);
        txt.setAdapter(ad);
    }
}
