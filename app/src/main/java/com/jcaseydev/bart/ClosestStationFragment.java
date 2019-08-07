package com.jcaseydev.bart;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.gson.GsonBuilder;
import com.jcaseydev.bart.Model.TrainArrival;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ClosestStationFragment extends Fragment {

    TrainArrival testRoot = new TrainArrival();
    private ApiInterface mService = RetrofitClient.getClient().create(ApiInterface.class);

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

        final TextView testTextView = v.findViewById(R.id.origin_textview);

        mService.getData().enqueue(new Callback<TrainArrival>() {
            @Override
            public void onResponse(Call<TrainArrival> call, Response<TrainArrival> response) {
                if (response.isSuccessful()) {
                    testRoot = response.body();
                    testTextView.setText(testRoot.getRoot().getStation().get(0).getName());
                    Log.d("TAG: RESPONSE", new GsonBuilder().setPrettyPrinting().create().toJson(response));
                } else {
                    int statusCode = response.code();
                    Log.d("TAG: STATUS CODE", Integer.toString(statusCode));
                }
            }

            @Override
            public void onFailure(Call<TrainArrival> call, Throwable t) {
                Log.d("TAG: FAILURE", t.getMessage());
            }
        });

        return v;
    }
}