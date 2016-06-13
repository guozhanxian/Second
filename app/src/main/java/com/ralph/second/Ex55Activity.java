package com.ralph.second;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.EditText;

/**
 * Created by 果占先 on 2016/6/13.
 */
public class Ex55Activity extends BaseActivity implements SensorEventListener{
    EditText fangxiang;
    EditText tuoluo;
    EditText cichang;
    EditText zhongli;
    EditText xianxing;
    EditText wendu;
    EditText guanggan;
    EditText yali;

    SensorManager manager;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex55_layout);

        fangxiang = (EditText) findViewById(R.id.fangxiang);
        tuoluo = (EditText) findViewById(R.id.tuoluo);
        cichang = (EditText) findViewById(R.id.cichang);
        zhongli = (EditText) findViewById(R.id.zhongli);
        xianxing = (EditText) findViewById(R.id.xianxing);
        wendu = (EditText) findViewById(R.id.wendu);
        guanggan = (EditText) findViewById(R.id.guanggan);
        yali = (EditText) findViewById(R.id.yali);

        manager = (SensorManager) getSystemService(SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        manager.registerListener(this,manager.getDefaultSensor(Sensor.TYPE_ORIENTATION),SensorManager.SENSOR_DELAY_GAME);
        manager.registerListener(this,manager.getDefaultSensor(Sensor.TYPE_GYROSCOPE),SensorManager.SENSOR_DELAY_GAME);
        manager.registerListener(this,manager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),SensorManager.SENSOR_DELAY_GAME);
        manager.registerListener(this,manager.getDefaultSensor(Sensor.TYPE_GRAVITY),SensorManager.SENSOR_DELAY_GAME);
        manager.registerListener(this,manager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION),SensorManager.SENSOR_DELAY_GAME);
        manager.registerListener(this,manager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE),SensorManager.SENSOR_DELAY_GAME);
        manager.registerListener(this,manager.getDefaultSensor(Sensor.TYPE_LIGHT),SensorManager.SENSOR_DELAY_GAME);
        manager.registerListener(this,manager.getDefaultSensor(Sensor.TYPE_PRESSURE),SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onStop() {
        manager.unregisterListener(this);
        super.onStop();
    }

    @Override
    protected void onPause() {
        manager.unregisterListener(this);
        super.onPause();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float[] value = event.values;
        int sensorType = event.sensor.getType();
        StringBuilder sb = null;
        switch (sensorType)
        {
            case Sensor.TYPE_ORIENTATION:
                sb = new StringBuilder();
                sb.append("与正北方向的夹角是："+value[0]+"，与X的夹角"+value[1]+"，于Y轴的夹角是"+value[2]);
                fangxiang.setText(sb.toString());
                break;
            case Sensor.TYPE_GYROSCOPE:
                sb = new StringBuilder();
                sb.append("X轴的角速度");
                sb.append(value[0]);
                sb.append(",Y轴的角速度");
                sb.append(value[1]);
                sb.append("，Z轴的角速度");
                sb.append(value[2]);
                tuoluo.setText(sb.toString());
                break;
            case Sensor.TYPE_MAGNETIC_FIELD:
                sb = new StringBuilder();
                sb.append("X轴磁场分量");
                sb.append(value[0]);
                sb.append("，Y轴磁场分量");
                sb.append(value[1]);
                sb.append("，Z轴磁场分量");
                sb.append(value[2]);
                cichang.setText(sb.toString());
                break;
            case Sensor.TYPE_GRAVITY:
                sb = new StringBuilder();
                sb.append("X轴重力分量");
                sb.append(value[0]);
                sb.append("，Y轴重力分量");
                sb.append(value[1]);
                sb.append("，Z轴重力分量");
                sb.append(value[2]);
                zhongli.setText(sb.toString());
                break;
            case Sensor.TYPE_LINEAR_ACCELERATION:
                sb = new StringBuilder();
                sb.append("X轴加速度分量");
                sb.append(value[0]);
                sb.append("，Y轴加速度分量");
                sb.append(value[1]);
                sb.append("，Z轴加速度分量");
                sb.append(value[2]);
                xianxing.setText(sb.toString());
                break;
            case Sensor.TYPE_AMBIENT_TEMPERATURE:
                sb = new StringBuilder();
                sb.append("当前温度是：");
                sb.append(value[0]);
                wendu.setText(sb.toString());
                break;
            case Sensor.TYPE_LIGHT:
                sb = new StringBuilder();
                sb.append("当前光的强度是：");
                sb.append(value[0]);
                guanggan.setText(sb.toString());
                break;
            case Sensor.TYPE_PRESSURE:
                sb = new StringBuilder();
                sb.append("当前压力是：");
                sb.append(value[0]);
                yali.setText(sb.toString());
                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}
