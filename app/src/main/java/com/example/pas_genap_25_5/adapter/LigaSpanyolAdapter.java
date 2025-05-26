package com.example.pas_genap_25_5.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pas_genap_25_5.R;
import com.example.pas_genap_25_5.model.Liga;

import java.util.List;

public class LigaSpanyolAdapter extends RecyclerView.Adapter<LigaSpanyolAdapter.ViewHolder> {
    private final List<Liga> teamList;

    public LigaSpanyolAdapter(List<Liga> teamList) {
        this.teamList = teamList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_team, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Liga ligas = teamList.get(position);
        holder.teamName.setText(ligas.getStrTeam());
        holder.teamDescription.setText(ligas.getStrDescriptionEN());
        Glide.with(holder.itemView.getContext())
                .load(ligas.getStrTeamBadge())
                .into(holder.teamBadge);
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView teamName, teamDescription;
        ImageView teamBadge;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            teamName = itemView.findViewById(R.id.tv_team_name);
            teamDescription = itemView.findViewById(R.id.tv_description);
            teamBadge = itemView.findViewById(R.id.img_team_badge);
        }
    }
}
