package com.firehook.houses;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

/**
 * Created by User on 28.09.2016.
 */

public class RecycledListActivity extends Activity {

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

        MyAdapter myAdapter = new MyAdapter();
        recyclerView.setAdapter(myAdapter);

        API service = ApiClient.getClient().create(API.class);
        Call<List<Item>> call = service.getItems();

        try {
            List<Item> items = call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
