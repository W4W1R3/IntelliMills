package com.example.intellimills;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PermitApprovalActivity extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private static final String TAG = "PermitApprovalActivity";

    private Button updateButton;
    private TableRow secondRow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permit_approval);

        // Replace "your_project_name" with your actual Firebase project name
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Harvest Applications");

        updateButton = findViewById(R.id.btnUpdate);
        secondRow = findViewById(R.id.secondRow);  // Assuming you have a TableRow with this ID in your XML layout

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchDataFromFirebaseForSecondRow();
            }
        });

        fetchDataFromFirebaseForSecondRow();
    }

    private void fetchDataFromFirebaseForSecondRow() {
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Assuming "Harvest Applications" is a direct child of the root
                DataSnapshot harvestApplicationsSnapshot = dataSnapshot.child("Harvest Applications");

                // Assuming the second row data is stored under a specific child (e.g., "record1")
                DataSnapshot secondRowDataSnapshot = harvestApplicationsSnapshot.child("record1");

                // Assuming you have TextViews in the second row with IDs userarea, usercounty, etc.
                updateTextView(secondRow, R.id.userarea, secondRowDataSnapshot.child("userarea").getValue(String.class));
                updateTextView(secondRow, R.id.usercounty, secondRowDataSnapshot.child("usercounty").getValue(String.class));
                // Add similar lines for other fields

                // Update the UI for other fields as needed
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w(TAG, "fetchDataFromFirebaseForSecondRow:onCancelled", databaseError.toException());
            }
        });
    }

    private void updateTextView(TableRow row, int textViewId, String value) {
        TextView textView = row.findViewById(textViewId);
        if (textView != null) {
            textView.setText(value);
        }
    }
}
