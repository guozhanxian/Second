package com.ralph.second;

import android.app.Activity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by 果占先 on 2016/5/19.
 */
public class Ex13Activity extends BaseActivity {
    private String[] operaName = {"葫芦娃","蜡笔小新","西游记","喜羊羊","猫和老鼠"};

    private String[][] peronName = {{"蛇精","爷爷","穿山甲","大娃"},{"美伢","小白","小新"},{"白龙马","八戒","悟空","悟净"},{"灰太狼","懒羊羊"},{"Tom","Jerry"}};

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex13_layout);

        ExpandableListAdapter ela = new ExpandableListAdapter() {
            @Override
            public void registerDataSetObserver(DataSetObserver observer) {
            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver observer) {
            }

            @Override
            public int getGroupCount() {
                return operaName.length;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return peronName[groupPosition].length;
            }

            @Override
            public Object getGroup(int groupPosition) {
                return operaName[groupPosition];
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return peronName[groupPosition][childPosition];
            }

            @Override
            public long getGroupId(int groupPosition) {
                return groupPosition;
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
//                TextView tv = new TextView(Ex13Activity.this);
//                tv.setText(operaName[groupPosition]);
                LayoutInflater li = LayoutInflater.from(Ex13Activity.this);
                View v = li.inflate(android.R.layout.simple_list_item_1,null);
                TextView tv = (TextView) v.findViewById(android.R.id.text1);
                tv.setPadding(90,0,0,0);
                tv.setText(operaName[groupPosition]);
                return v;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                LayoutInflater li = LayoutInflater.from(Ex13Activity.this);
                View v = li.inflate(android.R.layout.simple_list_item_1,null);
                TextView tv = (TextView) v.findViewById(android.R.id.text1);
                tv.setPadding(190,0,0,0);
                tv.setText(peronName[groupPosition][childPosition]);
                return tv;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return false;
            }

            @Override
            public boolean areAllItemsEnabled() {
                return false;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public void onGroupExpanded(int groupPosition) {
            }

            @Override
            public void onGroupCollapsed(int groupPosition) {
            }

            @Override
            public long getCombinedChildId(long groupId, long childId) {
                return childId;
            }

            @Override
            public long getCombinedGroupId(long groupId) {
                return groupId;
            }
        };

        ExpandableListView view = (ExpandableListView) findViewById(R.id.groupList);
        view.setAdapter(ela);
    }
}
