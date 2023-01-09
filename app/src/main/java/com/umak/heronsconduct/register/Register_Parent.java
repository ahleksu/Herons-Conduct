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

public class Register_Parent extends AppCompatActivity {

    ImageButton cancelButton1, cancelButtonError1;
    Button ok_btn1, ok_btnError1;
    ImageView btn_image;

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
    StorageReference storageReference = firebaseStorage.getReference();

    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_parent);

        //initialization of xml
        initXml();

        //Button register for parent
        reg_parent();

        //upload image button
        uploadImageButtonMetho();

        Button loginParent = findViewById(R.id.login_haveAcc_parent);
        loginParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void uploadImageButtonMetho() {
        btn_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.with(Register_Parent.this)
                        .galleryOnly()
                        .crop()
                        .compress(1024)
                        .maxResultSize(1080, 1080)
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
            btn_image.setImageURI(uri);
        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show();
        }
    }

    private void initXml() {
        btn_image = findViewById(R.id.btn_image);
    }

    public void reg_parent() {
        EditText edtFNamePAR = findViewById(R.id.fNamePAR);
        EditText edtMNamePAR = findViewById(R.id.mNamePAR);
        EditText edtLNamePAR = findViewById(R.id.lNamePAR);
        EditText edtAddressPAR = findViewById(R.id.addressParent);
        EditText edtContactPAR = findViewById(R.id.contactParent);
        EditText edtStudentIdPAR = findViewById(R.id.studentId_Parent);
        EditText edtParent_ID = findViewById(R.id.parent_ID);
        EditText edtEmailPAR = findViewById(R.id.parent_Email);
        EditText edtPasswordPAR = findViewById(R.id.parent_Password);
        EditText edtConfirmPasswordPAR = findViewById(R.id.parent_ConfirmPassword);

        Button Register_PAR_btn = findViewById(R.id.Register_Parent);
        Register_PAR_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String FNamePAR = edtFNamePAR.getText().toString();
                String MNamePAR = edtMNamePAR.getText().toString();
                String LNamePAR = edtLNamePAR.getText().toString();
                //String AddressPAR = edtAddressPAR.getText().toString();
                String ContactPAR = edtContactPAR.getText().toString();
                String StudentIdPAR = edtStudentIdPAR.getText().toString();
                String ParentIdPAR = edtParent_ID.getText().toString();
                String EmailPAR = edtEmailPAR.getText().toString();
                String PasswordPAR = edtPasswordPAR.getText().toString();
                String ConfirmPasswordPAR = edtConfirmPasswordPAR.getText().toString();

                ProgressBar progressBar = findViewById(R.id.progressbar);
                progressBar.setVisibility(View.VISIBLE);

                if (FNamePAR.isEmpty() || MNamePAR.isEmpty() || LNamePAR.isEmpty()) {
                    Toast.makeText(Register_Parent.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                } else if (!ConfirmPasswordPAR.equals(PasswordPAR)) {
                    Toast.makeText(Register_Parent.this, "Mismatch Password", Toast.LENGTH_SHORT).show();
                } else if (uri == null) {
                    Toast.makeText(Register_Parent.this, "Photo is required", Toast.LENGTH_SHORT).show();
                } else {

                    // get the user type
                    Register type = new Register();

                    // ACCOUNT OF PARENT
                    firebaseAuth.createUserWithEmailAndPassword(EmailPAR, ConfirmPasswordPAR).addOnSuccessListener(new OnSuccessListener < AuthResult > () {
                        @Override
                        public void onSuccess(AuthResult authResult) {

                            HashMap < String, Object > addData = new HashMap < > ();
                            addData.put("type", type.Account);

                            // ACCOUNT TABLE
                            firebaseFirestore.collection("ACCOUNT_TABLE").document(firebaseAuth.getUid())
                                    .set(addData).addOnSuccessListener(new OnSuccessListener < Void > () {
                                        @Override
                                        public void onSuccess(Void unused) {

                                            //get reference to firebase storage
                                            StorageReference parentProfile = storageReference.child("parentDp/" + FNamePAR + LNamePAR);

                                            //Uploading file to firebase Storage
                                            parentProfile.putFile(uri).addOnProgressListener(new OnProgressListener < UploadTask.TaskSnapshot > () {
                                                @Override
                                                public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                                                    progressBar.setVisibility(View.VISIBLE);
                                                }
                                            }).addOnSuccessListener(new OnSuccessListener < UploadTask.TaskSnapshot > () {
                                                @Override
                                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                                                    // get Document id
                                                    parentProfile.getDownloadUrl().addOnSuccessListener(new OnSuccessListener < Uri > () {
                                                        @Override
                                                        public void onSuccess(Uri uri) {
                                                            // add data to table of parent
                                                            if (type.Account.equalsIgnoreCase("parent")) {
                                                                HashMap < String, Object > addDataParents = new HashMap < > ();
                                                                addDataParents.put("email", EmailPAR);
                                                                addDataParents.put("parentID", ParentIdPAR);
                                                                addDataParents.put("student_id", StudentIdPAR);
                                                                addDataParents.put("first_name", FNamePAR);
                                                                addDataParents.put("middle_name", MNamePAR);
                                                                addDataParents.put("last_name", LNamePAR);
                                                                addDataParents.put("contact_num", ContactPAR);
                                                                addDataParents.put("image_url", uri);

                                                                //TODO ADD ANOTHER DATA
                                                                firebaseFirestore.collection("parent").document(firebaseAuth.getUid())
                                                                        .set(addDataParents)
                                                                        .addOnSuccessListener(new OnSuccessListener < Void > () {
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
                                            });

                                        }
                                    });
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            // you can put condition or pop upEmail is already existed
                            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);

                        }
                    });
                }

            }
        });

    }

    private void openDialog() {
        View alertCustomDialog = LayoutInflater.from(Register_Parent.this).inflate(R.layout.custom_dialog, null);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Register_Parent.this);

        alertDialog.setView(alertCustomDialog);
        cancelButton1 = (ImageButton) alertCustomDialog.findViewById(R.id.cancelID);
        ok_btn1 = (Button) alertCustomDialog.findViewById(R.id.ok_btn_id);

        final AlertDialog dialog = alertDialog.create();

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        cancelButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();

            }
        });
        ok_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
            }
        });
    }

    private void openDialogError() {
        View alertCustomDialog = LayoutInflater.from(Register_Parent.this).inflate(R.layout.custom_dialog_error, null);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Register_Parent.this);

        alertDialog.setView(alertCustomDialog);
        cancelButtonError1 = (ImageButton) alertCustomDialog.findViewById(R.id.cancelID_error);
        ok_btnError1 = (Button) alertCustomDialog.findViewById(R.id.ok_btn_id_error);

        final AlertDialog dialog = alertDialog.create();

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        cancelButtonError1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();

            }
        });
        ok_btnError1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
    }

    public void x_back1(View view) {
        Intent intent = new Intent(getApplicationContext(), Register.class);
        startActivity(intent);
    }
}