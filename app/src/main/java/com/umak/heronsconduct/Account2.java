package com.umak.heronsconduct;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.Objects;

public class Account2 extends AppCompatActivity {

    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_account2);


        navigationView = findViewById(R.id.bottom_navigation1);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container1, new HomeFragment_stu()).commit();
        navigationView.setSelectedItemId(R.id.nav_home);

        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        fragment = new HomeFragment_stu();
                        break;

                    case R.id.nav_csfd:
                        fragment = new CsfdFragment();
                        break;

                    case R.id.nav_notification:
                        fragment = new NotifFragment();
                        break;

                    case R.id.nav_settings:
                        fragment = new SettingsParentFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.body_container1, fragment).commit();


                return true;
            }
        });

    }
}