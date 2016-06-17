package com.ralph.second;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 果占先 on 2016/6/17.
 */
public class Ex59Activity extends BaseActivity {
    @BindView(R.id.data)
    EditText txt;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex59_layout);
    }

    @OnClick(R.id.btn)
    public void hello(View view)
    {
        txt.setText("Hello world"+new Date());
    }
}
