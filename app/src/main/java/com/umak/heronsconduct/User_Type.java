package com.umak.heronsconduct;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Objects;

public class User_Type extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_user_type);


    }


    public void x_circle(View view) {
        Intent intent = new Intent(getApplicationContext(), On_Boarding.class);
        startActivity(intent);
        finish();
    }

    public void student (View view) {
        Intent intent = new Intent(getApplicationContext(), Student_Register.class);
        startActivity(intent);
        finish();
    }

    public void parent (View view){
        Intent intent = new Intent(getApplicationContext(), Parent_Register.class);
        startActivity(intent);
        finish();
    }

    public void reporter (View view){
        Intent intent = new Intent(getApplicationContext(), Reporter_Register.class);
        startActivity(intent);
        finish();
    }
}