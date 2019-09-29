package com.example.gymapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Activity implements Parcelable{

    private String actionName;
    private String imgurl;
    private String desciption;
    private int min;
    private Boolean check=false;

    public Activity(String actionName, String imgurl, String desciption) {
        this.actionName = actionName;
        this.imgurl = imgurl;
        this.desciption = desciption;
    }

    public Activity(){
    }

    protected Activity(Parcel in) {
        actionName = in.readString();
        imgurl = in.readString();
        desciption = in.readString();
        min = in.readInt();
    }

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

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }


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

    @Override
    public String toString() {
        return "Activity{" +
                "actionName='" + actionName + '\'' +
                ", imgurl='" + imgurl + '\'' +
                ", desciption='" + desciption + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(actionName);
        parcel.writeString(imgurl);
        parcel.writeString(desciption);
        parcel.writeInt(min);
    }
}
