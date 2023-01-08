package com.umak.heronsconduct;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.concurrent.locks.ReentrantLock;

public class Login extends AppCompatActivity {

    private Button login;
    TextView forgotPass;
    Button loginSignUp;

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        forgotPass = (TextView) findViewById(R.id.forgotBTN);
        loginSignUp = (Button) findViewById(R.id.loginSignUp);
        EditText username = (EditText) findViewById(R.id.logIn_userName);
        EditText password = (EditText) findViewById(R.id.logIn_password);
        login = (Button) findViewById(R.id.signInBTN);

        ProgressBar progressBar = findViewById(R.id.progressbar);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO error handling
                String txtUsername = username.getText().toString();
                String txtPassword = password.getText().toString();

                if (txtUsername.isEmpty() || txtPassword.isEmpty()) {
                    Toast.makeText(Login.this, "Please Input Credentials", Toast.LENGTH_SHORT).show();
                }

                else {
                    firebaseAuth.signInWithEmailAndPassword(username.getText().toString(), password.getText().toString())
                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    progressBar.setVisibility(View.VISIBLE);

                                    //Condition kung san siya mapupunta

                                    firebaseFirestore.collection("ACCOUNT_TABLE")
                                            .document(firebaseAuth.getUid())
                                            .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                                @Override
                                                public void onSuccess(DocumentSnapshot documentSnapshot) {
                                                    if (documentSnapshot.getData() != null) {

                                                        String typeofAccount = documentSnapshot.get("type").toString();

                                                        if (typeofAccount.equals("student")) {
                                                            Intent intent = new Intent(getApplicationContext(), Student.class);
                                                            startActivity(intent);
                                                        } else if(typeofAccount.equals("parent")) {
                                                            Intent intent = new Intent(getApplicationContext(), Parent.class);
                                                            startActivity(intent);
                                                        }
                                                        else if (typeofAccount.equals("reporter")) {
                                                            Intent intent = new Intent(getApplicationContext(), Reporter.class);
                                                            startActivity(intent);
                                                        } else if(typeofAccount.equals("admin")) {
                                                            Intent intent = new Intent(getApplicationContext(), Admin.class);
                                                            startActivity(intent);
                                                        }

                                                    }
                                                }
                                            });
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                }

            }


        });

        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, ForgotPass.class);
                startActivity(i);
                finish();
            }
        });

        loginSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, Register.class);
                startActivity(i);
                finish();
            }
        });


    }

}