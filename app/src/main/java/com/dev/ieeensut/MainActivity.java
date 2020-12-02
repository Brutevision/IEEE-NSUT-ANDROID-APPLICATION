package com.dev.ieeensut;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.dev.ieeensut.fragments.AboutIeeeFragment;
import com.dev.ieeensut.fragments.HomeFragment;
import com.dev.ieeensut.fragments.IeeeResourcesFragment;
import com.dev.ieeensut.helpers.ContentUtils;
import com.dev.ieeensut.interfaces.OnHomeFragmentInteractionListener;
import com.dev.ieeensut.interfaces.OnHomeSliderInteractionListener;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "MainActivity";

    //calling fragments by created strings
    private static final String HOME_FRAGMENT_TAG = "home_fragment";
    private static final String ABOUT_IEEE_FRAGMENT_TAG = "about_ieee_fragment";
    private static final String FRAGMENT_TAG_KEY = "fragment_tag_key";
    private static final String IEEE_RESOURCES_TAG = "ieee_resources_tag";

    private NavigationView mNavigationView;

    private String currentFragmentTag = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationView = findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);
        // First display HomeFragment
        {
            displaySelectedFragment(R.id.nav_home);
            mNavigationView.setCheckedItem(R.id.nav_home);
        }
    }

    //When pressed back activity should jump to HomeFragment
    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        //Create variable name for fragment
        HomeFragment homeFragment = (HomeFragment) fm.findFragmentByTag(HOME_FRAGMENT_TAG);
        AboutIeeeFragment ieeeFragment = (AboutIeeeFragment) fm.findFragmentByTag(ABOUT_IEEE_FRAGMENT_TAG);
        IeeeResourcesFragment ieeeResourcesFragment = (IeeeResourcesFragment) fm.findFragmentByTag(IEEE_RESOURCES_TAG);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if ((ieeeFragment != null && ieeeFragment.isVisible())
                || (ieeeResourcesFragment != null && ieeeResourcesFragment.isVisible())) {
            ft.setCustomAnimations(R.anim.slide_back_from_left, R.anim.fade_translate_down);
            ft.replace(R.id.main_frame_layout, HomeFragment.newInstance(), HOME_FRAGMENT_TAG).addToBackStack(null).commit();
            mNavigationView.setCheckedItem(R.id.nav_home);
            currentFragmentTag = HOME_FRAGMENT_TAG;
        } else if (homeFragment != null && homeFragment.isVisible()) {
            finishAffinity();
        } else {
            try {
                super.onBackPressed();
            } catch (Exception e) {
                ft.setCustomAnimations(R.anim.slide_back_from_left, R.anim.fade_translate_down);
                ft.replace(R.id.main_frame_layout, HomeFragment.newInstance(), HOME_FRAGMENT_TAG).addToBackStack(null).commit();
                mNavigationView.setCheckedItem(R.id.nav_home);
                currentFragmentTag = HOME_FRAGMENT_TAG;
            }
        }
    }

    //Navigation item activities
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_join_ieee) {
            Uri uri = Uri.parse(ContentUtils.JOIN_IEEE_URL);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            PackageManager packageManager = getPackageManager();
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent);
            } else {
                Toast.makeText(this, "Please install browser to continue", Toast.LENGTH_SHORT).show();
            }
        } else {
            displaySelectedFragment(id);
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //Funtion to display particular fragment
    void displaySelectedFragment(int menuItemId) {
        //macros->ft
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        switch (menuItemId) {
            case R.id.nav_home:
                if (!currentFragmentTag.equals(HOME_FRAGMENT_TAG)) {
                    //Animations(folder->anim)
                    ft.setCustomAnimations(R.anim.fade_translate_up, R.anim.slide_to_left);
                    //Fragment replace function
                    ft.replace(R.id.main_frame_layout, HomeFragment.newInstance(), HOME_FRAGMENT_TAG).addToBackStack(null).commit();
                    mNavigationView.setCheckedItem(R.id.nav_home);
                    currentFragmentTag = HOME_FRAGMENT_TAG;
                }
                break;
            case R.id.nav_ieee:
                if (!currentFragmentTag.equals(ABOUT_IEEE_FRAGMENT_TAG)) {
                    ft.setCustomAnimations(R.anim.fade_translate_up, R.anim.slide_to_left);
                    ft.replace(R.id.main_frame_layout, new AboutIeeeFragment(), ABOUT_IEEE_FRAGMENT_TAG).addToBackStack(null).commit();
                    mNavigationView.setCheckedItem(R.id.nav_ieee);
                    currentFragmentTag = ABOUT_IEEE_FRAGMENT_TAG;
                }
                break;
            case R.id.nav_resource:
                if(!currentFragmentTag.equals(IEEE_RESOURCES_TAG)) {
                    ft.setCustomAnimations(R.anim.fade_translate_up, R.anim.slide_to_left);
                    ft.replace(R.id.main_frame_layout, new IeeeResourcesFragment(), IEEE_RESOURCES_TAG).addToBackStack(null).commit();
                    mNavigationView.setCheckedItem(R.id.nav_resource);
                    currentFragmentTag = IEEE_RESOURCES_TAG;
                }
                break;
        }
    }
}