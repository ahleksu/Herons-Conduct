package com.umak.heronsconduct.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.umak.heronsconduct.R;

public class AdminIncidentReferrals extends AppCompatActivity {


    LinearLayout customActionBar;
    ImageView back_to_adminHome;
    RecyclerView incRefListAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_incident_referrals);

        customActionBar = findViewById(R.id.customActionBar);
        back_to_adminHome = findViewById(R.id.back_to_adminHome);
        incRefListAdmin = findViewById(R.id.incRefListAdmin);




    }
}