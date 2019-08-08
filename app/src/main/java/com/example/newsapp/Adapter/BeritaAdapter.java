package com.example.newsapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsapp.DetailActivity;
import com.example.newsapp.Model.BeritaItem;
import com.example.newsapp.Model.ResponseNews;
import com.example.newsapp.R;

import org.w3c.dom.Text;

import java.util.List;

public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.ViewHolder> {
    Context context;
    List<BeritaItem> beritaItems;
    String urlImg;

    public BeritaAdapter(Context context, List<BeritaItem> beritaItems){
        this.context = context;
        this.beritaItems = beritaItems;
    }


    @NonNull
    @Override
    public BeritaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BeritaAdapter.ViewHolder viewHolder, final int i) {
        urlImg = "http://192.168.60.31:81/database_portal_berita-master/images/";

        viewHolder.judul.setText(beritaItems.get(i).getJudulBerita());
        viewHolder.tanggal.setText(beritaItems.get(i).getTanggalPosting());
        viewHolder.penulis.setText(beritaItems.get(i).getPenulis());

        Glide.with(context)
                .load(urlImg+beritaItems.get(i).getFoto())
                .into(viewHolder.image);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BeritaItem data = beritaItems.get(i);

                Intent i = new Intent (context, DetailActivity.class);
                i.putExtra("judul", data.getJudulBerita());
                i.putExtra("tanggal", data.getTanggalPosting());
                i.putExtra("penulis", data.getPenulis());
                i.putExtra("image", urlImg + data.getFoto());

                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return beritaItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView judul;
        TextView tanggal;
        TextView penulis;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.txtJudulBerita);
            tanggal = itemView.findViewById(R.id.txtTglBerita);
            penulis = itemView.findViewById(R.id.txtEditorBerita);
            image = itemView.findViewById(R.id.imgBerita);
        }
    }
}
