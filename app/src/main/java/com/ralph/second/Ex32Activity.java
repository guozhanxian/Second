package com.ralph.second;

import android.app.Activity;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by 果占先 on 2016/5/31.
 */
public class Ex32Activity extends BaseActivity {
    TextView pName;
    TextView phoneNum;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex32_layout);
        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_GET_CONTENT);
                i.setType("vnd.android.cursor.item/phone");//MIME类型
                startActivityForResult(i,0);
            }
        });

        pName = (TextView) findViewById(R.id.show);
        phoneNum = (TextView) findViewById(R.id.phone);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0 && resultCode== Activity.RESULT_OK)
        {
            Uri uri = data.getData();
            CursorLoader cl = new CursorLoader(this,uri,null,null,null,null);
            Cursor c = cl.loadInBackground();
            if(c.moveToFirst())
            {
                String contactId = c.getString(c.getColumnIndex(ContactsContract.Contacts._ID));
                String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                String phone = "";

                Cursor phoneC = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,"contact_id="+contactId,null,null);
                while(phoneC.moveToNext())
                {
                    phone = phone + " " + phoneC.getString(phoneC.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                }

                phoneC.close();

                pName.setText(name);
                phoneNum.setText(phone);
            }
            c.close();
        }
    }
}
