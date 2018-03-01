package com.crrtechnologies;

import java.util.Calendar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class GPSLocationBased extends Activity {
	  String latitude1;
	  String longitude1;
	  String datetime;
	  
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.locationbased);


	    LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
	    LocationListener ll = new Mylocationlistener();


	    // ---Get the status of GPS---
	    boolean isGPS = lm
	            .isProviderEnabled(LocationManager.GPS_PROVIDER);

	    // If GPS is not enable then it will be on
	    if(!isGPS)
	    {
	        Intent intent = new Intent("android.location.GPS_ENABLED_CHANGE");
	        intent.putExtra("enabled", true);
	         sendBroadcast(intent);

	    }

       
	    //<--registers the current activity to be notified periodically by the named provider. Periodically,
	    //the supplied LocationListener will be called with the current Location or with status updates.-->
	    lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, ll);
	}

	/**
	 *Mylocationlistener class will give the current GPS location 
	 *with the help of Location Listener interface 
	 */
	private class Mylocationlistener implements LocationListener {
	    @Override
	    public void onLocationChanged(Location location) {
	        if (location != null) {
	            // ---Get current location latitude, longitude, altitude & speed ---

	            Log.d("LOCATION CHANGED", location.getLatitude() + "");
	            Log.d("LOCATION CHANGED", location.getLongitude() + "");
	            float speed = location.getSpeed();
	            double altitude = location.getAltitude();
	            Toast.makeText(GPSLocationBased.this,"Latitude = "+
	                    location.getLatitude() + "" +"Longitude = "+ location.getLongitude()+"Altitude = "+altitude+"Speed = "+speed,
	                    Toast.LENGTH_LONG).show();
	            
	            
	            latitude1 = String.valueOf(location.getLatitude());
	            longitude1= String.valueOf(location.getLongitude());
	               	
				datetime = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
					        
		        GPSService GPSs = new GPSService();
		        String result = GPSs.getData(latitude1, longitude1, datetime);
		        
		        
	        }
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
	}
}
