package com.example.intellimills;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Services extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        ImageView profile = findViewById(R.id.profile);
       profile.setOnClickListener(view -> {
           Toast.makeText(Services.this,"Loading..",Toast.LENGTH_LONG).show();
           new Handler().postDelayed(() -> {
               Intent profile1 = new Intent(Services.this,Profile.class);
               startActivity(profile1);
           },3000);
       });



        Button button10 = findViewById(R.id.button10);
        button10.setOnClickListener(view -> {
            button10.setClickable(false);
            Toast.makeText(Services.this,"Loading...", Toast.LENGTH_LONG).show();
            new Handler().postDelayed(() -> {
                Toast.makeText(Services.this,"Loading...", Toast.LENGTH_LONG).show();
                Intent chat = new Intent(Services.this,Messaging.class);
                button10.setClickable(true);
                startActivity(chat);
            },2000);
        });



        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(view -> {
            button10.setClickable(false);
            button7.setClickable(false);
            Toast.makeText(Services.this,"Loading...", Toast.LENGTH_LONG).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent farmreg = new Intent(Services.this,Registerfarm.class);
                    button7.setClickable(true);
                    button10.setClickable(true);
                    startActivity(farmreg);
                }
            },2000);
        });


        Button button8 = findViewById(R.id.button8);
        button8.setOnClickListener(view -> {
            button10.setClickable(false);
            button7.setClickable(false);
            button8.setClickable(false);
            Toast.makeText(Services.this,"Loading...", Toast.LENGTH_LONG).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent harvestapplic = new Intent(Services.this,HarvestApplication.class);
                    button8.setClickable(true);
                    button10.setClickable(true);
                    button7.setClickable(true);
                    startActivity(harvestapplic);
                }
            },2000);
        });


        Button button9 = findViewById(R.id.button9);
        button9.setOnClickListener(view -> {
            button10.setClickable(false);
            button7.setClickable(false);
            button8.setClickable(false);
            button9.setClickable(false);
            Toast.makeText(Services.this,"Loading...", Toast.LENGTH_LONG).show();
            new Handler().postDelayed(() -> {
                Intent notif = new Intent(Services.this,Harvestupdates.class);
                button10.setClickable(true);
                button7.setClickable(true);
                button8.setClickable(true);
                button9.setClickable(true);
                startActivity(notif);
            },3000);
        });

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(view -> {

            Toast.makeText(Services.this,"Loading...", Toast.LENGTH_LONG).show();
            new Handler().postDelayed(() -> {
                Intent browser =new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.selinawamucii.com/insights/prices/kenya/sugar/"));
                startActivity(browser);
            },2000);

        });


        Button cane = findViewById(R.id.button17);
        cane.setOnClickListener(view -> {
            cane.setClickable(false);
            Toast.makeText(Services.this,"Loading...", Toast.LENGTH_LONG).show();
            new Handler().postDelayed(() -> {
                Intent browser =new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.gardeningknowhow.com/edible/herbs/sugarcane/common-sugarcane-varieties.htm"));
                cane.setClickable(true);
                startActivity(browser);
            },2000);

        });


        ImageButton imageButton6crop = findViewById(R.id.imageButton6);
        imageButton6crop.setOnClickListener(view -> {
            imageButton6crop.setClickable(false);
            Toast.makeText(Services.this,"Loading...", Toast.LENGTH_LONG).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent browser =new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.yara.co.ke/crop-nutrition/sugarcane/"));
                    imageButton6crop.setClickable(true);
                    startActivity(browser);
                }
            },2000);
        });


        Button button5 =findViewById(R.id.button5);
        button5.setOnClickListener(view -> {
            Toast.makeText(Services.this,"Loading....",Toast.LENGTH_LONG).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent industry = new Intent (Intent.ACTION_VIEW,Uri.parse("http://www.mumias-sugar.com/investor-center/the-sugar-industry"));
                    startActivity(industry);
                }
            },2000);

        });




    }
}