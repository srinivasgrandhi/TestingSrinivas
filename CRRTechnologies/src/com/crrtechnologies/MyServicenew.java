package com.crrtechnologies;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import org.kxml2.kdom.Node;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.os.PowerManager;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

public class MyServicenew extends Activity {

	GPSTracker gps;
    Geocoder geocoder;
    double latitude,longitude;
	String latitude1;
	String longitude1;
	String datetime;
	protected PowerManager.WakeLock mWakeLock;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.myservicenew);
		
		
		final PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
	    this.mWakeLock = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, "My Tag");
	    this.mWakeLock.acquire();
	    
	    
	      
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        
        //PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        //PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, "My Tag");
        //wl.acquire();
		
        
       
        
        LocationManager locationManager;
        String context = Context.LOCATION_SERVICE;
        locationManager = (LocationManager)getSystemService(context);

        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(Criteria.POWER_LOW);
        String provider = locationManager.getBestProvider(criteria, true);
        
        
        Timer myTimer = new Timer();
		myTimer.schedule(new TimerTask() {			
			@Override
			public void run() {
				TimerMethod();
				
				latitude1 = String.valueOf(latitude);
	            longitude1= String.valueOf(longitude);
	            
				datetime = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
		        GPSService GPSs = new GPSService();
		        String result = GPSs.getData(latitude1, longitude1, datetime);
		        
		        Log.v("StartServiceReturn Data", latitude + " " + longitude);
		        
			}
			
		}, 0, 10000);
        
		
		
		
        
	}
	
	
	// Method to start the service
    public void startService(View view) {
      Looper.prepare();
      
      
      
      startService(new Intent(getBaseContext(), MyServicenew.class));
       
    }

    // Method to stop the service
    public void stopService(View view) {
       stopService(new Intent(getBaseContext(), MyServicenew.class));
    }
	private void TimerMethod()
	{
		//This method is called directly by the timer
		//and runs in the same thread as the timer.

		//We call the method that will work with the UI
		//through the runOnUiThread method.
		//this.runOnUiThread(Timer_Tick);
		
		this.runOnUiThread(new Runnable() {
		    public void run() 
		    {
		    	/*gps = new GPSTracker(MyServicenew.this);

	            // check if GPS enabled     
	            if(gps.canGetLocation()){

	                 latitude = gps.getLatitude();
	                 longitude = gps.getLongitude();

	               // Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
	                
	            } */
		    }
		});
		
	}


	private Runnable Timer_Tick = new Runnable() {
		public void run() {
					
			/*gps = new GPSTracker(MyServicenew.this);

            // check if GPS enabled     
            if(gps.canGetLocation()){

                 latitude = gps.getLatitude();
                 longitude = gps.getLongitude();

               // Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
                
            }*/
		}
	};

}
