package com.example.visualstudio.simpleactivity.demoactivity.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.visualstudio.simpleactivity.R;

public class IntentForResultActivity extends AppCompatActivity {
    private TextView tv_userName;
    private static final int REQUEST_CODE_EDIT = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_for_result);
        tv_userName = (TextView) findViewById(R.id.activity_intent_for_result_tv_userName);
    }

    public void onClickBtnEditName(View view) {
        startActivityForResult(new Intent(this,IntentForResultEditNameActivity.class),REQUEST_CODE_EDIT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==  REQUEST_CODE_EDIT && resultCode == RESULT_OK && data != null){
            String newUserName = data.getStringExtra("newUserName");
            tv_userName.setText(newUserName);
        }
    }
}
