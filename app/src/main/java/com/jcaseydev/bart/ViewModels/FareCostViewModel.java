package com.jcaseydev.bart.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.jcaseydev.bart.Model2.Fare.FareCost;
import com.jcaseydev.bart.Repository.ProjectRepository;

public class FareCostViewModel extends ViewModel {

  private LiveData<FareCost> fareCostLiveData;
  private ProjectRepository repo;

  public FareCostViewModel() {
    repo = new ProjectRepository();
  }

//  public void init() {
//    if (this.fareCostLiveData != null) {
//      return;
//    }
//    fareCostLiveData = repo.getFareCost();
//  }

}
