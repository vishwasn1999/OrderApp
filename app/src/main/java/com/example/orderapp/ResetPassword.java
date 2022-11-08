package com.example.orderapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.orderapp.Database.DatabaseHelper;

public class ResetPassword extends AppCompatActivity {
    private EditText emailOld, password, repasssword;
    private Button login;
    private Button forgotpassword;
    private DatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        emailOld = (EditText) findViewById(R.id.EnailOld);
        password = (EditText) findViewById(R.id.passwordnew);
        repasssword = (EditText) findViewById(R.id.repasswordNew);
        login = (Button) findViewById(R.id.btnReLogin);
        forgotpassword = (Button) findViewById(R.id.btnForgotPassword);

        DB = new DatabaseHelper(this);

        // call the username and forgot password
        Intent intent = getIntent();
        emailOld.setText(intent.getStringExtra("username"));

        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String user = emailOld.getText().toString();
               String pass = password.getText().toString();
               String repass = repasssword.getText().toString();

               if (pass.equals(repass)) {
                   boolean updatepass = DB.updatepassword(user, pass);
                   if(updatepass == true) {
                       Toast.makeText(ResetPassword.this, "The most suitable pattern", Toast.LENGTH_SHORT).show();
                   } else {
                       Toast.makeText(ResetPassword.this, "The pattern can't be covered", Toast.LENGTH_SHORT).show();
                   }
               } else {
                   Toast.makeText(ResetPassword.this, "The connection is not in the middle of the city", Toast.LENGTH_SHORT).show();
               }
            }
        });

//        switch to login with intent
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
    }
}