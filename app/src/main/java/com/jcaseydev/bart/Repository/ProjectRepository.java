package com.jcaseydev.bart.Repository;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.jcaseydev.bart.ApiInterface;
import com.jcaseydev.bart.Model2.Arrivals.TrainArrival;
import com.jcaseydev.bart.Model2.Fare.FareCost;
import com.jcaseydev.bart.Model2.Stations.StationList;
import com.jcaseydev.bart.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectRepository {

  private ApiInterface apiInterface;

  public ProjectRepository() {
  }

  // Method to get list of train stations
  public MutableLiveData<StationList> getStations() {
    final MutableLiveData<StationList> stationList = new MutableLiveData<>();
    apiInterface = RetrofitClient.getClient().create(ApiInterface.class);
    Call<StationList> call = apiInterface.getStations();
    call.enqueue(new Callback<StationList>() {
      @Override
      public void onResponse(Call<StationList> call, Response<StationList> response) {
        if (response.isSuccessful()) {
          stationList.setValue(response.body());
        }
      }

      @Override
      public void onFailure(Call<StationList> call, Throwable t) {
        Log.d("STATIONS FAIL", t.getMessage());
      }
    });
    return stationList;
  }


  // method to get list of arrivals
  public MutableLiveData<TrainArrival> getTrainArrivals() {
    final MutableLiveData<TrainArrival> trainArrivals = new MutableLiveData<>();
    apiInterface = RetrofitClient.getClient().create(ApiInterface.class);
    Call<TrainArrival> call = apiInterface.getArrivals("19TH");
    call.enqueue(new Callback<TrainArrival>() {
      @Override
      public void onResponse(Call<TrainArrival> call, Response<TrainArrival> response) {
        if (response.isSuccessful()) {
          trainArrivals.setValue(response.body());
        }
      }

      @Override
      public void onFailure(Call<TrainArrival> call, Throwable t) {
        Log.d("ARRIVALS FAIL", t.getMessage());
      }
    });

    return trainArrivals;
  }

  public MutableLiveData<FareCost> getFareCost(String orig, String dest) {
    final MutableLiveData<FareCost> fareCost = new MutableLiveData<>();
    apiInterface = RetrofitClient.getClient().create(ApiInterface.class);
    Call<FareCost> call = apiInterface.getFares(orig, dest);
    call.enqueue(new Callback<FareCost>() {
      @Override
      public void onResponse(Call<FareCost> call, Response<FareCost> response) {
        if (response.isSuccessful()) {
          fareCost.setValue(response.body());
        }
      }

      @Override
      public void onFailure(Call<FareCost> call, Throwable t) {
        Log.d("FARES FAIL", t.getMessage());
      }
    });

    return fareCost;
  }
}
