package com.example.visualstudio.simpleactivity.LearnActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.visualstudio.simpleactivity.R;

public class IntentForResultEditNameActivity extends AppCompatActivity {
    private EditText edt_userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_for_result_edit_name);
        edt_userName = (EditText) findViewById(R.id.activity_intent_for_result_edit_name_edt_userName);
    }

    public void onClickBtnIntentExplicit(View view) {
        String newUserName = edt_userName.getText().toString().trim();
        Intent intent = new Intent();
        intent.putExtra("newUserName",newUserName);
        //RESULT_OK hằng số có sẵn trong android
        setResult(RESULT_OK,intent);
        finish();
    }
}
