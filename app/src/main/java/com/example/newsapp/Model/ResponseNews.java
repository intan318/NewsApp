package com.example.newsapp.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class ResponseNews{

	@SerializedName("berita")
	private List<BeritaItem> berita;

	@SerializedName("status")
	private boolean status;

	public void setBerita(List<BeritaItem> berita){
		this.berita = berita;
	}

	public List<BeritaItem> getBerita(){
		return berita;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResponseNews{" + 
			"berita = '" + berita + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}