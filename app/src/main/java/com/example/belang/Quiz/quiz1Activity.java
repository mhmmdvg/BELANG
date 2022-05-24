package com.example.belang.Quiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.animation.Animator;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.belang.R;
import com.example.belang.model.QuestionModel;
import com.example.belang.scoreActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class quiz1Activity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    private TextView question, noIndikator, timer_quiz1;
    private String motivasi = "Selamat! Kamu berhasil mendapatkan nilai diatas rata-rata";
    private String badMotiv = "Coba lagi untuk mendapatkan nilai yang lebih baik";
    private LinearLayout optionQuest;
    private Button Sharebtn, Nextbtn;
    private int count = 0;
    private int position = 0;
    private int score = 0;
    private List<QuestionModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);


        Window windows = getWindow();
        windows.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        Toolbar toolbar = findViewById(R.id.toolbar5);
        setSupportActionBar(toolbar);


        timer_quiz1 = findViewById(R.id.timer_quiz1);
        question = findViewById(R.id.questionQuiz);
        noIndikator = findViewById(R.id.no_indikatorQuiz);
        optionQuest = findViewById(R.id.optionquestQuiz);
        Sharebtn = findViewById(R.id.btn_shareQuiz);
        Nextbtn = findViewById(R.id.btn_nextQuiz);


        list = new ArrayList<>();

        myRef.child("Quiz").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    list.add(snapshot.getValue(QuestionModel.class));
                }
                if(list.size() > 0){

                    for (int i = 0; i < 4 ; i++){
                        optionQuest.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                checkAnswer((Button) v);
                            }
                        });
                    }
                    playAnim(question, 0, list.get(position).getQuestion());
                    Nextbtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Nextbtn.setEnabled(false);
                            Nextbtn.setAlpha(0.7f);
                            enableOption(true);
                            position++;
                            if(position == list.size()){
                                Intent scoreInent = new Intent(quiz1Activity.this, scoreActivity.class);
                                scoreInent.putExtra("score", score);
                                scoreInent.putExtra("total", list.size());
                                if (score > 5){
                                    scoreInent.putExtra("motivas", motivasi);
                                }else if (score <= 5){
                                    scoreInent.putExtra("motivas", badMotiv);
                                }

                                startActivity(scoreInent);
                                finish();
                                return;
                            }
                            count = 0;
                            playAnim(question, 0, list.get(position).getQuestion());
                        }
                    });

                }
                else {
                    finish();
                    Toast.makeText(quiz1Activity.this, "no questions", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(quiz1Activity.this, databaseError.getMessage(),Toast.LENGTH_SHORT);
            }
        });
    }

    private void playAnim(final View view, final int value, final String data){
        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500).setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

                if (value == 0 && count < 4){
                    String option = "";
                    if(count == 0){
                        option = list.get(position).getOptionA();
                    }else if (count == 1){
                        option = list.get(position).getOptionB();
                    }else if (count == 2){
                        option = list.get(position).getOptionC();
                    }else if (count == 3){
                        option = list.get(position).getOptionD();
                    }
                    playAnim(optionQuest.getChildAt(count),0, option);
                    count++;

                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {

                if(value == 0 ){
                    try {
                        ((TextView)view).setText(data);
                        noIndikator.setText(position+1+"/"+list.size());
                        countDownTimer.start();

                    }catch (ClassCastException ex){
                        ((Button)view).setText(data);
                    }
                    view.setTag(data);
                    playAnim(view, 1, data);
                }
            }


            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }


    ////////COUNTDOWN TIMER///////////
    CountDownTimer countDownTimer = new CountDownTimer(20 * 1000, 1000) {
        public void onTick(long millisUntilFinished) {
            timer_quiz1.setText("" + millisUntilFinished / 1000);
        }
        public void onFinish() {
            timer_quiz1.setText("0");
            Toast.makeText(quiz1Activity.this, "Time Out, Please click Next button", Toast.LENGTH_SHORT).show();
            enableOption(false);
            Nextbtn.setEnabled(true);
            Nextbtn.setAlpha(1);


        }
    };


    private void checkAnswer(Button selectOption){
        enableOption(false);
        Nextbtn.setEnabled(true);
        Nextbtn.setAlpha(1);
        if(selectOption.getText().toString().equals(list.get(position).getCorrectANS())){
            ///correct
            score++;
            selectOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#64b2cd")));
        }else {
            ///incorrect
            selectOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#64b2cd")));
        }
    }
    private void enableOption(boolean enable){
        for (int i = 0; i < 4 ; i++){
            optionQuest.getChildAt(i).setEnabled(enable);
            if(enable){
                optionQuest.getChildAt(i).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#989898")));
            }
        }
    }
}
