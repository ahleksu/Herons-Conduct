package com.umak.heronsconduct;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.Objects;

public class Account1 extends AppCompatActivity {

    BottomNavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_account1);

        nav = findViewById(R.id.nav);

        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home:

                        break;

                    case R.id.csfd:

                        break;

                    case R.id.bell:

                        break;

                    case R.id.settings:

                        break;

                    default:


                }




                return true;
            }
        });


    }
}