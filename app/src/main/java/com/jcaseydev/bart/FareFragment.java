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
  private Button getFareButton;
  private TextView oneWay;
  private TextView roundTrip;

  public FareFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View v = inflater.inflate(R.layout.fragment_fare, container, false);

    Spinner originSpinner = v.findViewById(R.id.origin_spinner);
    Spinner destSpinner = v.findViewById(R.id.destination_spinner);

    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
        getContext(),
        R.array.sations_list,
        R.layout.support_simple_spinner_dropdown_item);

    adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
    destSpinner.setAdapter(adapter);
    originSpinner.setAdapter(adapter);

    oneWay = v.findViewById(R.id.one_way_fare);
    roundTrip = v.findViewById(R.id.round_trip_fare);

    getFareButton = v.findViewById(R.id.calculate_fares);
    getFareButton.setOnClickListener(v1 -> getFares(originSpinner, destSpinner));

    return v;
  }

  private void getFares(Spinner originSpinner, Spinner destSpinner) {
    ApiInterface apiInterface = RetrofitClient.getClient().create(ApiInterface.class);
    Call<FareCost> call = apiInterface.getFares(
        "EMBR",
        "NCON"
    );
    call.enqueue(new Callback<FareCost>() {
      @Override
      public void onResponse(Call<FareCost> call, Response<FareCost> response) {
        if (response.isSuccessful()) {
          fareCost = response.body();
          float fare = Float.valueOf(fareCost.getFare());
          oneWay.setText(getContext()
              .getString(R.string.one_way_fare_cost, fareCost.getFare())
          );

          roundTrip.setText(getContext()
              .getString(R.string.round_trip_fare_cost, String.valueOf(fare * 2))
          );
        } else {
          Log.d("TAG ELSE: ", response.toString());
        }
      }

      @Override
      public void onFailure(Call<FareCost> call, Throwable t) {
        Log.d("TAG FAILURE: ", t.getMessage());
      }
    });
  }
}
