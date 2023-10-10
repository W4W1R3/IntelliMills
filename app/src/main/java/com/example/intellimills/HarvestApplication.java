package com.example.intellimills;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
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
        name = findViewById(R.id.Name);
        id = findViewById(R.id.IDNumber);
        email = findViewById(R.id.EmailAddress);
        sugarcaneAge = findViewById(R.id.SugarcaneAge);
        county = findViewById(R.id.County);
        subCounty = findViewById(R.id.subCounty);
        area = findViewById(R.id.Area);
        phone = findViewById(R.id.PhoneNumber);
        trailernumber = findViewById(R.id.editTextTextPersonName2);
        submit = findViewById(R.id.button15);
        backbutton = findViewById(R.id.backbutton);
        button12 = findViewById(R.id.button12);

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent serv = new Intent(HarvestApplication.this, Services.class);
                startActivity(serv);
                finish();
            }
        });

        button12.setOnClickListener(new View.OnClickListener() {
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
                // Get the values from the EditText fields
                String username = name.getText().toString().trim();
                String user_id = id.getText().toString().trim();
                String useremail = email.getText().toString().trim();
                String usersubcounty = subCounty.getText().toString().trim();
                String usercounty = county.getText().toString().trim();
                String usersugarcaneage = sugarcaneAge.getText().toString().trim();
                String userarea = area.getText().toString().trim();
                String userphone = phone.getText().toString().trim();
                String trailers = trailernumber.getText().toString().trim();

                // Check if any of the required fields are empty
                if (username.isEmpty() || user_id.isEmpty() || useremail.isEmpty() || usersubcounty.isEmpty() ||
                        usercounty.isEmpty() || usersugarcaneage.isEmpty() || userarea.isEmpty() || userphone.isEmpty() || trailers.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please fill in all required fields", Toast.LENGTH_LONG).show();
                    return; // Stop submission if any required field is empty
                }

                Toast.makeText(getApplicationContext(), "Uploading...", Toast.LENGTH_LONG).show();

                HarvestapplicationsClass harvestclass = new HarvestapplicationsClass
                        (username, user_id, useremail, usersubcounty, usercounty, usersugarcaneage, userarea, userphone, trailers);
                reference.child(username).setValue(harvestclass);

                // Clear the fields after successful submission


                Toast.makeText(getApplicationContext(), "Uploading complete", Toast.LENGTH_LONG).show();
            }
        });

        // The rest of your code for clearing fields
    }
}
