package com.example.atriabookbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    TextInputEditText usn, password;
    Button signup, passwdforgot, adminlogin, login;
    String usnText, passwdText;
    FirebaseAuth mAuth;

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

        mAuth= FirebaseAuth.getInstance();


        signup.setOnClickListener(v -> {
            Intent i= new Intent(MainActivity.this, SignUp.class);
            startActivity(i);
            finish();
        });

        passwdforgot.setOnClickListener(v -> {

        });

        login.setOnClickListener(v -> {

            usnText=usn.getText().toString().trim();
            passwdText=password.getText().toString().trim();

            if (usnText.isEmpty())
            {
                usn.setError("Email is required");
                usn.requestFocus();
                return;
            }

            if (passwdText.isEmpty())
            {
                password.setError("Password is required");
                password.requestFocus();
            }

            mAuth.signInWithEmailAndPassword(usnText, passwdText).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()) {
                        Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(MainActivity.this, studentAccess.class));
                        finish();
                    }
                    else
                        Toast.makeText(MainActivity.this, "Login unsuccessful", Toast.LENGTH_LONG).show();
                }
            });
        });

        adminlogin.setOnClickListener(v -> {
            Intent i= new Intent(MainActivity.this, AdminLogin.class);
            startActivity(i);
            finish();

        });
    }
}