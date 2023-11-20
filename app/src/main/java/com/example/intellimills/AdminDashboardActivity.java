package com.example.intellimills;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        // Get a reference to the btnPermitApproval button
        Button btnPermitApproval = findViewById(R.id.btnPermitApproval);

        // Set an OnClickListener for the btnPermitApproval button
        btnPermitApproval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open the PermitApprovalActivity when the button is clicked
                Intent permitApprovalIntent = new Intent(AdminDashboardActivity.this, PermitApprovalActivity.class);
                startActivity(permitApprovalIntent);
            }
        });

        // Add similar code for other buttons to open their respective activities
        // For example, if you have a button for Extraction Approval, add code here to open ExtractionApprovalActivity.
    }
}
