package com.example.gymapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "setActivities")
public class setActivities implements Parcelable {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int _id;
    private String actionName;
    private String imgurl;
    private String desciption;
    private int min;
    private String day;
    private Boolean check=false;

    public setActivities(String actionName, String imgurl, String desciption, int min, String day, Boolean check) {
        this.actionName = actionName;
        this.imgurl = imgurl;
        this.desciption = desciption;
        this.min = min;
        this.day = day;
        this.check = check;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
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

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }

    public static Creator<setActivities> getCREATOR() {
        return CREATOR;
    }

    @Ignore
    public setActivities(){}

    @Ignore
    protected setActivities(Parcel in) {
        _id = in.readInt();
        actionName = in.readString();
        imgurl = in.readString();
        desciption = in.readString();
        min = in.readInt();
        day = in.readString();
        byte tmpCheck = in.readByte();
        check = tmpCheck == 0 ? null : tmpCheck == 1;
    }

    @Ignore
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_id);
        dest.writeString(actionName);
        dest.writeString(imgurl);
        dest.writeString(desciption);
        dest.writeInt(min);
        dest.writeString(day);
        dest.writeByte((byte) (check == null ? 0 : check ? 1 : 2));
    }

    @Ignore
    @Override
    public int describeContents() {
        return 0;
    }

    @Ignore
    public static final Creator<setActivities> CREATOR = new Creator<setActivities>() {
        @Override
        public setActivities createFromParcel(Parcel in) {
            return new setActivities(in);
        }

        @Override
        public setActivities[] newArray(int size) {
            return new setActivities[size];
        }
    };
}
