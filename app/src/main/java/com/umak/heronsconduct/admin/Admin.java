package com.umak.heronsconduct.admin;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.umak.heronsconduct.R;

public class Admin extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ImageView btn;
    FrameLayout frameContainer;

    AdminHomeFragment adminHomeFragment = new AdminHomeFragment();
    AdminSearchFragment adminSearchFragment = new AdminSearchFragment();
    AdminStatsFragment adminStatsFragment = new AdminStatsFragment();
    AdminSettingsFragment adminSettingsFragment = new AdminSettingsFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);

        bottomNavigationView = findViewById(R.id.nav);
        btn = findViewById(R.id.add_btn);
        frameContainer = findViewById(R.id.container);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, adminHomeFragment).commit();


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId()){
                    case R.id.home:
                        btn.setVisibility(View.VISIBLE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, adminHomeFragment).commit();
                        //Toast.makeText(Admin.this, "Home Page", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.search:
                        btn.setVisibility(View.VISIBLE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, adminSearchFragment).commit();
                        //Toast.makeText(Admin.this, "Search Page", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.stats:
                        btn.setVisibility(View.VISIBLE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, adminStatsFragment).commit();
                        //Toast.makeText(Admin.this, "Stats Page", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.settings:
                        btn.setVisibility(View.INVISIBLE);
                        btn.setClickable(false);
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, adminSettingsFragment).commit();
                        //Toast.makeText(Admin.this, "Settings Page", Toast.LENGTH_SHORT).show();
                        break;

                    default:
                }


                return true;
            }
        });



    }
}