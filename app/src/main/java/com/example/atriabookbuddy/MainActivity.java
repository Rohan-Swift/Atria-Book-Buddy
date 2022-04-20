package com.example.atriabookbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    TextInputEditText usn, password;
    Button signup, passwdforgot, adminlogin, login;
    String usnText, passwdText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_main);

        usn=findViewById(R.id.usnInp);
        password=findViewById(R.id.passwdInp);
        passwdforgot=findViewById(R.id.forgotpswdBtn);
        signup=findViewById(R.id.signUpbtn);
        adminlogin=findViewById(R.id.adminLoginBtn);
        login=findViewById(R.id.loginSubBtn);

        usnText=usn.getText().toString();
        passwdText=password.getText().toString();


        signup.setOnClickListener(v -> {
            Intent i= new Intent(MainActivity.this, SignUp.class);
            startActivity(i);
        });

        passwdforgot.setOnClickListener(v -> {

        });

        login.setOnClickListener(v -> {

        });

        adminlogin.setOnClickListener(v -> {
            Intent i= new Intent(MainActivity.this, AdminLogin.class);
            startActivity(i);

        });
    }
}