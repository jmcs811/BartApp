package com.jcaseydev.bart;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.jcaseydev.bart.Model2.Fare.FareCost;
import com.jcaseydev.bart.Model2.Fare.Root;
import com.jcaseydev.bart.Model2.Stations.Station;
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

  public FareFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View v = inflater.inflate(R.layout.fragment_fare, container, false);

    Spinner orginSpinner = v.findViewById(R.id.origin_spinner);
    Spinner destSpinner = v.findViewById(R.id.destination_spinner);

    ApiInterface apiInterface = RetrofitClient.getClient().create(ApiInterface.class);
    Call<FareCost> call = apiInterface.getFares();
    call.enqueue(new Callback<FareCost>() {
      @Override
      public void onResponse(Call<FareCost> call, Response<FareCost> response) {
        if (response.isSuccessful()) {
          fareCost = response.body();
          float fare = Float.valueOf(fareCost.getFare());
          TextView oneWay = v.findViewById(R.id.one_way_fare);
          TextView roundTrip = v.findViewById(R.id.round_trip_fare);
          oneWay.setText(getContext().getString(R.string.one_way_fare_cost, fareCost.getFare()));
          roundTrip.setText(getContext().getString(R.string.round_trip_fare_cost, String.valueOf(fare*2)));
        } else {
          Log.d("TAG ELSE: ", response.toString());
        }
      }

      @Override
      public void onFailure(Call<FareCost> call, Throwable t) {
        Log.d("TAG FAILURE: ", t.getMessage());
      }
    });

    return v;
  }

}
