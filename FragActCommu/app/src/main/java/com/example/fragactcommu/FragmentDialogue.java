package com.example.fragactcommu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentDialogue extends DialogFragment {

    CharSequence outputText;
    FragmentToFragmentListener fragmentToFragmentListener;
    FragmentToActivityListener fragmentToActivityListener;
    CharSequence OutputText;
    Button cancelButton;
    Button okButton;
    TextView dialogTextview;
    public FragmentDialogue() {
        // Required empty public constructor
    }

    public interface FragmentToFragmentListener{
        public CharSequence receiveMessage();
    }

    public interface FragmentToActivityListener{
        public void sendMessageToA(CharSequence inputText);
        public void sendMessageToB(CharSequence inputText);

    }


    public static FragmentDialogue newInstance() {
        FragmentDialogue fragment = new FragmentDialogue();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }



    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.activity_fragment_dialogue, container, false);
        cancelButton = view.findViewById(R.id.cancelButton);
        okButton=view.findViewById(R.id.okButton);
        dialogTextview = view.findViewById(R.id.dialogTextView);

        outputText=fragmentToFragmentListener.receiveMessage();
        dialogTextview.setText("Want to send message: "+outputText);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(fragmentToFragmentListener instanceof FragmentUserA){
                    fragmentToActivityListener.sendMessageToB(outputText);
                }else if(fragmentToFragmentListener instanceof FragmentUserB){
                    fragmentToActivityListener.sendMessageToA(outputText);
                }
                dismissDialog();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismissDialog();
            }
        });
        return view;
    }

    private void dismissDialog(){
        this.dismiss();
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            fragmentToFragmentListener=(FragmentDialogue.FragmentToFragmentListener)getTargetFragment();
            fragmentToActivityListener=(FragmentDialogue.FragmentToActivityListener)context;
        }catch (Exception e){

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentToFragmentListener=null;
        fragmentToFragmentListener=null;
    }
}