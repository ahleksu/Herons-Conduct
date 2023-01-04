package com.umak.heronsconduct;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class forgotPasswordNewCredentials extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_new_credentials);
        button = (Button) findViewById(R.id.newCredentialUpdateBTN);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(forgotPasswordNewCredentials.this, forgotPasswordUpdated.class);
                startActivity(i);
                finish();
            }
        });
    }
}