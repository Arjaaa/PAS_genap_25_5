package com.example.pas_genap_25_5.model;
import com.google.gson.annotations.SerializedName;

import java.util.List;
public class searchResponses {
    @SerializedName("player")
    private List<search> searches;

    public List<search> getSearches() {
        return searches;
    }
}