package com.example.gymapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "AllActivities")
public class Activity implements Parcelable{

    @NonNull
    @PrimaryKey
    private String actionName;
    private String imgurl;
    private String desciption;



    @Ignore
    public Activity(){
    }

    public Activity(@NonNull String actionName, String imgurl, String desciption) {
        this.actionName = actionName;
        this.imgurl = imgurl;
        this.desciption = desciption;
    }

    @Ignore
    protected Activity(Parcel in) {
        actionName = in.readString();
        imgurl = in.readString();
        desciption = in.readString();
    }

    @Ignore
    public static final Creator<Activity> CREATOR = new Creator<Activity>() {
        @Override
        public Activity createFromParcel(Parcel in) {
            return new Activity(in);
        }

        @Override
        public Activity[] newArray(int size) {
            return new Activity[size];
        }
    };

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    @Ignore
    @Override
    public String toString() {
        return "Activity{" +
                "actionName='" + actionName + '\'' +
                ", imgurl='" + imgurl + '\'' +
                ", desciption='" + desciption + '\'' +
                '}';
    }

    @Ignore
    @Override
    public int describeContents() {
        return 0;
    }

    @Ignore
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(actionName);
        parcel.writeString(imgurl);
        parcel.writeString(desciption);
    }
}
