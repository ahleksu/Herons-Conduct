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

public class Student_Register2 extends AppCompatActivity {

    EditText passwordSTU, confirmPassStu;
    boolean passwordVisible, passwordVisible1;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_student_register2);

        passwordSTU = findViewById(R.id.et_passStud);
        passwordSTU.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int Right = 2;
                if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                    if(motionEvent.getRawX()>=passwordSTU.getRight()-passwordSTU.getCompoundDrawables()[Right].getBounds().width()){
                        int selection = passwordSTU.getSelectionEnd();
                        if(passwordVisible){
                            passwordSTU.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.eye_off, 0);
                            passwordSTU.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible=false;
                        }else {
                            passwordSTU.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.eye, 0);
                            passwordSTU.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible = true;
                        }
                        passwordSTU.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

        confirmPassStu = findViewById(R.id.et_confirmPassStu);
        confirmPassStu.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int Right = 2;
                if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                    if(motionEvent.getRawX()>=confirmPassStu.getRight()-confirmPassStu.getCompoundDrawables()[Right].getBounds().width()){
                        int selection = confirmPassStu.getSelectionEnd();
                        if(passwordVisible1){
                            confirmPassStu.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.eye_off, 0);
                            confirmPassStu.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible1=false;
                        }else {
                            confirmPassStu.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.eye, 0);
                            confirmPassStu.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible1 = true;
                        }
                        confirmPassStu.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });
    }

    public void corner_up_left(View view) {
        startActivity(new Intent(getApplicationContext(), Student_Register.class));
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }
}