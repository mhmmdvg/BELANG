package com.example.belang.Home_Bab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Spannable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ScrollView;

import com.example.belang.Adapter.TopologiAdapter;
import com.example.belang.MainActivity;
import com.example.belang.R;
import com.example.belang.model.materi;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;

public class topologi_jaringan extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener,
        YouTubePlayer.PlaybackEventListener, YouTubePlayer.PlayerStateChangeListener {


    String API_KEY = "AIzaSyCS5HApqcNWUq3I_AaA6TxV1GqkSUQdLh4AIzaSyCS5HApqcNWUq3I_AaA6TxV1GqkSUQdLh4";
    String VIDEO_CODE = "aHJElrgj6UA";
    YouTubePlayerView PlayerView;
    ScrollView scrollView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    ArrayList<materi> topologiArrayList = new ArrayList<>();
    TopologiAdapter topologiAdapter;
    materi Materi;
    ImageButton back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topologi_jaringan);

        Window windows = getWindow();
        windows.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        PlayerView = findViewById(R.id.youtubePlayerViewTopologi);
        PlayerView.initialize(API_KEY, this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        scrollView = findViewById(R.id.scrollTopologi);
        scrollView.setSmoothScrollingEnabled(true);

        topologiAdapter = new TopologiAdapter(this, topologiArrayList);
        recyclerView.setAdapter(topologiAdapter);

        back_button = (ImageButton) findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToHome();
            }
        });



        materi Materi1 = new materi("Apa itu Topologi", "Topologi adalah suatu cara menghubungkan komputer yang satu dengan komputer lainnya sehingga membentuk jaringan. Ada beberapa macam topologi yang umum digunakan saat ini, yaitu topologi bus, token-ring, star, tree, dan mesh.", R.drawable.apatu);
        topologiArrayList.add(Materi1);
        materi Materi = new materi("Topologi Bus", "Pada topologi bus digunakan sebuah kabel tunggal atau kabel pusat dimana seluruh workstation dan server dihubungkan. Keunggulan topologi bus adalah pengembangan  jaringan atau penambahan workstation baru dapat dilakukan dengan mudah tanpa mengganggu workstation lain. Kelemahan dari topologi ini adalah bila terdapat gangguan di sepanjang kabel pusat maka keseluruhan jaringan akan mengalami gangguan."
                ,R.drawable.bustop);
        topologiArrayList.add(Materi);
        materi Materi2 = new materi("Topologi Ring", "Pada topologi ring, semua workstation dan server dihubungkan sehingga terbentuk suatu pola lingkaran atau cincin. Tiap workstation ataupun server akan menerima dan melewatkan informasi dari satu komputer ke komputer lain, bila alamat-alamat yang dimaksud sesuai maka informasi diterima dan bila tidak informasi akan dilewatkan. Kelemahan dari topologi ini adalah setiap node dalam jaringan akan selalu ikut serta mengelola informasi yang dilewatkan dalam jaringan, sehingga bila terdapat gangguan di suatu node maka seluruh jaringan akan terganggu. Keunggulan topologi ring adalah tidak terjadinya collision atau tabrakan pengiriman data seperti pada topologi bus, karena hanya satu node dapat mengirimkan data pada suatu saat."
                , R.drawable.ring);
        topologiArrayList.add(Materi2);
        materi Materi3 = new materi("Topologi Star", "Pada topologi star, masing-masing workstation dihubungkan secara langsung ke server atau hub. Keunggulan dari topologi star adalah dengan adanya kabel tersendiri untuk setiap workstation ke server, maka bandwidth atau lebar jalur komunikasi dalam kabel akan semakin lebar sehingga akan meningkatkan unjuk kerja jaringan secara keseluruhan. Bila terdapat gangguan di suatu jalur kabel maka gangguan hanya akan terjadi dalam komunikasi antara workstation yang bersangkutan dengan server, jaringan secara keseluruhan tidak mengalami gangguan. Kelemahan dari topologi star adalah kebutuhan kabel yang lebih besar dibandingkan dengan topologi lainnya."
                , R.drawable.star);
        topologiArrayList.add(Materi3);
        materi Materi4 = new materi("Topologi Tree", "Topologi tree dapat berupa gabungan dari topologi star dengan topologi bus."
                , R.drawable.tree);
        topologiArrayList.add(Materi4);
        materi Materi5 = new materi("Topologi Mesh", "Topologi mesh digunakan pada kondisi di mana tidak ada hubungan komunikasi terputus secara absolut antar node komputer. Topologi ini merefleksikan desain internet yang memiliki multi path ke berbagai lokasi."
                ,R.drawable.mesh);
        topologiArrayList.add(Materi5);




    }

    public void backToHome(){
        finish();
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {


        youTubePlayer.setPlayerStateChangeListener(this);
        youTubePlayer.setPlaybackEventListener(this);

        if(!b){
            youTubePlayer.cueVideo(VIDEO_CODE);
        }

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }

    @Override
    public void onPlaying() {

    }

    @Override
    public void onPaused() {

    }

    @Override
    public void onStopped() {

    }

    @Override
    public void onBuffering(boolean b) {

    }

    @Override
    public void onSeekTo(int i) {

    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onLoaded(String s) {

    }

    @Override
    public void onAdStarted() {

    }

    @Override
    public void onVideoStarted() {

    }

    @Override
    public void onVideoEnded() {

    }

    @Override
    public void onError(YouTubePlayer.ErrorReason errorReason) {

    }
}
