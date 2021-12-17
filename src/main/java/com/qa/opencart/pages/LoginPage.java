package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementsUtil;

import io.qameta.allure.Step;

public class LoginPage {
	//here we can use the driver class and all actions related to page should be added here
	
	//declare private webdriver
	private WebDriver driver;
private ElementsUtil util;
Constants c;
	
	//page constructor
//	we need to intialize private web driver 
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		util=new ElementsUtil(driver);
	}
	
	
	//by locators
	private By emailID=By.id("input-email");
	private By password=By.id("input-password");
	private By login=By.xpath("//input[@value='Login']");
	private By registerLink=By.xpath("//div[@class='list-group']/a[contains(text(),'Register')]");
	private By forgotpasswordlink=By.linkText("Forgotten Password");
	
	
	
	//page actions
	@Step("login page title")
	public String LoginPageTitle() {
		
		return util.getTitletimeout(c.LOGIN_PAGE_TITLE, c.DEFAULT_TIME_OUT);
		
	}
	
	public String GetCurrenturl() {
		return driver.getCurrentUrl();
		
	}
	
	public boolean isforgotpasswordisplayed() {
		return  util.doIsidisplayed(forgotpasswordlink);
	}
	
	
	
	public boolean isRegistrationDisplayed() {
		return util.doIsidisplayed(registerLink);
	}
	
	//these will login by passing username and password 
	public AccountPage doLogin(String un,String pw) {
		System.out.println(un+pw);
		util.dosendKeys(emailID, un);
		util.dosendKeys(password, pw);
		util.goClick(login);
	
		
		//this is called page chainign model so after login go to account page
		return new AccountPage(driver);
		
		
	}
	
	
	public RegistrationPage DoLoginRegistrationPage(String un,String pw) {
		util.dosendKeys(emailID, un);
		util.dosendKeys(password, pw);
		util.goClick(login);
		return new RegistrationPage(driver);
	}

	

}
