package com.ralph.second;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by 果占先 on 2016/5/31.
 */
public class Ex31Activity extends BaseActivity {
    EditText et;
    Intent i;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex31_layout);
        et = (EditText) findViewById(R.id.city);
        et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=new Intent(Ex31Activity.this,Ex31Activity2.class);
                startActivityForResult(i,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == 123)
        {
            String city = data.getStringExtra("city");
            et.setText(city);
        }
    }
}
