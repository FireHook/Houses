package com.firehook.houses;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by User on 29.09.2016.
 */

public class ApiClient {
    public static final String BASE_URL = "http://sunnyislere.aws4apps.com/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if (retrofit == null){

            Gson gson = new GsonBuilder().create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }

        return retrofit;
    }
}
