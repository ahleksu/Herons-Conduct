package com.umak.heronsconduct.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.umak.heronsconduct.R;
import com.umak.heronsconduct.admin.Adapter.AdminReferalAdapter;
import com.umak.heronsconduct.admin.Adapter.MyInterface;
import com.umak.heronsconduct.admin.Model.AdminReferalModel;

import java.util.ArrayList;

public class AdminIncidentReferrals extends AppCompatActivity implements MyInterface {


    LinearLayout customActionBar;
    ImageView back_to_adminHome;
    RecyclerView incRefListAdmin;


    ArrayList<AdminReferalModel> adminReferalModels = new ArrayList<>();
    ArrayList<AdminReferalModel> college = new ArrayList<>();

    AdminReferalAdapter adminReferalAdapter;

    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_incident_referrals);

        customActionBar = findViewById(R.id.customActionBar);
        back_to_adminHome = findViewById(R.id.back_to_adminHome);
        incRefListAdmin = findViewById(R.id.incRefListAdmin);


        adminReferalAdapter = new AdminReferalAdapter(this,adminReferalModels, this, "adminreferall");

        //method for populating data
        setUpData();



    }

    private void setUpData() {

        firebaseFirestore.collection("Incident_referrals")
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(DocumentSnapshot documentSnapshot:task.getResult()){
                                //public AdminReferalModel(String image, String title, String codeNumber, String college, String reporter, String offender, String time, String location) {

                                //getting college
                                firebaseFirestore.collection("Student")
                                        .whereEqualTo("IDNumber_parties", documentSnapshot.get("incidenttype").toString())
                                        .get()
                                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                            @Override
                                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                                if(task.isSuccessful()){
                                                    for(DocumentSnapshot documentSnapshot1: task.getResult()){
                                                        adminReferalModels.add(new AdminReferalModel(documentSnapshot1.get("college").toString()));
                                                    }
                                                }
                                            }
                                        });

                                int x = 0;

                                adminReferalModels.add(new AdminReferalModel(documentSnapshot.get("img_url").toString(), documentSnapshot.get("incidenttype").toString(),  documentSnapshot.getId(), "", documentSnapshot.get("firstname_reporter").toString() + " " +  documentSnapshot.get("lastname_reporter").toString(),  documentSnapshot.get("firstname_parties").toString() + " " + documentSnapshot.get("lastname_parties").toString(), documentSnapshot.get("time").toString(), documentSnapshot.get("lcoation").toString() ));
                                x++;
                                adminReferalAdapter.notifyItemChanged(adminReferalModels.size());
                            }
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        incRefListAdmin.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        incRefListAdmin.setAdapter(adminReferalAdapter);


    }

    @Override
    public void onItemClick(int pos, String onclick) {
        //when click
    }
}