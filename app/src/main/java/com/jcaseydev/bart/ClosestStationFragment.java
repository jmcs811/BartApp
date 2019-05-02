package com.jcaseydev.bart;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class ClosestStationFragment extends Fragment {
    private TextView originStation;
    private TextView destinationStation;

    public ClosestStationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_closest_station, container, false);

        originStation = v.findViewById(R.id.origin_textview);
        destinationStation = v.findViewById(R.id.destination_textview);

        return v;
    }
}
