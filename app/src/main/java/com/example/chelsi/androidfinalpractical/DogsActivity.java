package com.example.chelsi.androidfinalpractical;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.util.SortedList;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Chelsi on 2/25/2018.
 */

public class DogsActivity extends AppCompatActivity {

    public static String BASE_URL = "https://dog.ceo/";
    private RecyclerView recyclerView;
    private DogAdapter dogAdapter;
    private ArrayList<DogModel> dogModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dogs);

        recyclerView = findViewById(R.id.dogRecycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(dogAdapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DogsService userService = retrofit.create(DogsService.class);
        Call<DogModel> responseCall = userService.getDogBreed();
        responseCall.enqueue(new Callback<DogModel>() {
            @Override
            public void onResponse(Call<DogModel> call, Response<DogModel> response) {
                Log.d("response", "onResponse: working"+ response.toString());
                dogModelArrayList = response.body().getStatus();
                dogAdapter = new DogAdapter(dogModelArrayList);
                recyclerView.setAdapter(dogAdapter);
            }

            @Override
            public void onFailure(Call<DogModel> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
