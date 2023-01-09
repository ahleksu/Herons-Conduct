package com.umak.heronsconduct.register;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.umak.heronsconduct.R;
import com.umak.heronsconduct.login.Login;

import java.util.HashMap;

public class Register_Reporter extends AppCompatActivity {

    ImageButton cancelButton3, cancelButtonError3;
    ImageView img_profile;
    Button ok_btn3, ok_btnError3;

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
    StorageReference storageReference = firebaseStorage.getReference();

    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_reporter);

        //register button for parent
        reg_reporter();

        //upload photo method
        uploadReporterProfileMethod();

        Button login_haveAcc_reporter = findViewById(R.id.login_haveAcc_reporter);
        login_haveAcc_reporter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });

    }

    private void uploadReporterProfileMethod() {
        img_profile = findViewById(R.id.img_profile);

        img_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadPhoto();
            }

            private void uploadPhoto() {
                ImagePicker.with(Register_Reporter.this)
                        .galleryOnly()
                        .crop()
                        .compress(1024)
                        .maxResultSize(1080,1080)
                        .start();
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            //Image Uri will not be null for RESULT_OK
            uri = data.getData();
            img_profile.setImageURI(uri);
        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show();
        }
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
                progressBar.setVisibility(View.VISIBLE);

                if(FNameRep.isEmpty() || MNameRep.isEmpty() || LNameRep.isEmpty()){
                    Toast.makeText(Register_Reporter.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
                else if(!ConfirmPasswordRep.equals(PasswordRep)){
                    Toast.makeText(Register_Reporter.this, "Mismatch Password", Toast.LENGTH_SHORT).show();
                }else if (uri == null) {
                    Toast.makeText(Register_Reporter.this, "Photo is required", Toast.LENGTH_SHORT).show();
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

                                                //get reference to firebase storage
                                                StorageReference reporterProfile = storageReference.child("reporterDp/" + edtFNameRep + edtLNameRep);

                                                //Uploading file to firebase Storage
                                                reporterProfile.putFile(uri).addOnProgressListener(new OnProgressListener< UploadTask.TaskSnapshot >() {
                                                    @Override
                                                    public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                                                        progressBar.setVisibility(View.VISIBLE);
                                                    }
                                                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                                    @Override
                                                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                                        reporterProfile.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                                            @Override
                                                            public void onSuccess(Uri uri) {
                                                                HashMap<String, Object> addDataReporter = new HashMap<>();

                                                                addDataReporter.put("umak_email", UmakEmailRep);
                                                                addDataReporter.put("first_name", FNameRep);
                                                                addDataReporter.put("middle_name", MNameRep);
                                                                addDataReporter.put("last_name", LNameRep);
                                                                addDataReporter.put("personal_email", EmailRep);
                                                                addDataReporter.put("reporterID", IdNumberRep);
                                                                addDataReporter.put("image_url", uri);


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
                                                        });
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