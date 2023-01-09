package com.umak.heronsconduct.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.umak.heronsconduct.R;

public class EnterOTP extends AppCompatActivity {
    private EditText code1, code2, code3, code4;
    private Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_otp);
        code1 = findViewById(R.id.inPutCode1);
        code2 = findViewById(R.id.inPutCode2);
        code3 = findViewById(R.id.inPutCode3);
        code4 = findViewById(R.id.inPutCode4);
        button1 = (Button) findViewById(R.id.otpVerifyBTN);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EnterOTP.this, forgotPasswordUpdated.class);
                startActivity(i);
                finish();
            }
        });
    }
}