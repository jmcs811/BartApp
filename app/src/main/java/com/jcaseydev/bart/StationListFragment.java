package com.jcaseydev.bart;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.jcaseydev.bart.Adapters.StationListAdapter;
import com.jcaseydev.bart.Model2.Stations.Station;
import com.jcaseydev.bart.Model2.Stations.StationList;
import com.jcaseydev.bart.ViewModels.StationListViewModel;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class StationListFragment extends Fragment {

  private StationList testList;
  private RecyclerView recyclerView;
  private StationListAdapter adapter;
  private StationListViewModel viewModel;
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
    recyclerView = v.findViewById(R.id.station_list_recycler);
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    recyclerView.setHasFixedSize(true);
    recyclerView.addItemDecoration(new DividerItemDecoration(
        recyclerView.getContext(),
        DividerItemDecoration.VERTICAL
    ));

    adapter = new StationListAdapter(getContext(), stations);
    recyclerView.setAdapter(adapter);

    return v;
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    viewModel = ViewModelProviders.of(this).get(StationListViewModel.class);
    viewModel.init();
    viewModel.getStationList().observe(this, new Observer<StationList>() {
      @Override
      public void onChanged(StationList stationList) {
        stations.addAll(stationList.getRoot().getStations().getStation());
        adapter.notifyDataSetChanged();
      }
    });
  }
}
