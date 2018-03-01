package com.crrtechnologies;

public class Contact {
	//private variables
	int _id;
	String _data1;
	String _data2;
	String _data3;
	 
	// Empty constructor
	public Contact(){
	     
	}
	// constructor
	public Contact(String _data1, String _data2, String _data3){
	   
	    this._data1 = _data1;
	    this._data2 = _data2;
	    this._data3 = _data3;
	}
	
	// getting name
	public String getName(){
	    return this._data1;
	}
	 
	// setting name
	public void setName(String data1){
	    this._data1 = data1;
	}
	 
	// getting phone number
	public String getdata2(){
	    return this._data2;
	}
	 
	// setting phone number
	public void setdata2(String data2){
	    this._data2 = data2;
	}
	
	// getting phone number
	public String getdata3(){
		return this._data3;
	}
		 
	// setting phone number
	public void setdata3(String data3){
		this._data3 = data3;
	}
}
