package com.example.a1stlab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.jar.Attributes;

public class SIGNUP extends AppCompatActivity implements View.OnClickListener {

    private Button SUBMIT;
    private FirebaseAuth mAuth;
    private TextView signin;
    private EditText email;
    private EditText password;
    private Button SignUp;
    private Button SignIn;
    private FirebaseDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        SUBMIT =findViewById(R.id.SUBMIT);
        mAuth = FirebaseAuth.getInstance();
        signin =findViewById(R.id.signin);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        database = FirebaseDatabase.getInstance();
        SUBMIT.setOnClickListener(this);
        SignIn.setOnClickListener(this);
        SignUp.setOnClickListener(this);
    }


    public void onClick(View v) {
        if(v == SUBMIT){
            creat_user(email.getText().toString(),password.getText().toString());
        }
    }


    public void creat_user(String email, String password) {

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            String User = new User(email.getText().toString(), Name.getText.toString(), password.getText().toString());
                            String Uid = mAuth.getCurrentUser().getUid().toString();
                            database.getReference("Users").child(Uid).setValue(User);
                            Intent i = new Intent(SIGNUP.this, HomeActivity.class);
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(SIGNUP.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
}