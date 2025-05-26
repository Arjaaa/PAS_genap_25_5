package com.example.pas_genap_25_5.model;

import com.google.gson.annotations.SerializedName;

public class search {
    @SerializedName("strPlayer")
    private String name;

    @SerializedName("strTeam")
    private String team;

    @SerializedName("strSport")
    private String sport;

    @SerializedName("strNationality")
    private String nationality;

    @SerializedName("dateBorn")
    private String dateborn;

    public String getName() { return name; }
    public String getTeam() { return team; }
    public String getSport() { return sport; }
    public String getNationality() { return nationality; }
    public String getDateborn() { return dateborn; }
}
