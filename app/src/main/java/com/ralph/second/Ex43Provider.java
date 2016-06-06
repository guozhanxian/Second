package com.ralph.second;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by 果占先 on 2016/6/6.
 */
public class Ex43Provider extends ContentProvider {
    static UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);

    StudentHelper helper;

    static final String AUTHORITY = "com.ralph.second";

    static final int STUDENTS = 1;
    static final int STUDENT = 2;

    static
    {
        matcher.addURI(AUTHORITY,"students",STUDENTS);
        matcher.addURI(AUTHORITY,"student/#",STUDENT);
    }

    @Override
    public boolean onCreate() {
        helper = new StudentHelper(this.getContext(),"student.db",null,Contants.DB_VERSION);
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteDatabase db = helper.getReadableDatabase();
        switch (matcher.match(uri))
        {
            case STUDENTS:
                return db.query("student",new String[]{"_id","name","age"},selection,selectionArgs,null,null,sortOrder);
            case STUDENT:
                long id = ContentUris.parseId(uri);
                return  db.query("student",new String[]{"_id","name","age"},"_id=?",new String[]{id+""},null,null,sortOrder);
            default:
                throw new IllegalArgumentException("未知Uri地址："+uri);
        }
    }

    @Nullable
    @Override
    public String getType(Uri uri) {//根据不同的Uri地址，返回不同的MIME类型
        switch (matcher.match(uri))
        {
            case STUDENTS:
                return "vnd.android.cursor.dir/com.ralph.second";
            case STUDENT:
                return "vnd.android.cursor.item/com.ralph.second";
            default:
                throw new IllegalArgumentException("未知Uri地址："+uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
