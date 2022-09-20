package com.example.fragactcommu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements  FragmentDialogue.FragmentToActivityListener{
    FragmentUserA fragmentUserA;
    FragmentUserB fragmentUserB;

    FragmentDialogue fragmentDialogue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragmentUserA = new FragmentUserA();
        fragmentUserB = new FragmentUserB();
        fragmentDialogue = new FragmentDialogue();

        FragmentManager fragmentManager=getSupportFragmentManager();

        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentALayout,fragmentUserA);
        fragmentTransaction.replace(R.id.fragmentBLayout,fragmentUserB);
        fragmentTransaction.commit();



    }

    @Override
    public void sendMessageToA(CharSequence inputText) {
        fragmentUserA.receiveMessageA(inputText);
    }

    @Override
    public void sendMessageToB(CharSequence inputText) { fragmentUserB.receiveMessageB(inputText);}



}