package com.example.belang.Activity_Details;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.belang.Home_Bab.home;
import com.example.belang.Home_Bab.topologi_jaringan;
import com.example.belang.R;
import com.example.belang.model.materi;

import java.util.ArrayList;

public class DasarJaringanDetails extends AppCompatActivity {

    private Toolbar toolbarJudul;
    private ImageView imageView;
    private ImageButton backBTN;
    private TextView judulTV, deskripsiTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasarjaringandetails);

        Intent intent = getIntent();

        String title = intent.getExtras().getString("Judul");
        String desc = intent.getExtras().getString("Deskripsi");
        int img = intent.getExtras().getInt("Image");

        backBTN = findViewById(R.id.backDetails1);
        toolbarJudul = findViewById(R.id.toolbarDetails);
        imageView = findViewById(R.id.foto);
        imageView.setImageResource(img);
        judulTV = findViewById(R.id.judul);
        judulTV.setText(title);
        deskripsiTV = findViewById(R.id.deskripsi);
        deskripsiTV.setText(desc);





        backBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToList();
            }
        });
    }

    public void backToList(){
        finish();
    }
}
