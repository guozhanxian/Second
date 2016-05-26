package com.ralph.second;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 果占先 on 2016/5/26.
 */
public class Ex26Activity extends AppCompatActivity {
    TextView txt;

    PopupMenu popm;

    ActionBar ab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex26_layout);

        txt = (TextView) findViewById(R.id.txt);
        registerForContextMenu(txt);

//        ab = getActionBar();
//        ab.setDisplayShowHomeEnabled(false);
//        ab.setDisplayHomeAsUpEnabled(true);
//        ab.setTitle("");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        SubMenu submenu = menu.addSubMenu("选择字体大小");
//        submenu.add(0,0x111,0,"10号字");
//        submenu.add(0,0x112,1,"12号字");
//        submenu.add(0,0x113,2,"14号字");
//        submenu.add(0,0x114,3,"16号字");
//
//        menu.add(0,1,0,"这是一个菜单项");

        MenuInflater inf = new MenuInflater(this);
        inf.inflate(R.menu.ex26menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.font_10:
                txt.setTextSize(10*3);
                break;
            case R.id.font_12:
                txt.setTextSize(12*3);
                break;
            case R.id.font_14:
                txt.setTextSize(14*3);
                break;
            case R.id.font_16:
                txt.setTextSize(16*3);
                break;
            case R.id.normal_btn:
                Toast.makeText(Ex26Activity.this, "点击的是菜单项！", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                Toast.makeText(Ex26Activity.this, "点击了Home图标", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0,0x211,0,"红色");
        menu.add(0,0x212,1,"绿色");
        menu.add(0,0x213,2,"蓝色");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case 0x211:
                txt.setTextColor(Color.RED);
                break;
            case 0x212:
                txt.setTextColor(Color.GREEN);
                break;
            case 0x213:
                txt.setTextColor(Color.BLUE);
                break;
        }
        return true;
    }

    public void changeFont(View view)
    {
        popm = new PopupMenu(this,view);
        getMenuInflater().inflate(R.menu.ex26menu,popm.getMenu());
        popm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.font_10:
                        txt.setTextSize(10*3);
                        break;
                    case R.id.font_12:
                        txt.setTextSize(12*3);
                        break;
                    case R.id.font_14:
                        txt.setTextSize(14*3);
                        break;
                    case R.id.font_16:
                        txt.setTextSize(16*3);
                        break;
                    case R.id.normal_btn:
                        Toast.makeText(Ex26Activity.this, "点击的是菜单项！", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

        popm.show();
    }

    public void showActionBar(View view)
    {
        ab.show();
    }
    public void hideActionBar(View view)
    {
        ab.hide();
    }
}
