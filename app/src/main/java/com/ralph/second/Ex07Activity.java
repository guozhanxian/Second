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
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;

/**
 * Created by 果占先 on 2016/5/17.
 */
public class Ex07Activity extends Activity {
    Handler h = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            Bundle b = msg.getData();
            String str = (String) b.get("str");
            Gson gson = new Gson();
            Person p = gson.fromJson(str.substring(0,str.indexOf("}")+1),Person.class);
            tv.setText(p.getName());
        }
    };

    TextView tv;
    EditText txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex07_layout);

        tv = (TextView) findViewById(R.id.findResult);
        txt = (EditText) findViewById(R.id.personId);
    }

    public void findPersonInfo(View view)
    {
        new AAA().start();
    }

    class AAA extends Thread
    {
        @Override
        public void run() {
            try {
                Socket s = new Socket("192.168.1.187",8080);
                OutputStream os = s.getOutputStream();
                Writer w = new OutputStreamWriter(os,"utf-8");
                PrintWriter out = new PrintWriter(w);
                out.println("GET /Test/findNameById.do?id="+txt.getText().toString()+" HTTP/1.1");
                out.println("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
                out.println("Accept-Encoding: gzip, deflate");
                out.println("Accept-Language: zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
                out.println("Cache-Control: max-age=0");
                out.println("Connection:　keep-alive");
                out.println("Host: localhost:8080");
                out.println("User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64; rv:46.0) Gecko/20100101 Firefox/46.0");
                out.println("");
                out.flush();

                InputStream is = s.getInputStream();
                Reader r = new InputStreamReader(is,"utf-8");
                BufferedReader br = new BufferedReader(r);

                StringBuilder sb = new StringBuilder();
                String str;
                boolean flag = false;
                while((str = br.readLine())!=null)
                {
                    if(str.contains("{")) {
                        flag = true;
                    }
                    if(flag)
                    {
                        sb.append(str);
                    }
                }
                out.close();
                is.close();

                Message m = new Message();
                Bundle b = new Bundle();
                b.putSerializable("str",sb.toString());
                m.setData(b);

                h.sendMessage(m);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
