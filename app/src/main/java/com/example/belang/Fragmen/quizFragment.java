package com.example.belang.Fragmen;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.belang.Quiz.quiz1Activity;
import com.example.belang.Quiz.quiz2Activity;
import com.example.belang.Quiz.quiz3Activity;
import com.example.belang.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class quizFragment extends Fragment {


    private ImageButton btnQuiz1, btnQuiz2, btnQuiz3;
    private LinearLayout QuizLayout;


    public quizFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);

        btnQuiz1 = view.findViewById(R.id.btn_quiz1);
        btnQuiz2 = view.findViewById(R.id.btn_quiz2);
        btnQuiz3 = view.findViewById(R.id.btn_quiz3);

        btnQuiz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Quiz1();
            }
        });

        btnQuiz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Quiz2();
            }
        });

        btnQuiz3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Quiz3();
            }
        });

        return view;
    }

    public void Quiz1(){
        Intent intent = new Intent(getActivity(), quiz1Activity.class);
        startActivity(intent);
    }
    public void Quiz2(){
        Intent intent = new Intent(getActivity(), quiz2Activity.class);
        startActivity(intent);

    }
    public void Quiz3(){
        Intent intent = new Intent(getActivity(), quiz3Activity.class);
        startActivity(intent);

    }

}
