package com.ralph.second;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.widget.TextView;

/**
 * Created by 果占先 on 2016/6/16.
 */
public class Ex57Activity extends BaseActivity {
    TextView tv;
    LocationManager lm;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex57_layout);

        tv = (TextView) findViewById(R.id.position);
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Location l = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        updateView(l);

        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 10, new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                updateView(location);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
            }

            @Override
            public void onProviderEnabled(String provider) {
                if (ActivityCompat.checkSelfPermission(Ex57Activity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(Ex57Activity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                Location l = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                updateView(l);
            }

            @Override
            public void onProviderDisabled(String provider) {
            }
        });
    }

    public void updateView(Location l)
    {
        if(l!=null)
        {
            StringBuilder sb = new StringBuilder();
            sb.append("当前的位置是：");
            sb.append("经度：");
            sb.append(l.getLongitude());
            sb.append("，纬度");
            sb.append(l.getLatitude());
            sb.append("，海拔");
            sb.append(l.getAltitude());
            sb.append("，速度");
            sb.append(l.getSpeed());
            sb.append("，方向");
            sb.append(l.getBearing());
            tv.setText(sb.toString());
        }else{
            tv.setText("无信息");
        }
    }
}
