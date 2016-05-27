package com.ralph.second;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by 果占先 on 2016/5/25.
 */
public class Ex25Activity extends BaseActivity
{
    Handler h = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            super.handleMessage(msg);
            ps += 10;
            p.setProgress(ps);
            if (ps >= 100)
            {
                p.dismiss();
            }
        }
    };
    int ps = 0;
    ProgressDialog p;
    EditText txt;
    EditText lang;
    EditText wife;
    List<String> list = new ArrayList<String>();
    EditText birth;
    EditText gradute;

    @Override
    protected void initContentView(Bundle savedInstanceState)
    {
        //super.onCreate(savedInstanceState);
        setContentView(R.layout.ex25_layout);

        txt = (EditText) findViewById(R.id.xueli);
        lang = (EditText) findViewById(R.id.lang);
        wife = (EditText) findViewById(R.id.wife);
        birth = (EditText) findViewById(R.id.birth);
        gradute = (EditText) findViewById(R.id.gradute);
    }

    public void showMsg(View view)
    {
        AlertDialog b = new AlertDialog.Builder(this)
                .setTitle("简单的对话框")
                .setIcon(R.drawable.icon_11)
                .setMessage("你确定要删除数据吗？\n确定删除吗？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        Toast.makeText(Ex25Activity.this, "你点击的是确定按钮", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        Toast.makeText(Ex25Activity.this, "你点击的是取消按钮", Toast.LENGTH_SHORT).show();
                    }
                })
                .create();
        b.show();
    }

    public void showMsg2(View view)
    {
        final String[] arr = {"专科", "本科", "研究生", "博士生", "博士后", "烈士"};
        AlertDialog b = new AlertDialog.Builder(this)
                .setTitle("简单的列表项对话框")
                .setIcon(R.drawable.icon_13)
                .setItems(arr, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        txt.setText(arr[which]);
                    }
                })
                .create();
        b.show();
    }

    public void showMsg3(View view)
    {
        final String[] arr = {"Java", "C", "C++", "Python", "Ruby", "JavaScript"};
        AlertDialog b = new AlertDialog.Builder(this)
                .setTitle("简单的列表项对话框")
                .setIcon(R.drawable.icon_13)
                .setSingleChoiceItems(arr, 0, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        lang.setText(arr[which]);
                    }
                })
                .create();
        b.show();
    }

    public void showMsg4(View view)
    {
        final String[] arr = {"悟空", "八戒", "奔波霸", "霸波奔", "金角大王", "银角大王"};
        AlertDialog b = new AlertDialog.Builder(this)
                .setTitle("简单的列表项对话框")
                .setIcon(R.drawable.icon_13)
                .setMultiChoiceItems(arr, new boolean[arr.length], new DialogInterface.OnMultiChoiceClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked)
                    {
                        if (isChecked)
                        {
                            list.add(arr[which]);
                        } else
                        {
                            list.remove(arr[which]);
                        }
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        wife.setText(list.toString());
                        list.clear();
                    }
                })
                .create();
        b.show();
    }

    public void showMsg5(View view)
    {
        LayoutInflater li = LayoutInflater.from(this);
        LinearLayout layout = (LinearLayout) li.inflate(R.layout.ex25_layout2, null);
        final DatePicker dp = (DatePicker) layout.findViewById(R.id.birth);

        AlertDialog b = new AlertDialog.Builder(this)
                .setTitle("简单的列表项对话框")
                .setIcon(R.drawable.icon_13)
                .setView(layout)
                .setPositiveButton("确定", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        birth.setText(dp.getYear() + "年" + (dp.getMonth() + 1) + "月" + dp.getDayOfMonth() + "日");
                    }
                })
                .create();
        b.show();
    }

    public void showMsg6(View view)
    {
        Calendar c = Calendar.getInstance();
        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
            {
                gradute.setText(year + "年" + (monthOfYear + 1) + "月" + dayOfMonth + "日");
            }
        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
    }

    public void showMsg7(View view)
    {
        (new Thread()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 10; i++)
                {
                    h.sendMessage(new Message());
                    try
                    {
                        sleep(1000);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
        p = new ProgressDialog(this);
        p.setTitle("下载中");
        p.setIcon(R.drawable.icon_28);
        p.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        p.setIndeterminate(false);
        p.show();

    }
}
