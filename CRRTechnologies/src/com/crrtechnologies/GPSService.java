package com.crrtechnologies;

import java.util.ArrayList;
import java.util.HashMap;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class GPSService {
	static public HashMap hmp=new HashMap();
	private static final String NAMESPACE = "http://tempuri.org/";
	private static final String URL ="http://mbpay.in/CustomerSupport/Service.asmx?WSDL";	
	private static final String SOAP_ACTION = "http://tempuri.org/SaveData";
	private static final String METHOD_NAME = "SaveData";
	private static final String String = null;
	//public HashMap getBal(String dist_no)
	//public ArrayList<String> getBal(String dist_no)
	public String getData(String data1,String data2,String datetime){
		
		ArrayList<String> arraylistdata = new ArrayList<String>();
		
		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME); 	
		request.addProperty("data1",data1);
		request.addProperty("data2",data2);
		request.addProperty("datetime",datetime);
		
		SoapSerializationEnvelope envelope = 
		new SoapSerializationEnvelope(SoapEnvelope.VER11); 
		envelope.bodyOut=request;
		envelope.dotNet=true;
		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
		try {
		androidHttpTransport.call(SOAP_ACTION, envelope);
		//SoapObject resultsRequestSOAP = (SoapObject) envelope.bodyIn;
		SoapObject resultsRequestSOAP = (SoapObject) envelope.getResponse();
		int xy = resultsRequestSOAP.getPropertyCount();
		int k=1;
		
		for(int x=0;x<xy;x++){
		String val=resultsRequestSOAP.getProperty(x).toString();
		//hmp.put(k, val);
		arraylistdata.add(val);
		return val;
		//k++;
		}
		new Hash();
		Hash.setBalance(hmp);
		} catch (Exception e) {
		hmp.put(1, e.toString());
		e.printStackTrace();
		}
		
		return String;
		//return val;
		}
	}
