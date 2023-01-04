package com.umak.heronsconduct;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Objects;

public class Student_List_Admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_student_list_admin);

/*
        Button bIcon = findViewById(R.id.back_to_adminHome);
        bIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
                //finish();
            }
        });

 */



    }




}
