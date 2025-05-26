package com.example.pas_genap_25_5.ui;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pas_genap_25_5.R;
import com.example.pas_genap_25_5.adapter.LigaSpanyolAdapter;
import com.example.pas_genap_25_5.model.Liga;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment{
    private RecyclerView rvTeam;
    private LigaSpanyolAdapter adapter;
    private List<Liga> teams = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        rvTeam = view.findViewById(R.id.rvTeam);
        rvTeam.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new LigaSpanyolAdapter(teams);
        rvTeam.setAdapter(adapter);
        return view;
    }
}
