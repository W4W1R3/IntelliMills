package com.example.intellimills;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    Button button3;
    Button button2;
    EditText editemail;
    EditText editpasswrd;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editemail =findViewById(R.id.editTextTextEmailAddress2);
        editpasswrd = findViewById(R.id.editTextTextPassword2);
        mAuth= FirebaseAuth.getInstance();

        Button button19 = findViewById(R.id.button19);
        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                                Toast.makeText(Login.this, "Loading Admin Login Page." , Toast.LENGTH_LONG).show();

            button19.setClickable(false);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                     Intent Admnlgn = new Intent(Login.this,AdminLogin.class);
                    startActivity(Admnlgn);
                    finish();
                }
            },3000);
            }
        });
        Button button3 = findViewById(R.id.button3);


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Login.this, "Loading Registration form." , Toast.LENGTH_LONG).show();

                button3.setClickable(false);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent reg = new Intent(Login.this,Register.class);
                        startActivity(reg);
                        finish();
                    }
                },3000);

            }
        });


        Button button2 =findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loginUsers();
            }
        });

    }

    private  void loginUsers(){
        String email = editemail.getText().toString();
        String password =editpasswrd.getText().toString();
        Button button2 =findViewById(R.id.button2);

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
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(Login.this, "Welcome.", Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(),"Verifying.......",Toast.LENGTH_LONG).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                editemail.setText("");
                                editpasswrd.setText("");
                                Intent advert = new Intent(Login.this,Advert.class);
                                startActivity(advert);
                                finish();

                            }
                        },2000);
                    }else {
                        Toast.makeText(Login.this, "Login Error" +task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        button2.setClickable(true);
                    }
                }
            });

        }
    }
}