package com.example.belang.Home_Bab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.belang.Adapter.JenisAdapter;
import com.example.belang.MainActivity;
import com.example.belang.R;
import com.example.belang.model.materi;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import java.util.ArrayList;


public class jenis_jaringan extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener,
        YouTubePlayer.PlaybackEventListener, YouTubePlayer.PlayerStateChangeListener {

    String API_KEY = "AIzaSyCS5HApqcNWUq3I_AaA6TxV1GqkSUQdLh4AIzaSyCS5HApqcNWUq3I_AaA6TxV1GqkSUQdLh4";
    String VIDEO_CODE = "aHJElrgj6UA";
    YouTubePlayerView PlayerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    ArrayList<materi> jenisArrayList = new ArrayList<>();
    JenisAdapter jenisAdapter;
    materi Materi;
    ImageButton back_button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jenis_jaringan);

        Window windows = getWindow();
        windows.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

         PlayerView = findViewById(R.id.youtubePlayerView);
         PlayerView.initialize(API_KEY, this);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        jenisAdapter = new JenisAdapter(this, jenisArrayList);
        recyclerView.setAdapter(jenisAdapter);

        back_button3 = (ImageButton) findViewById(R.id.back_button3);
        back_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToHome();
            }
        });

        materi Materi = new materi("Berdasarkan Jenis Transmisi", "Dalam mempelajari jenis jaringan komputer terdapat beberapa klasifikasi yang cukup penting yaitu teknologi transmisi dan jarak. Secara teori, jaringan komputer dibagi berdasarkan transmisi dan jarak. Terdapat dua jenis jaringan berdasarkan teknologi transmisi,  yaitu jaringan broadcast dan jaringan point-to-point.\n"
                +"\n• Jaringan Broadcast memiliki saluran komunikasi tunggal yang dipakai bersama-sama oleh semua device yang terkoneksi ke jaringan. Pesan-pesan berukuran kecil, disebut paket, yang dikirimkan oleh suatu mesin akan diterima oleh mesin-mesin lainnya. Field alamat pada sebuah paket berisi keterangan tentang kepada siapa paket tersebut ditujukan. Saat menerima paket, mesin akan mencek field alamat. Bila paket terserbut ditujukan untuk dirinya, maka mesin akan memproses paket itu, bila paket ditujukan untuk mesin lainnya, mesin terserbut akan mengabaikannya.\n"
                +"\n• Jaringan Point-to-Point terdiri dari beberapa koneksi pasangan individu, dari satu device ke satu device lain. Untuk mengirim paket dari sumber ke suatu tujuan, sebuah paket pada jaringan jenis ini mungkin harus melalui satu atau lebih mesin-mesin perantara. Seringkali harus melalui banyak route yang mungkin berbeda jaraknya. Karena itu algoritma route memegang peranan penting pada jaringan  point-to-point.\n" +
                "Pada umumnya jaringan yang lebih kecil dan terlokalisasi secara geografis cendurung memakai broadcasting, sedangkan jaringan yang lebih besar menggunakan point-to-point.\n "
                , R.drawable.berdasarkan_jenis_transmisi);
        jenisArrayList.add(Materi);
        materi Materi2 = new materi("Berdasarkan Geografis", "Alternatif lain dalam melakukan klasifikasi sebuah jaringan adalah berdasarkan pada cakupan geografis sebuah jaringan. LAN, MAN, WAN, dan internet bisa dikatakan sebagai true network, artinya komputer-komputer yang bekomunikasi dengan cara  bertukar data/pesan melalui kabel yang lebih panjang.\n"
                +"\n1. Local Area Network (LAN)\n"
                +"Local Area Network (LAN) dapat didefinisikan sebagai kumpulan komputer yang saling dihubungkan bersama didalam satu area tertentu yang tidak begitu luas, seperti didalam satu kantor atau gedung. LAN dapat juga didefinisikan berdasarkan pada penggunaan alamat IP komputer  pada jaringan. Suatu komputer atau host dapat dikatakan satu LAN bila memiliki alamat IP yang masih dalam satu alamat " +
                "jaringan, sehingga tidak memerlukan router untuk berkomunikasi. aringan LAN dapat juga dibagi menjadi dua tipe, yaitu jaringan peer to peer dan jaringan client-server. Pada jaringan peer to peer, setiap komputer yang terhubung dapat bertindak baik sebagai workstation maupun server, sedangkan pada jaringan client-server, hanya satu komputer yang bertindak sebagai server dan komputer lain sebagai workstation.\n"
                +"\n2. Metropolitan Area Network (MAN)\n"
                +"Metropolitan Area Network (MAN) pada dasarnya merupakan versi LAN yang berukuran lebih besar dan biasanya memakai teknologi yang sama dengan LAN.  MAN dapat mencakup kantor-kantor perusahaan yang berdekatan dan dapat dimanfaatkan untuk keperluan pribadi (swasta) atau umum. Alasan utama memisahkan MAN sebagai kategori khusus adalah telah ditentukannya standart untuk MAN, dan standart ini sekarang sedang diimplementasikan. Standart tersebut disebut DQDB (Distributed Queue Dual Bus) atau 802.6 menurut standart IEEE, DQDB terdiri dari dua buah kabel unidirectional dimana semua komputer dihubungkan. Setiap bus mempunyai sebuah head-end, perangkat untuk memulai aktivitas transmisi.\n"
                +"\n3. Wide Area Network (WAN)\n"
                +"Wide Area Network  (WAN) merupakan jaringan komputer yang mencakup daerah geografis yang luas, sering kali mencakup sebuah negara atau benua.\n"
                +"\n4. Internet\n"
                +"Internet (kependekan dari interconnection-networking) adalah seluruh jaringan komputer yang saling terhubung menggunakan standar sistem global Transmission Control Protocol/Internet Protocol Suite (TCP/IP) sebagai protokol pertukaran paket (packet switching communication protocol) untuk melayani miliaran pengguna di seluruh dunia, bahkan antar planet.\n"
                +"\n"
                +"\n"
                +"\n", R.drawable.berdasarkan_geografis);
        jenisArrayList.add(Materi2);
        materi Materi3 = new materi("Jaringan Tanpa Kabel", "Disebut juga jaringan nirkabel, hampir sama seperti halnya jaringan kabel, hanya saja koneksi antar host tidak lagi menggunakan media kabel. Biasanya jaringan tanpa kabel menghubungkan satu sistem komputer dengan sistem yang lain dengan menggunakan beberapa macam media transmisi tanpa kabel, seperti gelombang radio, gelombang mikro, maupun cahaya infra merah.\n"
                +"\n1. Inframerah "
                +"biasa digunakan untuk komunikasi jarak dekat, dengan kecepatan 4 Mbps. Dalam penggunaannya untuk pengendalian jarak jauh, misalnya remote control pada televisi serta alat elektronik lainnya\n"
                +"\n2. Transmisi data menggunakan gelombang radio biasa kita kenal dengan WiFi atau WLAN", R.drawable.berdasarkan_tanpa_kabe_);
        jenisArrayList.add(Materi3);




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
