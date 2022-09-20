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

public class FragmentUserB extends Fragment implements FragmentDialogue.FragmentToFragmentListener{

    FragmentUserB fragmentUserB;
    EditText fragmentB_edittext;
    TextView outputtext;
    UserBFragmentInterface userBFragmentInterface;
    Button fragmentB_button;
    FragmentDialogue fragmentDialogue;

    public FragmentUserB() {
        // Required empty public constructor
    }


    public static FragmentUserB newInstance() {
        FragmentUserB fragment = new FragmentUserB();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    public interface UserBFragmentInterface{
        void sendTextB(CharSequence textInput);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_fragment_user_b, container, false);
        outputtext = view.findViewById(R.id.fragmentBTextview);
        fragmentB_edittext = view.findViewById(R.id.fragmentBEditText);
        fragmentB_button = view.findViewById(R.id.fragmentBButton);

        fragmentB_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentDialogue fragmentDialogue = new FragmentDialogue();
                fragmentDialogue.setTargetFragment(FragmentUserB.this,2);
                fragmentDialogue.show(getFragmentManager(),"userB");
            }
        });
        return view;
    }

    @Override
    public CharSequence receiveMessage() {
        CharSequence optext = fragmentB_edittext.getText();
        fragmentB_edittext.setText("");
        return optext;
    }

    public void receiveMessageB(CharSequence textMessage){
        outputtext.setText("");
        outputtext.setText(textMessage);
    }


}