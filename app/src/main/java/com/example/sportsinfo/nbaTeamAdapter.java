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

public class nbaTeamAdapter extends RecyclerView.Adapter<nbaTeamAdapter.ViewHolder> {
    private List<nbaTeamModel>nbaTeamList;
    private Context context;

    public nbaTeamAdapter(List<nbaTeamModel>nbaTeamList,Context context){
        this.nbaTeamList = nbaTeamList;
        this.context = context;
    }

    @NonNull
    @Override
    public nbaTeamAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nbateams, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull nbaTeamAdapter.ViewHolder holder, int position) {
        nbaTeamModel nbaTeamModel = nbaTeamList.get(position);
        holder.A_nbaTeamName.setText(nbaTeamModel.getTeam_name());
        holder.A_nbaTeamId.setText(nbaTeamModel.getTeam_id());
        holder.A_nbaConference.setText(nbaTeamModel.getConference());
        holder.A_nbaDivision.setText(nbaTeamModel.getDivision());
        holder.A_nbaAbbreviation.setText(nbaTeamModel.getAbbreviation());

    }

    @Override
    public int getItemCount() {
        return nbaTeamList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        //define objects
        CardView A_cv_nba_teams;
        TextView A_nbaTeamId,A_nbaTeamName,A_nbaAbbreviation,A_nbaConference,A_nbaDivision;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            A_cv_nba_teams = itemView.findViewById(R.id.cv_isl_teams);
            A_nbaAbbreviation = itemView.findViewById(R.id.islAbbreviation);
            A_nbaDivision = itemView.findViewById(R.id.nbaDivision);
            A_nbaTeamId = itemView.findViewById(R.id.islTeamId);
            A_nbaTeamName = itemView.findViewById(R.id.islTeamName);
            A_nbaConference = itemView.findViewById(R.id.nbaConference);
        }
    }
}
