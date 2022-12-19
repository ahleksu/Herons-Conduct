package com.umak.heronsconduct;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class Student_Register extends AppCompatActivity{


    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://herons--conduct-default-rtdb.firebaseio.com/");

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

    EditText edtNameSTU,edtEmailSTU, edtStudentID, edtAddressSTU, edtBirthdateSTU, edtPhoneSTU, edtPasswordSTU, edtConfirmPassSTU, passwordSTU, confirmPassStu;
    CheckBox chTermSTU;

    boolean passwordVisible, passwordVisible1;
    Button regSTU;

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

               // if (TextUtils.isEmpty(NameSTU) || TextUtils.isEmpty(EmailSTU) || TextUtils.isEmpty(StudentID) || TextUtils.isEmpty(PasswordSTU) || TextUtils.isEmpty(ConfirmPassSTU) || TextUtils.isEmpty(AddressSTU) || TextUtils.isEmpty(BirthdateSTU) || TextUtils.isEmpty(PhoneSTU))
              //  {
                   // Intent intent = new Intent(getApplicationContext(), RegisterError.class);
                  //  startActivity(intent);
              //  }

                if(NameSTU.isEmpty()) {
                    Toast.makeText(Student_Register.this, "Invalid Name", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(EmailSTU.isEmpty()) {
                    Toast.makeText(Student_Register.this, "Invalid Email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(StudentID.isEmpty()) {
                    Toast.makeText(Student_Register.this, "Invalid Student Id", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(AddressSTU.isEmpty()) {
                    Toast.makeText(Student_Register.this, "Invalid Address", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(BirthdateSTU.isEmpty()) {
                    Toast.makeText(Student_Register.this, "Invalid Birthdate", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(PhoneSTU.isEmpty()) {
                    Toast.makeText(Student_Register.this, "Invalid Phone", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(PasswordSTU.isEmpty()) {
                    Toast.makeText(Student_Register.this, "Invalid Password", Toast.LENGTH_SHORT).show();
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

                                Intent in = new Intent(getApplicationContext(), RegisterSuccess.class);
                                startActivity(in);

                            }

                            else {
                                Toast.makeText(Student_Register.this,task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

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



