package com.example.sportsinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class nbaFixtureAdapter extends RecyclerView.Adapter<nbaFixtureAdapter.ViewHolder> {
    private List<nbaFixtureModel> nbaFixList;
    private Context context;

    public nbaFixtureAdapter(List<nbaFixtureModel>nbaFixList,Context context){
        this.nbaFixList = nbaFixList;
        this.context = context;
    }

    @NonNull
    @Override
    public nbaFixtureAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nbafixtures, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull nbaFixtureAdapter.ViewHolder holder, int position) {
        nbaFixtureModel nbaFixtureModel = nbaFixList.get(position);
        holder.A_fix_home_team.setText(nbaFixtureModel.getHome_team());
        holder.A_fix_away_team.setText(nbaFixtureModel.getAway_team());
        holder.A_fix_date.setText(nbaFixtureModel.getDate());
        holder.A_away_points.setText(nbaFixtureModel.getAway_points());
        holder.A_home_points.setText(nbaFixtureModel.getHome_points());

    }

    @Override
    public int getItemCount() {
        return nbaFixList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        //define objects
        CardView A_cv_nba_fixture;
        TextView A_fix_home_team,A_fix_away_team,A_fix_date,A_home_points,A_away_points;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            A_fix_home_team = itemView.findViewById(R.id.fix_home_team);
            A_fix_away_team = itemView.findViewById(R.id.fix_away_team);
            A_fix_date = itemView.findViewById(R.id.fix_date);
            A_home_points = itemView.findViewById(R.id.home_points);
            A_away_points = itemView.findViewById(R.id.away_points);
            A_cv_nba_fixture = itemView.findViewById(R.id.cv_nba_fixture);
        }
    }
}
