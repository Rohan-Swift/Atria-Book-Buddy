package com.example.atriabookbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.Objects;

public class AdminLogin extends AppCompatActivity {

    Button backBtn, adminSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_admin_login);

        backBtn= findViewById(R.id.adminBackbtn);
        adminSubmit= findViewById(R.id.adminSubmitbtn);

        backBtn.setOnClickListener(v -> {
            Intent i= new Intent(AdminLogin.this, MainActivity.class);
            startActivity(i);
        });

        /*TODO
        For now submit takes you to the next activity
        But later add login feature
         */

        adminSubmit.setOnClickListener(v -> {
            Intent i =new Intent(AdminLogin.this, adminIssueReturn.class);
            startActivity(i);
        });
    }
}