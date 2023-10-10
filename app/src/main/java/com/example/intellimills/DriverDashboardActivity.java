package com.example.intellimills;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DriverDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_dashboard);

        // Get references to the buttons
        Button pickHarvestButton = findViewById(R.id.buttonPickHarvest);
        Button reportIssueButton = findViewById(R.id.buttonReportIssue);
        Button applyLeaveButton = findViewById(R.id.buttonApplyLeave); // Added

        // Set OnClickListener for the "Pick a Harvest" button
        pickHarvestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open the DriverPickFarmActivity when "Pick a Harvest" button is clicked
                Intent pickFarmIntent = new Intent(DriverDashboardActivity.this, DriverPickFarmActivity.class);
                startActivity(pickFarmIntent);
            }
        });

        // Set OnClickListener for the "Report an Issue" button
        reportIssueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open the MessagingActivity when "Report an Issue" button is clicked
                Intent messagingIntent = new Intent(DriverDashboardActivity.this, Messaging.class);
                startActivity(messagingIntent);
            }
        });

        // Set OnClickListener for the "Apply Leave" button (Added)
        applyLeaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open the DriverLeaveFormActivity when "Apply Leave" button is clicked
                Intent applyLeaveIntent = new Intent(DriverDashboardActivity.this, DriverLeaveFormActivity.class);
                startActivity(applyLeaveIntent);
            }
        });

        // Rest of your onCreate code...
    }
}
