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

import com.example.belang.Adapter.MateriAdapter;
import com.example.belang.MainActivity;
import com.example.belang.R;
import com.example.belang.model.materi;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;

public class home extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener,
        YouTubePlayer.PlaybackEventListener, YouTubePlayer.PlayerStateChangeListener{

    String API_KEY = "AIzaSyCS5HApqcNWUq3I_AaA6TxV1GqkSUQdLh4AIzaSyCS5HApqcNWUq3I_AaA6TxV1GqkSUQdLh4";
    String VIDEO_CODE = "6aUDhk4Apys";
    YouTubePlayerView PlayerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    ArrayList<materi> materiArrayList = new ArrayList<>();
    MateriAdapter materiAdapter;
    materi Materi;
    ImageButton back_button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);


        Window windows = getWindow();
        windows.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        PlayerView = findViewById(R.id.youtubePlayerViewDasar);
        PlayerView.initialize(API_KEY, this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        materiAdapter = new MateriAdapter(this, materiArrayList);
        recyclerView.setAdapter(materiAdapter);


        back_button2 = (ImageButton) findViewById(R.id.back_button2);
        back_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToHome();
            }
        });


            materi Materi = new materi("Pengertian Jaringan",
                    "Menurut Wikipedia, Jaringan komputer (jaringan) adalah jaringan telekomunikasi yang memungkinkan antar komputer untuk saling berkomunikasi dengan bertukar data. \n" +
                            "Secara umum, Jaringan  komputer  adalah  koneksi  antara  dua  device atau  lebih, yang terhubung secara fisik maupun secara logika sehingga bisa saling bertukar informasi. Jaringan komputer dapat dikatakan  terkoneksi  apabila  device yang ada dalam jaringan tersebut  bisa  saling  bertukar  data/informasi dan berbagi resource yang dimiliki.\n",
                    R.drawable.pengertian_jaringan);
            materiArrayList.add(Materi);
            materi Materi2 = new materi("Tujuan Jaringan", "Tujuan dibangunnya suatu jaringan komputer adalah membawa informasi secara tepat dan tanpa adanya kesalahan dari sisi pengirim (transmitter) menuju kesisi penerima (receiver) melalui media komunikasi."
                    , R.drawable.tujuan_jaringan);
            materiArrayList.add(Materi2);
            materi Materi3 = new materi("Manfaat Jaringan", "Manfaat yang didapat dalam membangun jaringan komputer, yaitu :\n "
                    +"1.\tMedia berbagi sumber daya (Sharing resources) "
                    +"    Dengan adanya jaringan komputer, berbagi resource bisa dilakukan tanpa terkendala jarak. Resource sharing meliputi :\n"
                    +"a.\tData Sharing, dengan adanya jaringan komputer kita bisa dengan mudah berbagi data seperti dokumen, gambar, video, dll dengan kolega yang ada di lokasi yang jauh bahkan di negara yang berbeda.\n"
                    +"b.\tHardware Sharing, jika dulunya satu komputer satu printer, dengan jaringan komputer, satu printer bisa digunakan oleh beberapa komputer sekaligus. Tidak hanya printer, kita bisa sharing storage dan banyak hardware lainnya.\n"
                    +"c.\tInternet Access Sharing, jaringan komputer kecil memungkinkan beberapa komputer berbagi satu koneksi internet. Device khusus seperti router, memiliki kemampuan mengalokasikan bandiwdth  dengan mudah untuk komputer user yang membutuhkan.\n\n"
                    +"2.\tMedia komunikasi dan konektivitas (Communication and Connectivity)\n"
                    +"Jaringan komputer memungkinkan terjadinya komunikasi antar pengguna, baik untuk teleconference maupun untuk mengirim pesan atau informasi yang penting lainnya. Dengan demikian, orang orang yang jaraknya berjauhan akan lebih mudah untuk bekerja sama. Misalnya dengan menggunakan teknologi email.\n\n"
                    +"3.\tMedia Integrasi Data \n"
                    +"Pembangunan jaringan komputer dapat mencegah ketergantungan pada komputer pusat setiap proses data tidak harus dilakukan pada satu komputer saja, melainkan dapat didistribusikan ketempat lainnya. \n" +
                    "Dengan adanya jaringan komputer, maka pengembangan peralatan dapat dilakukan dengan mudah, karena adanya kemampuan berbagi peralatan melalui jaringan. \n\n"
                    +"4.\tMedia Keamanan Data \n"
                    +"Sistem jaringan komputer memberikan perlindungan terhadap data . jaminan keamanan terserbut diberikan melalui pengaturan hak akses para pemakai dan password, serta perlindungan terhadap harddisk sehingga data mendapatkan perlindungan efektif, sumber daya lebih efisien, dan informasi terkini. \n" +
                    "Dalam Dunia bisnis, jaringan memberikan kemudahan bagi administrator untuk melakukan managemen data penting perusahaan dengan lebih baik. Daripada data penting ini ada di setiap perangkat komputer karyawan yang bisa pengelolaan data dilakukan secara serampangan, akan lebih aman dan lebih mudah ketika data tersebut disimpan secara terpusat dengan menggunakan Shared Server. Dengan cara seperti ini, karyawan perusahaan lebih mudah dalam mencari data. Administrator juga dapat memastikan bahwa data dibackup secara reguler, dan memungkinkan untuk menerapkan security dengan cara menentukan siapa yang boleh membaca atau menulis data yang bersifat penting.\n\n"
                    +"5.\tPengembangan dan Pemeliharaan \n"
                    +"Pengembangan peralatan dapat dilakukan dengan mudah dan menghemat biaya, karena setiap pembelian komponen seperti printer, maka tidak perlu membeli printer sejumlah komputer yang ada tetapi cukup satu buah karena printer itu dapat digunakan secara bersama – sama. \n" +
                    "Jaringan komputer juga memudahkan pemakai dalam merawat harddisk dan peralatan lainnya, misalnya untuk memberikan perlindungan terhadap serangan virus maka pemakai cukup memusatkan perhatian pada harddisk yang ada pada komputer pusat.\n\n"
                    +"6.\tSumber Daya Lebih Efisien dan Informasi Terkini\n "
                    +"Dengan pemakaian sumber daya secara bersama – sama, akan mendapatkan hasil yang maksimal dan kualitas yang tinggi. Selain itu data atau informasi yang diakses selalu terbaru, karena setiap ada perubahan yang terjadi dapat segera langsung diketahui oleh setiap pemakai.\n\n"
                    +"7.\tHiburan (Entertainment)\n"
                    +"Jaringan komputer terutama internet, biasanya menyediakan banyak jenis hiburan dan permainan. Seperti multi-player game yang bisa dimainkan oleh beberapa user dalam waktu yang bersamaan, atau sekedar menonton video.\n\n"
                    +"\n"
                    +"\n"
                    +"\n"
                    ,R.drawable.manfaat_jaringan);

            materiArrayList.add(Materi3);
            materi Materi4 = new materi("Kekurangan", "1.\tBiaya Network Hardware, Software dan Setup\n"
                    +"Jaringan komputer tidak terbentuk begitu saja, membuat jaringan komputer tentu membutuhkan investasi hardware dan software, perencanaan, design jaringan, dan implementasi jaringan.\n"
                    +"2.\tBiaya Managemen Hardware/Software dan Administrasi\n"
                    +"Jaringan komputer membutuhkan perawatan dan pemeliharaan secara berkala oleh IT profesional.\n"
                    +"3.\tSharing yang Tidak Diinginkan\n"
                    +"Disamping kemudahan dalam melakukan sharing informasi, ada resiko dimana file yang disharing terinfeksi virus komputer, sehingga bisa dengan mudah tersebar.\n"
                    +"4.\tPerilaku yang Ilegal atau Tidak Diinginkan\n"
                    +"Hampir sama dengan point sebelumnya, jaringan komputer memudahkan untuk berkomunikasi, akan tetapi membawa resiko lain, seperti mengambil atau memproduksi konten ilegal, pembajakan, dll.\n"
                    +"5.\tData Security Concerns\n"
                    +"Pada jaringan komputer yang diimplementasikan dengan baik, keamanan data bisa tetap terjaga. Sebaliknya, jika implementasi yang terkesan asal - asalan, maka data yang ada dalam jaringan tersebut juga dalam bahaya. Serangan hacker mungkin saja terjadi, sabotae, atau yang cukup riskan adalah upaya untuk mencuri dokumen penting perusahaan.\n"
                    +"\n"
                    +"\n"
                    +"\n"
                    , R.drawable.kekurangan_jaringan);
            materiArrayList.add(Materi4);



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
