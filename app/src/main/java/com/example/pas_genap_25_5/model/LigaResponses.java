package com.example.pas_genap_25_5.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class LigaResponses {
    @SerializedName("teams")
    private List<Liga> teams;

    public List<Liga> getTeams() {
        return teams;
    }
}