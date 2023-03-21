package com.android.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    private EditText emailSignup, usernameSignup, passwordSignup, addressSignup, contactSignup;
    private Button signupButton, signinButton;
    private DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        emailSignup = findViewById(R.id.email);
        usernameSignup = findViewById(R.id.username);
        passwordSignup = findViewById(R.id.password);
        addressSignup = findViewById(R.id.address);
        contactSignup = findViewById(R.id.contact);

        signupButton = findViewById(R.id.signupbtn);
        signinButton = findViewById(R.id.signinbtn);

        db = new DataBaseHelper(this);
        insertUser();
    }

    private void insertUser() {
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean var = db.registerUser(usernameSignup.getText().toString(), emailSignup.getText().toString(), passwordSignup.getText().toString(), addressSignup.getText().toString(), contactSignup.getText().toString());
                if (var) {
                    Toast.makeText(SignupActivity.this, "User Registered Successfully!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignupActivity.this, SigninActivity.class));
                    finish();
                } else {
                    Toast.makeText(SignupActivity.this, "Sorry, Failed to Register!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignupActivity.this, SigninActivity.class));
                finish();
            }
        });
    }

}