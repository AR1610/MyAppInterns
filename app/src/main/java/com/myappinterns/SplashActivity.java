package com.myappinterns;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.myappinterns.API.PostAPIActivity;

public class SplashActivity extends AppCompatActivity {

    int time = 3000;
    GifImageView gifImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        gifImageView = findViewById(R.id.img_gif);
        gifImageView.setGifImageResource(R.drawable.source);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(SplashActivity.this,
                        NotificationActivity.class);

                startActivity(i);
                finish();

            }
        }, time);
    }
}