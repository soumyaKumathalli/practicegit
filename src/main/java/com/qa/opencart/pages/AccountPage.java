package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementsUtil;

public class AccountPage {
	
	
	private WebDriver driver;
	private ElementsUtil util;
	Constants c;
	
	private By storelink=By.cssSelector("div#logo h1");
	private By Accountssections=By.cssSelector("div#content h2");
	private By search=By.name("search");
	private By searchButton=By.cssSelector("div#search button");
	private By logout=By.xpath("//div[@class='list-group']/a[contains(text(),'Logout')]");
	
		public AccountPage(WebDriver driver) 
		{
			this.driver=driver;
			util=new ElementsUtil(driver);
			
		}
	
	
	public String getPageTitle() {
		return util.getTitletimeout(c.ACCOUNTS_PAGE_TITLE, c.DEFAULT_TIME_OUT);
	}
	
	
	public String getStoretext() {
		return util.getText(storelink);
	}
	
	public List<String> getAccounts() {
		List<WebElement> list=util.getElements(Accountssections);
		List<String> liststr=new ArrayList<String>();
		for(WebElement e:list) {
			String text=e.getText();
			liststr.add(text);
		}
		return liststr;
	}
	
	
	public boolean Logoutexist() {
	return util.doIsidisplayed(logout);
	}
	
	public void logout() {
		if(Logoutexist())
		 util.goClick(logout);
	}
	
	public void clear() {
		util.getElement(search).clear();
	}
	
	
	public searchPage searchproduct(String product) {
		
		util.dosendKeysl(search,product);
	util.goClick(searchButton);

	//util.getElement(search).clear();
	//so from entering here we will go to nextpage we are creating the object
	return new searchPage(driver);
		
	}


	
	
	
	
	

}
