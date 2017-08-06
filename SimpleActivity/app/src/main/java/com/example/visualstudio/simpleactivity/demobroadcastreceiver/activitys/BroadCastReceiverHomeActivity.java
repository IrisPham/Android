package com.example.visualstudio.simpleactivity.demobroadcastreceiver.activitys;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.visualstudio.simpleactivity.R;
/*
*
* Trong phần tìm hiểu về android BroadCast Receiver
* Thì em có làm 2 phần:
*   + đăng kí trực tiếp androidmainfest
*   + đăng kí bằng Java Code
*
*
*/
public class BroadCastReceiverHomeActivity extends AppCompatActivity {
    private WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast_receiver_home);
        wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
    }

    public void onClickBtnBroadCastAndroidMainfest(View view) {
        if(wifiManager.isWifiEnabled()){
            wifiManager.setWifiEnabled(false);
            Toast.makeText(this, "Wifi turn OFF", Toast.LENGTH_SHORT).show();
        }else {
            wifiManager.setWifiEnabled(true);
            Toast.makeText(this, "Wifi turn ON", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickBtnBroadCastJavaCode(View view) {
        startActivity(new Intent(this, BroadCastReceiverJavaCodeActivity.class));
    }

}
