package com.crrtechnologies;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

public class GPSTrackerNew2 extends Service implements LocationListener {
	
	private final Context mContext;
	// Declaring a Location Manager
	 private LocationManager locationManager;
	 Location location; // location
	    double latitude; // latitude
	    double longitude; // longitude
	    boolean canGetLocation = false;
	    
	 public GPSTrackerNew2(Context context)
	 {
	        this.mContext = context;
	 }
	 public Location GetLocation(Location location)
	 {
		 locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		 locationManager.requestLocationUpdates( LocationManager.GPS_PROVIDER,60000,30,this); 
		 String locationProvider = LocationManager.NETWORK_PROVIDER;
		// Or use LocationManager.GPS_PROVIDER
		 location = locationManager.getLastKnownLocation(locationProvider);
		return location;
	 }
	 public Double getLatitude()
	 {
		 if(location != null){
	            latitude = location.getLatitude();
	        }
		 return latitude;
	 }
	 public Double getLongitude()
	 {
		 if(location != null){
	            longitude = location.getLongitude();
	        }
		 return longitude;
	 }
	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		Double Latitude= location.getLatitude();
		Double Longitude=location.getLongitude();
		String latandlon=Latitude+","+Longitude;
		Toast.makeText(getBaseContext(), latandlon, Toast.LENGTH_LONG).show();
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		Toast.makeText(getBaseContext(), "Gps turned off ", Toast.LENGTH_LONG).show();
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		Toast.makeText(getBaseContext(), "Gps turned on ", Toast.LENGTH_LONG).show();
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		Double Latitude= location.getLatitude();
		Double Longitude=location.getLongitude();
		String latandlon=Latitude+","+Longitude;
		Toast.makeText(getBaseContext(), latandlon, Toast.LENGTH_LONG).show();
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean canGetLocation() {
		// TODO Auto-generated method stub
		 return this.canGetLocation;
	}

	 
}