package com.example.gymapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface setActivitiesDAO {

    @Insert
    void insert(setActivities setActivities1);

    @Delete
    void delete(setActivities setActivities1);

    @Query("DELETE FROM setActivities WHERE day=:day AND actionName=:actionName")
    void deletebyname(String actionName,String day);

    @Query("UPDATE setActivities SET `check`=:check WHERE actionName=:actionName AND day=:day" )
    void updatecheck(String day,Boolean check,String actionName);


    @Query("SELECT * FROM setActivities")
    List<setActivities> getsetActivities();

}
