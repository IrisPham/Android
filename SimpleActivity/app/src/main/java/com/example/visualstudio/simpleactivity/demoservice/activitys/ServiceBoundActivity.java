package com.example.visualstudio.simpleactivity.demoservice.activitys;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.visualstudio.simpleactivity.R;
import com.example.visualstudio.simpleactivity.demoservice.boundservice.WeatherService;

public class ServiceBoundActivity extends AppCompatActivity implements ServiceConnection{
    private EditText edtNameLocation;
    private TextView tvShowWeather;
    private WeatherService weatherService;
    private boolean binded = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_bound);
        edtNameLocation = (EditText) findViewById(R.id.activity_service_bound_edt_nameLocation);
        tvShowWeather = (TextView) findViewById(R.id.activity_service_bound_tv_showWeather);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this,WeatherService.class);
        // Gọi method bindService(..) để ràng buộc dịch vụ với giao diện.
        bindService(intent,this,Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (binded) {
            // Hủy ràng buộc kết nối với dịch vụ.
            unbindService(this);
            binded = false;
        }
    }

    public void onClickBtnShowWeather(View view) {
        String location = edtNameLocation.getText().toString();
        String weather= this.weatherService.getWeatherToday(location);
        tvShowWeather.setText(weather);
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder service) {
        WeatherService.LocalWeatherBinder binder = (WeatherService.LocalWeatherBinder) service;
        weatherService = binder.getService();
        binded = true;
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        binded = false;
    }
}
