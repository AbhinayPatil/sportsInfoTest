package com.example.sportsinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class eufaTable extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    //private List<tableModel> tableList;
    // link from previous activity depending on league selected
    static String useLink= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eufa_table);

        recyclerView = (RecyclerView) findViewById(R.id.table_rc);
        useLink = getIntent().getStringExtra("islTableUrl");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //tableList = new ArrayList<>();

        // method to fetch data in the recycler view
        loadRecyclerVieData();
    }

    private void loadRecyclerVieData() {

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("LOADING DATA....... ");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,useLink, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                try {
                    //getting data  from json object
                    ArrayList<TeamModel> list = new ArrayList<>();
                    JSONObject mainObj = new JSONObject(response);
                    JSONObject data = mainObj.getJSONObject("data");
                    JSONArray standings = data.getJSONArray("standings");

                    for (int i = 0; i < standings.length(); i++) {
                        JSONArray currentStandings = standings.getJSONArray(i);

                        for (int j = 0; j < currentStandings.length(); j++) {
                            TeamModel model = new TeamModel();
                            JSONObject current = currentStandings.getJSONObject(i);
                            model.setTeamId(current.getInt("team_id"));
                            model.setPoints(current.getInt("points"));
                            JSONObject overall = current.optJSONObject("overall");
                            model.setDraw(overall.getInt("draw"));
                            model.setWon(overall.getInt("won"));
                            model.setWon(overall.getInt("lost"));
                            model.setGoalDiff(overall.getInt("goals_diff"));

                            list.add(model);

                        }
                        adapter = new tableAdapter(list, getApplicationContext());
                        recyclerView.setAdapter(adapter);
                        //adapter.notifyDataSetChanged();
                    }//return list;
                }
                catch (JSONException e) {
                    //Toast.makeText(footballFixtures.this, "failed", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "oops!! something went wrong", Toast.LENGTH_SHORT).show();

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}