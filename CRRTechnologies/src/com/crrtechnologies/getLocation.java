package com.crrtechnologies;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;

public class getLocation extends Service implements LocationListener {
	 
		private final Context mContext;
	 
		// flag for GPS status
		boolean isGPSActive  = false;
	 
		Location location; // location
		double latitude; // latitude
		double longitude; // longitude
	 
		// The minimum distance to change Updates in meters
		private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10; // 10 meters
	 
		// The minimum time between updates in milliseconds
		private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1; // 1 minute
	 
		// Declaring a Location Manager
		protected LocationManager locationManager;
	 
		public getLocation(Context context) {
			this.mContext = context;
			getTheLocation();
		}
	 
		public Location getTheLocation() {
			try {
				locationManager = (LocationManager) mContext.getSystemService(LOCATION_SERVICE);
	 
				// getting GPS status
				isGPSActive  = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
	 
				if (!isGPSActive ) {
					// GPS Not Active
				} else {				
					if (location == null) {
						locationManager.requestLocationUpdates(
								LocationManager.GPS_PROVIDER,
								MIN_TIME_BW_UPDATES,
								MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
						if (locationManager != null) {
							location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
							if (location != null) {
								latitude = location.getLatitude();
								longitude = location.getLongitude();
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	 
			return location;
		}
	 
		public double getLatitude(){
			if(location != null){
				latitude = location.getLatitude();
			}
			return latitude;
		}
	 
		public double getLongitude(){
			if(location != null){
				longitude = location.getLongitude();
			}
			return longitude;
		}
	 
		public boolean isGPSActive() {
			return this.isGPSActive;
		}
	 
		@Override
		public void onLocationChanged(Location location) {
		}
	 
		@Override
		public void onProviderDisabled(String provider) {
		}
	 
		@Override
		public void onProviderEnabled(String provider) {
		}
	 
		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
		}
	 
		@Override
		public IBinder onBind(Intent arg0) {
			return null;
		}
	}
