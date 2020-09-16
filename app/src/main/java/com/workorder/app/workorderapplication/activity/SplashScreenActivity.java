package com.workorder.app.workorderapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.workorder.app.R;
import com.workorder.app.activity.LoginActivity;


public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent main = new Intent(SplashScreenActivity.this, LoginActivity.class);
                SplashScreenActivity.this.startActivity(main);
              //  overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                SplashScreenActivity.this.finish();
            }
        }, 4000);
    }
}
