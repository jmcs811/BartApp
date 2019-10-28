package com.jcaseydev.bart.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jcaseydev.bart.Model2.Stations.StationList
import com.jcaseydev.bart.Repository.ProjectRepository

class StationListViewModel : ViewModel() {

    var stationList: LiveData<StationList>? = null
        private set
    private val repo: ProjectRepository = ProjectRepository()

    fun init() {
        if (this.stationList != null) {
            return
        }
        stationList = repo.stations
    }
}
