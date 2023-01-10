package com.umak.heronsconduct.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.umak.heronsconduct.R;
import com.umak.heronsconduct.admin.Adapter.AdminGoodMoralRequestAdapter;
import com.umak.heronsconduct.admin.Adapter.MyInterface;
import com.umak.heronsconduct.admin.Model.GoodMoralRequestModel;

import java.util.ArrayList;

public class GoodMoralRequest_AdminList extends AppCompatActivity implements MyInterface {

    LinearLayout customActionBar;
    ImageView back_to_adminHome;
    RecyclerView goodMoralRequestList;

    //call and inititate Arrauylist Method
    ArrayList<GoodMoralRequestModel> goodMoralRequestModels = new ArrayList<>();

    //call adapter
    AdminGoodMoralRequestAdapter adminGoodMoralRequestAdapter;
    FirebaseFirestore firestore = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_moral_request_admin_list);

        customActionBar = findViewById(R.id.customActionBar);
        back_to_adminHome = findViewById(R.id.back_to_adminHome);
        goodMoralRequestList = findViewById(R.id.goodMoralRequestsList);


        //inititiate Adapter
        adminGoodMoralRequestAdapter = new AdminGoodMoralRequestAdapter(this, goodMoralRequestModels, this, "goodmoralrequest");


        //setUpData
        setUpData();


    }

    private void setUpData() {
            firestore.collection("Good_Moral_Requests").get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if(task.isSuccessful()){
                                for(QueryDocumentSnapshot queryDocumentSnapshot: task.getResult()){
                                       // public GoodMoralRequestModel(String id, String name_of_requestor, String requestor_college, String email_of_requestor, String date_of_request) {
                                        goodMoralRequestModels.add(new GoodMoralRequestModel(queryDocumentSnapshot.getId(), queryDocumentSnapshot.get("requestor").toString(), queryDocumentSnapshot.get("college").toString(), queryDocumentSnapshot.get("umak_email").toString(), ""  ));
                                        adminGoodMoralRequestAdapter.notifyItemChanged(goodMoralRequestModels.size());
                                }
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            e.printStackTrace();
                        }
                    });

        goodMoralRequestList.setAdapter(adminGoodMoralRequestAdapter);
        goodMoralRequestList.setLayoutManager(new LinearLayoutManager(this));
    }




    @Override
    public void onItemClick(int pos, String onclick) {

    }
}