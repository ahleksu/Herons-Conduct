package com.umak.heronsconduct;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.checkerframework.checker.units.qual.C;

import java.util.Objects;

public class Student_Register extends AppCompatActivity{


    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://herons--conduct-default-rtdb.firebaseio.com/");

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

    EditText edtNameSTU,edtEmailSTU, edtStudentID, edtAddressSTU, edtBirthdateSTU, edtPhoneSTU, edtPasswordSTU, edtConfirmPassSTU, passwordSTU, confirmPassStu;
    CheckBox chTermSTU;

    boolean passwordVisible, passwordVisible1;
    Button regSTU;


    ImageButton cancelButton, cancelButtonError;
    Button ok_btn, ok_btnError;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_student_register);


        password();
        reg_stu();
    }


    public void reg_stu() {
         edtNameSTU = findViewById(R.id.et_Name);
         edtEmailSTU = findViewById(R.id.et_UEmail);
         edtStudentID = findViewById(R.id.et_stuID);
         edtAddressSTU = findViewById(R.id.et_addressSTU);
         edtBirthdateSTU = findViewById(R.id.et_bdateSTU);
         edtPhoneSTU = findViewById(R.id.et_phone);
         edtPasswordSTU = findViewById(R.id.et_passStud);
         edtConfirmPassSTU = findViewById(R.id.et_confirmPassStu);
         regSTU = findViewById(R.id.Register_STU);
         chTermSTU = findViewById(R.id.terms_Stu);



        //dialog = new Dialog(this);

        regSTU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);

               String NameSTU = edtNameSTU.getText().toString();
               String EmailSTU = edtEmailSTU.getText().toString();
               String StudentID = edtStudentID.getText().toString();
               String AddressSTU = edtAddressSTU.getText().toString();
               String BirthdateSTU = edtBirthdateSTU.getText().toString();
               String PhoneSTU = edtPhoneSTU.getText().toString();
               String PasswordSTU = edtPasswordSTU.getText().toString();
               String ConfirmPassSTU = edtConfirmPassSTU.getText().toString();

               if (TextUtils.isEmpty(NameSTU) || TextUtils.isEmpty(EmailSTU) || TextUtils.isEmpty(StudentID) || TextUtils.isEmpty(PasswordSTU) || TextUtils.isEmpty(ConfirmPassSTU) || TextUtils.isEmpty(AddressSTU) || TextUtils.isEmpty(BirthdateSTU) || TextUtils.isEmpty(PhoneSTU))
               {
                    openDialogError();
               }

               if(NameSTU.isEmpty()) {
                   openDialogError();
                    return;
                }

                if(EmailSTU.isEmpty()) {
                    openDialogError();
                    return;
                }

                if(StudentID.isEmpty()) {
                    openDialogError();
                    return;
                }

                if(AddressSTU.isEmpty()) {
                    openDialogError();
                    return;
                }

                if(BirthdateSTU.isEmpty()) {
                    openDialogError();
                    return;
                }

                if(PhoneSTU.isEmpty()) {
                    openDialogError();
                    return;
                }

                if(PasswordSTU.isEmpty()) {
                    openDialogError();
                    return;
                }

                if(!ConfirmPassSTU.equals(PasswordSTU)) {
                    Toast.makeText(Student_Register.this, "Mismatch Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(chTermSTU.isChecked()) {

                } else {
                    chTermSTU.setTextColor(Color.parseColor("#FF0000"));
                }

                if(!(edtNameSTU.getText().toString().isEmpty() && edtEmailSTU.getText().toString().isEmpty() && edtStudentID.getText().toString().isEmpty() && edtAddressSTU.getText().toString().isEmpty() && edtBirthdateSTU.getText().toString().isEmpty() && edtPhoneSTU.getText().toString().isEmpty() && edtPasswordSTU.getText().toString().isEmpty() && edtConfirmPassSTU.getText().toString().isEmpty() ))
                {
                    firebaseAuth.createUserWithEmailAndPassword(edtEmailSTU.getText().toString(), edtPasswordSTU.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {

                                String uid = task.getResult().getUser().getUid();
                                Users user = new Users(uid, edtNameSTU.getText().toString(), edtEmailSTU.getText().toString(), edtStudentID.getText().toString(), edtAddressSTU.getText().toString(), edtBirthdateSTU.getText().toString(), edtPhoneSTU.getText().toString(), edtPasswordSTU.getText().toString(), 0);

                                firebaseDatabase.getReference().child("Users").child(uid).setValue(user);

                                openDialog();

                            }

                            else {
                                openDialogError();
                                Toast.makeText(Student_Register.this,task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }

                    });
                }

            }
        });
    }

    private void openDialog() {
        View alertCustomDialog = LayoutInflater.from(Student_Register.this).inflate(R.layout.custom_dialog, null);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Student_Register.this);

        alertDialog.setView(alertCustomDialog);
        cancelButton = (ImageButton) alertCustomDialog.findViewById(R.id.cancelID);
        ok_btn = (Button) alertCustomDialog.findViewById(R.id.ok_btn_id);

        final AlertDialog dialog = alertDialog.create();


        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();


        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();

            }
        });
        ok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
                Intent intent = new Intent (getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
    }

    private void openDialogError() {
        View alertCustomDialog = LayoutInflater.from(Student_Register.this).inflate(R.layout.custom_dialog_error, null);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Student_Register.this);

        alertDialog.setView(alertCustomDialog);
        cancelButtonError = (ImageButton) alertCustomDialog.findViewById(R.id.cancelID_error);
        ok_btnError = (Button) alertCustomDialog.findViewById(R.id.ok_btn_id_error);

        final AlertDialog dialog = alertDialog.create();


        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();


        cancelButtonError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();

            }
        });
        ok_btnError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
    }





    @SuppressLint("ClickableViewAccessibility")
    public void password() {
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


            public void x_back(View view) {
                startActivity(new Intent(getApplicationContext(), On_Boarding.class));
                overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
                finish();
            }

            public void login_reg1(View view) {
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



