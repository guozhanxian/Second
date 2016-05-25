package com.ralph.second;

import android.app.Activity;
import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

/**
 * Created by 果占先 on 2016/5/24.
 */
public class Ex23Activity extends TabActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex23_layout);

        TabHost host = getTabHost();

        TabHost.TabSpec tab1 = host.newTabSpec("tab1").setIndicator("我的电话").setContent(R.id.tab1);
        host.addTab(tab1);

        TabHost.TabSpec tab2 = host.newTabSpec("tab2").setIndicator("我的图片").setContent(R.id.tab2);
        host.addTab(tab2);

        TabHost.TabSpec tab3 = host.newTabSpec("tab3").setIndicator("我的主页").setContent(R.id.tab3);
        host.addTab(tab3);
    }
}
