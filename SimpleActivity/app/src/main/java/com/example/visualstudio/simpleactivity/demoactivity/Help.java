package com.example.visualstudio.simpleactivity.demoactivity;

/**
 * Created by Visual Studio on 7/1/2017.
 */
/*
* // Sử dụng Bundle cách 1.
Intent mIntent = new Intent(this, GreetingActivity.class);
Bundle extras = mIntent.getExtras();
extras.putString("firstName", "<firstName>");
extras.putString("látName", "<lastName>");

// Sử dụng Bundle cách 2.
Intent mIntent2 = new Intent(this, GreetingActivity.class);
Bundle mBundle = new Bundle();
mBundle.putString("firstName", "<firstName>");
mBundle.putString("látName", "<lastName>");
mIntent2.putExtras(mBundle);

// Cách 3:
// Sử dụng putExtra(), phương thức gọi tắt của Intent.
Intent mIntent3 = new Intent(this, GreetingActivity.class);
mIntent3.putExtra("firstName", "<firstName>");
mIntent3.putExtra("látName", "<lastName>");
* */