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

public class footballFixAdapter extends RecyclerView.Adapter<footballFixAdapter.ViewHolder> {

    private List<footballFixModel> fixModelList;
    private Context context;

    public footballFixAdapter(List<footballFixModel> fixModelList, Context context) {
        this.fixModelList = fixModelList;
        this.context = context;
    }



    @NonNull
    @Override
    public footballFixAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.footballfixturelayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull footballFixAdapter.ViewHolder holder, int position) {
        footballFixModel footballfixmodel = fixModelList.get(position);
        holder.A_homeTeam.setText(footballfixmodel.getHome_team());
        holder.A_awayTeam.setText(footballfixmodel.getAway_team());
        holder.A_homeTeamScore.setText(footballfixmodel.getHome_score());
        holder.A_awayTeamScore.setText(footballfixmodel.getAway_score());
        holder.A_date.setText(footballfixmodel.getDate());
        holder.A_htScore.setText(footballfixmodel.getHt_score());
        holder.A_ftScore.setText(footballfixmodel.getFt_score());
        holder.A_venue.setText(footballfixmodel.getVenue());
        holder.A_matchStatus.setText(footballfixmodel.getStatus());
        holder.A_time.setText(footballfixmodel.getTime());
       // holder.homeTeamLogo.setText(footballfixmodel.getImg_url_home());
        //holder.awayTeamLogo.setText(footballfixmodel.getImg_url_away());
        Picasso.get().load(footballfixmodel.getImg_url_home()).into(holder.A_homeTeamLogo);
        Picasso.get().load(footballfixmodel.getImg_url_away()).into(holder.A_awayTeamLogo);


    }

    @Override
    public int getItemCount() {
        return fixModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //define view objects
        CardView A_ftfixcv1;
        TextView A_homeTeam, A_awayTeam, A_homeTeamScore, A_awayTeamScore, A_date, A_htScore, A_ftScore, A_venue, A_matchStatus,A_time;
        ImageView A_homeTeamLogo, A_awayTeamLogo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            A_ftfixcv1 = itemView.findViewById(R.id.ftfixcv1);
            A_homeTeam = itemView.findViewById(R.id.homeTeam);
            A_awayTeam = itemView.findViewById(R.id.awayTeam);
            A_homeTeamScore = itemView.findViewById(R.id.homeTeamScore);
            A_awayTeamScore = itemView.findViewById(R.id.awayTeamScore);
            A_homeTeamLogo = (ImageView) itemView.findViewById(R.id.homeTeamLogo);
            A_awayTeamLogo = (ImageView) itemView.findViewById(R.id.awayTeamLogo);
            A_date = itemView.findViewById(R.id.date);
            A_matchStatus = itemView.findViewById(R.id.matchStatus);
            A_htScore = itemView.findViewById(R.id.htScore);
            A_ftScore = itemView.findViewById(R.id.ftScore);
            A_venue = itemView.findViewById(R.id.venue);
            A_time  =  itemView.findViewById(R.id.time);
        }
    }
}
