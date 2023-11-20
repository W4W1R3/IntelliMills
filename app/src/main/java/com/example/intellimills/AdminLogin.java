package com.example.intellimills;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;

public class AdminLogin extends AppCompatActivity {

    EditText editemail;
    EditText editpasswrd;
    Button button2;

    // Initialize Firebase Authentication
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        // Initialize Firebase Authentication
        mAuth = FirebaseAuth.getInstance();

        editemail = findViewById(R.id.editTextTextEmailAddress2);
        editpasswrd = findViewById(R.id.editTextTextPassword2);
        button2 = findViewById(R.id.button2login);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });
    }

    private void loginUser() {
        String email = editemail.getText().toString();
        String password = editpasswrd.getText().toString();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Please enter email and password.", Toast.LENGTH_LONG).show();
        } else {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
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
                    });
        }
    }
}
