package com.example.intellimills;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class Advert extends AppCompatActivity {

    Handler handler;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advert);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Toast.makeText(Advert.this,"Loading",Toast.LENGTH_LONG).show();
                Intent services = new Intent(Advert.this,Services.class);
                startActivity(services);
                finish();
            }
        },3000);


    }
}



