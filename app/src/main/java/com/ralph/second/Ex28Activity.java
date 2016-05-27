package com.ralph.second;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by 果占先 on 2016/5/27.
 */
public class Ex28Activity extends BaseActivity {
    TextView result;
    EditText url;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex28_layout);

        url = (EditText) findViewById(R.id.urlTxt);
        result = (TextView) findViewById(R.id.result);
    }

    public void getResource(View view) throws MalformedURLException {
        MyTask t = new MyTask(this);
        t.execute(new URL(url.getText().toString()));
    }

    class MyTask extends AsyncTask<URL,Integer,String>
    {
        Context ctx;
        public MyTask(Context ctx)
        {
            this.ctx = ctx;
        }
        ProgressDialog pd;
        int progressNum = 0;
        @Override
        protected String doInBackground(URL... params) {
            StringBuilder sb = new StringBuilder();
            try{
                URLConnection conn = params[0].openConnection();
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
                String str = null;
                while((str = br.readLine())!=null)
                {
                    sb.append(str + "\n");
                    progressNum++;
                    publishProgress(progressNum);
                }
            }catch(Exception e){
                Log.e("error",e.getMessage());
            }
            return sb.toString();
        }

        @Override
        protected void onPreExecute() {
            pd = new ProgressDialog(ctx);
            pd.setTitle("下载进度");
            pd.setMessage("正在下载，别吵吵！");
            pd.setMax(500);
            pd.setCancelable(false);
            pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            pd.setIndeterminate(false);
            pd.show();
        }

        @Override
        protected void onPostExecute(String s) {
            result.setText(s);
            pd.dismiss();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            pd.setProgress(values[0]);
        }
    }
}
