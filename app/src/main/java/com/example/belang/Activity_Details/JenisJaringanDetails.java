package com.example.belang.Activity_Details;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.belang.Home_Bab.jenis_jaringan;
import com.example.belang.R;
import com.example.belang.model.materi;

import java.util.ArrayList;
import java.util.List;

public class JenisJaringanDetails extends AppCompatActivity {

    private Toolbar toolbarJudul, statusBar;
    private ImageView imageView;
    private ImageButton backBTN;
    private TextView judulTV, deskripsiTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jenisjaringandetails);

        Window windows = getWindow();
        windows.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        Intent intent = getIntent();

        String title = intent.getExtras().getString("Judul");
        String desc = intent.getExtras().getString("Deskripsi");
        int img = intent.getExtras().getInt("Image");

       // SpannableString ss = new SpannableString(desc);

      //  StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);



       // StyleSpan boldSpan2 = new StyleSpan(Typeface.BOLD);

        //ss.setSpan(boldSpan, 317, 337, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
       // ss.setSpan(boldSpan2, 874, 901, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        statusBar = findViewById(R.id.statusbarDetails2);
        backBTN = findViewById(R.id.backDetails2);
        toolbarJudul = findViewById(R.id.toolbarDetails2);
        imageView = findViewById(R.id.foto2);
        imageView.setImageResource(img);
        judulTV = findViewById(R.id.judul2);
        judulTV.setText(title);
        deskripsiTV = findViewById(R.id.deskripsi2);
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
