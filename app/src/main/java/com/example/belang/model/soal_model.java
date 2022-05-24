package com.example.belang.model;

public class soal_model {

    private String judul;
    private int foto;

    public soal_model(String judul, int foto) {
        this.judul = judul;
        this.foto = foto;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
