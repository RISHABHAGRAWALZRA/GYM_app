package com.example.gymapp;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Utility {

    private static List<Activity> AllActivities;
    private static List<setActivities> setActivities;

    public static List<com.example.gymapp.setActivities> getActivity() {
        return activity;
    }

    public static void setActivity(List<com.example.gymapp.setActivities> activity) {
        Utility.activity = activity;
    }

    public static void removeActivity(setActivities setactivities){
        activity.remove(setactivities);
    }

    private static List<setActivities> activity;

    private static Context context;

    public static void setContext(Context context) {
        Utility.context = context;
    }

    private static ActivityDatabase db;

    public static ActivityDatabase getDb() {
        return db;
    }

    public static void initDatabase(){
        db=ActivityDatabase.getInstance(context);
    }

    public static int noOfActivitiesplanned=0;

    public static List<Activity> getAllActivities() {
        return AllActivities;
    }

    public static void setAllActivities(List<Activity> allActivities) {
        AllActivities = allActivities;
    }

    public static List<com.example.gymapp.setActivities> getSetActivities() {
        return setActivities;
    }

    public static void setSetActivities(List<com.example.gymapp.setActivities> setActivities) {
        Utility.setActivities = setActivities;
    }


    public static void addsetActivity(setActivities setactivities){
        setActivities.add(setactivities);
    }

    public static void removesetActivity(setActivities setactivities){
        setActivities.remove(setactivities);
    }
}
