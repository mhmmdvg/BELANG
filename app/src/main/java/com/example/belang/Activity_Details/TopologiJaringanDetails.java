package com.example.belang.Activity_Details;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.belang.Home_Bab.topologi_jaringan;
import com.example.belang.R;

public class TopologiJaringanDetails extends AppCompatActivity {

    private Toolbar toolbarJudul, statusBar;
    private ImageView imageView;
    private ImageButton backBTN;
    private TextView judulTV, deskripsiTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topologijaringandetails);

        Window windows = getWindow();
        windows.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        Intent intent = getIntent();

        String title = intent.getExtras().getString("Judul");
        String desc = intent.getExtras().getString("Deskripsi");
        int img = intent.getExtras().getInt("Image");

        statusBar = findViewById(R.id.statusbarDetails3);
        backBTN = findViewById(R.id.backDetails3);
        toolbarJudul = findViewById(R.id.toolbarDetails3);
        imageView = findViewById(R.id.foto3);
        imageView.setImageResource(img);
        judulTV = findViewById(R.id.judul3);
        judulTV.setText(title);
        deskripsiTV = findViewById(R.id.deskripsi3);
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
