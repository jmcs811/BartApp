package com.jcaseydev.bart;


import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.gson.GsonBuilder;
import com.jcaseydev.bart.Model2.Arrivals.TrainArrival;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ClosestStationFragment extends Fragment {

    private static final int REQUEST_LOCATION = 1;
    private static final int DIALOG_PERMISSION_REASON = 2;

    TrainArrival testRoot = new TrainArrival();
    private ApiInterface mService = RetrofitClient.getClient().create(ApiInterface.class);
    private FusedLocationProviderClient fusedLocationProviderClient;
    private Location currentLocation;
    private LocationCallback locationCallback;
    private RecyclerView recyclerView;
    private ArrivalsAdapter arrivalsAdapter;

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
        recyclerView = v.findViewById(R.id.arrivals_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));

        mService.getData().enqueue(new Callback<TrainArrival>() {
            @Override
            public void onResponse(Call<TrainArrival> call, Response<TrainArrival> response) {
                if (response.isSuccessful()) {
                    testRoot = response.body();
                    testTextView.setText(testRoot.getRoot().getStation().get(0).getName());
                    arrivalsAdapter = new ArrivalsAdapter(getContext(), testRoot.getRoot().getStation().get(0).getEtd());
                    recyclerView.setAdapter(arrivalsAdapter);
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