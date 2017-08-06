package com.example.visualstudio.simpleactivity.demoservice.activitys;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.visualstudio.simpleactivity.R;
import com.example.visualstudio.simpleactivity.demoservice.intentservice.MyIntentService;
import com.example.visualstudio.simpleactivity.demoservice.object.ResponseReceiver;
import com.example.visualstudio.simpleactivity.demoservice.object.ShowPrgessBarTask;
import com.gc.materialdesign.views.ButtonRectangle;

public class ServiceIntentActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private TextView tvPercent;
    private ButtonRectangle btnStartIntentService;
    private ResponseReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        tvPercent = (TextView) findViewById(R.id.tv_Percel);
        btnStartIntentService = (ButtonRectangle) findViewById(R.id.btn_StartService);
        receiver = new ResponseReceiver(progressBar,tvPercent,btnStartIntentService);
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(receiver, new IntentFilter(MyIntentService.ACTION_1));
    }

    @Override
    protected void onPause() {
        super.onPause();
        try {
            unregisterReceiver(receiver);
        }catch (IllegalArgumentException e){
            Log.e("Rec",""+e);
        }
    }

    public void onClickBtnStartService(View view) {
        btnStartIntentService.setEnabled(false);
        startService(new Intent(this,MyIntentService.class));
    }

    public void onClickBtnStopService(View view) {
        btnStartIntentService.setEnabled(true);
        try {
            unregisterReceiver(receiver);
        }catch (IllegalArgumentException e){
            Log.e("Rec",""+e);
        }
    }

}
