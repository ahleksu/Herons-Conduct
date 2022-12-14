package com.umak.heronsconduct.student_parent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.umak.heronsconduct.R;

public class Parent extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ImageView btn;
    FrameLayout frameContainer;

    StudentHomeFragment studentHomeFragment = new StudentHomeFragment();
    StudentCSFDPortalFragment studentCSFDPortalFragment = new StudentCSFDPortalFragment();


    ParentNotifFragment parentNotifFragment = new ParentNotifFragment();
    ParentSettingsFragment parentSettingsFragment = new ParentSettingsFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);

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
                        break;
                    case R.id.search:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, studentCSFDPortalFragment).commit();
                        break;
                    case R.id.notifications:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, parentNotifFragment).commit();
                        break;
                    case R.id.settings:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, parentSettingsFragment).commit();
                        break;

                    default:
                }

                return true;
            }
        });
    }


}