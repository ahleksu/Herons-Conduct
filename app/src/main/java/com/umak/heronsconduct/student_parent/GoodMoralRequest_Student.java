package com.umak.heronsconduct.student_parent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.umak.heronsconduct.R;

import java.util.HashMap;

public class GoodMoralRequest_Student extends AppCompatActivity {

    ImageButton cancelButtonGD, cancelButtonGD1;
    EditText edtReq_name_goodMoral, edtReq_umakEmail_goodmoral, edtReq_college_goodmoral, edtReq_idnumber_goodMoral;
    ProgressBar progressbar;

    //inititate FIrebase
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_moral_request_student);
        progressbar = findViewById(R.id.progressbar);

        EditText req_name_goodMoral = findViewById(R.id.req_name_goodMoral);

        //request good moral
        req_goodMoral();

        Cancel_GoodMoral();

        //getting the data from firestore method
        getCredential();

    }

    private void getCredential() {

        progressbar.setVisibility(View.VISIBLE);

        //TODO: GAWING OFF LINE NLANG ANG PAG KEEP NG DATA NG CURREENT USERS
        //TODO: PARA TIPID

        //As of now we retrieve from firestore datatabase
        firebaseFirestore.collection("ACCOUNT_TABLE").document(firebaseAuth.getUid()).get()
                .addOnCompleteListener(new OnCompleteListener < DocumentSnapshot > () {
                    @Override
                    public void onComplete(@NonNull Task < DocumentSnapshot > task) {

                        DocumentSnapshot documentSnapshot = task.getResult();

                        //getting type if student or parents
                        String myType = documentSnapshot.get("type").toString();
                        //for students
                        if (myType.equals("student")) {
                            firebaseFirestore.collection("Student").document(firebaseAuth.getUid())
                                    .get().addOnCompleteListener(new OnCompleteListener < DocumentSnapshot > () {
                                        @Override
                                        public void onComplete(@NonNull Task < DocumentSnapshot > task) {
                                            if (task.isSuccessful()) {
                                                DocumentSnapshot documentSnapshot = task.getResult();
                                                //Log.d("firebase", documentSnapshot.get("student_id").toString());
                                                edtReq_name_goodMoral.setText(documentSnapshot.get("first_name").toString() + " " + documentSnapshot.get("last_name").toString());
                                                edtReq_umakEmail_goodmoral.setText(documentSnapshot.get("umak_email").toString());
                                                edtReq_college_goodmoral.setText(documentSnapshot.get("college").toString());
                                                edtReq_idnumber_goodMoral.setText(documentSnapshot.get("student_id").toString());
                                                progressbar.setVisibility(View.GONE);
                                            }
                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.d("firebase", e.getMessage());
                                            progressbar.setVisibility(View.GONE);
                                        }
                                    });
                        }

                        // for parents
                        else if (myType.equals("parent")) {
                            firebaseFirestore.collection("parent").document(firebaseAuth.getUid())
                                    .get()
                                    .addOnCompleteListener(new OnCompleteListener < DocumentSnapshot > () {
                                        @Override
                                        public void onComplete(@NonNull Task < DocumentSnapshot > task) {
                                            if (task.isSuccessful()) {
                                                DocumentSnapshot documentSnapshot = task.getResult();
                                                Log.d("firebase", documentSnapshot.get("student_id").toString());
                                                //TODO for student
                                                firebaseFirestore.collection("Student").whereEqualTo("student_id", documentSnapshot.get("student_id").toString())
                                                        .get().addOnCompleteListener(new OnCompleteListener < QuerySnapshot > () {
                                                            @Override
                                                            public void onComplete(@NonNull Task < QuerySnapshot > task) {
                                                                for (QueryDocumentSnapshot documentSnapshot1: task.getResult()) {
                                                                    //                                   Log.d("firebase", documentSnapshot1.get("first_name").toString());
                                                                    edtReq_name_goodMoral.setText(documentSnapshot1.get("first_name").toString());
                                                                    edtReq_umakEmail_goodmoral.setText(documentSnapshot1.get("umak_email").toString());
                                                                    edtReq_college_goodmoral.setText(documentSnapshot1.get("college").toString());
                                                                    edtReq_idnumber_goodMoral.setText(documentSnapshot1.get("student_id").toString());
                                                                    progressbar.setVisibility(View.GONE);
                                                                }
                                                            }
                                                        });
                                            }
                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.d("firebase", e.getMessage());
                                            progressbar.setVisibility(View.GONE);
                                        }
                                    });
                        }
                    }
                });

        //TODO for parent
    }

    public void Cancel_GoodMoral() {
        Button Cancel_GoodMoral = findViewById(R.id.Cancel_GoodMoral);
        Cancel_GoodMoral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Student.class);
                startActivity(intent);
            }
        });
    }

    public void req_goodMoral() {

        edtReq_name_goodMoral = findViewById(R.id.req_name_goodMoral);
        edtReq_umakEmail_goodmoral = findViewById(R.id.req_umakEmail_goodmoral);
        edtReq_college_goodmoral = findViewById(R.id.req_college_goodmoral);
        edtReq_idnumber_goodMoral = findViewById(R.id.req_idnumber_goodMoral);

        Button Request_GoodMoral = findViewById(R.id.Request_GoodMoral);
        Request_GoodMoral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String req_nameGoodMoral = edtReq_name_goodMoral.getText().toString();
                String req_EmailGoodMoral = edtReq_umakEmail_goodmoral.getText().toString();
                String req_collegeGoodMoral = edtReq_college_goodmoral.getText().toString();
                String req_idNumberGoodMoral = edtReq_idnumber_goodMoral.getText().toString();

                if (TextUtils.isEmpty(req_nameGoodMoral) || TextUtils.isEmpty(req_EmailGoodMoral) || TextUtils.isEmpty(req_collegeGoodMoral) || TextUtils.isEmpty(req_idNumberGoodMoral)) {
                    openDialogError();
                } else {

                    HashMap<String, String> requestCertificate = new HashMap<>();
                    requestCertificate.put("student_id", req_idNumberGoodMoral);
                    requestCertificate.put("requestor", req_nameGoodMoral);
                    requestCertificate.put("umak_email", req_EmailGoodMoral);
                    requestCertificate.put("college", req_collegeGoodMoral);

                    firebaseFirestore.collection("Good_Moral_Requests")
                            .add(requestCertificate).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    openDialog();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    e.printStackTrace();
                                }
                            });
                }
            }
        });
    }

    private void openDialog() {
        View alertCustomDialog = LayoutInflater.from(GoodMoralRequest_Student.this).inflate(R.layout.req_goodmoral_dialog, null);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(GoodMoralRequest_Student.this);

        alertDialog.setView(alertCustomDialog);
        cancelButtonGD = (ImageButton) alertCustomDialog.findViewById(R.id.cancelID);

        final AlertDialog dialog = alertDialog.create();

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        cancelButtonGD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
                finish();
            }
        });
    }

    private void openDialogError() {
        View alertCustomDialog = LayoutInflater.from(GoodMoralRequest_Student.this).inflate(R.layout.req_goodmoral_dialog_error, null);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(GoodMoralRequest_Student.this);

        alertDialog.setView(alertCustomDialog);
        cancelButtonGD1 = (ImageButton) alertCustomDialog.findViewById(R.id.cancelID);

        final AlertDialog dialog = alertDialog.create();

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        cancelButtonGD1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();

            }
        });
    }

    public void back_goodMoral(View view) {
        // Back button
    }

}