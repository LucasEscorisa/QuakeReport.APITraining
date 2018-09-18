package com.example.android.quakereport;

public class Earthquake {

    private String mMagnitude, mLocation, mDate;

    public Earthquake(String Magnitude, String Location, String Date){
        mMagnitude = Magnitude;
        mLocation = Location;
        mDate = Date;
    }

    public String getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public String getDate() {
        return mDate;
    }
}
