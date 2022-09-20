package com.example.fragactcommu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FragmentUserA extends Fragment implements FragmentDialogue.FragmentToFragmentListener {
    FragmentUserA fragmentUserA;
    EditText fragmentA_edittext;
    TextView outputtext;
    Button fragmentA_button;
    FragmentDialogue fragmentDialogue;
    public FragmentUserA() {
        // Required empty public constructor
    }


    public static FragmentUserA newInstance() {
        FragmentUserA fragment = new FragmentUserA();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_fragment_user_a, container, false);
        outputtext = view.findViewById(R.id.fragmentATextview);
        fragmentA_button = view.findViewById(R.id.fragmentAButton);
        fragmentA_edittext = view.findViewById(R.id.fragmentAEditText);


        fragmentA_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentDialogue fragmentDialogue = new FragmentDialogue();
                fragmentDialogue.setTargetFragment(FragmentUserA.this,1);
                fragmentDialogue.show(getFragmentManager(),"userA");
            }
        });
        return view;
    }

    public void receiveMessageA(CharSequence textMessage){
        outputtext.setText("");
        outputtext.setText(textMessage);
    }

    @Override
    public CharSequence receiveMessage() {
        CharSequence opText = fragmentA_edittext.getText();;
        fragmentA_edittext.setText("");
        return opText;
    }

}