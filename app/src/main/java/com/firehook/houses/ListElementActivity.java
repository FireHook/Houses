package com.firehook.houses;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.firehook.houses.model.Building;
import com.firehook.houses.model.Info;
import com.firehook.houses.model.Recent;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by User on 28.09.2016.
 */

public class ListElementActivity extends Activity {

    TextView mTitle;
    TextView mAddress;
    ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_element_layout);

        mTitle = (TextView) findViewById(R.id.title_item);
        mAddress = (TextView) findViewById(R.id.address);
        mImage = (ImageView) findViewById(R.id.image_item);

        API apiService = ApiClient.getClient().create(API.class);
        Call<Info> buildings = apiService.getBuildings();
        buildings.enqueue(new Callback<Info>() {
            @Override
            public void onResponse(Call<Info> call, Response<Info> response) {

                Intent intent = getIntent();
                String title = intent.getStringExtra("title");

                Info body = response.body();
                Log.d(" title1", title);
                for (Building building : body.data.buildings) {
                    Log.d("title2", building.title);
                    if (building.title.equals(title)){

                        mTitle.setText(building.title);
                        mAddress.setText(building.address);
                        Picasso.with(getApplicationContext())
                                .load(ApiClient.BASE_URL + building.image)
                                .resize(200, 200)
                                .centerCrop()
                                .into(mImage);
                    }else {Log.d("ListElementActivity", "title != title");}
                }
            }

            @Override
            public void onFailure(Call<Info> call, Throwable t) {
                Log.d("RETROFIT", "onFailure");
            }
        });
    }
}
