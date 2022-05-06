package com.example.atriabookbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.Objects;

public class adminIssueReturn extends AppCompatActivity {

    Button bookIssuebtn, bookReturnbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_admin_issue_return);

        bookIssuebtn=findViewById(R.id.bookIssue);
        bookReturnbtn=findViewById(R.id.bookReturn);


        bookIssuebtn.setOnClickListener(v -> {
            Intent i= new Intent(adminIssueReturn.this, adminBookIssue.class);
            startActivity(i);
        });

        bookReturnbtn.setOnClickListener(v -> {
            Intent i= new Intent(adminIssueReturn.this, adminBookReturn.class);
            startActivity(i);
        });
    }
}