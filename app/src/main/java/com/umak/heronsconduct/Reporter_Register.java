package com.umak.heronsconduct;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class Reporter_Register extends AppCompatActivity {
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();


    EditText edtNameRE, edtEmailRE,edtNumberIdRE, edtPhoneRE, edtAddressRE, edtBirthdateRE , edtPasswordRE, edtConfirmPassRE, passwordRE, confirmPassRE;
    boolean passwordVisibleRE1, passwordVisibleRE2;
    Button reporter_register;

    ImageButton cancelButtonRE, cancelButtonErrorRE;
    Button ok_btnRE, ok_btnErrorRE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_reporter_register);

        password2();
        reporter_register();

    }

    public void reporter_register() {

        edtNameRE = findViewById(R.id.et_NameRE);
        edtEmailRE = findViewById(R.id.et_REEmail);
        edtNumberIdRE = findViewById(R.id.et_stuRE);
        edtPhoneRE = findViewById(R.id.et_phoneRE);
        edtAddressRE = findViewById(R.id.et_addressRE);
        edtBirthdateRE = findViewById(R.id.et_bdateRE);
        edtPasswordRE = findViewById(R.id.et_passRE);
        edtConfirmPassRE = findViewById(R.id.et_confirmPassRE);
        reporter_register = findViewById(R.id.reporter_register);


        reporter_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);

                String NameRE = edtNameRE.getText().toString();
                String EmailRE = edtEmailRE.getText().toString();
                String NumberIdRE = edtNumberIdRE.getText().toString();
                String PhoneRE = edtPhoneRE.getText().toString();
                String AddressRE = edtAddressRE.getText().toString();
                String BirthdateRE = edtBirthdateRE.getText().toString();
                String PasswordRE = edtPasswordRE.getText().toString();
                String ConfirmPassRE = edtConfirmPassRE.getText().toString();

                if (TextUtils.isEmpty(NameRE) || TextUtils.isEmpty(EmailRE) || TextUtils.isEmpty(PasswordRE) || TextUtils.isEmpty(ConfirmPassRE) || TextUtils.isEmpty(AddressRE) || TextUtils.isEmpty(BirthdateRE) || TextUtils.isEmpty(PhoneRE))
                {
                    reporterDialogError();
                }

                if(NameRE.isEmpty()) {
                    Toast.makeText(Reporter_Register.this, "Invalid Name", Toast.LENGTH_SHORT).show();
                    reporterDialogError();
                    return;
                }

                if(EmailRE.isEmpty()) {
                    Toast.makeText(Reporter_Register.this, "Invalid Email", Toast.LENGTH_SHORT).show();
                    reporterDialogError();
                    return;
                }

                if(NumberIdRE.isEmpty()) {
                    Toast.makeText(Reporter_Register.this, "Invalid Student Id", Toast.LENGTH_SHORT).show();
                    reporterDialogError();
                    return;
                }

                if(PhoneRE.isEmpty()) {
                    Toast.makeText(Reporter_Register.this, "Invalid Address", Toast.LENGTH_SHORT).show();
                    reporterDialogError();
                    return;
                }

                if(AddressRE.isEmpty()) {
                    Toast.makeText(Reporter_Register.this, "Invalid Birthdate", Toast.LENGTH_SHORT).show();
                    reporterDialogError();
                    return;
                }

                if(BirthdateRE.isEmpty()) {
                    Toast.makeText(Reporter_Register.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                    reporterDialogError();
                    return;
                }

                if(PasswordRE.isEmpty()) {
                    Toast.makeText(Reporter_Register.this, "Mismatch Password", Toast.LENGTH_SHORT).show();
                    reporterDialogError();
                    return;
                }

                if(!ConfirmPassRE.equals(PasswordRE)) {
                    Toast.makeText(Reporter_Register.this, "Mismatch Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(!(edtNameRE.getText().toString().isEmpty() && edtEmailRE.getText().toString().isEmpty() && edtNumberIdRE.getText().toString().isEmpty() && edtAddressRE.getText().toString().isEmpty() && edtBirthdateRE.getText().toString().isEmpty() && edtPhoneRE.getText().toString().isEmpty() && edtPasswordRE.getText().toString().isEmpty() && edtConfirmPassRE.getText().toString().isEmpty() ))
                {
                    firebaseAuth.createUserWithEmailAndPassword(edtEmailRE.getText().toString(), edtPasswordRE.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {

                                String uid = task.getResult().getUser().getUid();
                                Users2 user2 = new Users2(uid, edtNameRE.getText().toString(), edtEmailRE.getText().toString(), edtNumberIdRE.getText().toString(), edtAddressRE.getText().toString(), edtBirthdateRE.getText().toString(), edtPhoneRE.getText().toString(), edtPasswordRE.getText().toString(), 2);

                                firebaseDatabase.getReference().child("Users").child(uid).setValue(user2);
                                reporterDialog();

                            }

                            else {
                                Toast.makeText(Reporter_Register.this,task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });
    }

    private void reporterDialog() {
        View alertCustomDialog = LayoutInflater.from(Reporter_Register.this).inflate(R.layout.custom_dialog, null);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Reporter_Register.this);

        alertDialog.setView(alertCustomDialog);
        cancelButtonRE = (ImageButton) alertCustomDialog.findViewById(R.id.cancelID);
        ok_btnRE = (Button) alertCustomDialog.findViewById(R.id.ok_btn_id);

        final AlertDialog dialog = alertDialog.create();


        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();


        cancelButtonRE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();

            }
        });
        ok_btnRE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
                Intent intent = new Intent (getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
    }

    private void reporterDialogError() {
        View alertCustomDialog = LayoutInflater.from(Reporter_Register.this).inflate(R.layout.custom_dialog_error, null);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Reporter_Register.this);

        alertDialog.setView(alertCustomDialog);
        cancelButtonErrorRE = (ImageButton) alertCustomDialog.findViewById(R.id.cancelID_error);
        ok_btnErrorRE = (Button) alertCustomDialog.findViewById(R.id.ok_btn_id_error);

        final AlertDialog dialog = alertDialog.create();


        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();


        cancelButtonErrorRE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();

            }
        });
        ok_btnErrorRE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
    }



    @SuppressLint("ClickableViewAccessibility")
    public void password2() {
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





    public void login_reg3(View view) {
        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();
    }

    public void x_reporter(View view) {
        startActivity(new Intent(getApplicationContext(), On_Boarding.class));
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(), On_Boarding.class));
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }
}