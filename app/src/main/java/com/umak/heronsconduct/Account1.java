package com.umak.heronsconduct;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.umak.heronsconduct.databinding.ActivityMainBinding;

import java.util.Objects;

public class Account1 extends AppCompatActivity {

    BottomNavigationView navigationView;
    TextView name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_account1);

        //getSupportActionBar().hide();
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        navigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container, new HomeFragment_stu()).commit();
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
                        fragment = new SettingsFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.body_container, fragment).commit();


                return true;
            }
        });


    }

}






