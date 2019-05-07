package com.jcaseydev.bart;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jcaseydev.bart.Model.Root;
import com.jcaseydev.bart.Model.Station;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ClosestStationFragment extends Fragment {

    List<Station> stations;
    private TextView mTextView;

    private ApiInterface mService;

    public ClosestStationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mService = ApiUtils.getApiInterface();
        mService.getData().enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                if (response.isSuccessful()) {
                    stations = response.body().getStation();
                    Log.d("TAG", "posts loaded");
                } else {
                    int statusCode = response.code();
                    Log.d("TAG", Integer.toString(statusCode));
                }
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                Log.d("TAG", t.getMessage());
            }
        });


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_closest_station, container, false);

        if (stations == null) {
            Log.d("TAG", "stations is null");
        } else {
            for (int i = 0; i < stations.size(); i++) {
                Log.d("TAG", stations.get(i).toString());
            }
        }
        return v;
    }
}
