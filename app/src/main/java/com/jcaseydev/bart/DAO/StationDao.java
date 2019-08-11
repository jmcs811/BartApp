package com.jcaseydev.bart.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.jcaseydev.bart.Model2.Stations.Station;
import java.util.Date;
import java.util.List;

@Dao
public interface StationDao {

  @Query("SELECT * FROM station")
  LiveData<Station> getAllStations();

  @Insert
  void insertAll(List<Station> stations);

  @Delete
  void delete(Station station);

  @Query("SELECT * FROM station WHERE lastRefresh > :lastRefreshMax LIMIT 1")
  Station hasStation(Date lastRefreshMax);

}
