package com.ralph.second;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

/**
 * Created by 果占先 on 2016/6/6.
 */
public class Ex44Activity extends BaseActivity {
    ListView lv;
    ContentResolver cr;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex44_layout);

        lv = (ListView) findViewById(R.id.studList);

        cr = getContentResolver();

        Uri uri = Uri.parse("content://com.ralph.second/students");
        Cursor c = cr.query(uri,null,null,null,null,null);

        SimpleCursorAdapter aca = new SimpleCursorAdapter(this,R.layout.ex09_row_layout,c,new String[]{"name","age"},new int[]{R.id.studName,R.id.studAge},0);
        lv.setAdapter(aca);
    }
}
