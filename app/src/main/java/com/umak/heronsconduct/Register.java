package com.umak.heronsconduct;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


    }


    public void student_user(View view) {

        Intent intent = new Intent(getApplicationContext(), Register_Student.class);
        startActivity(intent);
        finish();
    }


    public void parent_user(View view) {
        Intent intent = new Intent(getApplicationContext(), Register_Parent.class);
        startActivity(intent);
        finish();
    }


    public void reporter_user(View view) {
        Intent intent = new Intent(getApplicationContext(), Register_Reporter.class);
        startActivity(intent);
    }
}