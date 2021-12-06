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

public class rc_isl_teams extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<islTeamModel> islTeamList;
    // link from previous activity depending on league selected
    static String useIslTeamLink= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rc_isl_teams);
        recyclerView = (RecyclerView) findViewById(R.id.isl_team_rc);
        useIslTeamLink = getIntent().getStringExtra("islTeamUrl");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        islTeamList = new ArrayList<>();

        // method to fetch data in the recycler view
        loadRecyclerVieData();
    }

    private void loadRecyclerVieData() {

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("LOADING DATA....... ");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,useIslTeamLink, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                try {
                    //getting data  from json object
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("data");
                    Log.i("problem",array.toString());

                    for(int i=0 ; i<array.length() ; i++){
                        JSONObject o = array.getJSONObject(i);

                        islTeamModel item = new islTeamModel(
                                o.getString("name"),
                                o.getString("logo"),
                                o.getString("short_code"),
                                o.getString("team_id")
                        );
                        islTeamList.add(item);

                    }
                    adapter = new islTeamAdapter(islTeamList,getApplicationContext());
                    recyclerView.setAdapter(adapter);
                    //adapter.notifyDataSetChanged();
                } catch (JSONException e) {
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