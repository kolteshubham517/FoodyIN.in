package com.android.foodorderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SigninActivity extends AppCompatActivity {
    private EditText loginUsername, loginPassword;
    private Button loginButton, signupButton;
    private DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        loginUsername = findViewById(R.id.username);
        loginPassword = findViewById(R.id.password);
        loginButton = findViewById(R.id.signinbtn);
        signupButton = findViewById(R.id.signupbtn);

        db = new DataBaseHelper(this);
        checkUser();
    }

    private void checkUser(){
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean flag = db.checkUser(loginUsername.getText().toString(), loginPassword.getText().toString());
                if(flag) {
                    Toast.makeText(SigninActivity.this, "Login Successful...", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SigninActivity.this, MainActivity.class));
                    finish();
                }
                else
                    Toast.makeText(SigninActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();
            }
        });
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SigninActivity.this, SignupActivity.class));
                finish();
            }
        });
    }



}
