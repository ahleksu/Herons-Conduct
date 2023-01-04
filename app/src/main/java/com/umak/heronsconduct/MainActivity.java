package com.umak.heronsconduct;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.nav);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId()){
                    case R.id.home:
                        Toast.makeText(MainActivity.this, "Home Page", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.search:
                        Toast.makeText(MainActivity.this, "Search Page", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.stats:
                        Toast.makeText(MainActivity.this, "Stats Page", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.settings:
                        Toast.makeText(MainActivity.this, "Settings Page", Toast.LENGTH_SHORT).show();
                        break;

                    default:
                }


                return true;
            }
        });


    }



}