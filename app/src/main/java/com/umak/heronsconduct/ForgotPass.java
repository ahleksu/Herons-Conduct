package com.umak.heronsconduct;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPass extends AppCompatActivity {
    Button submitForgotPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);

        submitForgotPassword = (Button)findViewById(R.id.submitForgotButton);

        submitForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EnterOTP.class);
                startActivity(intent);
                Toast.makeText(ForgotPass.this, "Email not found. Try again.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}