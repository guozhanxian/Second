package com.ralph.second;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends BaseActivity {
    String[] names = {"Hello World","画心形图像","获取短信验证码","Chronometer倒计时和保修期计算"
    ,"循环显示五张图片","图片链接到联系人信息","用Socket获取服务端数据","ArrayAdapter显示城市列表","SimpleAdapter和BaseAdapter"
           ,"URLConnection连接百度手机归属地" ,"ListActivity显示列表","AutoCompleteTextView过滤字符串","ExpandableListView显示好友分组"
            ,"Spinner选择编程语言","AdapterViewFlipper循环播放图片","StackView播放图片","进度条显示进度","星评分RatingBar"
            ,"Grid显示图片动画显示出图片","动画效果显示文字","CalendarView选择生日","选择日期和时间","TabHost做Tab标签"
            ,"Notification发送通知","使用各种对话框","使用Toolbar","使用外部普通类处理事件"
            ,"Preference配置","图书Fragment","选择城市列表","获取手机联系人信息","获取网络图片","旋转图片","打拳动画播放"
            ,"SurfaceView画图","SharedPreference读写XML文件","SQLite查询学生信息","Fling事件翻动图片","手势保存","手势识别"
            ,"百度语音朗读TTS","ContentResolver读取共享数据","用Service播放声音","绑定方式启动Servie获取数据","监听手机来电"
            ,"SoundPool播放音频","VideoView播放视频","MediaPlayer和SurfaceView播放视频","音频录制","视频录制"
            ,"Retrofit请求手机归属地","传感器应用","WebView显示H5","GPS获取位置信息","百度地图"
            ,"使用ButterKnife获取组件","ListView分页显示数据"};
    Class[] clazz = {Ex01Activity.class,Ex02Activity.class,Ex03Activity.class,Ex04Activity.class
    ,Ex05Activity.class,Ex06Activity.class,Ex07Activity.class,Ex08Activity.class, Ex09Activity.class
            ,Ex10Activity.class,Ex11Activity.class,Ex12Activity.class,Ex13Activity.class
            ,EX14Activity.class,Ex15Activity.class,Ex16Activity.class,Ex17Activity.class,Ex18Activity.class
            ,Ex19Activity.class,Ex20Activity.class,Ex21Activity.class,Ex22Activity.class,Ex23Activity.class
            ,Ex24Activity.class,Ex25Activity.class,Ex26Activity.class,Ex27Activity.class
            ,Ex29Activity.class,Ex30Activity.class,Ex31Activity.class,Ex32Activity.class,Ex33Activity.class,Ex34Activity.class,Ex35Activity.class
            ,Ex36Activity.class,Ex37Activity.class,Ex38Activity.class,Ex39Activity.class,Ex40Activity.class,Ex41Activity.class
            ,Ex42Activity.class,Ex44Activity.class,Ex45Activity.class,Ex46Activity.class,Ex47Activity.class
            ,Ex48Activity.class,Ex49Activity.class,Ex50Activity.class,Ex51Activity.class,Ex52Activity.class
            ,Ex53Activity.class,Ex55Activity.class,Ex56Activity.class,Ex57Activity.class,Ex58Activity.class
            ,Ex59Activity.class,Ex60Activity.class};
    //String[] actions = {"helloworld","heart"};
    ListView listView;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_list_item_1,names);
        listView.setAdapter(aa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this,clazz[position]);
                startActivity(i);
//                Intent i = new Intent();
//                i.setAction(actions[position]);
//                i.addCategory("com.ralph.second");
//                startActivity(i);
            }
        });
    }
}
