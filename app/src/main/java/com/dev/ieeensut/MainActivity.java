package com.dev.ieeensut;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(getColor(R.color.material_on_surface_emphasis_high_type));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getColor(R.color.black)));getWindow().setStatusBarColor(getColor(R.color.material_on_surface_emphasis_high_type));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getColor(R.color.black)));
    }
}