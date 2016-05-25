package com.ralph.second;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by 果占先 on 2016/5/17.
 */
public class Ex04Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex04_layout);

        Toast.makeText(Ex04Activity.this, "你好你好你好！", Toast.LENGTH_LONG).show();

        ToggleButton btn = (ToggleButton) findViewById(R.id.wifiBtn);
        btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(Ex04Activity.this, "Open Wifi", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Ex04Activity.this, "Close Wifi", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void sendMsg(View view) {
        final Button btn = (Button) findViewById(R.id.sendMsgBtn);
        btn.setEnabled(false);
        final Chronometer ch = (Chronometer) findViewById(R.id.chronometer);
        ch.setBase(SystemClock.elapsedRealtime());
        ch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            private int t = 20;
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if((SystemClock.elapsedRealtime()-chronometer.getBase())>20*1000)
                {
                    btn.setText("发送验证码");
                    btn.setEnabled(true);
                    ch.stop();
                }else{
                    btn.setText("倒计时"+(t--));
                }
            }
        });
        ch.start();
    }

    public void isPass(View view) {
        EditText et = (EditText) findViewById(R.id.buyDate);
        String s = et.getText().toString();
        String nian = s.substring(0, 4);
        String yue = s.substring(5, 7);
        String day = s.substring(8);
        Calendar c = Calendar.getInstance();
        c.set(Integer.parseInt(nian), Integer.parseInt(yue), Integer.parseInt(day));
        Calendar now = Calendar.getInstance();
        c.add(Calendar.MONTH, 6);
        if (c.after(now)) {
            Toast.makeText(Ex04Activity.this, "没有过保质期", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(Ex04Activity.this, "以过保质期", Toast.LENGTH_SHORT).show();
        }
    }
}

