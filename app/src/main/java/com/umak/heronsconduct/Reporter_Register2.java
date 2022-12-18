package com.umak.heronsconduct;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import java.util.Objects;

public class Reporter_Register2 extends AppCompatActivity {

    EditText passwordRE, confirmPassRE;
    boolean passwordVisibleRE1, passwordVisibleRE2;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_reporter_register2);

        passwordRE = findViewById(R.id.et_passRE);
        passwordRE.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int Right = 2;
                if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                    if(motionEvent.getRawX()>=passwordRE.getRight()-passwordRE.getCompoundDrawables()[Right].getBounds().width()){
                        int selection = passwordRE.getSelectionEnd();
                        if(passwordVisibleRE1){
                            passwordRE.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.eye_off, 0);
                            passwordRE.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisibleRE1=false;
                        }else {
                            passwordRE.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.eye, 0);
                            passwordRE.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisibleRE1 = true;
                        }
                        passwordRE.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

        confirmPassRE = findViewById(R.id.et_confirmPassRE);
        confirmPassRE.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int Right = 2;
                if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                    if(motionEvent.getRawX()>=confirmPassRE.getRight()-confirmPassRE.getCompoundDrawables()[Right].getBounds().width()){
                        int selection = confirmPassRE.getSelectionEnd();
                        if(passwordVisibleRE2){
                            confirmPassRE.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.eye_off, 0);
                            confirmPassRE.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisibleRE2=false;
                        }else {
                            confirmPassRE.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.eye, 0);
                            confirmPassRE.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisibleRE2 = true;
                        }
                        confirmPassRE.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });
    }

    public void corner_up_left_RE(View view) {
        startActivity(new Intent(getApplicationContext(), Reporter_Register.class));
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }
}