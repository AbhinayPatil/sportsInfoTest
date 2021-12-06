package com.example.sportsinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class islTeamAdapter extends RecyclerView.Adapter<islTeamAdapter.ViewHolder> {

    private List<islTeamModel> islTeamList;
    private Context context;

    public islTeamAdapter(List<islTeamModel>islTeamList,Context context){
        this.islTeamList = islTeamList;
        this.context = context;
    }

    @NonNull
    @Override
    public islTeamAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.islteams, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull islTeamAdapter.ViewHolder holder, int position) {
        islTeamModel islTeamModel = islTeamList.get(position);
        holder.A_islTeamId.setText(islTeamModel.getIsl_team_id());
        holder.A_islTeamName.setText(islTeamModel.getIsl_team_name());
        holder.A_islAbbreviation.setText(islTeamModel.getIsl_team_shortForm());
        //holder.A_islTeamLogo.setText(nbaTeamModel.getDivision());
        Picasso.get().load(islTeamModel.getIsl_team_logo()).into(holder.A_islTeamLogo);


    }

    @Override
    public int getItemCount() {
        return islTeamList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        //define objects
        CardView A_cv_isl_teams;
        TextView A_islTeamId,A_islTeamName,A_islAbbreviation;
        ImageView A_islTeamLogo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            A_cv_isl_teams = itemView.findViewById(R.id.cv_isl_teams);
            A_islTeamId = itemView.findViewById(R.id.islTeamId);
            A_islTeamName = itemView.findViewById(R.id.islTeamName);
            A_islAbbreviation = itemView.findViewById(R.id.islAbbreviation);
            A_islTeamLogo = itemView.findViewById(R.id.islTeamLogo);

        }
    }
}
