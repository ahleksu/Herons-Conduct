package com.umak.heronsconduct.student_parent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.umak.heronsconduct.R;

public class StudentDiscRecord extends AppCompatActivity {

    FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    TextView studentDisc_Email, studentDisc_ID, studentDisc_Address, studentDisc_Birthdate, studentDisc_Phone, studentDisc_Middle, studentDisc_Last;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_disc_record);


        TextView studentDisc_Name = findViewById(R.id.studentDisc_Name);
        TextView collegeDisc = findViewById(R.id.collegeDisc);
        studentDisc_Email = findViewById(R.id.studentDisc_Email);
        studentDisc_ID = findViewById(R.id.studentDisc_ID);
        studentDisc_Address = findViewById(R.id.studentDisc_Address);
        studentDisc_Birthdate = findViewById(R.id.studentDisc_Birthdate);
        studentDisc_Phone = findViewById(R.id.studentDisc_Phone);
        studentDisc_Middle = findViewById(R.id.studentDisc_Middle);
        studentDisc_Last = findViewById(R.id.studentDisc_Last);


        String svega = "svega.a12035738@umak.edu.ph";
/*
        firestore.collection("Student").document(firebaseAuth.getUid())
                .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if(task.isSuccessful()){
                            DocumentSnapshot documentSnapshot = task.getResult();
                            if (documentSnapshot.equals("svega")) {
                                Intent intent = new Intent(getApplicationContext(), StudentWithRecord.class);
                                startActivity(intent);
                            }
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        e.printStackTrace();
                    }
                });

 */


        //getting name
        firestore.collection("Student")
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot documentSnapshot:task.getResult()) {
                                if(documentSnapshot.getData() != null ) {

                                        studentDisc_Name.setText(documentSnapshot.get("first_name").toString());
                                        collegeDisc.setText(documentSnapshot.get("college").toString());
                                        studentDisc_Email.setText(documentSnapshot.get("umak_email").toString());
                                        studentDisc_ID.setText(documentSnapshot.get("student_id").toString());
                                        studentDisc_Address.setText(documentSnapshot.get("address").toString());
                                        studentDisc_Birthdate.setText(documentSnapshot.get("birthdate").toString());
                                        studentDisc_Phone.setText(documentSnapshot.get("contact_num").toString());
                                        studentDisc_Middle.setText(documentSnapshot.get("middle_name").toString());
                                        studentDisc_Last.setText(documentSnapshot.get("last_name").toString());

                                }
                            }
                        }
                    }

                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        e.printStackTrace();
                    }
                });






    }
}