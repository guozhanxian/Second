package com.ralph.second;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by 果占先 on 2016/5/30.
 */
public class Ex30Activity extends Activity implements Ex30BookListFragment.Callback{
    boolean twoPan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex30_layout);

        if(findViewById(R.id.book_detail_container)!=null)
        {
            twoPan = true;
        }
    }


    @Override
    public void onItemSelected(Integer id) {
       if(twoPan)
       {
           Bundle b = new Bundle();
           b.putInt("item_id",id);

           Ex30BookDetailFragment f = new Ex30BookDetailFragment();
           f.setArguments(b);

           getFragmentManager().beginTransaction().replace(R.id.book_detail_container,f).commit();
       }else{
           Intent i = new Intent(this,Ex30ActivityBookDetail.class);
           i.putExtra("item_id",id);
           startActivity(i);
       }
    }
}
