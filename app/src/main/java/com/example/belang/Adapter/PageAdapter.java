package com.example.belang.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.belang.LoginAndSignup.LoginFragment;
import com.example.belang.LoginAndSignup.SignupFragment;

public class PageAdapter extends FragmentPagerAdapter {

    public PageAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                Fragment login = new LoginFragment();
                return login;
            case 1 :
                Fragment singUp = new SignupFragment();
                return singUp;
             default:
                    return null;

        }

    }

    @Override
    public int getCount() {
        return 2;
    }
}
