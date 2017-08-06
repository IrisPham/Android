package com.example.visualstudio.simpleactivity.demoactivity.activitys;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.visualstudio.simpleactivity.R;

public class IntentCameraActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 1234;
    private ImageView imv_showPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_camera);
        imv_showPicture = (ImageView) findViewById(R.id.activity_intent_camera_imv_showPicture);
    }

    public void onClickBtnTakePicture(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null){
            //get key. key mac dich la ""data"
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imv_showPicture.setImageBitmap(bitmap);
        }
    }
}
