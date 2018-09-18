package com.example.android.quakereport;

public class Earthquake {

    private double mMagnitude;
    private String mLocation, mUrl;
    private long mTimeInMilliseconds;

    public Earthquake(double Magnitude, String Location, long Date, String Url){
        mMagnitude = Magnitude;
        mLocation = Location;
        mTimeInMilliseconds = Date;
        mUrl = Url;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public long getDate() {
        return mTimeInMilliseconds;
    }

    public String getUrl() {
        return mUrl;
    }
}
