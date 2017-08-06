package com.example.visualstudio.simpleactivity.demoservice.unboundservice;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;

import com.example.visualstudio.simpleactivity.R;

/**
 * Created by Visual Studio on 7/6/2017.
 */

public class LocalService extends Service {
    private MediaPlayer mMediaPlayer;
    private NotificationCompat.Builder mNotificationCompat;
    private NotificationManager mNotificationManager;
    @Override
    public void onCreate() {
        super.onCreate();
        showNotification();
        mMediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ghen_khac_hung);
        Toast.makeText(this, "Khoi tao Service", Toast.LENGTH_SHORT).show();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Music Running", Toast.LENGTH_SHORT).show();
        mMediaPlayer.start();
        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Music Stop", Toast.LENGTH_SHORT).show();
        mNotificationManager.cancel(1);
        mMediaPlayer.stop();
        mMediaPlayer.release();
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void showNotification(){
        mNotificationCompat = (NotificationCompat.Builder) new NotificationCompat
                .Builder(this)
                .setContentTitle("Service Runnig")
                .setContentText("Music Running")
                .setSmallIcon(R.drawable.ic_launcher);
        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotificationManager.notify(1,mNotificationCompat.build());
    }
}
