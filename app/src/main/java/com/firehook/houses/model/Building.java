package com.firehook.houses.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Building {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("image")
    @Expose
    public String image;
    @SerializedName("address")
    @Expose
    public String address;
    @SerializedName("rent")
    @Expose
    public String rent;
    @SerializedName("sale")
    @Expose
    public String sale;

}