package com.example.csulb.wecare;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


//Splash the logo of the app to check the internet connectivity.
public class SplashActivity extends AppCompatActivity {

//onCreate is called when the activity is created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final Intent intent = new Intent(this, LoginnActivity.class);

        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {

            @Override
            public void run() {
                startActivity(intent);
                finish();
            }

        }, 2000L);


    }
}

