package com.jcaseydev.bart.ViewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.jcaseydev.bart.Model2.Arrivals.TrainArrival;
import com.jcaseydev.bart.Repository.ProjectRepository;

public class TrainArrivalViewModel extends ViewModel {

  private MutableLiveData<TrainArrival> trainArrivals;
  private ProjectRepository repo;

  public TrainArrivalViewModel() {
    repo = new ProjectRepository();
  }

  public void init() {
    if (this.trainArrivals != null) {
      return;
    }
    trainArrivals = repo.getTrainArrivals();
  }

  public MutableLiveData<TrainArrival> getTrainArrivals() {
    return this.trainArrivals;
  }

}
