package com.example.atriabookbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class studentBookNumber extends AppCompatActivity {

    TextView book1num, book2num, book3num, book4num;

    FirebaseDatabase db= FirebaseDatabase.getInstance();
    DatabaseReference b1=db.getReference("books").child("Book1");
    DatabaseReference b2=db.getReference("books").child("Book2");
    DatabaseReference b3=db.getReference("books").child("Book3");
    DatabaseReference b4=db.getReference("books").child("Book4");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_book_number);

        book1num=findViewById(R.id.book1Num);
        book2num= findViewById(R.id.book2Num);
        book3num= findViewById(R.id.book3Num);
        book4num= findViewById(R.id.book4Num);

        b1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                snapshot.getChildren();
                String value= snapshot.child("Quantity").getValue().toString();
                book1num.setText(value);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        b2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                snapshot.getChildren();
                String value= snapshot.child("Quantity").getValue().toString();
                book2num.setText(value);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        b3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                snapshot.getChildren();
                String value= snapshot.child("Quantity").getValue().toString();
                book3num.setText(value);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        b4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                snapshot.getChildren();
                String value= snapshot.child("Quantity").getValue().toString();
                book4num.setText(value);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}