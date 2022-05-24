package com.example.belang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class scoreActivity extends AppCompatActivity {

    private TextView scored, total, motivats;
    private Button btnDone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        motivats = findViewById(R.id.motivasiQuiz);
        scored = findViewById(R.id.Scored);
        total = findViewById(R.id.total);
        btnDone = findViewById(R.id.btnDone);

        scored.setText(String.valueOf(getIntent().getIntExtra("score", 0)));
        total.setText("OUT OF "+String.valueOf(getIntent().getIntExtra("total", 0)));
        motivats.setText(String.valueOf(getIntent().getStringExtra("motivas")));



        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
