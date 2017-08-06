package com.example.visualstudio.simpleactivity.demoservice.boundservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class WeatherService extends Service {
    private HashMap<String,String> weatherData;
    private final IBinder mIBinder =  new LocalWeatherBinder();
    public class LocalWeatherBinder extends Binder {
        public WeatherService getService(){
            return WeatherService.this;
        }
    }
    public WeatherService() {
        initialzation();
    }

    private void initialzation(){
        weatherData = new HashMap<>();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this, "onBind", Toast.LENGTH_SHORT).show();
        return this.mIBinder;
    }

    @Override
    public void onRebind(Intent intent) {
        Toast.makeText(this, "onReBind", Toast.LENGTH_SHORT).show();
        super.onRebind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(this, "onUnBind", Toast.LENGTH_SHORT).show();
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    // Trả về thông tin thời tiết ứng với địa điểm của ngày hiện tại.
    public String getWeatherToday(String location) {
        Date now= new Date();
        DateFormat df= new SimpleDateFormat("dd-MM-yyyy");

        String dayString = df.format(now);
        String keyLocAndDay = location + "$"+ dayString;

        String weather=  weatherData.get(keyLocAndDay);

        if(weather != null) return weather;

        String[] weathers = new String[]{"Nhiều mưa", "Nóng bức", "Lạnh", "Ấm áp" ,"Có tuyết rơi"};

        //Giá trị ngẫu nhiên từ 0 tới 4
        int i= new Random().nextInt(5);

        weather =weathers[i];
        weatherData.put(keyLocAndDay, weather);

        return weather;
    }
}
