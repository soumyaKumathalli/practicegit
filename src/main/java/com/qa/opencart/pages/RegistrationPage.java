package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementsUtil;

public class RegistrationPage {

	//in order  to access private webdriver use it in constructor
	private WebDriver driver;
	private ElementsUtil util;

	public RegistrationPage(WebDriver driver) {
this.driver=driver;
util=new ElementsUtil(driver);

}
	
	
	private By Firstname=By.id("input-firstname");
	private By Lastname=By.id("input-lastname");
	private By Email=By.id("input-email");
	private By Telephone=By.id("input-telephone");
	private By Password=By.id("input-password");
	private By Confirmpswd=By.id("input-confirm");
	private By yesradio=By.xpath("(//label[@class='radio-inline'])[position()=1]/input[@type='radio']");
	private By noradio=By.xpath("(//label[@class='radio-inline'])[position()=2]/input[@type='radio']");
	private By agree=By.xpath("//input[@name='agree']");
	private By continuebutton=By.xpath("//input[@value='Continue']");
	
	private By successmesg=By.cssSelector("div#content h1");
	private By logout=By.xpath("//div[@class='list-group'] /a[contains(text(),'Logout')]");
	private By RegsiterLink=By.xpath("//div[@class='list-group'] /a[contains(text(),'Register')]");
	
	
	
	public boolean accountRegistration(String firstname,String lastname,String email,String telephone,String password,String confirmpswd,String subscribeyes) {
		
		util.goClick(RegsiterLink);

		util.dosendKeys(Firstname, firstname);
		util.dosendKeys(Lastname, lastname);
		util.dosendKeys(Email, email);
		util.dosendKeys(Telephone, telephone);
		util.dosendKeys(Password, password);
		util.dosendKeys(Confirmpswd, confirmpswd);
		
	if(subscribeyes.equals("Yes")) {
		util.goClick(yesradio);
	}
	else {
		util.goClick(noradio);
	}
	
	
	String message=util.VisibilityOfElementLocated(successmesg, 5).getText();//so the get textfrom element
	if(message.contains(Constants.REGISTERED_SUCCESS_MSG))

		util.goClick(logout);
	util.goClick(RegsiterLink);
	return true;
		
	}
	

}
