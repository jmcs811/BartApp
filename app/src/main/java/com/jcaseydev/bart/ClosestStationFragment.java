package com.jcaseydev.bart;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.jcaseydev.bart.Adapters.ArrivalsAdapter;
import com.jcaseydev.bart.Model2.Arrivals.Etd;
import com.jcaseydev.bart.ViewModels.TrainArrivalViewModel;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ClosestStationFragment extends Fragment {

  private RecyclerView arrivalsRecyclerView;
  private ArrivalsAdapter arrivalsAdapter;
  private TrainArrivalViewModel arrivalsViewModel;
  private List<Etd> arrivals = new ArrayList<>();
  private TextView testTextView;

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

    testTextView = v.findViewById(R.id.origin_textview);
    arrivalsRecyclerView = v.findViewById(R.id.arrivals_recyclerview);
    arrivalsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    arrivalsRecyclerView.setHasFixedSize(true);
    arrivalsRecyclerView.addItemDecoration(
        new DividerItemDecoration(arrivalsRecyclerView.getContext(),
            DividerItemDecoration.VERTICAL)
    );
    arrivalsAdapter = new ArrivalsAdapter(getContext(), arrivals);
    arrivalsRecyclerView.setAdapter(arrivalsAdapter);

    return v;
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    arrivalsViewModel = ViewModelProviders.of(this).get(TrainArrivalViewModel.class);
    arrivalsViewModel.init();
    arrivalsViewModel.getTrainArrivals().observe(this, trainArrival -> {
      testTextView.setText(trainArrival.getRoot().getStation().get(0).getName());
      arrivals.addAll(trainArrival.getRoot().getStation().get(0).getEtd());
      arrivalsAdapter.notifyDataSetChanged();
    });
  }
}