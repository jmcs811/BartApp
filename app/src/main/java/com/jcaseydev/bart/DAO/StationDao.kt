package com.jcaseydev.bart.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.jcaseydev.bart.Model2.Stations.Station
import java.util.Date

@Dao
interface StationDao {

    @get:Query("SELECT * FROM station")
    val allStations: LiveData<Station>

    @Insert
    fun insertAll(stations: List<Station>)

    @Delete
    fun delete(station: Station)

    @Query("SELECT * FROM station WHERE lastRefresh > :lastRefreshMax LIMIT 1")
    fun hasStation(lastRefreshMax: Date): Station

}
