package com.example.pas_genap_25_5.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pas_genap_25_5.R;
import com.example.pas_genap_25_5.model.search;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private List<search> searchList;

    public SearchAdapter(List<search> searchList) {
        this.searchList = searchList;
    }

    public void setSearchList(List<search> newList) {
        this.searchList = newList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder holder, int position) {
        search data = searchList.get(position);
        holder.tvName.setText(data.getName());
        holder.tvTeam.setText("Team: " + data.getTeam());
        holder.tvSport.setText("Sport: " + data.getSport());
        holder.tvNationality.setText("Nationality: " + data.getNationality());
        holder.tvDateborn.setText("Born: " + data.getDateborn());
    }

    @Override
    public int getItemCount() {
        return searchList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvTeam, tvSport, tvNationality, tvDateborn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvTeam = itemView.findViewById(R.id.tv_team);
            tvSport = itemView.findViewById(R.id.tv_sport);
            tvNationality = itemView.findViewById(R.id.tv_nationality);
            tvDateborn = itemView.findViewById(R.id.tv_dateborn);
        }
    }
}
