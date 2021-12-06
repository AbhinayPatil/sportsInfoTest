package com.example.sportsinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class splashScreen extends AppCompatActivity {
    ImageView bg;
    LottieAnimationView lottie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //bg = findViewById(R.id.imageView5);
        lottie = findViewById(R.id.lottie);
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                Intent i = new Intent(splashScreen.this, MainActivity.class);
                startActivity(i);
                finish();
            }
            }, 9000);
    }
       // bg.animate().translationY(-1600).setDuration(1000).setStartDelay(4000);
    }
