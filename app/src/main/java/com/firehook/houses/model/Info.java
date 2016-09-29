package com.firehook.houses.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info {

    @SerializedName("data")
    @Expose
    public Data data;
    @SerializedName("status")
    @Expose
    public String status;

}
