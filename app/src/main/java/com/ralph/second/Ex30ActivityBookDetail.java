package com.ralph.second;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by 果占先 on 2016/5/30.
 */
public class Ex30ActivityBookDetail extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex30_layout2);

        if(savedInstanceState == null)
        {
            Ex30BookDetailFragment f = new Ex30BookDetailFragment();
            Bundle b = new Bundle();
            b.putInt("item_id",getIntent().getIntExtra("item_id",0));
            f.setArguments(b);

            getFragmentManager().beginTransaction().replace(R.id.book_detail_container,f).commit();
        }
    }
}
