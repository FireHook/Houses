package com.firehook.houses;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by User on 29.09.2016.
 */

public interface API {
    @GET("buildings/list")
    Call<List<Item>> getItems();
}
