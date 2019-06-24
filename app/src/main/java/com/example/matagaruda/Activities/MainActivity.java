package com.example.matagaruda.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;
import com.example.matagaruda.Fragments.*;
import com.example.matagaruda.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new SensorlistFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_sensor);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item
    ) {
        switch (item.getItemId()) {
            case R.id.nav_sensor:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SensorlistFragment()).commit();
                break;

            case R.id.nav_events:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new EventsFragment()).commit();
                break;
            case R.id.nav_events_statistic:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new EventsStatisticFragment()).commit();
                break;
            case R.id.nav_sensor_statistic:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SensorStatisticFragment()).commit();
                break;
            case R.id.nav_top_signature:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new TopSignatureFragment()).commit();
                break;
            case R.id.nav_top_protocols:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new TopProtocolsFragment()).commit();
                break;
            case R.id.nav_daily:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DailyFragment()).commit();
                break;
            case R.id.nav_monthly:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MonthlyFragment()).commit();
                break;
            case R.id.nav_usually:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new UsuallyFragment()).commit();
                break;
            case R.id.nav_logout:
                Toast.makeText(this, "Log Out Successful", Toast.LENGTH_SHORT).show();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
