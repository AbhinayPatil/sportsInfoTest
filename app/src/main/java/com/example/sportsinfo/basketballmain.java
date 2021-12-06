package com.example.sportsinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class basketballmain extends AppCompatActivity {
    CardView bftcv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basketballmain);
        bftcv1 = findViewById(R.id.bftcv1);


        // on click listener for moving to isl fixtures
        bftcv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(basketballmain.this, nbaSelect.class);
                intent.putExtra("nbaFixtureUrl","https://www.balldontlie.io/api/v1/games?seasons[]=2021");
                startActivity(intent);
            }
        });
    }
}