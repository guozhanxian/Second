package com.ralph.second;

import android.app.Activity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

/**
 * Created by 果占先 on 2016/5/31.
 */
public class Ex31Activity2 extends Activity {
    String[] s={"辽宁","吉林"};
    String[][] c={{"沈阳","阜新","大连"},{"吉林","四平","长春"}};
    ExpandableListView elv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex31_caity_layout);
        elv= (ExpandableListView) findViewById(R.id.city);
        ExpandableListAdapter e=new ExpandableListAdapter() {
            @Override
            public void registerDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public int getGroupCount() {
                return s.length;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return c[groupPosition].length;
            }

            @Override
            public Object getGroup(int groupPosition) {
                return s[groupPosition];
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return c[groupPosition][childPosition];
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
                TextView v=new TextView(Ex31Activity2.this);
                v.setText(s[groupPosition]);
                return v;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                TextView v=new TextView(Ex31Activity2.this);
                v.setText(c[groupPosition][childPosition]);
                return v;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return true;
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
                return 0;
            }

            @Override
            public long getCombinedGroupId(long groupId) {
                return 0;
            }
        };
        elv.setAdapter(e);
        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Intent i = getIntent();
                i.putExtra("city",c[groupPosition][childPosition]);
                setResult(123,i);
                finish();
                return true;
            }
        });

    }
}
