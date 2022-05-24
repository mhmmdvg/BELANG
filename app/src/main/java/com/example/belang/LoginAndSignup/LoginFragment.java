package com.example.belang.LoginAndSignup;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.belang.MainActivity;
import com.example.belang.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    EditText emailId, password;
    Button btnSignUp;
    FirebaseAuth mFirebaseAuth;
    FirebaseUser currentUser;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);


        mFirebaseAuth = FirebaseAuth.getInstance();
        currentUser = mFirebaseAuth.getCurrentUser();
        emailId = view.findViewById(R.id.etEmail);
        password = view.findViewById(R.id.etPassword);
        btnSignUp = view.findViewById(R.id.button);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {


            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if(mFirebaseUser != null){
                    Toast.makeText(getActivity(), "You are logged in", Toast.LENGTH_SHORT ).show();
                    Intent intent = new Intent (getActivity(), MainActivity.class);
                    startActivity(intent);

                }
                else{
                    Toast.makeText(getActivity(), "Please Login", Toast.LENGTH_SHORT).show();
                }
            }

        };
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailId.getText().toString();
                String pass = password.getText().toString();
                if (email.isEmpty()) {
                    emailId.setError("Please enter email id");
                    emailId.requestFocus();
                }
                else if (pass.isEmpty()) {
                    password.setError("Please enter your password");
                    password.requestFocus();
                }
                else if (email.isEmpty() && pass.isEmpty()) {
                    Toast.makeText(getActivity(), "Fields Are Empty!", Toast.LENGTH_SHORT).show();
                }
                else if (!(email.isEmpty() && pass.isEmpty())) {
                    mFirebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(getActivity(), "Login Error, Please Login Again", Toast.LENGTH_SHORT).show();

                            } else {
                                if (task.getResult().getAdditionalUserInfo().isNewUser()){
                                    String email = currentUser.getEmail();
                                    String nama = currentUser.getDisplayName();

                                    HashMap<Object, String> hashMap = new HashMap<>();

                                    hashMap.put("email", email);
                                    hashMap.put("nama", nama);

                                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                                    DatabaseReference reference = database.getReference("User");
                                    reference.child(email).setValue(hashMap);

                                }
                                Intent intentToHome = new Intent(getActivity(), MainActivity.class);
                                startActivity(intentToHome);
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(getActivity(), "Error Ocurred!", Toast.LENGTH_SHORT).show();
                }
            }


        });


        return view;

    }
    @Override
    public void onStart(){
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

}
