package com.example.belang.Fragmen;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.belang.R;
import com.example.belang.Soal_Activity.SoalDasarJ;
import com.example.belang.Soal_Activity.SoalJenisJ;
import com.example.belang.Soal_Activity.SoalTopologiJ;

/**
 * A simple {@link Fragment} subclass.
 */
public class soalFragment extends Fragment {

    private ImageButton btnSoalDasarj, btnSoalJenisj, btnSoalTopologij;
    private LinearLayout SoalLayout;

    public soalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_soal, container, false);

        btnSoalDasarj = view.findViewById(R.id.btn_soal1);
        btnSoalJenisj = view.findViewById(R.id.btn_soal2);
        btnSoalTopologij = view.findViewById(R.id.btn_soal3);

        btnSoalDasarj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSoalDasarJ();
            }
        });

        btnSoalJenisj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSoalJenisJ();
            }
        });

        btnSoalTopologij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSoalTopologiJ();
            }
        });


        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void openSoalDasarJ(){
        Intent intent = new Intent(getActivity(), SoalDasarJ.class);
        startActivity(intent);
    }
    public void openSoalJenisJ(){
        Intent intent = new Intent(getActivity(), SoalJenisJ.class);
        startActivity(intent);

    }
    public void openSoalTopologiJ(){
        Intent intent = new Intent(getActivity(), SoalTopologiJ.class);
        startActivity(intent);

    }


}
