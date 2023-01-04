package com.umak.heronsconduct;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class FindStudents_Admin2 extends AppCompatActivity {


    String name1 = "Sonie Vega";
    String id = "a12035738";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_find_students_admin2);


        EditText name = findViewById(R.id.nameFindStudent);
        EditText idNum = findViewById(R.id.idNumberFindStudent);



        Button find = findViewById(R.id.searchFindStudent);
        find.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

            if(name.getText().toString().isEmpty() && idNum.getText().toString().isEmpty()) {
                Toast.makeText(FindStudents_Admin2.this, "Search not found. Please Try again.", Toast.LENGTH_SHORT).show();
            }
             else if(name.equals(name1) && idNum.equals(id)) {
                Toast.makeText(FindStudents_Admin2.this, "PRINT THE USER INFO HERE", Toast.LENGTH_SHORT).show();
            }
             else if(!name.getText().toString().isEmpty() && !idNum.getText().toString().isEmpty()) {
                    Toast.makeText(FindStudents_Admin2.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}