package com.example.belang.Fragmen;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.belang.LoginAndSignup.LoginActivity;
import com.example.belang.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class profileFragment extends Fragment {

    TextView namaAcc, emailAcc;
    ImageButton btnLogout;
    FirebaseUser user;
    FirebaseAuth mFirebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    public profileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        mFirebaseAuth = FirebaseAuth.getInstance();
        user = mFirebaseAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("User");

        namaAcc = view.findViewById(R.id.namaAccount);
        emailAcc = view.findViewById(R.id.emailAccount);


        btnLogout = view.findViewById(R.id.btnLogout);


        Query query = databaseReference.orderByChild("email").equalTo(user.getEmail());

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ////check
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    //get data
                    String nama = "" + ds.child("nama").getValue();
                    String email = "" + ds.child("email").getValue();

                    //set data
                    namaAcc.setText(nama);
                    emailAcc.setText(email);
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                getActivity().finish();
                Intent intentToLogin = new Intent(getActivity(), LoginActivity.class);
                startActivity(intentToLogin);

            }
        });

        return view;
    }

}
