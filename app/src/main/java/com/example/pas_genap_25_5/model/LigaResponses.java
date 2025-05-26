package com.example.pas_genap_25_5.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LigaResponses {
    @SerializedName("teams")
    private List<com.example.pas_genap_25_5.model.Liga> ligas;

    public List<com.example.pas_genap_25_5.model.Liga> getLigas() {
        return ligas;
    }
}
