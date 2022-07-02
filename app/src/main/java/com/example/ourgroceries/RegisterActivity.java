package com.example.ourgroceries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        TextView HadAccount= findViewById(R.id.hadaccount);
        HadAccount.setOnClickListener(view -> startActivity(new Intent(RegisterActivity.this,LoginActivity.class)));
    }
}