package com.crrtechnologies;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {

		private Thread mSplashThread;
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	        
	        final MainActivity sPlashScreen = this;
	        
			mSplashThread = new Thread() {
				@Override
				public void run() {
					try {
						synchronized (this) {
							wait(3000);
						}
					} catch (InterruptedException ex) {
						finish();
					} finally {
						finish();
					}

					//Boolean inserted = sharedpreference.getBoolean("InsertValue",false);

					startActivity(new Intent(getApplicationContext(), Login.class));

				}
			};

			mSplashThread.start();
	    }


	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }

}
