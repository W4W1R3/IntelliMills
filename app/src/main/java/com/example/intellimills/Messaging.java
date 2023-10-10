package com.example.intellimills;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Messaging extends AppCompatActivity {

    ImageView backbtn;
    EditText nameEditText, emailEditText, reportEditText;
    Button clearButton, submitButton;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messaging);

        // Initialize Firebase Database reference
        reference = FirebaseDatabase.getInstance().getReference("Report");

        // Initialize views
        backbtn = findViewById(R.id.backbtn);
        nameEditText = findViewById(R.id.Name);
        emailEditText = findViewById(R.id.EmailAddress);
        reportEditText = findViewById(R.id.editTextText4);
        clearButton = findViewById(R.id.button11);
        submitButton = findViewById(R.id.button7);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(Messaging.this, Services.class);
                startActivity(back);
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Clear EditText fields
                nameEditText.setText("");
                emailEditText.setText("");
                reportEditText.setText("");
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get user input
                String name = nameEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String report = reportEditText.getText().toString().trim();

                // Check if any field is empty
                if (name.isEmpty() || email.isEmpty() || report.isEmpty()) {
                    // Handle empty fields, show a message, or prevent submission.
                    // You can display a Toast message or handle it as needed.
                    Toast.makeText(getApplicationContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {

                    // Create an instance of FarmsRegisteredClass with the data
                    MessagingClass report2 = new MessagingClass(
                          name,email,report
                    );

                    // Push the data to Firebase
                    String newKey = reference.push().getKey(); // Generate a unique key
                    reference.child(name).setValue(report2).addOnCompleteListener(new OnCompleteListener<Void>() {
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
                            submitButton.setClickable(true); // Enable the button again
                        }

                            });
                }
            }
        });
    }
}
