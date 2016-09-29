package com.firehook.houses.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Data {

    @SerializedName("buildings")
    @Expose
    public List<Building> buildings = new ArrayList<Building>();
    @SerializedName("recent")
    @Expose
    public List<Recent> recent = new ArrayList<Recent>();

}