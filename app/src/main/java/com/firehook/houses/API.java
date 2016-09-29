package com.firehook.houses;

import retrofit2.Response;
import retrofit2.http.GET;

/**
 * Created by User on 29.09.2016.
 */

public interface API {
    @GET("/data/buildings")
    Response getItems();
}
