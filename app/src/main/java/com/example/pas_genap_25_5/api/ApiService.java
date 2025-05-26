package com.example.pas_genap_25_5.api;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import com.example.tryout.model.Ayah;
import com.example.tryout.model.AyahResponses;
import com.example.tryout.model.Surah;

import java.util.List;

public interface ApiService {
    @GET("/search_all_teams.php?s=Soccer&c=Spain")
    Call<List<Surah>> getSurahs();
    @GET("/searchplayers.php?p=Ronaldo")
    Call<AyahResponses> getAyahs(@Path("number") int number);

}
