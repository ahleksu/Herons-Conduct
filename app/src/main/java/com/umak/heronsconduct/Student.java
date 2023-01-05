package com.umak.heronsconduct;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Student extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ImageView btn;
    FrameLayout frameContainer;

    StudentHomeFragment studentHomeFragment = new StudentHomeFragment();
    StudentCSFDPortalFragment studentCSFDPortalFragment = new StudentCSFDPortalFragment();
    StudentNotifFragment studentNotifFragment = new StudentNotifFragment();
    StudentSettingsFragment studentSettingsFragment = new StudentSettingsFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        bottomNavigationView = findViewById(R.id.nav);
        btn = findViewById(R.id.add_btn);
        frameContainer = findViewById(R.id.container);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, studentHomeFragment).commit();

        BadgeDrawable badgeDrawable = bottomNavigationView.getOrCreateBadge(R.id.notifications);
        badgeDrawable.setVisible(true);
        badgeDrawable.setNumber(7);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId()){
                    case R.id.home:
                        btn.setVisibility(View.VISIBLE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, studentHomeFragment).commit();
                        Toast.makeText(Student.this, "Home Page", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.search:
                        btn.setVisibility(View.VISIBLE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, studentCSFDPortalFragment).commit();
                        Toast.makeText(Student.this, "CSFD Portal Page", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.notifications:
                        btn.setVisibility(View.VISIBLE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, studentNotifFragment).commit();
                        Toast.makeText(Student.this, "Notifications Page", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.settings:
                        btn.setVisibility(View.INVISIBLE);
                        btn.setClickable(false);
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, studentSettingsFragment).commit();
                        Toast.makeText(Student.this, "Settings Page", Toast.LENGTH_SHORT).show();
                        break;

                    default:
                }

                return true;
            }
        });
    }
}