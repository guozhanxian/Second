package com.ralph.second;

import android.app.Activity;
import android.os.Bundle;
import android.widget.QuickContactBadge;

/**
 * Created by 果占先 on 2016/5/17.
 */
public class Ex06Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex06_layout);

        QuickContactBadge qc = (QuickContactBadge) findViewById(R.id.quickContactBadge);
        qc.assignContactFromPhone("13889221849",false);
    }
}
