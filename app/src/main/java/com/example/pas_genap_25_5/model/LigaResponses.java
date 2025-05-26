package com.example.pas_genap_25_5.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LigaResponses {
    @SerializedName("teams")
    private List<com.example.pas_genap_25_5.model.Liga> teams;

    public List<com.example.pas_genap_25_5.model.Liga> getTeams() {
        return liga;
    }
}
