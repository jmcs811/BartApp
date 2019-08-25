package com.jcaseydev.bart;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;
import com.jcaseydev.bart.Adapters.StationListAdapter;
import com.jcaseydev.bart.Model2.Fare.FareCost;
import com.jcaseydev.bart.Model2.Fare.Root;
import com.jcaseydev.bart.Model2.Stations.Station;
import com.jcaseydev.bart.Model2.Stations.StationList;
import com.jcaseydev.bart.Repository.ProjectRepository;
import com.jcaseydev.bart.ViewModels.StationListViewModel;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class FareFragment extends Fragment {


  private FareCost fareCost;
  private Root rootFare;
  private List<Station> stations = new ArrayList<>();
  private StationListViewModel stationViewModel;
  private Button getFareButton;
  private TextView oneWay;
  private TextView roundTrip;
  private ArrayAdapter<Station> adapter;
  private Spinner originSpinner;
  private Spinner destSpinner;


  public FareFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View v = inflater.inflate(R.layout.fragment_fare, container, false);

    originSpinner = v.findViewById(R.id.origin_spinner);
    destSpinner = v.findViewById(R.id.destination_spinner);

    oneWay = v.findViewById(R.id.one_way_fare);
    roundTrip = v.findViewById(R.id.round_trip_fare);

    getFareButton = v.findViewById(R.id.calculate_fares);
    getFareButton.setOnClickListener(v1 -> getFares(originSpinner, destSpinner));

    return v;
  }

  private void getFares(Spinner originSpinner, Spinner destSpinner) {
    // TODO: get spinner to work properly!!!
    ProjectRepository projectRepository = new ProjectRepository();
    LiveData<FareCost> fareCostLiveData;

    fareCostLiveData = projectRepository.getFareCost("NCON", "EMBR");

    //oneWay.setText(fareCostLiveData.getValue().getFare());
    //roundTrip.setText(String.valueOf(Float.valueOf(fareCostLiveData.getValue().getFare()) * 2));
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    // Use ViewModel to get data
    stationViewModel = ViewModelProviders.of(this).get(StationListViewModel.class);
    stationViewModel.init();
    stationViewModel.getStationList().observe(
        this,
        stationList -> stations.addAll(stationList.getStations())
    );

    adapter = new ArrayAdapter<>(
        getContext(),
        android.R.layout.simple_spinner_item,
        stations
    );
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    destSpinner.setAdapter(adapter);
    originSpinner.setAdapter(adapter);
  }
}
