package com.example.sportsinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class legue_football extends AppCompatActivity {
    CardView ftcv1, ftcv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legue_football);

        ftcv1 = findViewById(R.id.ftcv1);
        ftcv2 = findViewById(R.id.ftcv2);


        // on click listener for moving to isl fixtures
        ftcv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(legue_football.this, islSelect.class);
                startActivity(intent);
            }
        });

        // on click listener for moving to eufa fixtures
        ftcv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(legue_football.this, eufaSelect.class);
                startActivity(intent);
            }
        });


    }
}