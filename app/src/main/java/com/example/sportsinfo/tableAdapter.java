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

import java.util.List;

public class tableAdapter extends RecyclerView.Adapter<tableAdapter.ViewHolder> {
    private List<tableModel> tableList;
    private Context context;

    public tableAdapter(List<tableModel> tableList, Context context) {
        this.tableList = tableList;
        this.context = context;
    }


    @NonNull
    @Override
    public tableAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tableres, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull tableAdapter.ViewHolder holder, int position) {
        tableModel tablemodel = tableList.get(position);

        holder.A_table_id.setText(tablemodel.getTeam_id());
        holder.A_table_points.setText(tablemodel.getTeam_points());
        holder.A_table_won.setText(tablemodel.getWon());
        holder.A_table_lost.setText(tablemodel.getLost());
        holder.A_table_draw.setText(tablemodel.getDraw());
        holder.A_table_gd.setText(tablemodel.getGD());


    }

    @Override
    public int getItemCount() {
        return tableList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //define view objects

        TextView A_table_id, A_table_points, A_table_won, A_table_lost, A_table_draw, A_table_gd;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            A_table_id = itemView.findViewById(R.id.table_id);
            A_table_points = itemView.findViewById(R.id.table_points);
            A_table_won = itemView.findViewById(R.id.table_won);
            A_table_lost = itemView.findViewById(R.id.table_lost);
            A_table_draw = itemView.findViewById(R.id.table_draw);
            A_table_gd = itemView.findViewById(R.id.table_gd);
        }
    }
}

