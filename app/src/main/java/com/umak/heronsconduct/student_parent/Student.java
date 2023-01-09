package com.umak.heronsconduct.student_parent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.umak.heronsconduct.R;

public class Student extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
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
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, studentHomeFragment).commit();
                        //Toast.makeText(Student.this, "Home Page", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.search:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, studentCSFDPortalFragment).commit();
                        //Toast.makeText(Student.this, "CSFD Portal Page", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.notifications:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, studentNotifFragment).commit();
                        //Toast.makeText(Student.this, "Notifications Page", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.settings:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, studentSettingsFragment).commit();
                        //Toast.makeText(Student.this, "Settings Page", Toast.LENGTH_SHORT).show();
                        break;

                    default:
                }

                return true;
            }
        });
    }
}