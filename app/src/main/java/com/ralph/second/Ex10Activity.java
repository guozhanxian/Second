package com.ralph.second;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by 果占先 on 2016/5/18.
 */
public class Ex10Activity extends Activity {

    Handler h = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle b = msg.getData();
            String str = (String) b.get("str");

            Gson gson = new Gson();
            PhoneCity pc = gson.fromJson(str,PhoneCity.class);
            if("success".equals(pc.getRetMsg()))
            {
                result.setText(pc.getRetData().getProvince()+"省"+pc.getRetData().getCity()+"市"+pc.getRetData().getSupplier());
            }else {
                result.setText("未查询到！");
            }
        }
    };

    EditText phone;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex10_layout);

        phone = (EditText) findViewById(R.id.phoneNum);
        result = (TextView) findViewById(R.id.result);
    }

    public void findPhoneCity(View view)
    {
        (new Thread(){
            @Override
            public void run() {
                String httpUrl = "http://apis.baidu.com/apistore/mobilenumber/mobilenumber";
                BufferedReader reader = null;
                String result = null;
                StringBuffer sbf = new StringBuffer();
                httpUrl = httpUrl + "?phone="+phone.getText().toString();

                try {
                    URL url = new URL(httpUrl);
                    HttpURLConnection connection = (HttpURLConnection) url
                            .openConnection();
                    connection.setRequestMethod("GET");
                    // 填入apikey到HTTP header
                    connection.setRequestProperty("apikey",  "562bafef6007883e2e8fffbbdfa9e6ac");
                    connection.connect();
                    InputStream is = connection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                    String strRead = null;
                    while ((strRead = reader.readLine()) != null) {
                        sbf.append(strRead);
                        sbf.append("\r\n");
                    }
                    reader.close();
                    result = sbf.toString();

                    Message m = new Message();
                    Bundle b = new Bundle();
                    b.putSerializable("str",result);
                    m.setData(b);
                    h.sendMessage(m);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
