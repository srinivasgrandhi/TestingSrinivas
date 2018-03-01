package com.crrtechnologies;

import java.util.ArrayList;
import java.util.Calendar;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.LocationManager;
import android.os.IBinder;
import android.os.Looper;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;


public class MyService extends Service {
	    ArrayList<String> Arraydata = new ArrayList<String>();
	    protected static final String Timer_Tick = null;
		
		double latitude,longitude;
		String latitude1;
		String longitude1;

		String bo;
		String datetime;
	    // GPSTracker class
	    GPSTracker gps;
	    Geocoder geocoder;
	    private Thread mSplashThread;
	    
	    
	   @Override
	   public IBinder onBind(Intent arg0) {
	      return null;
	   }

	   @Override
	   public int onStartCommand(Intent intent, int flags, int startId) {
	      // Let it continue running until it is stopped.
	      Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
	      
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
	    
	        Looper.prepare(); 
	      Thread thread = new Thread()
	      {
	         

			@Override
	          public void run() {
	              try {
	                  while(true) {
	                      sleep(60000);
	                      //Log.v("1000 - Started", "1000 - Started");
	                      
	                    latitude1 = String.valueOf(latitude);
	      	            longitude1= String.valueOf(longitude);
	      	            
	      				datetime = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
	      		        GPSService GPSs = new GPSService();
	      		        String result = GPSs.getData(latitude1, longitude1, datetime);
	      		        
	      		        Log.v("StartServiceReturn Data", latitude + " " + longitude);
	                      	                      
	                  }
	              } catch (InterruptedException e) {
	                  e.printStackTrace();
	              
	              }
	          }
	         
	      };

	      /*gps = new GPSTracker(MyService.this);

          // check if GPS enabled     
          if(gps.canGetLocation()){

               latitude = gps.getLatitude();
               longitude = gps.getLongitude();
               bo = latitude + "," + longitude;
               
          }*/
	      /*thread.start();*/
	      return START_STICKY;
	      
	      
	   }
	   @Override
	   public void onDestroy() {
	      super.onDestroy();
	      Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
	   }
  
	}