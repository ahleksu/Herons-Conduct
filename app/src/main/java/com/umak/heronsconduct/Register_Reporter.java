package com.umak.heronsconduct;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class Register_Reporter extends AppCompatActivity {

    ImageButton cancelButton3, cancelButtonError3;

    Button ok_btn3, ok_btnError3;

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_reporter);



        //register button for parent
        reg_reporter();

        Button login_haveAcc_reporter = findViewById(R.id.login_haveAcc_reporter);
        login_haveAcc_reporter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });

    }


    public void reg_reporter() {
        EditText edtFNameRep = findViewById(R.id.fNameRep);
        EditText edtMNameRep = findViewById(R.id.mNameRep);
        EditText edtLNameRep = findViewById(R.id.lNameRep);
        EditText edtUmakEmailRep = findViewById(R.id.umakEmailReporter);
        EditText edtIdNumberRep = findViewById(R.id.idNumber_Reporter);
        EditText edtEmailRep = findViewById(R.id.reporter_Email);
        EditText edtPasswordRep = findViewById(R.id.reporter_Password);
        EditText edtConfirmPasswordRep = findViewById(R.id.reporter_ConfirmPassword);


        Button Register_REPORTER = findViewById(R.id.Register_REPORTER);
        Register_REPORTER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String FNameRep = edtFNameRep.getText().toString();
                String MNameRep = edtMNameRep.getText().toString();
                String LNameRep = edtLNameRep.getText().toString();
                String UmakEmailRep = edtUmakEmailRep.getText().toString();
                String IdNumberRep = edtIdNumberRep.getText().toString();
                String EmailRep = edtEmailRep.getText().toString();
                String PasswordRep = edtPasswordRep.getText().toString();
                String ConfirmPasswordRep = edtConfirmPasswordRep.getText().toString();


                ProgressBar progressBar = findViewById(R.id.progressbar);


                if(!ConfirmPasswordRep.equals(PasswordRep)){
                    Toast.makeText(Register_Reporter.this, "Mismatch Password", Toast.LENGTH_SHORT).show();
                }
                else {

                    // get the user type
                    Register type = new Register();

                    // ACCOUNT OF PARENT
                    firebaseAuth.createUserWithEmailAndPassword(UmakEmailRep, ConfirmPasswordRep).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            progressBar.setVisibility(View.VISIBLE);
                            HashMap<String, Object> addData = new HashMap<>();
                            addData.put("type", type.Account);

                            // ACCOUNT TABLE

                            firebaseFirestore.collection("ACCOUNT_TABLE").document(firebaseAuth.getUid())
                                    .set(addData).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void unused) {
                                            // add data to table of reporter

                                            if(type.Account.equalsIgnoreCase("reporter")) {

                                                HashMap<String, Object> addDataReporter = new HashMap<>();

                                                addDataReporter.put("umak_email", UmakEmailRep);
                                                addDataReporter.put("first_name", FNameRep);
                                                addDataReporter.put("middle_name", MNameRep);
                                                addDataReporter.put("last_name", LNameRep);
                                                addDataReporter.put("personal_email", EmailRep);
                                                addDataReporter.put("reporterID", IdNumberRep);


                                                //TODO ADD ANOTHER DATA


                                                firebaseFirestore.collection("reporter").document(firebaseAuth.getUid())
                                                        .set(addDataReporter)
                                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                            @Override
                                                            public void onSuccess(Void unused) {
                                                                Intent intent = new Intent(getApplicationContext(), Login.class);
                                                                startActivity(intent);
                                                                Toast.makeText(getApplicationContext(), "SUCCESS", Toast.LENGTH_SHORT).show();
                                                            }
                                                        });

                                            }
                                        }
                                    });
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            // you can put condition or pop upEmail is already existed
                            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }



            }
        });



    }





    private void openDialog() {
        View alertCustomDialog = LayoutInflater.from(Register_Reporter.this).inflate(R.layout.custom_dialog, null);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Register_Reporter.this);

        alertDialog.setView(alertCustomDialog);
        cancelButton3 = (ImageButton) alertCustomDialog.findViewById(R.id.cancelID);
        ok_btn3 = (Button) alertCustomDialog.findViewById(R.id.ok_btn_id);

        final AlertDialog dialog = alertDialog.create();


        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();


        cancelButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();

            }
        });
        ok_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
                Intent intent = new Intent (getApplicationContext(), Register.class);
                startActivity(intent);
            }
        });
    }



    private void openDialogError() {
        View alertCustomDialog = LayoutInflater.from(Register_Reporter.this).inflate(R.layout.custom_dialog_error, null);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Register_Reporter.this);

        alertDialog.setView(alertCustomDialog);
        cancelButtonError3 = (ImageButton) alertCustomDialog.findViewById(R.id.cancelID_error);
        ok_btnError3 = (Button) alertCustomDialog.findViewById(R.id.ok_btn_id_error);

        final AlertDialog dialog = alertDialog.create();


        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();


        cancelButtonError3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();

            }
        });
        ok_btnError3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
    }


    public void x_back2(View View) {
        Intent intent = new Intent(getApplicationContext(), Register.class);
        startActivity(intent);
    }
}