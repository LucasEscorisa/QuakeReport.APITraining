package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOG_TAG = EarthquakeAdapter.class.getSimpleName();

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes){
        super(context, 0, earthquakes);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }




        Earthquake currentEarthquake = getItem(position);

        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        DecimalFormat roundedMag = new DecimalFormat("0.0");
        String output = roundedMag.format(currentEarthquake.getMagnitude());
        magnitudeView.setText(output);

        String location = currentEarthquake.getLocation();
        TextView distanceView = (TextView) listItemView.findViewById(R.id.distance);
        String distance = splitDistance(location);
        distanceView.setText(distance);
        TextView locationView = (TextView) listItemView.findViewById(R.id.location);
        String place = splitLocation(location);
        locationView.setText(place);

        Date dateObject = new Date(currentEarthquake.getDate());
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        String formattedDate = formatDate(dateObject);
        dateView.setText(formattedDate);

        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        timeView.setText(formattedTime);

        return listItemView;

    }

    private String formatDate(Date dateObject){
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject){
        SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm a");
        return dateFormat.format(dateObject);
    }

    private String splitDistance(String location){
        String part;

        if (location.contains("of")) {

            String[] parts = location.split("of");
            part = parts[0];

            return part;

        } else {
            return "Near of ";
        }
    }

    private String splitLocation(String location){
        String part;
        if (location.contains("of")) {

            String[] parts = location.split("of");
            part = parts[1];

            return part;

        } else {
            return location;
        }
    }



}
