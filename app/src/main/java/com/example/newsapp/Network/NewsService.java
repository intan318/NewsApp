package com.example.newsapp.Network;

import com.example.newsapp.Model.ResponseNews;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsService {
    @GET("tampil_berita.php")
    Call<ResponseNews> getAllBerita();
}
