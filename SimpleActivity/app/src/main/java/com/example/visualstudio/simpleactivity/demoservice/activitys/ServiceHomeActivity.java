package com.example.visualstudio.simpleactivity.demoservice.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.visualstudio.simpleactivity.R;

public class ServiceHomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_home);
    }
    public void onClickBtnDemoUnBoundService(View view) {
        startActivity(new Intent(this,ServiceUnBoundActivity.class));
    }

    public void onClickBtnBoundService(View view) {
        startActivity(new Intent(this, ServiceBoundActivity.class));
    }

    public void onClickBtnDemoIntentService(View view) {
        startActivity(new Intent(this,ServiceIntentActivity.class));
    }
}
