package com.umak.heronsconduct;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


public class SplashScreen extends AppCompatActivity {

    Handler h = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        h.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(SplashScreen.this, Onboarding.class);
                startActivity(i);
                finish();

            }
        }, 2000);



    }
}