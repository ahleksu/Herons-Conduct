package com.umak.heronsconduct;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.Objects;

public class AdminAccount extends AppCompatActivity {

    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_admin_account);


        navigationView = findViewById(R.id.bottom_navigation4);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container4, new AdminHomeFragment()).commit();
        navigationView.setSelectedItemId(R.id.nav_admin);

        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.nav_admin:
                        fragment = new AdminHomeFragment();
                        break;

                    case R.id.nav_csfd_admin:
                        fragment = new AdminSearchFragment();
                        break;

                    case R.id.plus_admin:
                        fragment = new PlusAdminFragment();
                        break;

                    case R.id.nav_stats_admin:
                        fragment = new AdminStatsFragment();
                        break;

                    case R.id.nav_settings_admin:
                        fragment = new AdminSettingsFragment();
                        break;


                }
                getSupportFragmentManager().beginTransaction().replace(R.id.body_container4, fragment).commit();


                return true;
            }
        });


    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Do you want to Exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });
        builder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert=builder.create();
        alert.show();
    }

}