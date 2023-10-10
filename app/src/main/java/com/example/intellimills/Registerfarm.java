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
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registerfarm extends AppCompatActivity {
    EditText farmername;
    EditText farmermphone;
    EditText county;
    EditText subcounty;
    EditText area;
    EditText bankAccountName;
    EditText idnumber;
    EditText email;
    EditText acres;
    ImageView back;
    EditText farmerAccountNumber;
    Button submit;
    Button CLEAR;
    FirebaseDatabase rootNode2;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerfarm);

        // Initialize Firebase
        FirebaseDatabase rootNode2 = FirebaseDatabase.getInstance();
        DatabaseReference reference = rootNode2.getReference("FarmsRegistered");

        CLEAR = findViewById(R.id.clear2);
        submit = findViewById(R.id.button14);
        acres = findViewById(R.id.Name);
        email = findViewById(R.id.EmailAddress);
        idnumber = findViewById(R.id.IDNumber);
        bankAccountName = findViewById(R.id.BankAccountName);
        area = findViewById(R.id.Area);
        subcounty = findViewById(R.id.Area);
        county = findViewById(R.id.County);
        farmermphone = findViewById(R.id.PhoneNumber);
        farmerAccountNumber = findViewById(R.id.AccountNumber);
        back = findViewById(R.id.back);

        CLEAR.setClickable(true);
        CLEAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Registerfarm.this, "Refreshing...", Toast.LENGTH_SHORT).show();
                        farmermphone.setText("");
                        email.setText("");
                        county.setText("");
                        subcounty.setText("");
                        area.setText("");
                        bankAccountName.setText("");
                        idnumber.setText("");
                        acres.setText("");
                        farmerAccountNumber.setText("");
                    }
                }, 3000);
                Toast.makeText(Registerfarm.this, "cleared.", Toast.LENGTH_LONG).show();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent servi = new Intent(Registerfarm.this, Services.class);
                startActivity(servi);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit.setClickable(false);

                String farmer_phonenumber = farmermphone.getText().toString();
                String farmer_County = county.getText().toString();
                String farmer_Subcounty = subcounty.getText().toString();
                String farm_Area = area.getText().toString();
                String farmer_BankAccountName = bankAccountName.getText().toString();
                String farmer_ID = idnumber.getText().toString();
                String land_Acres = acres.getText().toString();
                String farm_Account_Number = farmerAccountNumber.getText().toString();
                String emails = email.getText().toString();

                if (TextUtils.isEmpty(emails)) {
                    email.setError("Email ");
                    email.requestFocus();
                    submit.setClickable(true);
                } else if (TextUtils.isEmpty(farmer_phonenumber)) {
                    farmermphone.setError("Phone");
                    farmermphone.requestFocus();
                    submit.setClickable(true);
                } else if (TextUtils.isEmpty(farmer_County)) {
                    county.setError("County");
                    county.requestFocus();
                    submit.setClickable(true);
                } else if (TextUtils.isEmpty(farmer_Subcounty)) {
                    subcounty.setError("Subcounty");
                    subcounty.requestFocus();
                    submit.setClickable(true);
                } else if (TextUtils.isEmpty(farm_Area)) {
                    area.setError("Area");
                    area.requestFocus();
                    submit.setClickable(true);
                } else if (TextUtils.isEmpty(farmer_BankAccountName)) {
                    bankAccountName.setError("Bak Account Name.");
                    bankAccountName.requestFocus();
                    submit.setClickable(true);
                } else if (TextUtils.isEmpty(farmer_ID)) {
                    idnumber.setError("ID Number.");
                    idnumber.requestFocus();
                    submit.setClickable(true);
                } else if (TextUtils.isEmpty(land_Acres)) {
                    acres.setError("Number Of Acres");
                    acres.requestFocus();
                    submit.setClickable(true);
                    Toast.makeText(getApplicationContext(), "Please Enter the land quantity", Toast.LENGTH_LONG).show();
                } else if (TextUtils.isEmpty(farm_Account_Number)) {
                    farmerAccountNumber.setError("Farmer BankAccount Number");
                    farmerAccountNumber.requestFocus();
                    submit.setClickable(true);
                } else {
                    // Create an instance of FarmsRegisteredClass with the data
                    FarmsRegisteredClass farmsClass = new FarmsRegisteredClass(
                            farmer_phonenumber, farmer_County, farmer_Subcounty, farm_Area,
                            farmer_BankAccountName, farmer_ID, land_Acres, farm_Account_Number, emails
                    );

                    // Push the data to Firebase
                    String newKey = reference.push().getKey(); // Generate a unique key
                    reference.child(newKey).setValue(farmsClass).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "Data uploaded successfully", Toast.LENGTH_SHORT).show();

                                // Data was successfully written to Firebase
                                // You can perform any additional actions here
                            } else {
                                Toast.makeText(getApplicationContext(), "Data upload failed", Toast.LENGTH_SHORT).show();

                                // Data upload to Firebase failed
                                // You can handle this case here, e.g., display an error message
                            }
                            submit.setClickable(true); // Enable the button again
                        }
                    });
                }
            }
        });
    }
}
