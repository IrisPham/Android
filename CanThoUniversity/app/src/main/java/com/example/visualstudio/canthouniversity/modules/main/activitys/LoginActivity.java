package com.example.visualstudio.canthouniversity.modules.main.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.example.visualstudio.canthouniversity.R;

public class LoginActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressBar = (ProgressBar) findViewById(R.id.progressBartest);
        linearLayout = (LinearLayout) findViewById(R.id.linearlayout);
    }

    public void onClickBtnLogin(View view) {
        new CountDownTimer(5000,1000) {
            @Override
            public void onTick(long l) {
                linearLayout.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.VISIBLE);
            }
            @Override
            public void onFinish() {
                init();
            }
        }.start();

    }
    private void init(){
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }

}
