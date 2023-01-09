package com.umak.heronsconduct.general;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.umak.heronsconduct.R;


public class Announcements_CSFD extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcements_csfd);

        CardView a = findViewById(R.id.announcements1);
        CardView b = findViewById(R.id.announcements2);
        CardView c = findViewById(R.id.announcements3);
        CardView d = findViewById(R.id.announcements4);



        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), webview_announcements.class);
                i.putExtra("url", "https://www.facebook.com/UMakCSFD");
                startActivity(i);
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),webview_announcements.class);
                i.putExtra("url", "https://www.facebook.com/UMakCSFD");
                startActivity(i);
            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),webview_announcements.class);
                i.putExtra("url", "https://www.facebook.com/UMakCSFD");
                startActivity(i);
            }
        });

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),webview_announcements.class);
                i.putExtra("url", "https://www.facebook.com/UMakCSFD");
                startActivity(i);
            }
        });



    }
    
    public void back_announcements(View view) {
        Toast.makeText(this, "BACK", Toast.LENGTH_SHORT).show();
    }





}


