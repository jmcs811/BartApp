package com.jcaseydev.bart.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jcaseydev.bart.Model2.Arrivals.TrainArrival
import com.jcaseydev.bart.Repository.ProjectRepository

class TrainArrivalViewModel : ViewModel() {

    var trainArrivals: MutableLiveData<TrainArrival>? = null
        private set
    private val repo: ProjectRepository = ProjectRepository()

    fun init() {
        if (this.trainArrivals != null) {
            return
        }
        trainArrivals = repo.trainArrivals
    }

}
