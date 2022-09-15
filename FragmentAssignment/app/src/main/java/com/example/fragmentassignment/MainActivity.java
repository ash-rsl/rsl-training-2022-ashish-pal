package com.example.fragmentassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static String checkTag = "Main";
    Fragment fragment = null;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button timeButton = findViewById(R.id.time);
        Button dateButton = findViewById(R.id.date);
        Button batteryButton = findViewById(R.id.battery);

        if(savedInstanceState == null)
            replaceFragment(new FragmentActivity(), "Assign");


        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!(fragment instanceof FragmentTime))
                    checkInstance();

                fragment = new FragmentTime();
                replaceFragment(fragment,"time");

            }
        });

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(fragment instanceof FragmentDate))
                    checkInstance();
                fragment = new FragmentDate();
                replaceFragment(fragment,"date");

            }
        });

        batteryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!(fragment instanceof FragmentBattery))
                    checkInstance();
                fragment = new FragmentBattery();
                replaceFragment(fragment,"battery");

            }
        });

    }

    private void replaceFragment(Fragment fragment, String tag) {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if(tag.equals("Assign")){
            fragmentTransaction.add(R.id.framelayout,fragment);

        }else if(!tag.equals(checkTag)){
            fragmentTransaction.replace(R.id.framelayout,fragment);
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
        checkTag=tag;
    }

    private void checkInstance(){
        if(fragment instanceof FragmentTime){
            showToast("Hiding Show Time screen");
        }else if(fragment instanceof FragmentDate){
            showToast("Hiding Show Date screen");
        }else if(fragment instanceof  FragmentBattery){
            showToast("Hiding Show Battery Percentage screen");
        }
    }

    private void showToast(String msg){
        CharSequence text = "";
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        text = msg;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}