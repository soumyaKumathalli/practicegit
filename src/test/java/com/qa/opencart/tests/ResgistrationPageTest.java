package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.utils.Constants;

public class ResgistrationPageTest extends BaseTest{
	
//	@BeforeClass
//	public void RegistrationPage() {
//		rg=	pg.DoLoginRegistrationPage(prop.getProperty("username"), prop.getProperty("password"));
//	}
//	
	
	@DataProvider
	public Object[][] getRegsiterData() {
		//get the sheet to data provider
		 return exl.getTestdata(Constants.REGISTERED_SHEET_NAME);
		
		
	}
	
	@Test(dataProvider="getRegsiterData")
	public void userregistartion(String firstname,String lastname,String Email,String Telephone,String Password,String Confimpswd,String subscribe) {
		Assert.assertTrue(rg.accountRegistration(firstname, lastname, Email, Telephone, Password, Confimpswd, subscribe));
		
//	Assert.assertTrue(rg.accountRegistration(firstname, lastname, Email, Telephone, Password, Confimpswd, subscribe));
		
	}
	

}
