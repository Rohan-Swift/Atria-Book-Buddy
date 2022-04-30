package com.example.atriabookbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class SignUp extends AppCompatActivity {

    TextInputEditText nameInp, usnInp, phnumInp, passwdInp;
    Button signUpsignin, SignUpsubmit;
    String name, usn, phnum, passwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_sign_up);

        nameInp=findViewById(R.id.signUpname);
        usnInp=findViewById(R.id.signUpusn);
        phnumInp=findViewById(R.id.signupPhnum);
        passwdInp=findViewById(R.id.signupPswd);

        signUpsignin=findViewById(R.id.signUpsigninbtn);
        SignUpsubmit= findViewById(R.id.signUpsubmitbtn);



        signUpsignin.setOnClickListener(v -> {
            Intent i= new Intent(SignUp.this, MainActivity.class);
            startActivity(i);
        });

        SignUpsubmit.setOnClickListener(v ->
        {
            name=nameInp.getText().toString();
            usn=usnInp.getText().toString();
            phnum=phnumInp.getText().toString();
            passwd=passwdInp.getText().toString();


            if(name.isEmpty())
            {
                nameInp.setError("Name is required");
                nameInp.requestFocus();
                return;
            }
            if (usn.isEmpty())
            {
                usnInp.setError("USN is required");
                usnInp.requestFocus();
                return;
            }
            if (phnum.isEmpty())
            {
                phnumInp.setError("Phone Number is required");
                phnumInp.requestFocus();
                return;
            }
            if(passwd.isEmpty())
            {
                passwdInp.setError("Password is required");
                passwdInp.requestFocus();
                return;
            }
            if(passwd.length()<6)
            {
                passwdInp.setError("Minimum length is 6 characters");
            }
        });



    }
}