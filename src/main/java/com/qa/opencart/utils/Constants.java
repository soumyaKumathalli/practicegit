package com.qa.opencart.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	//so constants class where it will store the string values ans once the value is set it cannot be chnaged
	
	public  static final  String LOGIN_PAGE_TITLE="Account Loin";
public static final String LOGIN_PAGE_URL_FRACTION="https://demo.opencart.com/index.php?route=account/login";
public static final int DEFAULT_TIME_OUT=5;
public static final String  ACCOUNTS_PAGE_TITLE="My Account";
public static final String ACCOUNT_TEXT="Your Store";
public static final int IMAGE_COUNT=4;
public static final String REGISTERED_SUCCESS_MSG="Your Account has been created!";
public static final String REGISTERED_SHEET_NAME="registration";


public static List<String> addtheaccounts() {
	List<String> list=new ArrayList<String>();
	list.add("My Account");
	list.add("My Orders");
	list.add("My Affiliate Account");
	list.add("Newsletter");
	return list;
}


}
