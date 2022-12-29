package com.umak.heronsconduct;

import static com.umak.heronsconduct.R.*;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Objects;

public class Login extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

    DatabaseReference reference;

    EditText login_edtEmail,login_edtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(layout.activity_login);

        Button button_forgot_password = (Button) findViewById(id.button_forgot_password);
        Button button_no_account = (Button) findViewById(R.id.button_no_account);
        Button buttonSign_in = (Button) findViewById(R.id.buttonSign_in);



        login_edtEmail = findViewById(R.id.et_username);
        login_edtPass = findViewById(id.et_password);

        buttonSign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(login_edtEmail.getText().toString().isEmpty()) {
                    Toast.makeText(Login.this, "Please enter your username", Toast.LENGTH_SHORT).show();
                    return;
                }
                
                if(login_edtPass.getText().toString().isEmpty()) {
                    Toast.makeText(Login.this, "Please enter your password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(!(login_edtEmail.getText().toString().isEmpty() && login_edtPass.getText().toString().isEmpty())) {

                    firebaseAuth.signInWithEmailAndPassword(login_edtEmail.getText().toString(), login_edtPass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {

                                String uid = task.getResult().getUser().getUid();

                                firebaseDatabase.getReference().child("Users").child(uid).child("usertype").addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        int usertype = snapshot.getValue(Integer.class);

                                        if(usertype==0) {
                                            // STUDENT ACCOUNT


                                            Intent intent = new Intent(getApplicationContext(), Account1.class);
                                            startActivity(intent);
                                        }

                                       else if(usertype==1) {
                                           //PARENT ACCOUNT

                                        }

                                       else if(usertype==2) {
                                           //REPORTER ACCOUNT


                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });

                            }

                            else {
                                Toast.makeText(Login.this, Objects.requireNonNull(task.getException()).getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });



        button_forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Forgot_Password.class));
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });

        button_no_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), User_Type.class));
            }
        });

    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(), On_Boarding.class));
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }
}
