package com.umak.heronsconduct;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Reporter extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ImageView btn;
    FrameLayout frameContainer;

    ReporterHomeFragment reporterHomeFragment = new ReporterHomeFragment();
    ReporterCSFDPortalFragment reporterCSFDPortalFragment = new ReporterCSFDPortalFragment();
    ReporterNotifFragment reporterNotifFragment = new ReporterNotifFragment();
    ReporterSettingsFragment reporterSettingsFragment = new ReporterSettingsFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporter);

        bottomNavigationView = findViewById(R.id.nav);
        btn = findViewById(R.id.add_btn);
        frameContainer = findViewById(R.id.container);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, reporterHomeFragment).commit();


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId()){
                    case R.id.home:
                        btn.setVisibility(View.VISIBLE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, reporterHomeFragment).commit();
                        //Toast.makeText(Reporter.this, "Reporter Home Page", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.search:
                        btn.setVisibility(View.VISIBLE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, reporterCSFDPortalFragment).commit();
                        //Toast.makeText(Reporter.this, "Reporter CSFD Page", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.notifications:
                        btn.setVisibility(View.INVISIBLE);
                        btn.setClickable(false);
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, reporterNotifFragment).commit();
                        //Toast.makeText(Reporter.this, "Reporter Notifications Page", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.settings:
                        btn.setVisibility(View.INVISIBLE);
                        btn.setClickable(false);
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, reporterSettingsFragment).commit();
                        //Toast.makeText(Reporter.this, "Reporter Settings Page", Toast.LENGTH_SHORT).show();
                        break;

                    default:
                }


                return true;
            }
        });

    }
}