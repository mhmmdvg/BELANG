package com.example.belang.Fragmen;


import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.belang.R;
import com.example.belang.model.AboutModel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class aboutFragment extends Fragment {

    TextView deskripsiAbout, textKD, textKI3, textKI4, space;
    ArrayList<AboutModel> aboutModel;


    public aboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        textKD = view.findViewById(R.id.textKD);
        textKI3 = view.findViewById(R.id.textKi3);
        textKI4 = view.findViewById(R.id.textKi4);
        deskripsiAbout = view.findViewById(R.id.textAbout);
        space = view.findViewById(R.id.space);



        String deskripsi = "BELANG merupakan singkatan dari Belajar Jaringan. Aplikasi ini di buat untuk memberikan informasi " +
                "berupa materi, soal, dan gamabar tentang Jaringan Komputer. BELANG berisikan tentang Pengertian Jaringan Komputer, Tujuan Jaringan Komputer, Manfaat Jaringan Komputer, Kekurangan Jaringan Komputer, Jenis Jaringan Komputer Topologi Jaringan, dan Perangkat Jaringan. Sesuai dengan KI/KD pada SMK untuk dapat mengetahui dan mengerti tentang Jaringan Komputer maka aplikasi ini cocok untuk mempelajari materi tersebut.";

        String kd = "\nKompetensi Dasar : \n"+"Menerapkan instalasi jaringan komputer";

        String ki3 = "\nKompetensi inti 3 (Pengetahuan):\n"+"Memahami, menerapkan, menganalisis, dan mengevaluasi tentang pengetahuan faktual, konseptual, operasional dasar, dan metakognitif sesuai dengan bidang dan lingkup kerja Dasar-dasar Teknik Komputer dan Informatika pada tingkat teknis, spesifik, detil, dan kompleks, berkenaan dengan ilmu pengetahuan, teknologi, seni, budaya, dan humaniora dalam konteks pengembangan potensi diri sebagai bagian dari keluarga, sekolah, dunia kerja, warga masyarakat nasional, regional, dan internasional";

        String ki4 = "\nKompetensi inti 4 (Keterampilan):\n"+"Menunjukkan keterampilan menalar, mengolah, dan menyaji secara efektif, kreatif, produktif, kritis, mandiri, kolaboratif, komunikatif, dan solutif dalam ranah abstrak terkait dengan pengembangan dari yang dipelajarinya di sekolah, serta mampu melaksanakan tugas spesifik dibawah pengawasan langsung.\n";

        SpannableString ss = new SpannableString(deskripsi);
        SpannableString ss2 = new SpannableString(kd);
        SpannableString ss3 = new SpannableString(ki3);
        SpannableString ss4 = new SpannableString(ki4);
        StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);



        // StyleSpan boldSpan2 = new StyleSpan(Typeface.BOLD);

        ss.setSpan(boldSpan, 0, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss2.setSpan(boldSpan,0, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss3.setSpan(boldSpan, 0, 33, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );
        ss4.setSpan(boldSpan, 0, 34, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );

        // ss.setSpan(boldSpan2, 874, 901, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        deskripsiAbout.setText(ss);
        textKD.setText(ss2);
        textKI3.setText(ss3);
        textKI4.setText(ss4);



        return view;
    }

}
