package com.jcaseydev.bart;


import android.os.Bundle;

import android.util.Log;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.GsonBuilder;
import com.jcaseydev.bart.Model2.Stations.StationList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class StationListFragment extends Fragment {

  private StationList testList;
  private RecyclerView recyclerView;
  private StationListAdapter adapter;

  public StationListFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    final View v = inflater.inflate(R.layout.fragment_station_list, container, false);

    // Set up RecyclerView
    recyclerView = v.findViewById(R.id.station_list_recycler);
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    recyclerView.setHasFixedSize(true);
    recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));

    // Make API call with retrofit
    ApiInterface service = RetrofitClient.getClient().create(ApiInterface.class);
    Call<StationList> call = service.getStations();
    call.enqueue(new Callback<StationList>() {
      @Override
      public void onResponse(Call<StationList> call, Response<StationList> response) {
        // populate recycler view with the list of stations.
        if (response.isSuccessful()) {
          testList = response.body();
          adapter = new StationListAdapter(getContext(), testList.getRoot().getStations().getStation());
          recyclerView.setAdapter(adapter);
          Log.d("TAG: RESPONSE", new GsonBuilder().setPrettyPrinting().create().toJson(response));
        } else {
          int statusCode = response.code();
          Log.d("TAG: STATUSCODE", Integer.toString(statusCode));
        }
      }

      @Override
      public void onFailure(Call<StationList> call, Throwable t) {
        Log.d("TAG: FAILURE", t.getMessage());
      }
    });

    return v;
  }
}
