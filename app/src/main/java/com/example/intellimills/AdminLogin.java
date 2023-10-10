package com.example.intellimills;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class AdminLogin extends AppCompatActivity {

    // Define hardcoded admin credentials
    private static final String ADMIN_USERNAME = "adminintel";
    private static final String ADMIN_PASSWORD = "001122";

    EditText editemail;
    EditText editpasswrd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        editemail = findViewById(R.id.editTextTextEmailAddress2);
        editpasswrd = findViewById(R.id.editTextTextPassword2);

        Button button2 = findViewById(R.id.button2login);
        button2.setOnClickListener(view -> loginUser());
    }

    private void loginUser() {
        String email = editemail.getText().toString();
        String password = editpasswrd.getText().toString();

        if (TextUtils.isEmpty(email)) {
            editemail.setError("Email cannot be empty");
            editemail.requestFocus();
            Toast.makeText(getApplicationContext(), "Please Enter Your Email", Toast.LENGTH_LONG).show();
        } else if (TextUtils.isEmpty(password)) {
            editpasswrd.setError("Password cannot be empty");
            editpasswrd.requestFocus();
            Toast.makeText(getApplicationContext(), "Please enter Password.", Toast.LENGTH_LONG).show();
        } else {
            // Check if the provided credentials match the hardcoded admin credentials
            if (email.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
                // Admin login successful
                Toast.makeText(AdminLogin.this, "Admin login successful", Toast.LENGTH_LONG).show();

                // Start the AdminDashboardActivity
                Intent adminDashboardIntent = new Intent(AdminLogin.this, AdminDashboardActivity.class);
                startActivity(adminDashboardIntent);
                // Optional: Finish the AdminLoginActivity to prevent going back to it
            } else {
                // Admin login failed
                Toast.makeText(AdminLogin.this, "Admin login failed. Incorrect credentials.", Toast.LENGTH_LONG).show();
            }
        }
    }
}
