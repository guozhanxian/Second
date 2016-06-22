package com.ralph.second;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 果占先 on 2016/6/22.
 */
public class Ex60Activity extends BaseActivity {

    ListView studList;

    List<Student> totalList = new ArrayList();
    List<Student> currentList = new ArrayList();

    int currentPage;
    int totalPage;

    ProgressDialog pd;

    StudAdapter ad;

    boolean flag;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex60_layout);

        studList = (ListView) findViewById(R.id.studList);

        currentPage = 1;
        pd = new ProgressDialog(this);
        pd.setTitle("加载中");
        pd.setMessage("正在获取数据...");
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        ad = new StudAdapter();
        studList.setAdapter(ad);

        studList.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if(scrollState== AbsListView.OnScrollListener.SCROLL_STATE_IDLE){
                    if(flag && currentPage<totalPage){
                        currentPage++;
                        new TT().execute();
                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                flag = (firstVisibleItem+visibleItemCount>=totalItemCount);
            }
        });

        new TT().execute();
    }

    class StudAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return totalList.size();
        }

        @Override
        public Object getItem(int position) {
            return totalList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LinearLayout layout = new LinearLayout(Ex60Activity.this);
            layout.setOrientation(LinearLayout.HORIZONTAL);
            TextView txt = new TextView(Ex60Activity.this);
            txt.setHeight(40);
            Map s = (Map) totalList.get(position);
            txt.setText("学号："+s.get("_id")+"，姓名："+s.get("sname")+"，生日："+s.get("sbirth"));
            layout.addView(txt);

            return layout;
        }
    }

    class TT extends AsyncTask<String,Void,Page>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd.show();
        }

        @Override
        protected void onPostExecute(Page page) {
            super.onPostExecute(page);
            pd.dismiss();
            currentList = page.getResult();
            totalList.addAll(page.getResult());
            totalPage = page.getTotalPage();
            ad.notifyDataSetChanged();
        }

        @Override
        protected Page doInBackground(String... params) {
            Retrofit r = new Retrofit.Builder()
                    .baseUrl("http://192.168.1.188:8080")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            Ex60StudentService service = r.create(Ex60StudentService.class);
            Call<Page> call = service.findStudentByPage(currentPage);
            Page p = new Page();
            try{
                Response<Page> res = call.execute();
                p = res.body();
            }catch(Exception e){
                Log.e("error", e.toString());
            }
            return p;
        }
    }
}
