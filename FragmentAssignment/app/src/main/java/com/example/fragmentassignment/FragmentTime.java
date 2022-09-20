package com.example.fragmentassignment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FragmentTime extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String curTime;
    private String mParam1;
    private String mParam2;

    public FragmentTime() {
    }

    public static FragmentTime newInstance(String param1) {
        FragmentTime fragment = new FragmentTime();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("time",curTime);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.activity_fragment_time, container, false);
        TextView text=view.findViewById(R.id.textView);
        if(savedInstanceState!=null && savedInstanceState.getString("time")!=null){

            curTime = savedInstanceState.getString("time");

        }else{
            Calendar c = Calendar.getInstance();
            SimpleDateFormat date= new SimpleDateFormat("HH:mm:ss");
            String dt = date.format(c.getTime());

            curTime = dt;
        }
        text.setText(curTime);
        return view;
    }
}