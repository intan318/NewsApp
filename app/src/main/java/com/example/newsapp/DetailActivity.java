package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    TextView detailJudul;
    TextView detailTgl;
    TextView detailPenulis;
    ImageView detailImg;
    WebView webView;

    private View webviewBerita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initData();
        tampilBerita();

        Intent i = getIntent();
        String detJudul = i.getStringExtra("judul");
        String detPenulis = i.getStringExtra("penulis");
        String detTgl = i.getStringExtra("tanggal");
        String detImg = i.getStringExtra("image");
//        Integer detImg = i.getIntExtra("image", 0);

        detailJudul.setText(detJudul);
        detailPenulis.setText(detPenulis);
        detailTgl.setText(detTgl);
        Glide.with(this)
                .load(detImg)
                .into(detailImg);
    }

    private void tampilBerita() {


    }

    private void initData() {
        detailJudul = findViewById(R.id.txtJudulBerita);
        detailPenulis = findViewById(R.id.txtEditorBerita);
        detailTgl = findViewById(R.id.txtTglBerita);
        detailImg = findViewById(R.id.imgBerita);
//        webView = findViewById(R.id.web)
    }

}
