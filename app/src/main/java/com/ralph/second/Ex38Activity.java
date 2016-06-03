package com.ralph.second;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/**
 * Created by 果占先 on 2016/6/3.
 */
public class Ex38Activity extends BaseActivity {
    StudentHelper helper;
    ListView lv;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex38_layout);

        helper = new StudentHelper(this,"student.db",null,Contants.DB_VERSION);
        lv = (ListView) findViewById(R.id.studList);

        Cursor c = helper.getReadableDatabase().query("student",null,null,null,null,null,null);
        SimpleCursorAdapter aca = new SimpleCursorAdapter(this,R.layout.ex09_row_layout,c,new String[]{"name","pic","age"},new int[]{R.id.studName,R.id.studPic,R.id.studAge},0);

        lv.setAdapter(aca);
    }
}
