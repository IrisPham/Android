package com.example.visualstudio.simpleactivity.demobroadcastreceiver.activitys;

import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.visualstudio.simpleactivity.R;
import com.example.visualstudio.simpleactivity.demobroadcastreceiver.object.NetWorkChangeReceiverJavaCode;

public class BroadCastReceiverJavaCodeActivity extends AppCompatActivity {
    private NetWorkChangeReceiverJavaCode mNetWorkChangeReceiverJavaCode;
    private WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast_receiver_java_code);
        initialzation();
    }

    private void initialzation(){
        wifiManager = (WifiManager) getSystemService(WIFI_SERVICE);
    }

    private void regisWifiRecevier(){
        mNetWorkChangeReceiverJavaCode = new NetWorkChangeReceiverJavaCode();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(mNetWorkChangeReceiverJavaCode,intentFilter);
    }

    private void setStateWifi(){
        if(wifiManager.isWifiEnabled()){
            wifiManager.setWifiEnabled(false);
            Toast.makeText(this, "Wifi turn OFF", Toast.LENGTH_SHORT).show();
        }else {
            wifiManager.setWifiEnabled(true);
            Toast.makeText(this, "Wifi turn ON", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        regisWifiRecevier();
    }

    @Override
    protected void onPause() {
        super.onPause();
        try{
            unregisterReceiver(mNetWorkChangeReceiverJavaCode);
        }catch (IllegalArgumentException e){
            Log.e("Rec","IllegalArgumentException: "+e);
        }

    }

    public void onClickBtnTurnOnOrOffWifi(View view) {
        setStateWifi();
    }
}
