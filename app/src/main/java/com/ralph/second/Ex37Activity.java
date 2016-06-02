package com.ralph.second;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 果占先 on 2016/6/2.
 */
public class Ex37Activity extends BaseActivity {
    SharedPreferences sp;

    SharedPreferences.Editor editor;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex37_layout);

        sp = getSharedPreferences("ex37",MODE_PRIVATE);
        editor = sp.edit();
    }

    public void writeData(View view)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        editor.putString("time",sdf.format(new Date()));
        editor.putInt("rand", (int) (Math.random()*50));
        editor.commit();
    }

    public void readData(View view)
    {
        String time = sp.getString("time","没有存放时间");
        int rand = sp.getInt("rand",-1);
        Toast.makeText(Ex37Activity.this, "系统时间是："+time+"，生成的随机数是"+rand, Toast.LENGTH_SHORT).show();
    }
}
