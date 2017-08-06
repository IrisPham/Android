package com.example.visualstudio.simpleactivity.demoservice.object;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.visualstudio.simpleactivity.demoservice.intentservice.MyIntentService;
import com.gc.materialdesign.views.ButtonRectangle;

/**
 * Created by Visual Studio on 7/9/2017.
 */

public class ResponseReceiver extends BroadcastReceiver {
    private ProgressBar progressBar;
    private TextView tvPercent;
    private ButtonRectangle btnStartIntentService;

    public ResponseReceiver(ProgressBar progressBar, TextView tvPercent
            , ButtonRectangle btnStartIntentService) {
        this.progressBar = progressBar;
        this.tvPercent = tvPercent;
        this.btnStartIntentService = btnStartIntentService;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(MyIntentService.ACTION_1)){
            int value = intent.getIntExtra("Percent: ",-1);
            new ShowPrgessBarTask(progressBar
                    ,tvPercent
                    ,btnStartIntentService)
                    .execute(value);
        }
    }
}
