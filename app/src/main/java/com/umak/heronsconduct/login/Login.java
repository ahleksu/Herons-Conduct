package com.umak.heronsconduct.login;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.umak.heronsconduct.student_parent.Parent;
import com.umak.heronsconduct.R;
import com.umak.heronsconduct.register.Register;
import com.umak.heronsconduct.reporter.Reporter;
import com.umak.heronsconduct.student_parent.Student;
import com.umak.heronsconduct.admin.Admin;

public class Login extends AppCompatActivity {

    private Button login;
    TextView forgotPass;
    Button loginSignUp;
    Dialog dialog;

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

        //Exit Dialog
        dialog = new Dialog(Login.this);
        dialog.setContentView(R.layout.custom_dialog_exit);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background));
        }

        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

        //Custom Exit Dialog
        Button ok = dialog.findViewById(R.id.ok_btn_id);
        Button cancel = dialog.findViewById(R.id.cancel_button);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });


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

    @Override
    public void onBackPressed() {
        //Disabled back button on Login
        dialog.show();
    }


}