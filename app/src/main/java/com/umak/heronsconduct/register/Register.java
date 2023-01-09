package com.umak.heronsconduct.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.umak.heronsconduct.R;
import com.umak.heronsconduct.login.Login;

public class Register extends AppCompatActivity {

    Button signIn;

    static String Account = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        signIn = findViewById(R.id.login_haveAcc_parent);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });


    }


    public void student_user(View view) {
        Account = "student";
        Intent intent = new Intent(getApplicationContext(), Register_Student.class);
        startActivity(intent);
        finish();
    }


    public void parent_user(View view) {
        Account = "parent";
        Intent intent = new Intent(getApplicationContext(), Register_Parent.class);
        startActivity(intent);
        finish();
    }


    public void reporter_user(View view) {
        Account = "reporter";
        Intent intent = new Intent(getApplicationContext(), Register_Reporter.class);
        startActivity(intent);
    }
}