package com.example.belang.Fragmen;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.belang.Home_Bab.home;
import com.example.belang.Home_Bab.jenis_jaringan;
import com.example.belang.Home_Bab.topologi_jaringan;
import com.example.belang.Home_Bab.videoActivity;
import com.example.belang.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class homeFragment extends Fragment {

    ImageButton button1,button2,button3, button4;
    Context context;

    public homeFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);




        button1 = view.findViewById(R.id.button1);
        button2 = (ImageButton) view.findViewById(R.id.button2);
        button3 = (ImageButton) view.findViewById(R.id.button3);
        button4 = (ImageButton) view.findViewById(R.id.button4);





        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openDasar();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openJenis();
            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTopologi();
            }
        });


        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVideo();
            }
        });

    return view;
    }



    public void openDasar(){
    Intent intent = new Intent (getActivity(), home.class);
    startActivity(intent);
    }
    public void openJenis(){
        Intent intent = new Intent (getActivity(), jenis_jaringan.class);
        startActivity(intent);
    }
    public void openTopologi(){
        Intent intent = new Intent (getActivity(), topologi_jaringan.class);
        startActivity(intent);
    }
    public void openVideo(){
        Intent intent = new Intent (getActivity(), videoActivity.class);
        startActivity(intent);
    }
}
