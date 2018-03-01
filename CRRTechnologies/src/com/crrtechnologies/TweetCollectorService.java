package com.crrtechnologies;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Geocoder;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.StrictMode;
import android.util.Log;


public class TweetCollectorService extends Service {
	  
	
    
	  private static final String TAG = TweetCollectorService.class.getSimpleName();
	   
	  private Timer timer;
	  
	  	GPSTracker gps;
	    Geocoder geocoder;
	    double latitude,longitude;
		String latitude1;
		String longitude1;
		String datetime;
	  
		
        
	  private TimerTask updateTask = new TimerTask() {
	   	@Override
	    public void run() {	    	
	        
	    	// check if GPS enabled
	   		gps = new GPSTracker(TweetCollectorService.this);

	          // check if GPS enabled     
	          if(gps.canGetLocation()){

	               latitude = gps.getLatitude();
	               longitude = gps.getLongitude();
	              
	               Log.d("timerupdatetask", "Started");  
	          }
	          latitude1 = String.valueOf(gps.getLatitude());
	          longitude1 = String.valueOf(gps.getLongitude());
	          
	          Log.d("longandlati", latitude1 + " " + longitude1);
	          
            datetime = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
	        GPSService GPSs = new GPSService();
	        String result = GPSs.getData(latitude1, longitude1, datetime);
	        
	        
	      //Log.i(TAG, "Timer task doing work");
	    }
	  };
	   
	  @Override
	  public IBinder onBind(Intent intent) {
	    // TODO Auto-generated method stub
	    return null;
	  }
	 
	  @SuppressLint("NewApi")
	@Override
	  public void onCreate() {
	    super.onCreate();
	    
	    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	    StrictMode.setThreadPolicy(policy);
	    
	    //Log.i(TAG, "Service creating");
	    

        // check if GPS enabled     
        if(gps.canGetLocation()){

             latitude = gps.getLatitude();
             longitude = gps.getLongitude();
            
             
        }
        latitude1 = String.valueOf(gps.getLatitude());
        longitude1 = String.valueOf(gps.getLongitude());
        
      datetime = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
      GPSService GPSs = new GPSService();
      String result = GPSs.getData(latitude1, longitude1, datetime);
	    
	    timer = new Timer("TweetCollectorTimer");
	    timer.schedule(updateTask, 1000L, 60 * 1000L);
	  }
	 
	  public int onStart(Intent intent, int flags, int startId) {
		  
		  PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
	      PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, "My Tag");
	      wl.acquire();
	      wl.release();
	      return START_STICKY;

		}
	  
	  @Override
	  public void onDestroy() {
	    super.onDestroy();
	    Log.i(TAG, "Service destroying");
	     
	    timer.cancel();
	    timer = null;
	  }
	}