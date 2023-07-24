package com.example.intellimills;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HarvestApplication extends AppCompatActivity {

    EditText name;
    EditText id;
    EditText email;
    EditText sugarcaneAge;
    EditText county;
    EditText subCounty;
    EditText area;
    EditText phone;
    EditText trailernumber;
    Button submit;
    Button button12;
    ImageView backbutton;
    Button button11;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harvest_application);

        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Harvest Applications");
        name = findViewById(R.id.Acres);
        id = findViewById(R.id.IDNumber);
        email = findViewById(R.id.EmailAddress);
        sugarcaneAge = findViewById(R.id.SugarcaneAge);
        county = findViewById(R.id.County);
        subCounty = findViewById(R.id.subCounty);
        area= findViewById(R.id.subcounty);
        phone = findViewById(R.id.PhoneNumber);
        trailernumber = findViewById(R.id.editTextTextPersonName2);
        submit = findViewById(R.id.button15);
        backbutton = findViewById(R.id.backbutton);
        button11 = findViewById(R.id.button11);



        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent serv = new Intent(HarvestApplication.this,Services.class);
                startActivity(serv);
                finish();
            }
        });

        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id.setText("");
                email.setText("");
                name.setText("");
                Toast.makeText(HarvestApplication.this, "Cleared..!", Toast.LENGTH_LONG).show();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"Uploading.........",Toast.LENGTH_LONG).show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        String username = name.getText().toString();
                        String user_id = id.getText().toString();
                        String useremail = email.getText().toString();
                        String usersubcounty = subCounty.getText().toString();
                        String usercounty = county.getText().toString();
                        String usersugarcaneage = sugarcaneAge.getText().toString();
                        String userarea = area.getText().toString();
                        String userphone = phone.getText().toString();
                        String trailers = trailernumber.getText().toString();


                        HarvestapplicationsClass harvestclass = new HarvestapplicationsClass(username,user_id,useremail,usersubcounty,usercounty,usersugarcaneage,userarea,userphone,trailers);
                        reference.child(username).setValue(harvestclass);

                    }
                },3000);

                name.setText("");
                id.setText("");
                email.setText("");
                subCounty.setText("");
                sugarcaneAge.setText("");
                area.setText("");
                phone.setText("");
                county.setText("");
                sugarcaneAge.setText("");
                trailernumber.setText("");

                Toast.makeText(getApplicationContext(),"Uploading complete.........",Toast.LENGTH_LONG).show();



            }
        });


        button11 = findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setText("");
                id.setText("");
                email.setText("");
                subCounty.setText("");
                sugarcaneAge.setText("");
                Toast.makeText(HarvestApplication.this, "Cleared..!", Toast.LENGTH_LONG).show();
            }
        });
        button12 = findViewById(R.id.clear2);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                county.setText("");
                subCounty.setText("");
                area.setText("");
                phone.setText("");
                Toast.makeText(HarvestApplication.this, "Cleared..!", Toast.LENGTH_LONG).show();
            }
        });



    }
}