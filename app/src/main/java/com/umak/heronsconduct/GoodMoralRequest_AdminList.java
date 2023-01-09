package com.umak.heronsconduct;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class GoodMoralRequest_AdminList extends AppCompatActivity {
    private ArrayList<GoodMoralRequest_AdminUser> usersList;
    private RecyclerView recyclerView;



    FirebaseFirestore firestore = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_moral_request_admin_list);
        recyclerView = findViewById(R.id.goodMoralRecyclerView);
        usersList = new ArrayList<>();

        setUserInfo();
        setAdapter();



    }

    private void setAdapter() {
        GoodMoralRequest_AdminRecyclerAdapter adapter = new GoodMoralRequest_AdminRecyclerAdapter(usersList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

    }

    private void setUserInfo() {
/*
        firestore.collection("Student")
                        .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if(task.isSuccessful()) {
                            for(QuerySnapshot.getData() != null){
                                usersList.add(new GoodMoralRequest_AdminUser(documentSnapshot.getId)),
                                documentSnapshot.get("first_name").toString();
                            }
                        }


                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(GoodMoralRequest_AdminList.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

 */

        usersList.add(new GoodMoralRequest_AdminUser("Howard","hbayquen.UmakEmail","CCIS","1-7-2023", "2am"));
        usersList.add(new GoodMoralRequest_AdminUser("Howard","hbayquen.UmakEmail","CCIS","1-7-2023", "2am"));
        usersList.add(new GoodMoralRequest_AdminUser("Howard","hbayquen.UmakEmail","CCIS","1-7-2023", "2am"));
        usersList.add(new GoodMoralRequest_AdminUser("Howard","hbayquen.UmakEmail","CCIS","1-7-2023", "2am"));
        usersList.add(new GoodMoralRequest_AdminUser("Howard","hbayquen.UmakEmail","CCIS","1-7-2023", "2am"));
        usersList.add(new GoodMoralRequest_AdminUser("Howard","hbayquen.UmakEmail","CCIS","1-7-2023", "2am"));
        usersList.add(new GoodMoralRequest_AdminUser("Howard","hbayquen.UmakEmail","CCIS","1-7-2023", "2am"));
    }
}