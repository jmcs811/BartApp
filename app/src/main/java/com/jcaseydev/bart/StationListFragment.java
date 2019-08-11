package com.jcaseydev.bart;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.jcaseydev.bart.Adapters.StationListAdapter;
import com.jcaseydev.bart.Model2.Stations.Station;
import com.jcaseydev.bart.ViewModels.StationListViewModel;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class StationListFragment extends Fragment {

  private RecyclerView stationRecyclerView;
  private StationListAdapter stationAdapter;
  private StationListViewModel stationViewModel;
  private List<Station> stations = new ArrayList<>();

  public StationListFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    final View v = inflater.inflate(R.layout.fragment_station_list, container, false);

    // Set up RecyclerView
    stationRecyclerView = v.findViewById(R.id.station_list_recycler);
    stationRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    stationRecyclerView.setHasFixedSize(true);
    stationRecyclerView.addItemDecoration(new DividerItemDecoration(
        stationRecyclerView.getContext(),
        DividerItemDecoration.VERTICAL
    ));

    stationAdapter = new StationListAdapter(getContext(), stations);
    stationRecyclerView.setAdapter(stationAdapter);

    return v;
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    // Use ViewModel to get data
    stationViewModel = ViewModelProviders.of(this).get(StationListViewModel.class);
    stationViewModel.init();
    stationViewModel.getStationList().observe(this, stationList -> {
      stations.addAll(stationList.getStations());
      stationAdapter.notifyDataSetChanged();
    });
  }
}
