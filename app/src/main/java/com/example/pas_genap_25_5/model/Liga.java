package com.example.pas_genap_25_5.model;

import com.google.gson.annotations.SerializedName;

public class Liga {
    @SerializedName("strTeam")
    private String strTeam;

    @SerializedName("strDescriptionEN")
    private String strDescriptionEN;

    @SerializedName("strTeamBadge")
    private String strTeamBadge;

    // Getters
    public String getStrTeam() {
        return strTeam;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public String getStrTeamBadge() {
        return strTeamBadge;
    }
}