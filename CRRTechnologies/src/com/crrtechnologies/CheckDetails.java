package com.crrtechnologies;

import java.util.HashMap;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;


public class CheckDetails {
	String result;
	static public HashMap hmp=new HashMap();
	private static final String NAMESPACE = "http://tempuri.org/";
	private static final String URL ="http://mbpay.in/MBDealer/Dealer.asmx?WSDL";	
	private static final String SOAP_ACTION = "http://tempuri.org/DealerLogin";
	private static final String METHOD_NAME = "DealerLogin";
	public HashMap getLogin(String name,String pass){
		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME); 		
		request.addProperty("mobile_no",name); 
		request.addProperty("Password",pass);
		
		//request.addProperty("version",version);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11); 
		envelope.bodyOut=request;
		envelope.dotNet=true;	
		envelope.setOutputSoapObject(request);
		try {
			HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
			androidHttpTransport.call(SOAP_ACTION, envelope);	
			//SoapObject resultsRequestSOAP = (SoapObject) envelope.bodyIn;	
			SoapObject resultsRequestSOAP = (SoapObject) envelope.getResponse();				
			int xy = resultsRequestSOAP.getPropertyCount();		
			int k=1;		
			for(int x=0;x<xy;x++){
				String val=resultsRequestSOAP.getProperty(x).toString();
				hmp.put(k, val);
				k++;		
			}
			new Hash();
			Hash.setLogin(hmp);		
		} catch (Exception e) {
			hmp.put(1, "Server Down");
			e.printStackTrace();
		}
		return hmp;
	}
	
	public String checkVc(String vc){
		if(vc.equals("")){
			result="Please Enter VC Number";
			
		}
		return result;
		
	}

}
