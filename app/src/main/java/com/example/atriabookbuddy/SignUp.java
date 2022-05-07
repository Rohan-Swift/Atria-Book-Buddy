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

public class SignUp extends AppCompatActivity {

    TextInputEditText nameInp, usnInp, phnumInp, passwdInp;
    Button signUpsignin, SignUpsubmit;
    String name, usn, phnum, passwd;
    FirebaseAuth mAuth;

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

        mAuth=FirebaseAuth.getInstance();



        signUpsignin.setOnClickListener(v -> {
            Intent i= new Intent(SignUp.this, MainActivity.class);
            startActivity(i);
            finish();
        });

        SignUpsubmit.setOnClickListener(v ->
        {
            name=nameInp.getText().toString().trim();
            usn=usnInp.getText().toString().trim();
            phnum=phnumInp.getText().toString().trim();
            passwd=passwdInp.getText().toString().trim();


            if (usn.isEmpty())
            {
                usnInp.setError("USN is required");
                usnInp.requestFocus();
                return;
            }

            if(name.isEmpty())
            {
                nameInp.setError("Name is required");
                nameInp.requestFocus();
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

            mAuth.createUserWithEmailAndPassword(usn, passwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()) {
                        Toast.makeText(SignUp.this, "User has been registered", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(SignUp.this, MainActivity.class));
                        finish();
                    }
                    else
                        Toast.makeText(SignUp.this, "Error: Not registered", Toast.LENGTH_LONG).show();
                }
            });
        });
    }
}