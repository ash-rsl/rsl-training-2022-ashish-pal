package com.example.week1assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button logIn = findViewById(R.id.login);

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText e1 = (EditText) findViewById(R.id.userName);
                EditText e2 = (EditText) findViewById(R.id.password);
                String userName = e1.getText().toString();
                String password = e2.getText().toString();

                Log.i(userName, password);

                if(userName.equals("admin") && password.equals("admin123")){
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"Invalid credentials", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}