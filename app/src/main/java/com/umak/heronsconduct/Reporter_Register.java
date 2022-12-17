package com.umak.heronsconduct;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Objects;

public class Reporter_Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_reporter_register);
    }

    public void NextRegisterPage3(View view) {
        startActivity(new Intent(getApplicationContext(), Student_Register2.class));
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }

    public void login_reg3(View view) {
        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();
    }
}