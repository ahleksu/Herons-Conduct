package com.umak.heronsconduct.student_parent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.umak.heronsconduct.R;

public class Accountabilities extends AppCompatActivity {

    LinearLayout customActionBar;
    CardView accContainer;
    TextView collegeAcc, umakEmailAcc, studentIDAcc, addressAcc, bdayAcc, contactNumAcc, num_acc_id, num_vio_id;
    RecyclerView listofAcc;
    ImageView back_to_student_parent_home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountabilities);

        //Action Bar
        customActionBar = findViewById(R.id.customActionBar);
        back_to_student_parent_home = findViewById(R.id.back_to_student_parent_home);

        //Container
        accContainer = findViewById(R.id.accContainer);

        //text views
        collegeAcc = findViewById(R.id.collegeAcc);
        umakEmailAcc = findViewById(R.id.umakEmailAcc);
        studentIDAcc = findViewById(R.id.studentIDAcc);
        addressAcc = findViewById(R.id.addressAcc);
        bdayAcc = findViewById(R.id.bdayAcc);
        contactNumAcc = findViewById(R.id.contactNumAcc);
        num_acc_id = findViewById(R.id.num_acc_id);
        num_vio_id = findViewById(R.id.num_vio_id);

        //recycler view
        listofAcc = findViewById(R.id.listofAcc);

    }
}