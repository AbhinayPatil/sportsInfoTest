package com.example.sportsinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class eufaSelect extends AppCompatActivity {

    Button eufaTeamsbtn , eufaFixturesbtn, eufaTablebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eufa_select);

        eufaTeamsbtn = findViewById(R.id.eufaTeamsbtn);
        eufaFixturesbtn = findViewById(R.id.eufaFixturebtn);
        eufaTablebtn = findViewById(R.id.eufaTablebtn);

        // on click listener for moving to nba teams
        eufaTeamsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(eufaSelect.this,rc_isl_teams.class);
                intent.putExtra("islTeamUrl","https://app.sportdataapi.com/api/v1/soccer/teams?apikey=c5a42250-42f3-11ec-812a-454a6bdabca0&country_id=4");
                startActivity(intent);
            }
        });

        eufaFixturesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(eufaSelect.this,footballFixtures.class);
                intent.putExtra("linkUrl","https://app.sportdataapi.com/api/v1/soccer/matches?apikey=c5a42250-42f3-11ec-812a-454a6bdabca0&season_id=1959&date_from=2021-11-01");
                startActivity(intent);
            }
        });

        eufaTablebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(eufaSelect.this,footballtable.class);
                intent.putExtra("islTableUrl","https://app.sportdataapi.com/api/v1/soccer/standings?apikey=c5a42250-42f3-11ec-812a-454a6bdabca0&season_id=1959");
                startActivity(intent);
            }
        });
    }
}