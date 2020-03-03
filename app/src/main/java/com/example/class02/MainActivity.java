package com.example.class02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayoutId);
        toolbar = findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home");
        toolbar.setTitleTextColor(Color.WHITE);

        navigationView = findViewById(R.id.navId);
        bottomNavigationView = findViewById(R.id.bottomNavId);
        BottomNavigationHelper.disableShiftMode(bottomNavigationView);


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_open
                , R.string.navigation_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(Color.WHITE);
        actionBarDrawerToggle.syncState();


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                if (id == R.id.settingsId){

                    Toast.makeText(MainActivity.this, "Settings is clicked", Toast.LENGTH_SHORT).show();
                }
                else if (id == R.id.shareId){
                    Toast.makeText(MainActivity.this, "Share is clicked", Toast.LENGTH_SHORT).show();
                    Snackbar snackbar = Snackbar.make(drawerLayout,"Share",Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }
                else if (id == R.id.logoutId){
                    Toast.makeText(MainActivity.this, "Logout is clicked", Toast.LENGTH_SHORT).show();
                }


                return false;
            }
        });

    }
}
