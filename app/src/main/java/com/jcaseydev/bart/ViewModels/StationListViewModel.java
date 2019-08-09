package com.jcaseydev.bart.ViewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.jcaseydev.bart.Model2.Stations.StationList;
import com.jcaseydev.bart.Repository.ProjectRepository;

public class StationListViewModel extends ViewModel {

  private MutableLiveData<StationList> stationList;
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

  public MutableLiveData<StationList> getStationList() {
    return this.stationList;
  }
}
