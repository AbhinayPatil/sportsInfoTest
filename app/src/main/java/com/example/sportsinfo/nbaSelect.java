package com.example.sportsinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class nbaSelect extends AppCompatActivity {
    Button nbaTeamsbtn , nbaFixturesbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nbaselect);
        nbaTeamsbtn = findViewById(R.id.eufaTeamsbtn);
        nbaFixturesbtn = findViewById(R.id.b);

        // on click listener for moving to nba teams
        nbaTeamsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(nbaSelect.this,rc_nba_teams.class);
                intent.putExtra("nbaTeamUrl","https://www.balldontlie.io/api/v1/teams");
                startActivity(intent);
            }
        });

        nbaFixturesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(nbaSelect.this,rc_nba_fixtures.class);
                intent.putExtra("nbaFixUrl","https://www.balldontlie.io/api/v1/games?seasons[]=2021");
                startActivity(intent);
            }
        });
    }
}