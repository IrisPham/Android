package com.example.visualstudio.simpleactivity.LearnActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.visualstudio.simpleactivity.R;

public class IntentImplicitItemActivity extends AppCompatActivity {
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent__implicit__item);
    }

    public void onClickBtnACTION_SENTDTO(View view) {
        intent = new Intent();
        intent.setAction(intent.ACTION_SENDTO);
        intent.putExtra("sms_body","Hello");
        intent.setData(Uri.parse("sms:01639997154"));
        startActivity(intent);
    }

    public void onClickBtnACTION_VIEW(View view) {
        intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.facebook.com/kendy.pham.1297"));
        startActivity(intent);
    }

    public void onClickBtnACTION_CALL(View view) {
        intent = new Intent();
        intent.setAction(intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:01639997154"));
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    1);

            // MY_PERMISSIONS_REQUEST_CALL_PHONE is an
            // app-defined int constant. The callback method gets the
            // result of the request.
        } else {
            //You already have permission
            try {
                startActivity(intent);
            } catch (SecurityException e) {
                e.printStackTrace();
            }
        }
    }
}
