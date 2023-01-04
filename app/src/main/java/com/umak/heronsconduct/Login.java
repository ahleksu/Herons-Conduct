package com.umak.heronsconduct;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private Button login;
    TextView forgotPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        forgotPass = (TextView)findViewById(R.id.forgotBTN);
        TextView username = (TextView) findViewById(R.id.logIn_userName);
        TextView password = (TextView) findViewById(R.id.logIn_password);
        login = (Button) findViewById(R.id.signInBTN);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    Toast.makeText(Login.this, "Success", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(Login.this, "Fail", Toast.LENGTH_SHORT).show();
            }
        });

        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, ForgotPass.class);
                startActivity(i);
                finish();
            }
        });

    }
}