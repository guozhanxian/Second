package com.ralph.second;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by 果占先 on 2016/6/7.
 */
public class Ex45Activity extends BaseActivity {
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex45_layout);
    }

    public void startPlay(View view)
    {
        Intent i = new Intent(this,Ex45Service.class);
        startService(i);
    }

    public void stopPlay(View view)
    {
        Intent i = new Intent(this,Ex45Service.class);
        stopService(i);
    }
}
