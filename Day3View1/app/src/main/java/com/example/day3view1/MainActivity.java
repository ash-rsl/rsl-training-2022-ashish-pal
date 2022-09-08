package com.example.day3view1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button editTextBtn = findViewById(R.id.editTextBtn);
        Button textViewBtn = findViewById(R.id.textViewBtn);
        Button imageViewBtn = findViewById(R.id.imageViewBtn);
        Button buttonView = findViewById(R.id.buttons);

        editTextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EditTextActivity.class);
                startActivity(intent);
            }
        });

        textViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), activityTextView.class);
                startActivity(intent);
            }
        });

        imageViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ImageViewActivity.class);
                startActivity(intent);
            }
        });

        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ActivityButton.class);
                startActivity(intent);
            }
        });
    }
}