package com.dev.ieeensut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class splashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // transparent phone status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        // Action bar removed from splash screen
        getSupportActionBar().hide();
        Thread thread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent intent = new Intent(splashScreen.this , MainActivity.class);
                    startActivity(intent);
                    //back button pressed==exit
                    finish();
                }
            }
        }; thread.start();
    }
}