package com.jcaseydev.bart.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.jcaseydev.bart.Model2.Stations.StationList;
import com.jcaseydev.bart.Repository.ProjectRepository;

public class StationListViewModel extends ViewModel {

  private LiveData<StationList> stationList;
  private ProjectRepository repo;

  public StationListViewModel() {
    repo = new ProjectRepository();
  }

  public void init() {
    if (this.stationList != null) {
      return;
    }
    stationList = repo.getStations();
  }

  public LiveData<StationList> getStationList() {
    return this.stationList;
  }
}
