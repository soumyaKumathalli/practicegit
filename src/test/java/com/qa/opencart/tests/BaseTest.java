package com.qa.opencart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfopage;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.pages.searchPage;
import com.qa.opencart.utils.ExcelUtil;

public class BaseTest {
	DriverFactory df;
	WebDriver driver;
	Properties prop;
	LoginPage pg;
	AccountPage ag;
	searchPage sg;
	ProductInfopage pdpg;
	SoftAssert softassert;
	RegistrationPage rg;
	ExcelUtil exl;
	
	@BeforeTest
	public void setup() {
		df=new DriverFactory();
		prop=df.init_prop();
		driver=df.init_driver(prop);
		pg=new LoginPage(driver);
		ag=new AccountPage(driver);
		//sg=new searchPage(driver);
		pdpg=new ProductInfopage(driver);
		softassert =new SoftAssert();
		rg=new RegistrationPage(driver);
		exl=new ExcelUtil();
		
		
	}
	
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
