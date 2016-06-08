package com.ralph.second;

import android.content.Context;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.EditText;
import android.widget.Toast;

import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.TtsMode;

/**
 * Created by 果占先 on 2016/6/7.
 */
public class Ex47Activity extends BaseActivity {
    TelephonyManager telManager;

    SpeechSynthesizer speechSynthesizer;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex47_layout);

        telManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        speechSynthesizer = SpeechSynthesizer.getInstance();
        speechSynthesizer.setContext(this);
        speechSynthesizer.setAppId("7934301");
        speechSynthesizer.setApiKey("mF30Ge9lZS6q1ClMrYMczr3tVnOxP7P1", "Ci0K4l51f9trzM5Ku2shpLf2MriiaWq7");
        speechSynthesizer.initTts(TtsMode.ONLINE);

        PhoneStateListener listener = new PhoneStateListener(){
            @Override
            public void onCallStateChanged(int state, String incomingNumber) {
                switch (state)
                {
                    case TelephonyManager.CALL_STATE_IDLE:
                        break;
                    case TelephonyManager.CALL_STATE_OFFHOOK:
                        break;
                    case TelephonyManager.CALL_STATE_RINGING:
                        speechSynthesizer.speak(incomingNumber+"来电话了！");
                        Toast.makeText(Ex47Activity.this, incomingNumber, Toast.LENGTH_LONG).show();
                        break;
                    default:
                        break;
                }
                super.onCallStateChanged(state, incomingNumber);
            }
        };

        telManager.listen(listener,PhoneStateListener.LISTEN_CALL_STATE);
    }
}
