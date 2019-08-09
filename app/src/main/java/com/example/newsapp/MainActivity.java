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
import com.example.newsapp.Presenter.MainPresenter;
import com.example.newsapp.View.MainView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MainView {
    //ngeimplement mainview diminta implement 4 method dari mainview dan baseview (mainview soalnya extends baseview)


    List<BeritaItem> dataBerita;
    MainPresenter mainPresenter;
    RecyclerView recyclerView;
    BeritaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        mainPresenter = new MainPresenter(this);
        mainPresenter.getAllBerita();
    }

    @Override
    public void getBerita(List<BeritaItem> berita) {
//        adapter = new BeritaAdapter(this, dataBerita);
//        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BeritaAdapter(this, berita);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void error(String msg) {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    //onattach buat attach presenter ke view
    @Override
    public void onAttachView() {
        mainPresenter.onAttach(this);
    }

    @Override
    public void onDetachView() {
        mainPresenter.onDetach(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        onAttachView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onDetachView();
    }
}
