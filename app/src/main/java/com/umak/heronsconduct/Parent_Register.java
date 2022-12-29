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

public class Parent_Register extends AppCompatActivity {

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();


    EditText edtNamePA, edtEmailPA, edtBirthdatePA, edtPhonePA, edtAddressPA, edtPasswordPA, edtConfirmPassPA, passwordPA, confirmPassPA;
    boolean passwordVisiblePA1, passwordVisiblePA2;
    Button reg_parent;

    ImageButton cancelButtonPA, cancelButtonErrorPA;
    Button ok_btnPA, ok_btnErrorPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_parent_register);

        password1();
        reg_parent();


    }

    public void reg_parent() {

        edtNamePA = findViewById(R.id.et_NamePA);
        edtEmailPA = findViewById(R.id.et_ParentEmail);
        edtBirthdatePA = findViewById(R.id.et_bdatePA);
        edtPhonePA = findViewById(R.id.et_phonePA);
        edtAddressPA = findViewById(R.id.et_addressPA);
        edtPasswordPA = findViewById(R.id.et_passPA);
        edtConfirmPassPA = findViewById(R.id.et_confirmPassPA);
        reg_parent= findViewById(R.id.register_parent);


        reg_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);

                String NamePA = edtNamePA.getText().toString();
                String EmailPA = edtEmailPA.getText().toString();
                String BirthdatePA = edtBirthdatePA.getText().toString();
                String PhonePA = edtPhonePA.getText().toString();
                String AddressPA = edtAddressPA.getText().toString();
                String PasswordPA = edtPasswordPA.getText().toString();
                String ConfirmPassPA = edtConfirmPassPA.getText().toString();

                if (TextUtils.isEmpty(NamePA) || TextUtils.isEmpty(EmailPA) || TextUtils.isEmpty(PasswordPA) || TextUtils.isEmpty(ConfirmPassPA) || TextUtils.isEmpty(AddressPA) || TextUtils.isEmpty(BirthdatePA) || TextUtils.isEmpty(PhonePA))
                {
                    openDialogError();
                }

                if(NamePA.isEmpty()) {
                    Toast.makeText(Parent_Register.this, "Invalid Name", Toast.LENGTH_SHORT).show();
                    openDialogError();
                    return;
                }

                if(EmailPA.isEmpty()) {
                    Toast.makeText(Parent_Register.this, "Invalid Email", Toast.LENGTH_SHORT).show();
                    openDialogError();
                    return;
                }

                if(BirthdatePA.isEmpty()) {
                    Toast.makeText(Parent_Register.this, "Invalid Student Id", Toast.LENGTH_SHORT).show();
                    openDialogError();
                    return;
                }

                if(PhonePA.isEmpty()) {
                    Toast.makeText(Parent_Register.this, "Invalid Address", Toast.LENGTH_SHORT).show();
                    openDialogError();
                    return;
                }

                if(AddressPA.isEmpty()) {
                    Toast.makeText(Parent_Register.this, "Invalid Birthdate", Toast.LENGTH_SHORT).show();
                    openDialogError();
                    return;
                }

                if(PasswordPA.isEmpty()) {
                    Toast.makeText(Parent_Register.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                    openDialogError();
                    return;
                }

                if(!ConfirmPassPA.equals(PasswordPA)) {
                    Toast.makeText(Parent_Register.this, "Mismatch Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(!(edtNamePA.getText().toString().isEmpty() && edtEmailPA.getText().toString().isEmpty() && edtAddressPA.getText().toString().isEmpty() && edtBirthdatePA.getText().toString().isEmpty() && edtPhonePA.getText().toString().isEmpty() && edtPasswordPA.getText().toString().isEmpty() && edtConfirmPassPA.getText().toString().isEmpty() ))
                {
                    firebaseAuth.createUserWithEmailAndPassword(edtEmailPA.getText().toString(), edtPasswordPA.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {

                                String uid = task.getResult().getUser().getUid();
                                Users1 user1 = new Users1(uid, edtNamePA.getText().toString(), edtEmailPA.getText().toString(), edtAddressPA.getText().toString(), edtBirthdatePA.getText().toString(), edtPhonePA.getText().toString(), edtPasswordPA.getText().toString(), 1);

                                firebaseDatabase.getReference().child("Users").child(uid).setValue(user1);
                                parentDialog();
                            }

                            else {
                                Toast.makeText(Parent_Register.this,task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });
    }

    private void parentDialog() {
        View alertCustomDialog = LayoutInflater.from(Parent_Register.this).inflate(R.layout.custom_dialog, null);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Parent_Register.this);

        alertDialog.setView(alertCustomDialog);
        cancelButtonPA = (ImageButton) alertCustomDialog.findViewById(R.id.cancelID);
        ok_btnPA = (Button) alertCustomDialog.findViewById(R.id.ok_btn_id);

        final AlertDialog dialog = alertDialog.create();


        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();


        cancelButtonPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();

            }
        });
        ok_btnPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
                Intent intent = new Intent (getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
    }

    private void openDialogError() {
        View alertCustomDialog = LayoutInflater.from(Parent_Register.this).inflate(R.layout.custom_dialog_error, null);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Parent_Register.this);

        alertDialog.setView(alertCustomDialog);
        cancelButtonErrorPA = (ImageButton) alertCustomDialog.findViewById(R.id.cancelID_error);
        ok_btnErrorPA = (Button) alertCustomDialog.findViewById(R.id.ok_btn_id_error);

        final AlertDialog dialog = alertDialog.create();


        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();


        cancelButtonErrorPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();

            }
        });
        ok_btnErrorPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
    }


    @SuppressLint("ClickableViewAccessibility")
    public void password1() {

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

    public void x_parent(View view) {
        startActivity(new Intent(getApplicationContext(), On_Boarding.class));
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
        finish();
    }

    public void login_reg2(View view) {
        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(), On_Boarding.class));
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }
}