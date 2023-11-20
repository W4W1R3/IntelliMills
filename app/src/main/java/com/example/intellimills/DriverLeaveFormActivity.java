package com.example.intellimills;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap;
import java.util.Map;

public class DriverLeaveFormActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText idEditText;
    private EditText reasonEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_leave_form);

        nameEditText = findViewById(R.id.name3);
        idEditText = findViewById(R.id.Id);
        reasonEditText = findViewById(R.id.editTextText4);

        Button clearButton = findViewById(R.id.button11);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Clear all EditText fields
                nameEditText.setText("");
                idEditText.setText("");
                reasonEditText.setText("");
            }
        });

        Button submitButton = findViewById(R.id.button7);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the user's input
                String name = nameEditText.getText().toString();
                String id = idEditText.getText().toString();
                String reason = reasonEditText.getText().toString();

                // Validate the input and submit to Firebase
                if (!name.isEmpty() && !id.isEmpty() && !reason.isEmpty()) {
                    submitLeaveToFirebase(name, id, reason);
                } else {
                    Toast.makeText(DriverLeaveFormActivity.this, "Please fill in all fields.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void submitLeaveToFirebase(String name, String id, String reason) {
        // Replace this with your Firebase database reference
        DatabaseReference leaveRef = FirebaseDatabase.getInstance().getReference("leave_requests");

        // Create a unique key for the leave request
        String leaveId = leaveRef.push().getKey();

        // Create a map to store the leave data
        Map<String, Object> leaveData = new HashMap<>();
        leaveData.put("name", name);
        leaveData.put("id", id);
        leaveData.put("reason", reason);

        // Push the data to Firebase
        leaveRef.child(leaveId).updateChildren(leaveData)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(DriverLeaveFormActivity.this, "Submission successful.", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(DriverLeaveFormActivity.this, "Submission failed. Please try again.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
