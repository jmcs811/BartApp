package com.jcaseydev.bart;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import com.jcaseydev.bart.DAO.StationDao;
import com.jcaseydev.bart.Model2.Stations.Station;
import com.jcaseydev.bart.TypeConverters.DateConverter;

@Database(entities = {Station.class}, version = 1)
@TypeConverters(DateConverter.class)
abstract class StationDatabase extends RoomDatabase {
  public abstract StationDao stationDao();

}
