package com.example.gymapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface AllActivityDAO {

    @Insert
    void insert(Activity activity);

    @Query("SELECT * FROM AllActivities")
    List<Activity> getAllActivities();

    @Query("SELECT * FROM AllActivities")
    LiveData<List<Activity>> getLiveAllActivities();

}
