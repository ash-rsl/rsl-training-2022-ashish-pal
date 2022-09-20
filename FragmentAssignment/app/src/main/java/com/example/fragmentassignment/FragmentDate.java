package com.example.fragmentassignment;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FragmentDate extends Fragment {

    private static final String ARG_PARAM1 = "param1";



    private String mParam1;

    public FragmentDate() {
        // Required empty public constructor
    }


    public static FragmentDate newInstance(String param1) {
        FragmentDate fragment = new FragmentDate();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_fragment_date, container, false);
        TextView text=view.findViewById(R.id.textView);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat date= new SimpleDateFormat("yyyy-MM-dd");
        String dt = date.format(c.getTime());
        text.setText(dt);
        return view;
    }
}