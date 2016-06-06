package com.ralph.second;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.TtsMode;

/**
 * Created by 果占先 on 2016/6/6.
 */
public class Ex42Activity extends BaseActivity {
    EditText txt;

    SpeechSynthesizer speechSynthesizer;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex42_layout);

        txt = (EditText) findViewById(R.id.txt);
        speechSynthesizer = SpeechSynthesizer.getInstance();
        speechSynthesizer.setContext(this);
        speechSynthesizer.setAppId("7934301");
        speechSynthesizer.setApiKey("mF30Ge9lZS6q1ClMrYMczr3tVnOxP7P1", "Ci0K4l51f9trzM5Ku2shpLf2MriiaWq7");
        speechSynthesizer.initTts(TtsMode.ONLINE);
    }

    public void playSound(View view)
    {
        speechSynthesizer.speak(txt.getText().toString());
    }
}
