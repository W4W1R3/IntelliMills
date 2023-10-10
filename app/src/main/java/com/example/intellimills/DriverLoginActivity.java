package com.example.intellimills;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;

public class DriverLoginActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    EditText editemail;
    EditText editpasswrd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_login);
        editemail =findViewById(R.id.editTextTextEmailAddress2);
        editpasswrd = findViewById(R.id.editTextTextPassword2);

        // Initialize FirebaseAuth
        mAuth = FirebaseAuth.getInstance(); // Add this line to initialize Firebase Authentication

        Button signupdriver = findViewById(R.id.signupdriver);
        signupdriver.setOnClickListener(view -> {
            Toast.makeText(DriverLoginActivity.this, "Loading Driver Sign Up Page." , Toast.LENGTH_LONG).show();

            signupdriver.setClickable(false);
            new Handler().postDelayed(() -> {
                Intent signdrv = new Intent(DriverLoginActivity.this,DriverSignUpActivity.class);
                startActivity(signdrv);
                finish();
            },3000);
        });
        Button button2 =findViewById(R.id.button2login);
        button2.setOnClickListener(view -> loginUser());
    }
    private  void loginUser(){
        editemail =findViewById(R.id.editTextTextEmailAddress2);
        editpasswrd = findViewById(R.id.editTextTextPassword2);

        String email = editemail.getText().toString();
        String password =editpasswrd.getText().toString();
        Button button2 =findViewById(R.id.button2login);

        if (TextUtils.isEmpty(email)){
            editemail.setError("Email cannot be empty");
            editemail.requestFocus();
            Toast.makeText(getApplicationContext(),"Please Enter Your Email",Toast.LENGTH_LONG).show();
        }else if (TextUtils.isEmpty(password)){
            editpasswrd.setError("Password cannot be empty");
            editpasswrd.requestFocus();
            Toast.makeText(getApplicationContext(),"Please enter Password.",Toast.LENGTH_LONG).show();
        }else{
            button2.setClickable(true);
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                if (task.isSuccessful()){
                    Toast.makeText(DriverLoginActivity.this, "Welcome.", Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(),"Verifying.......",Toast.LENGTH_LONG).show();
                    new Handler().postDelayed(() -> {
                        editemail.setText("");
                        editpasswrd.setText("");
                        Intent advert = new Intent(DriverLoginActivity.this, DriverDashboardActivity.class);
                        startActivity(advert);
                        finish();

                    },2000);
                }else {
                    Toast.makeText(DriverLoginActivity.this, "Login Error" +task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    button2.setClickable(true);
                }
            });

        }
    }
}