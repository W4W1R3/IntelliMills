package com.example.intellimills;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText editemail;
    EditText editpasswrd;
    FirebaseAuth dAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editemail =findViewById(R.id.editTextTextEmailAddress2);
        editpasswrd = findViewById(R.id.editTextTextPassword2);
        dAuth= FirebaseAuth.getInstance();

        Button button19 = findViewById(R.id.button19);
        button19.setOnClickListener(view -> {
                            Toast.makeText(Login.this, "Loading Admin Login Page." , Toast.LENGTH_LONG).show();

        button19.setClickable(false);
        new Handler().postDelayed(() -> {
             Intent Admnlgn = new Intent(Login.this,AdminLogin.class);
            startActivity(Admnlgn);
        },3000);
        });
         Button button18 = findViewById(R.id.button18);
        button18.setOnClickListener(view -> {
            Toast.makeText(Login.this, "Loading Driver Login Page." , Toast.LENGTH_LONG).show();

            button18.setClickable(false);
            new Handler().postDelayed(() -> {
                Intent DrvrLgn = new Intent(Login.this, DriverLoginActivity.class);
                startActivity(DrvrLgn);
            },3000);
        });
        Button button3 = findViewById(R.id.button3);


        button3.setOnClickListener(view -> {
            Toast.makeText(Login.this, "Loading Registration form." , Toast.LENGTH_LONG).show();

            button3.setClickable(false);
            new Handler().postDelayed(() -> {
                Intent reg = new Intent(Login.this,Register.class);
                startActivity(reg);
            },3000);

        });


        Button button2 =findViewById(R.id.button2login);
        button2.setOnClickListener(view -> loginUsers());

    }

    private  void loginUsers(){
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
            dAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                if (task.isSuccessful()){
                    Toast.makeText(Login.this, "Welcome.", Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(),"Verifying.......",Toast.LENGTH_LONG).show();
                    new Handler().postDelayed(() -> {
                        editemail.setText("");
                        editpasswrd.setText("");
                        Intent advert = new Intent(Login.this,Advert.class);
                        startActivity(advert);

                    },2000);
                }else {
                    Toast.makeText(Login.this, "Login Error" +task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    button2.setClickable(true);
                }
            });

        }
    }
}