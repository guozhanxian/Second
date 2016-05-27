package com.ralph.second;


import android.content.Context;
import android.view.View;
import android.widget.Toast;

/**
 * Created by 果占先 on 2016/5/27.
 */
public class Ex27ButtonListener implements View.OnClickListener {
    private Context ctx;
    public Ex27ButtonListener(Context ctx)
    {
        this.ctx = ctx;
    }
    @Override
    public void onClick(View v) {
        Toast.makeText(ctx, "按钮被点击了！", Toast.LENGTH_SHORT).show();
    }
}
