package com.umak.heronsconduct.login;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.umak.heronsconduct.R;

public class forgotPasswordUpdated extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_updated);

        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
    }
}