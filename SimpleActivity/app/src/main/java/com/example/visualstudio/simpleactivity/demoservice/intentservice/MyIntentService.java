package com.example.visualstudio.simpleactivity.demoservice.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.SystemClock;
import android.util.Log;


public class MyIntentService extends IntentService {
    public static final String ACTION_1 = "MY_ACTION_1";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Intent broadCastIntent = new Intent();
        broadCastIntent.setAction(MyIntentService.ACTION_1);
        //Vòng lặp 100 lần phát sóng của Intent
        for(int i = 1; i <= 100; i++){
            broadCastIntent.putExtra("Percent: ",i);
            sendBroadcast(broadCastIntent);
            SystemClock.sleep(100); //Tạm dừng 100 mili giây
            Log.e("TAG",""+i);
        }

    }
}
