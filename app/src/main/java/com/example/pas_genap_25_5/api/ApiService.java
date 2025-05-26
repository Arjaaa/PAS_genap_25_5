package com.example.pas_genap_25_5.api;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import com.example.pas_genap_25_5.model.Liga;
import com.example.pas_genap_25_5.model.search;
import com.example.pas_genap_25_5.model.searchResponses;

import java.util.List;

public interface ApiService {
    @GET("search_all_teams.php?s=Soccer&c=Spain")
    Call<List<Liga>> getTeams();
    @GET("searchplayers.php?p=Ronaldo")
    Call<searchResponses> getname();
}
