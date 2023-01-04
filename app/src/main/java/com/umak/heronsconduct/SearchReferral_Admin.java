package com.umak.heronsconduct;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Objects;

public class SearchReferral_Admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_search_referral_admin);


        ImageButton search_violation_admin = findViewById(R.id.search_violation_admin);
        search_violation_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SearchReferral_Admin.this, "Hi", Toast.LENGTH_SHORT).show();
            }
        });
    }
}