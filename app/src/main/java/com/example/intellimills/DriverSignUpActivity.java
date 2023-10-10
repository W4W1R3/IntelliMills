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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DriverSignUpActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    EditText editText;
    EditText editemail;
    EditText  editpassword;
    EditText editname;
    EditText editphone;
    FirebaseDatabase rootNode2;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_sign_up);

        rootNode2 = FirebaseDatabase.getInstance();
        reference = rootNode2.getReference("User data");
        editemail = findViewById(R.id.editTextTextEmailAddress);
        editpassword = findViewById(R.id.editTextTextPassword);
        editname = findViewById(R.id.editTextTextPersonName);
        editphone = findViewById(R.id.editTextPhone);
        Button login = findViewById(R.id.button);
        mAuth = FirebaseAuth.getInstance();
        Button button=findViewById(R.id.button);

        String email =editemail.getText().toString();
        String phone = editphone.getText().toString();
        String name = editname.getText().toString();
        String password = editpassword.getText().toString();



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.setClickable(false);
                createUser();
            }
        });
    }
    private void createUser(){

        Button button=findViewById(R.id.button);
        String email =editemail.getText().toString();
        String name = editname.getText().toString();
        String phone = editphone.getText().toString();
        String password = editpassword.getText().toString();


        if (TextUtils.isEmpty(name)){
            editname.setError("Name cannot be empty");
            editname.requestFocus();
            button.setClickable(true);
            Toast.makeText(getApplicationContext(), "Please Enter name.", Toast.LENGTH_LONG).show();
        }else if(TextUtils.isEmpty(email)) {
            editemail.setError("Email cannot be empty");
            editemail.requestFocus();
            button.setClickable(true);
            Toast.makeText(getApplicationContext(), "Please Enter your email.", Toast.LENGTH_LONG).show();
        }else if (phone.length()==13){
            Toast.makeText(getApplicationContext(), "Please Enter full phonenumber +254....", Toast.LENGTH_LONG).show();
        }else if (password.length() == 0) {
            editpassword.setError("Password cannot be empty");
            editpassword.requestFocus();
            button.setClickable(true);
            Toast.makeText(getApplicationContext(), "Please enter password", Toast.LENGTH_LONG).show();
        }else {
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(DriverSignUpActivity.this, "User registered Successfully. You are now a registered driver at IntelliMills.", Toast.LENGTH_LONG).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Registerclass registerclass = new Registerclass(email,name,phone);
                                reference.child(name).setValue(registerclass);

                                Intent Login = new Intent(DriverSignUpActivity.this,DriverLoginActivity.class);
                                startActivity(Login);
                                finish();
                            }
                        },2000);


                    }else {

                        Toast.makeText(DriverSignUpActivity.this, "Registration Error,Account not created." +task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        button.setClickable(true);
                    }

                }
            });
        }








    }
}