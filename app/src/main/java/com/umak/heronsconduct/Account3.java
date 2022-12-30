package com.umak.heronsconduct;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.Objects;

public class Account3 extends AppCompatActivity {

    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_account3);

        navigationView = findViewById(R.id.bottom_navigation3);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container3, new HomeFragment_rep()).commit();
        navigationView.setSelectedItemId(R.id.nav_home1);

        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.nav_home1:
                        fragment = new HomeFragment_rep();
                        break;

                    case R.id.nav_csfd1:
                        fragment = new CsfdReporterFragment();
                        break;

                    case R.id.plus:
                        fragment = new CreateIncidentFragment();
                        break;

                    case R.id.nav_notification1:
                        fragment = new NotifFragment();
                        break;

                    case R.id.nav_settings1:
                        fragment = new SettingsReporterFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.body_container3, fragment).commit();


                return true;
            }
        });
    }
}