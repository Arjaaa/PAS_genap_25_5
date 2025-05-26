package com.example.pas_genap_25_5.model;

import com.google.gson.annotations.SerializedName;

public class Liga {
    @SerializedName("idTeam")
    private String idTeam;

    @SerializedName("strTeam")
    private String strTeam;

    @SerializedName("strDescriptionEN")
    private String strDescriptionEN;

    @SerializedName("strBadge")
    private String strBadge;

    // Getters
    public String getIdTeam() { return idTeam; }
    public String getStrTeam() { return strTeam; }
    public String getStrDescriptionEN() { return strDescriptionEN; }
    public String getStrTeamBadge() {return strBadge;}
}
