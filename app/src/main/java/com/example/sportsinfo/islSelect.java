package com.example.sportsinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class islSelect extends AppCompatActivity {

    Button islTeamsbtn , islFixturesbtn, islTablebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isl_select);

        islTablebtn = findViewById(R.id.islTablebtn);
        islTeamsbtn = findViewById(R.id.islTeamsbtn);
        islFixturesbtn = findViewById(R.id.islFixturebtn);

        // on click listener for moving to nba teams
        islTeamsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(islSelect.this,rc_isl_teams.class);
                intent.putExtra("islTeamUrl","https://app.sportdataapi.com/api/v1/soccer/teams?apikey=c5a42250-42f3-11ec-812a-454a6bdabca0&country_id=57");
                startActivity(intent);
            }
        });

        islFixturesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(islSelect.this,footballFixtures.class);
                intent.putExtra("linkUrl","https://app.sportdataapi.com/api/v1/soccer/matches?apikey=c5a42250-42f3-11ec-812a-454a6bdabca0&season_id=2760&date_from=2021-11-01");
                startActivity(intent);
            }
        });

        islTablebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(islSelect.this,footballtable.class);
                intent.putExtra("islTableUrl","https://app.sportdataapi.com/api/v1/soccer/standings?apikey=c5a42250-42f3-11ec-812a-454a6bdabca0&season_id=2760");
                startActivity(intent);
            }
        });
    }
}