package com.example.visualstudio.simpleactivity.demoservice.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.visualstudio.simpleactivity.R;
import com.example.visualstudio.simpleactivity.demoservice.unboundservice.LocalService;

public class ServiceUnBoundActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_un_bound);
    }

    public void onClickBtnStartService(View view) {
        startService(new Intent(this, LocalService.class));
    }

    public void onClickBtnStopService(View view) {
        stopService(new Intent(this, LocalService.class));
    }
}
