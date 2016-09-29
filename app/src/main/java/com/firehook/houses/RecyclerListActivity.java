package com.firehook.houses;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.firehook.houses.model.Building;
import com.firehook.houses.model.Info;
import com.firehook.houses.model.Recent;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by User on 28.09.2016.
 */

public class RecyclerListActivity extends Activity {

    public static final String TAG = "RETROFIT";

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycled_list_layout);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MyAdapter();
        recyclerView.setAdapter(adapter);


        API apiService = ApiClient.getClient().create(API.class);
        Call<Info> buildings = apiService.getBuildings();
        buildings.enqueue(new Callback<Info>() {
            @Override
            public void onResponse(Call<Info> call, Response<Info> response) {
                Log.d("RETROFIT", "onResponse");
                Info body = response.body();
                Log.d("RETROFIT", "STATUS - " + body.status);
                Log.d("RETROFIT", "=== BUILDS ===");
                for (Building building : body.data.buildings) {
                    Log.d("RETROFIT", building.title);
                }
                Log.d("RETROFIT", "=== BUILDS ENDS ===");
                Log.d("RETROFIT", "=== RECENT ===");
                for (Recent recent : body.data.recent) {
                    Log.d("RETROFIT", recent.buildingTitle + " " + recent.price);
                }
                Log.d("RETROFIT", "=== RECENT END ===");

            }

            @Override
            public void onFailure(Call<Info> call, Throwable t) {
                Log.d("RETROFIT", "onFailure");
            }
        });

    }



}
