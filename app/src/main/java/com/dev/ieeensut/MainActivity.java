package com.dev.ieeensut;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;


import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(getColor(R.color.blue));
        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getColor(R.color.black)));

        toolbar=findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.blue));
        navigationView=findViewById(R.id.navigation);
        drawer=findViewById(R.id.drawer);

        setSupportActionBar(toolbar);

        toggle=new ActionBarDrawerToggle(this, drawer, toolbar,R.string.open, R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawer.closeDrawer(GravityCompat.START);
                switch (item.getItemId()){
                    case R.id.nav_my_profile:
                        Toast.makeText(MainActivity.this, "My profile", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_search:
                        Toast.makeText(MainActivity.this, "connect with other members", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_home:
                        Toast.makeText(MainActivity.this, "I'm coming home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_events:
                        Toast.makeText(MainActivity.this, "Hota toh kuch hai nhi", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_ieee:
                        Toast.makeText(MainActivity.this, "IEEE", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_resource:
                        Toast.makeText(MainActivity.this, "resources", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_join_ieee:
                        Toast.makeText(MainActivity.this, "Hume join karlo", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_team:
                        Toast.makeText(MainActivity.this, "Team", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_developers:
                        Toast.makeText(MainActivity.this, "Developers", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_connect:
                        Toast.makeText(MainActivity.this, "site, fb, insta, mail", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_share:
                        Toast.makeText(MainActivity.this, "Share", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }
}