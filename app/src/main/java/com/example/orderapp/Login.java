package com.example.orderapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orderapp.Database.DatabaseHelper;

public class
Login extends AppCompatActivity {
    private EditText email, password;
    private TextView forPass;
    private Button login;
    private DatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        DB = new DatabaseHelper(this);

        email = findViewById(R.id.edtEmailLog);
        password = findViewById(R.id.edtPassLog);
        forPass = findViewById(R.id.forgotPass);
        login = findViewById(R.id.btnLog);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getEmail = email.getText().toString();
                String getPassword = password.getText().toString();

                if (getEmail.equals("") || getPassword.equals("")) {
                    Toast.makeText(Login.this, "Please enter full information", Toast.LENGTH_SHORT).show();
                } else {
                    boolean checkuserandpass = DB.checkUserandPass(getEmail, getPassword);
                    if (checkuserandpass == true) {
                        Toast.makeText(Login.this, "Welcome to the Coffee Order App", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Login.this, "Incorrect authentication", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        forPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ForgotPassword.class);
                startActivity(intent);
            }
        });
    }
}
