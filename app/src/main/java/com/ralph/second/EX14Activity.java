package com.ralph.second;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by 果占先 on 2016/5/19.
 */
public class EX14Activity extends Activity {
    String [] s={"java","c","c#","html","jsp"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex14_layout);
        Spinner ss= (Spinner) findViewById(R.id.xiala);
        ArrayAdapter aa=new ArrayAdapter(this,android.R.layout.simple_list_item_1,s);
        ss.setAdapter(aa);
        ss.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String t="你选择的是"+s[position];
                Toast.makeText(EX14Activity.this,t , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
