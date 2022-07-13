package com.example.atriabookbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class studentAccess extends AppCompatActivity {

    Button books;
    TextView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_student_access);

        books=findViewById(R.id.studBooks);
        back=findViewById(R.id.studBack);

        books.setOnClickListener(v -> {
            startActivity(new Intent(studentAccess.this, studentBookNumber.class));
        });

        back.setOnClickListener(v -> {
            startActivity(new Intent(studentAccess.this, MainActivity.class));
            finish();
        });
    }
}