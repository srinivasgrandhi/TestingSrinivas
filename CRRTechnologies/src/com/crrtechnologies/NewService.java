package com.crrtechnologies;

import java.util.Calendar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;

public class NewService extends Activity{

	GPSTracker gps;
	Geocoder geocoder;
	double latitude,longitude;
	String latitude1;
	String longitude1;
	String datetime;
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.locationbased);
		
		 StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		 StrictMode.setThreadPolicy(policy);
		    
		gps = new GPSTracker(NewService.this);

	    // check if GPS enabled     
	    if(gps.canGetLocation()){

	         latitude = gps.getLatitude();
	         longitude = gps.getLongitude();

	         latitude1 = String.valueOf(latitude);
	         longitude1= String.valueOf(longitude);
	         
	         datetime = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
		     GPSService GPSs = new GPSService();
		     String result = GPSs.getData(latitude1, longitude1, datetime);
		        
		     Log.v("StartServiceReturn Data", latitude + " " + longitude);
	       // Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
	        
	    }
	}

}
