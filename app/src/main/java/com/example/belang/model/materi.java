package com.example.belang.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class materi{

    String judul, deskripsi;
    int foto;

    public materi(String judul, String deskripsi, int foto) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.foto = foto;
    }


    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

}
