package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementsUtil;

public class searchPage {

	private WebDriver driver;
	private ElementsUtil util;
	public searchPage(WebDriver driver) {
		this.driver=driver;
		util=new ElementsUtil(driver);
	}
	
	//these locators are used to get the details of laptop related to brand,rate etc
	private By listofMacproducts=By.xpath("//div[@class='caption']//a");
	
	
	
	
	//so first method we are trying to get the list of macproducts using method
	public int Productlistcount() {
		
		int count=util.VisibilityOfElementsLocated(listofMacproducts, 10).size();
		System.out.println(count);
		return count;
	}
	
	
	public ProductInfopage selectproduct(String productname) {
		System.out.println(productname);
		List<WebElement> list=util.VisibilityOfElementsLocated(listofMacproducts, 5);
		for(WebElement e:list) {
		String text=	e.getText();
		if(text.equals(productname)) {
			e.click();
			break;
		}
		}
		//this retrun is used because after clicj=king it will land in product page of the product
		//and this approach is called as Test data driven approach
	return new ProductInfopage(driver);	
	}
	
	
	
	
	
	
	

}
