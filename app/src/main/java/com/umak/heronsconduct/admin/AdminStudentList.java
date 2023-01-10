package com.umak.heronsconduct.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.umak.heronsconduct.R;
import com.umak.heronsconduct.admin.Adapter.AdminStudentListAdapter;
import com.umak.heronsconduct.admin.Adapter.MyInterface;
import com.umak.heronsconduct.admin.Model.AdminStudentListModel;

import java.util.ArrayList;

import javax.xml.transform.sax.SAXResult;

public class AdminStudentList extends AppCompatActivity implements MyInterface {

    LinearLayout customActionBar;
    ImageView back_to_adminHome;
    RecyclerView studentListRecyclerView;

    //Model
    ArrayList<AdminStudentListModel> adminStudentLists = new ArrayList<>();

    //Adapyer
    AdminStudentListAdapter adminStudentListAdapter;


    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_student_list);

        customActionBar = findViewById(R.id.customActionBar);
        back_to_adminHome = findViewById(R.id.back_to_adminHome);
        studentListRecyclerView = findViewById(R.id.studentListRecyclerView);

        //inititiate apdapter
        adminStudentListAdapter = new AdminStudentListAdapter(AdminStudentList.this, adminStudentLists, this, "adminstudentlist");

        //for set up data
        setUpData();
        studentListRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        studentListRecyclerView.setAdapter(adminStudentListAdapter);

    }

    private void setUpData() {
        firebaseFirestore.collection("Student").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot queryDocumentSnapshot: task.getResult()){
                                if(queryDocumentSnapshot.getData() != null || queryDocumentSnapshot.get("image_url") != null ){
                                     //   public AdminStudentListModel(String id, String img_profile, String studList_item_name, String studList_item_college, String studList_item_umak_email, String studList_num_acc, String studList_num_vio) {
                                        adminStudentLists.add(new AdminStudentListModel(queryDocumentSnapshot.getId(), queryDocumentSnapshot.get("image_url").toString(), queryDocumentSnapshot.get("first_name").toString() + " " + queryDocumentSnapshot.get("last_name").toString(),  queryDocumentSnapshot.get("college").toString(), queryDocumentSnapshot.get("umak_email").toString(), "0", "0"));
                                        adminStudentListAdapter.notifyItemChanged(adminStudentLists.size());
                                }else{
                                    Toast.makeText(getApplicationContext(), "Have missing value", Toast.LENGTH_SHORT).show();
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

    @Override
    public void onItemClick(int pos, String onclick) {

    }
}