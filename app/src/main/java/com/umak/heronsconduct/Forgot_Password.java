package com.umak.heronsconduct;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class Forgot_Password extends AppCompatActivity {

    
    EditText forgot_email;
    Button forgot_button;
    
   @Override
  protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_forgot_password);
        

        forgot_email = findViewById(R.id.et_email);
        forgot_button = findViewById(R.id.button_send);


        forgot_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(forgot_email.getText().toString().isEmpty()) {
                    Toast.makeText(Forgot_Password.this, "Email not found. Try again.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), Login3.class);
                    startActivity(intent);
                }
            }
        });
    }
    
    
    
    
    

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(), Login.class));
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }
}