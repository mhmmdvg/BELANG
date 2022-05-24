package com.example.belang;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.example.belang.Fragmen.aboutFragment;
import com.example.belang.Fragmen.homeFragment;
import com.example.belang.Fragmen.profileFragment;
import com.example.belang.Fragmen.quizFragment;
import com.example.belang.Fragmen.soalFragment;
import com.example.belang.Home_Bab.home;
import com.example.belang.Home_Bab.jenis_jaringan;
import com.example.belang.Home_Bab.topologi_jaringan;
import com.example.belang.Home_Bab.videoActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView Main_nav;
    private FrameLayout Main_frame;

    private homeFragment HomeFragment;
    private soalFragment SoalFragment;
    private profileFragment ProfileFragment;
    private aboutFragment AboutFragment;
    private quizFragment QuizFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_view);

        HomeFragment = new homeFragment();
        ProfileFragment = new profileFragment();
        SoalFragment = new soalFragment();
        AboutFragment = new aboutFragment();
        QuizFragment = new quizFragment();
        setFragment(HomeFragment);


        Main_frame = (FrameLayout) findViewById(R.id.main_frame);
        Main_nav = (BottomNavigationView) findViewById(R.id.nav_menu);



        Main_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){

                    case R.id.nav_home :
                        setFragment(HomeFragment);
                        return true;


                    case R.id.nav_soal :
                        setFragment(SoalFragment);
                        return true;

                    case R.id.nav_quiz :
                        setFragment(QuizFragment);
                        return true;

                    case R.id.nav_profile :
                        setFragment(ProfileFragment);
                        return true;

                    case R.id.nav_about :
                        setFragment(AboutFragment);
                        return true;


                        default:
                            return false;

                }


            }
        });

    }


    private void setFragment (Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }


}
