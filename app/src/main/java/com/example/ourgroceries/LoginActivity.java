package com.example.ourgroceries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView ForgetPass= findViewById(R.id.forgotpass);
        ForgetPass.setOnClickListener(view -> startActivity(new Intent(LoginActivity.this,RegisterActivity.class)));
        TextView username =(TextView) findViewById(R.id.username);
        TextView password =(TextView) findViewById(R.id.password);

        MaterialButton loginBtn = (MaterialButton) findViewById(R.id.loginbtn);

        //admin and admin

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    //correct
                    Toast.makeText(LoginActivity.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                }else
                    //incorrect
                    Toast.makeText(LoginActivity.this,"LOGIN FAILED !!!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}