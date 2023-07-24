package com.example.intellimills;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();


    }
        protected void onStart() {
            super.onStart();
            FirebaseUser currentUser = mAuth.getCurrentUser();
            if (currentUser == null) {

                new Handler().postDelayed(() -> {

                    Intent Register = new Intent(MainActivity.this, Register.class);
                    startActivity(Register);
                    finish();
                }, 4000);
            } else {
                new Handler().postDelayed(() -> {
                    Intent Login = new Intent(MainActivity.this,Login.class);
                    startActivity(Login);
                    finish();
                }, 4000);

            }

        }

}