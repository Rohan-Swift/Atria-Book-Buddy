package com.example.atriabookbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.Objects;

public class studentAccess extends AppCompatActivity {

    Button books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_student_access);

        books=findViewById(R.id.studBooks);

        books.setOnClickListener(v -> {
            startActivity(new Intent(studentAccess.this, studentBookNumber.class));
        });
    }
}