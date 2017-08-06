package com.example.visualstudio.simpleactivity.demobroadcastreceiver.object;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Visual Studio on 7/7/2017.
 */

public class NetworkReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Network State turn ON/OFF", Toast.LENGTH_SHORT).show();
    }
}
