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

public class footballFixtures extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<footballFixModel> fixModelList;
    // link from previous activity depending on league selected
    static String useLink= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football_fixtures);
        recyclerView = (RecyclerView) findViewById(R.id.rv2);
        useLink = getIntent().getStringExtra("linkUrl");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fixModelList = new ArrayList<>();

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
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("data");
                    Log.i("problem",array.toString());

                    for(int i=0 ; i<array.length() ; i++){
                        JSONObject o = array.getJSONObject(i);
                        JSONObject o1 = o.getJSONObject("home_team");
                        JSONObject o2 = o.getJSONObject("away_team");
                        JSONObject o3 = o.getJSONObject("stats");
                        JSONObject o4 = o.getJSONObject("venue");
                        footballFixModel item = new footballFixModel(
                                o1.getString("logo"),
                                o2.getString("logo"),
                                o3.getString("home_score"),
                                o3.getString("away_score"),
                                o1.getString("short_code"),
                                o2.getString("short_code"),
                                o.getString("match_start").substring(0,10),
                                o4.getString("city"),
                                o.getString("status"),
                                o3.getString("ht_score"),
                                o3.getString("ft_score"),
                                o.getString("match_start").substring(10)
                        );
                        fixModelList.add(item);

                    }
                    adapter = new footballFixAdapter(fixModelList,getApplicationContext());
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