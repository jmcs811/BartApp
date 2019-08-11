package com.jcaseydev.bart;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.jcaseydev.bart.Model2.Fare.FareCost;
import com.jcaseydev.bart.Model2.Fare.Root;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class FareFragment extends Fragment {


  private FareCost fareCost;
  private Root rootFare;

  public FareFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View v = inflater.inflate(R.layout.fragment_fare, container, false);

    ApiInterface apiInterface = RetrofitClient.getClient().create(ApiInterface.class);
    Call<FareCost> call = apiInterface.getFares();
    call.enqueue(new Callback<FareCost>() {
      @Override
      public void onResponse(Call<FareCost> call, Response<FareCost> response) {
        if (response.isSuccessful()) {
          fareCost = response.body();
          TextView test = v.findViewById(R.id.fare_cost);
          TextView origin = v.findViewById(R.id.origin);
          TextView dest = v.findViewById(R.id.dest);
          test.setText(getContext().getString(R.string.fare_cost, fareCost.getFare()));
          origin.setText(fareCost.getOrigin());
          dest.setText(fareCost.getDestination());
        } else {
          Log.d("TAG ELSE: ", response.toString());
        }
      }

      @Override
      public void onFailure(Call<FareCost> call, Throwable t) {
        Log.d("TAG FAILUER: ", t.getMessage());
      }
    });

    return v;
  }

}
