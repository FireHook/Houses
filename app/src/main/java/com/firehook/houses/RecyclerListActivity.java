package com.firehook.houses;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.firehook.houses.model.Building;
import com.firehook.houses.model.Info;
import com.firehook.houses.model.Recent;
import com.firehook.houses.model.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

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
    List<Building> mDataset;

    TextView user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycled_list_layout);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mDataset = new ArrayList<>();

        user = (TextView) findViewById(R.id.user);
        Intent intent = getIntent();
        user.setText(intent.getStringExtra("name") + " " + intent.getStringExtra("email"));

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

                mDataset = body.data.buildings;
                adapter = new MyAdapter(mDataset);
                recyclerView.setAdapter(adapter);

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


        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), recyclerView , new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        TextView title = (TextView) view.findViewById(R.id.recyclerText);
                        Log.d("CLICK LISTENER", "====CLICKED=====");
                        Intent intent = new Intent(RecyclerListActivity.this, ListElementActivity.class);
                        intent.putExtra("title", title.getText().toString());
                        startActivity(intent);
                    }

                    @Override public void onLongItemClick(View view, int position) {

                    }
                })
        );

    }
}
