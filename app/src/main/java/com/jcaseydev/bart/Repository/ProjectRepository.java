package com.jcaseydev.bart.Repository;

import androidx.lifecycle.MutableLiveData;
import com.jcaseydev.bart.ApiInterface;
import com.jcaseydev.bart.Model2.Stations.StationList;
import com.jcaseydev.bart.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectRepository {

  private ApiInterface apiInterface;

  public ProjectRepository() {
  }

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

      }
    });

    return stationList;
  }

}
