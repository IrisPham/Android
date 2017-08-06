package com.example.visualstudio.simpleactivity.demoactivity.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.visualstudio.simpleactivity.R;
import com.example.visualstudio.simpleactivity.demoactivity.DialogActivity;
import com.gc.materialdesign.views.ButtonRectangle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final String nameActivityCurrent = getClass().getSimpleName();
    private TextView tv_WelcomeUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialzation();
        setWelcomeUser();
        //Khởi tạo ứng dụng -> onStart
    }
    private void initialzation(){
        tv_WelcomeUser = (TextView) findViewById(R.id.activity_main_tv_showUserInfo);
        ButtonRectangle btnWelcomwe = (ButtonRectangle) findViewById(R.id.activity_main_btn_Welcome);
    }
    @Override
    protected void onStart() {
        super.onStart();
        //Khởi tạo giao diện -  hiện giao diện - chưa tương tác được giao diện -> onResume
        Toast.makeText(this, nameActivityCurrent + " onStart() Load successful display!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Bắt đầu tương tác được với giao diện - nhập,xuất .....
        //Nếu hiện lên một activity khác mà che toàn màn hình activi hiện tại thì nó sẽ vào hàm onPase
        Toast.makeText(this, nameActivityCurrent + " onResume() Load successful!", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, nameActivityCurrent + " onPause() Load successful!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //nếu ứng dụng đang chạy mk có ứng dụng khác đè lên thì nó sẽ vào hàm onCreate -> onResume -> onStop
        //Sau khi ứng dụng kia hết đè lên ứng dụng của bạn thì nó sẽ gọi hàm onRestart -> onStart -> noResume
        Toast.makeText(this, nameActivityCurrent + " onStop() Load successful!", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, nameActivityCurrent + " onRestart Load successful!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Khi nhấn vào nút Back và thoát ứng dụng thì nó sẽ chạy
        //onPase -> onStop -> OnDestroy -> Activi bi pha huy.
        Toast.makeText(this, nameActivityCurrent + " onDestroy Load successful!", Toast.LENGTH_SHORT).show();

    }

    public void onClickBtnWelcome(View view) {
        startActivity(new Intent(MainActivity.this,DialogActivity.class));
    }

    private void setWelcomeUser(){
        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        tv_WelcomeUser.setText("Chào mừng: "+userName);

        ArrayList<String> listUserName = intent.getStringArrayListExtra("listUserName");
       // Toast.makeText(MainActivity.this, listUserName.size(), Toast.LENGTH_SHORT).show();
        //Log.e("TAG", String.valueOf(listUserName.size()));

    }
}
