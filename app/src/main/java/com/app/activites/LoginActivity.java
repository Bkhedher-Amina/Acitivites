package com.app.activites;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText inputEmail,inputPassword;
    Button btnInscription;
    DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputEmail=findViewById(R.id.inputMail);
        inputPassword=findViewById(R.id.inputPassword);

        btnInscription=findViewById(R.id.btnInscription);
        btnInscription.setOnClickListener(v -> {
            String email=inputEmail.getText().toString();
            String password =inputPassword.getText().toString();
            boolean CheckEmailPassword= db.EmailPassword(email,password);
            if (CheckEmailPassword){
                Toast.makeText(getApplicationContext(), "Successfully login", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(getApplicationContext(), "Wrong email or password", Toast.LENGTH_SHORT).show();
            }

        });

    }
}