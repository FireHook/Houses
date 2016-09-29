package com.firehook.houses;

import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 29.09.2016.
 */

public class Item {
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("image")
    private String image;
    @SerializedName("address")
    private String address;
    @SerializedName("rent")
    private int rent;
    @SerializedName("sale")
    private int sale;

    public Item(int id, String title, String image, String address, int rent, int sale) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.address = address;
        this.rent = rent;
        this.sale = sale;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getAddress() {
        return address;
    }

    public int getRent() {
        return rent;
    }

    public int getSale() {
        return sale;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }
}
