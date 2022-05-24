package com.example.belang.LoginAndSignup;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.belang.MainActivity;
import com.example.belang.R;
import com.example.belang.model.user;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignupFragment extends Fragment {

    EditText emailId, password, namaId;
    Button btnSignUp;
    FirebaseAuth mFirebaseAuth;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;

    public SignupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signup, container, false);


        databaseReference = FirebaseDatabase.getInstance().getReference("User");
        mFirebaseAuth = FirebaseAuth.getInstance();
        namaId = view.findViewById(R.id.etNama);
        emailId = view.findViewById(R.id.etEmail);
        password = view.findViewById(R.id.etPassword);
        btnSignUp = view.findViewById(R.id.button);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String fullName = namaId.getText().toString();
                final String email = emailId.getText().toString();
                String pass = password.getText().toString();

                if (email.isEmpty()) {
                    emailId.setError("Please enter email id");
                    emailId.requestFocus();
                }else if (pass.isEmpty()) {
                    password.setError("Please enter your password");
                    password.requestFocus();
                } else if (email.isEmpty() && pass.isEmpty()) {
                    Toast.makeText(getActivity(), "Fields Are Empty!", Toast.LENGTH_SHORT).show();
                } else if (!(email.isEmpty() && pass.isEmpty())) {
                    mFirebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(getActivity(), "Sign Up Unsuccessful, Please Try Again or Email Already", Toast.LENGTH_SHORT).show();
                            } else {
                                user information = new user(
                                        fullName,
                                        email
                                );

                                FirebaseDatabase.getInstance().getReference("User")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(information).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        Toast.makeText(getActivity(), "Registration Complete", Toast.LENGTH_SHORT).show();

                                    }

                                });
                                startActivity(new Intent(getActivity(), MainActivity.class));
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


}