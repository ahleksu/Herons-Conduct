package com.umak.heronsconduct.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.umak.heronsconduct.R;

public class AdminStudentList extends AppCompatActivity {

    LinearLayout customActionBar;
    ImageView back_to_adminHome;
    RecyclerView studentListRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_student_list);

        customActionBar = findViewById(R.id.customActionBar);
        back_to_adminHome = findViewById(R.id.back_to_adminHome);
        studentListRecyclerView = findViewById(R.id.studentListRecyclerView);


    }
}