package com.crrtechnologies;

import java.util.HashMap;

public class Hash {
	static public HashMap home=new HashMap();
	static public HashMap login=new HashMap();
	static public HashMap searchdate=new HashMap();
	static public HashMap transsummary=new HashMap();
	static public HashMap vcnum=new HashMap();
	static public HashMap reachrge=new HashMap();
	static public HashMap reachrgedeal=new HashMap();
	static public HashMap balance=new HashMap();
	static public HashMap UserInfo = new HashMap();
	public static HashMap getUserInfo() {
		return UserInfo;
	}
	public static void setUserInfo(HashMap UserInfo) {
		Hash.UserInfo = UserInfo;
	}
	public static HashMap getBalance() {
		return balance;
	}
	public static void setBalance(HashMap balance) {
		Hash.balance = balance;
	}
	public static HashMap getReachrgedeal() {
		return reachrgedeal;
	}
	public static void setReachrgedeal(HashMap reachrgedeal) {
		Hash.reachrgedeal = reachrgedeal;
	}
	public static HashMap getReachrge() {
		return reachrge;
	}
	public static void setReachrge(HashMap reachrge) {
		Hash.reachrge = reachrge;
	}
	public static HashMap getVcnum() {
		return vcnum;
	}
	public static void setVcnum(HashMap vcnum) {
		Hash.vcnum = vcnum;
	}
	public static HashMap getTranssummary() {
		return transsummary;
	}
	public static void setTranssummary(HashMap transsummary) {
		Hash.transsummary = transsummary;
	}
	public static HashMap getSearchdate() {
		return searchdate;
	}
	public static void setSearchdate(HashMap searchdate) {
		Hash.searchdate = searchdate;
	}
	public static HashMap getLogin() {
		return login;
	}
	public static void setLogin(HashMap login) {
		Hash.login = login;
	}
	public static HashMap getHome() {
		return home;
	}
	public static void setHome(HashMap home) {
		Hash.home = home;
	}

}
