package com.umak.heronsconduct;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
                Toast.makeText(ForgotPass.this, "Email not found. Try again.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}