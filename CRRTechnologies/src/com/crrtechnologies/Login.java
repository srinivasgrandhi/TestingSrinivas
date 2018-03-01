package com.crrtechnologies;

import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity{

	Button btnlogin;
	EditText et_email,et_password;
	
	private Thread mSplashThread;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		btnlogin = (Button)findViewById(R.id.btnlogin);
		et_email =(EditText)findViewById(R.id.et_email);
		et_password=(EditText)findViewById(R.id.et_password);
		btnlogin.setOnClickListener(new OnClickListener() {
		
			HashMap hm=new HashMap();
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

				
				PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
				PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "My Wakelock");
				wl.acquire();
				wl.release();
					
				
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
						try{
							
							new CheckDetails().getLogin(et_email.getText().toString(), et_password.getText().toString());
							new Hash();
							hm=Hash.getLogin();
							
							
							String main=null;
							int s=hm.size();		
							if(0<s){
								String val=new Integer(s).toString(); 	
								main=hm.get(1).toString();
								if(main.equals("FAIL"))
								{
									Toast.makeText(Login.this,"Please Check User ID and Password",Toast.LENGTH_SHORT).show();
								}
								else
								{
								if(main.equals("Home")){
									
																	
									HashMap<String, String> hashMap = new HashMap<String, String>();
									hashMap.put("uname",et_email.getText().toString() );
									
									startService(new Intent(BackgroundService.class.getName()));
									
								}
								else 
								{	
									Intent home1=new Intent(getApplicationContext(),Error.class);
									startActivity(home1);	
								}
								
							  }
								
							}
							
						}catch (Exception e) {
						
						}
						
						
						
					}
				};

				mSplashThread.start();
				
				/*Intent home1=new Intent(getApplicationContext(),MyServicenew.class);
				startActivity(home1);*/
			}
		});
	}
	
	

}
