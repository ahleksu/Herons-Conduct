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

public class Parent_Register2 extends AppCompatActivity {

    EditText passwordPA, confirmPassPA;
    boolean passwordVisiblePA1, passwordVisiblePA2;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_parent_register2);

        passwordPA = findViewById(R.id.et_passPA);
        passwordPA.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int Right = 2;
                if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                    if(motionEvent.getRawX()>=passwordPA.getRight()-passwordPA.getCompoundDrawables()[Right].getBounds().width()){
                        int selection = passwordPA.getSelectionEnd();
                        if(passwordVisiblePA1){
                            passwordPA.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.eye_off, 0);
                            passwordPA.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisiblePA1=false;
                        }else {
                            passwordPA.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.eye, 0);
                            passwordPA.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisiblePA1 = true;
                        }
                        passwordPA.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

        confirmPassPA = findViewById(R.id.et_confirmPassPA);
        confirmPassPA.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int Right = 2;
                if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                    if(motionEvent.getRawX()>=confirmPassPA.getRight()-confirmPassPA.getCompoundDrawables()[Right].getBounds().width()){
                        int selection = confirmPassPA.getSelectionEnd();
                        if(passwordVisiblePA2){
                            confirmPassPA.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.eye_off, 0);
                            confirmPassPA.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisiblePA2=false;
                        }else {
                            confirmPassPA.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.eye, 0);
                            confirmPassPA.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisiblePA2 = true;
                        }
                        confirmPassPA.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });
    }

    public void corner_up_leftPA(View view) {
        startActivity(new Intent(getApplicationContext(), Parent_Register.class));
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }
}