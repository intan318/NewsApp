package com.example.newsapp.View;

import com.example.newsapp.Base.BaseView;
import com.example.newsapp.Model.BeritaItem;

import java.util.List;

public interface MainView extends BaseView {
    void getBerita(List<BeritaItem> berita); //manggil method getBerita yg parameternya dari List<BeritaItem>
    void error(String msg);


}
