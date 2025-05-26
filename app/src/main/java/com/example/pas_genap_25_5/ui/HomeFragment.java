package com.example.pas_genap_25_5.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pas_genap_25_5.R;
import com.example.pas_genap_25_5.adapter.SearchAdapter;
import com.example.pas_genap_25_5.api.ApiClient;
import com.example.pas_genap_25_5.api.ApiService;
import com.example.pas_genap_25_5.model.search;
import com.example.pas_genap_25_5.model.searchResponses;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private SearchAdapter searchAdapter;
    private List<search> searchList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.rvSearch);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        searchAdapter = new SearchAdapter(searchList);
        recyclerView.setAdapter(searchAdapter);

        loadSearchData();

        return view;
    }

    private void loadSearchData() {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<searchResponses> call = apiService.getname();

        call.enqueue(new Callback<searchResponses>() {
            @Override
            public void onResponse(Call<searchResponses> call, Response<searchResponses> response) {
                if (response.isSuccessful() && response.body() != null && response.body().getSearches() != null) {
                    searchList.clear();
                    searchList.addAll(response.body().getSearches());
                    searchAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getContext(), "Data kosong atau error!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<searchResponses> call, Throwable t) {
                Toast.makeText(getContext(), "Gagal memuat data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}