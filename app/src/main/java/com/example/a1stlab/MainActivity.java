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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView signin;
    private EditText email;
    private EditText password;
    private Button SignUp;
    private Button SignIn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signin =findViewById(R.id.signin);
        mAuth = FirebaseAuth.getInstance();
        email =findViewById(R.id.email);
        password =findViewById(R.id.password);
        SignUp =findViewById(R.id.SignUp);
        SignIn =findViewById(R.id.SignIn);
        SignIn.setOnClickListener(this);
        SignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == SignIn && email.getText().toString().contains("@") && email.getText().toString().contains(".com")) {
            password.setText(email.getText().toString());
        }
        if (v == SignUp) {
            Toast.makeText(getApplicationContext(), "Signup is under construction", Toast.LENGTH_SHORT).show();
        }
        if(v == SignUp){
            Intent i = new Intent(this,SIGNUP.class);
            startActivity(i);
        }
        if(v == SignIn){
            Intent i = new Intent(this,HomeActivity.class);
            startActivity(i);
        }
    }
    public void signin_user(String email, String password) {

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Intent i = new Intent(MainActivity.this, HomeActivity.class);
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
}