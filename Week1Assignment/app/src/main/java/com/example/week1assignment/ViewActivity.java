package com.example.week1assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
    }

    public void changeColor(View view){
        TextView tv = findViewById(R.id.textView);

        if(tv.getCurrentTextColor() == Color.rgb(255,0,0)) {
            tv.setTextColor(Color.rgb(0,255,0));
            tv.setTypeface(tv.getTypeface(), Typeface.BOLD);
        }
        else if(tv.getCurrentTextColor() == Color.rgb(0,255,0)) {
            tv.setTextColor(Color.rgb(0,0,255));
            tv.setTypeface(tv.getTypeface(), Typeface.BOLD_ITALIC);
        }
        else if(tv.getCurrentTextColor() == Color.rgb(0,0,255)){
            tv.setTextColor(Color.rgb(255,0,0));
            tv.setTypeface(tv.getTypeface(), Typeface.ITALIC);
        }

    }

}
