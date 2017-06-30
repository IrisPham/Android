package com.example.visualstudio.simpleactivity.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.visualstudio.simpleactivity.LearnActivity.IntentCameraActivity;
import com.example.visualstudio.simpleactivity.LearnActivity.IntentForResultActivity;
import com.example.visualstudio.simpleactivity.LearnActivity.IntentImplicitItemActivity;
import com.example.visualstudio.simpleactivity.LearnActivity.MainActivity;
import com.example.visualstudio.simpleactivity.R;
import com.gc.materialdesign.views.ButtonRectangle;

public class LoginActivity extends AppCompatActivity {
    private EditText edt_UserName,edt_UserPass;
    private ButtonRectangle btnIntentExplicit, btnIntentImplicit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialzation();
    }
    private void initialzation(){
        edt_UserName = (EditText) findViewById(R.id.activity_login_edt_userName);
        edt_UserPass = (EditText) findViewById(R.id.activity_login_edt_userPass);
        btnIntentExplicit = (ButtonRectangle) findViewById(R.id.activity_login_btn_intentExplicit);
        btnIntentImplicit = (ButtonRectangle) findViewById(R.id.activity_login_btn_intentImplicit);
    }

    public void onClickBtnImplicit(View view) {
        startActivity(new Intent(this, IntentImplicitItemActivity.class));
    }

    public void onClickBtnIntentExplicit(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("userName",edt_UserName.getText().toString());
        //intent.putExtra("userPass",edt_UserPass.getText().toString());
        //gứi int thì dùng getIntExtra();
        //Note data type when sent = int is receive = int
        //ArrayList<String> listUserName = new ArrayList<>();
        //listUserName.add("Pham Hoai An");
        //listUserName.add("Nguyen Van B");
        //intent.putStringArrayListExtra("listUserName",listUserName);
        //Truyền bằng bundle thì cũng tương tự
        startActivity(intent);
    }

    public void onClickBtnIntentForResult(View view) {
        startActivity(new Intent(this, IntentForResultActivity.class));
    }

    public void onClickBtnIntentCamera(View view) {
        startActivity(new Intent(this, IntentCameraActivity.class));
    }
}
