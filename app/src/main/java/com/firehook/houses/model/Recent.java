package com.firehook.houses.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Recent {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("unit_number")
    @Expose
    public String unitNumber;
    @SerializedName("building_title")
    @Expose
    public String buildingTitle;
    @SerializedName("building_id")
    @Expose
    public Integer buildingId;
    @SerializedName("date")
    @Expose
    public String date;
    @SerializedName("date_year")
    @Expose
    public String dateYear;
    @SerializedName("bedroom")
    @Expose
    public Integer bedroom;
    @SerializedName("bath_full")
    @Expose
    public Integer bathFull;
    @SerializedName("living_area")
    @Expose
    public String livingArea;
    @SerializedName("price")
    @Expose
    public String price;
    @SerializedName("percent")
    @Expose
    public String percent;
    @SerializedName("status")
    @Expose
    public Integer status;

}
