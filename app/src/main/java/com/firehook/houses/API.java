package com.firehook.houses;

import android.os.Bundle;

import com.firehook.houses.model.Info;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by User on 29.09.2016.
 */

public interface API {
    @GET("v1/building/list")
    Call<Info> getBuildings();
}

