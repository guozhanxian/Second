package com.ralph.second;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

/**
 * Created by 果占先 on 2016/5/24.
 */
public class Ex21Activity extends Activity {
    CalendarView cv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex21_layout);

        cv = (CalendarView) findViewById(R.id.calendarView);
        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Toast.makeText(Ex21Activity.this, "你的生日是"+year+"年"+(month+1)+"月"+dayOfMonth+"日", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
