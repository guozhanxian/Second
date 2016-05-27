package com.ralph.second;

import android.os.Bundle;
import android.widget.Button;

/**
 * Created by 果占先 on 2016/5/27.
 */
public class Ex27Activity extends BaseActivity {
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex27_layout);

        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new Ex27ButtonListener(this));
    }
}
