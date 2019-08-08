package com.example.newsapp.Presenter;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.newsapp.Adapter.BeritaAdapter;
import com.example.newsapp.Base.BasePresenter;
import com.example.newsapp.Model.ResponseNews;
import com.example.newsapp.Network.Injection;
import com.example.newsapp.View.MainView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements BasePresenter<MainView> {

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }

    MainView mainView;

    @Override
    public void onAttach(MainView View) {
    //method ini utk naro view di MainActivity
    mainView = View;

//    getAllBerita();

    }

    @Override
    public void onDetach(MainView View) {
    //method ini utk ngedetach semua view yg udh ditaro supaya nanti ga memory leak
    mainView = null;
    }

    public void getAllBerita() {
        //manggil class injection trus manggil method getService di injection, method getService itu manggil NewsService, trs di newsservice manggil method getAllBerita (callback)
        Injection.getService().getAllBerita().enqueue(new Callback<ResponseNews>() {

            @Override
            public void onResponse(Call<ResponseNews> call, Response<ResponseNews> response) {
                if(response.isSuccessful()){
                    mainView.getBerita(response.body().getBerita());
                } else {
                    mainView.error("Gagal Menampilkan Berita");
                }
            }

            @Override
            public void onFailure(Call<ResponseNews> call, Throwable t) {
                mainView.error("onFailure : "+ t.getLocalizedMessage());
            }
        });
    }
}
