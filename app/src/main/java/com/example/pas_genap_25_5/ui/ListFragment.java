package com.example.pas_genap_25_5.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pas_genap_25_5.R;
import com.example.pas_genap_25_5.adapter.LigaSpanyolAdapter;
import com.example.pas_genap_25_5.api.ApiClient;
import com.example.pas_genap_25_5.api.ApiService;
import com.example.pas_genap_25_5.model.Liga;
import com.example.pas_genap_25_5.model.LigaResponses;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListFragment extends Fragment {
    private static final String TAG = "ListFragment";
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

        fetchTeamDataFromAPI();
        return view;
    }

    private void fetchTeamDataFromAPI() {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<LigaResponses> call = apiService.getTeams();

        call.enqueue(new Callback<LigaResponses>() {
            @Override
            public void onResponse(Call<LigaResponses> call, Response<LigaResponses> response) {
                if (response.isSuccessful() && response.body() != null) {
                    LigaResponses ligaResponses = response.body();
                    if (ligaResponses != null && ligaResponses.getTeams() != null) {
                        teams.clear();
                        teams.addAll(ligaResponses.getTeams());
                        adapter.notifyDataSetChanged();
                    } else {
                        showToast("Data kosong atau format tidak sesuai");
                        Log.e(TAG, "Response body or teams list is null");
                    }
                } else {
                    showToast("Gagal mendapatkan respons dari server");
                    Log.e(TAG, "Unsuccessful response: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<LigaResponses> call, Throwable t) {
                showToast("Gagal terhubung ke server");
                Log.e(TAG, "API call failed: " + t.getMessage());
                t.printStackTrace();
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}