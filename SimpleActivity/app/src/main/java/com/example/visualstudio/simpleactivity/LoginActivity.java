package com.example.visualstudio.simpleactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.visualstudio.simpleactivity.demoactivity.activitys.IntentCameraActivity;
import com.example.visualstudio.simpleactivity.demoactivity.activitys.IntentForResultActivity;
import com.example.visualstudio.simpleactivity.demoactivity.activitys.IntentImplicitItemActivity;
import com.example.visualstudio.simpleactivity.demoactivity.activitys.MainActivity;
import com.example.visualstudio.simpleactivity.demobroadcastreceiver.activitys.BroadCastReceiverHomeActivity;
import com.example.visualstudio.simpleactivity.democontentrrovider.StudentContentProviderActivity;
import com.example.visualstudio.simpleactivity.demoservice.activitys.ServiceHomeActivity;
import com.example.visualstudio.simpleactivity.demowebservice.activitys.WebServiceMainActivity;
import com.gc.materialdesign.views.ButtonRectangle;

public class LoginActivity extends AppCompatActivity{
    private EditText edtUserName;
    private ButtonRectangle btnIntentExplicit, btnIntentImplicit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialzation();
    }
    private void initialzation(){
        edtUserName = (EditText) findViewById(R.id.activity_login_edt_userName);
        btnIntentExplicit = (ButtonRectangle) findViewById(R.id.activity_login_btn_intentExplicit);
        btnIntentImplicit = (ButtonRectangle) findViewById(R.id.activity_login_btn_intentImplicit);
    }

    public void onClickBtnImplicit(View view) {
        startActivity(new Intent(this, IntentImplicitItemActivity.class));
    }

    public void onClickBtnIntentExplicit(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("userName",edtUserName.getText().toString());
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

    public void onClickBtnContentProvider(View view) {
        startActivity(new Intent(this, StudentContentProviderActivity.class));
    }

    public void onClickBtnService(View view) {
        startActivity(new Intent(this, ServiceHomeActivity.class));
    }

    public void onClickBtnBroadCast(View view) {
        startActivity(new Intent(this, BroadCastReceiverHomeActivity.class));
    }

    public void onClickBtnWebService(View view) {
        startActivity(new Intent(this,WebServiceMainActivity.class));
    }
}
