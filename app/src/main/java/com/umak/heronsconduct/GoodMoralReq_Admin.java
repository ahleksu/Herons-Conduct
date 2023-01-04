package com.umak.heronsconduct;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Objects;

public class GoodMoralReq_Admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_good_moral_req_admin);


        CardView req_goodmoral = findViewById(R.id.sonie_req);

        req_goodmoral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GoodMoralReq_AdminNotify.class);
                startActivity(intent);
            }
        });
    }
}