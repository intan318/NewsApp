package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.newsapp.Adapter.BeritaAdapter;
import com.example.newsapp.Model.BeritaItem;
import com.example.newsapp.Model.ResponseNews;
import com.example.newsapp.Network.Injection;
import com.example.newsapp.Network.NewsService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<BeritaItem> dataBerita;
    RecyclerView recyclerView;
    BeritaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        getBerita();

//        adapter = new BeritaAdapter(this, dataBerita);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        recyclerView.setAdapter(adapter);

    }

    private void getBerita() {
        //manggil class injection trus manggil method getService di injection, method getService itu manggil NewsService, trs di newsservice manggil method getAllBerita (callback)
        Injection.getService().getAllBerita().enqueue(new Callback<ResponseNews>() {
            @Override
            public void onResponse(Call<ResponseNews> call, Response<ResponseNews> response) {
                if (response.isSuccessful()){
                    dataBerita = response.body().getBerita();
                    adapter = new BeritaAdapter(getApplicationContext(), dataBerita);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseNews> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Failed", Toast.LENGTH_SHORT);
            }
        });
    }
}
