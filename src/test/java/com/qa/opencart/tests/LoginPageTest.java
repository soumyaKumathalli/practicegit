package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


@Epic("login page for open cart")
public class LoginPageTest extends BaseTest {
	//once after creating actions and locators 
	
	
	
	
	@Description("login page title test")
	@Severity(SeverityLevel.MINOR)
	@Test(priority=1)
	public void LoginPageTitletest() {
	String title=pg.LoginPageTitle();
	System.out.println(title);
	Assert.assertEquals(title,Constants.LOGIN_PAGE_TITLE);
	}
	
	
	@Test(priority=2)
	public void LoginPageurl() {
		String url=pg.GetCurrenturl();
		System.out.println(url);
		Assert.assertEquals(url, Constants.LOGIN_PAGE_URL_FRACTION);
	}
	
	@Test(priority=3)
	public void forgotpasswordList() {
		Assert.assertTrue(pg.isforgotpasswordisplayed());
		
	}
	
	
	@Test(priority=4)
	public void RegsitrationDisplayed() {
		Assert.assertTrue(pg.isRegistrationDisplayed());
		
	}
	
	@Test(priority=5)
	public void Login() {
		//here after login will go to account pae so we are asserting the account page
	ag	=pg.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	
	Assert.assertEquals(ag.getPageTitle(),Constants.ACCOUNTS_PAGE_TITLE);
		
	}
	
	

}
 