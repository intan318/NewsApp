package com.example.newsapp.Base;

//M itu sbg object namanya boleh apa aka
public interface BasePresenter <M extends BaseView>{
    void onAttach(M View); //kyk onCreate/onStart
    void onDetach(M View); //kyk onDestroy
}
