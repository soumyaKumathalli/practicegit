package com.qa.opencart.pages;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementsUtil;

public class ProductInfopage {
	
	private WebDriver driver;
	private ElementsUtil util;
	
	
	private By productname=By.xpath("//div[@id=\"content\"]//h1");
	private By imagecount=By.cssSelector("a.thumbnail img");
	private By productmetadata=By.cssSelector("div#content ul.list-unstyled:nth-of-Type(1) li");
	private By productpricedata=By.cssSelector("div#content ul.list-unstyled:nth-of-Type(2) li");
	private By qty=By.xpath("//input[@name='quantity']");
	private By btncart=By.cssSelector("button#button-cart");
	
	private Map<String,String> productInfomap;

	
	public ProductInfopage(WebDriver driver) {
		this.driver=driver;
		util=new ElementsUtil(driver);
	}
	
	
	public String productheadername() {
		//return util.getElement(productname).getText();
		return util.getText(productname);
		
	}
	
	//to get the image count
	public int getimagescount() {
		return util.VisibilityOfElementsLocated(imagecount, 10).size();
		}
		
		
		
		//in ordeer to get the details of the product like brandd ect using hashmap
		public Map<String, String> productinfo() {
			productInfomap=new LinkedHashMap<String,String>();
			productInfomap.put("name", productheadername());//calling the productn name
			productmetadata();
			productpricedata();
			return productInfomap;
		}
	
		
		private void productmetadata() {
			//when we get like this brand:apple which acts as key value pair use HashMap
		List<WebElement> list=	util.getElements(productmetadata);
		for(WebElement e:list) {
			String text=e.getText();//getting text as Brand:Apple
		String meta[]= text.split(":");//so we are here splitting the  brnd and apple where 0 conatins key and 1 contains value
		String metakey=meta[0].trim();//these trim will remove the spaces 
		String metavalue=meta[1].trim();
		//we need to add this to hashmap
		productInfomap.put(metakey, metavalue);		
		}
		
		}
		
		
		private void productpricedata() {
			List<WebElement> list=	util.getElements(productpricedata);
		String price=	list.get(0).getText().trim();
			String extprice=list.get(1).getText().trim();
			productInfomap.put("price", price);
			productInfomap.put("extprice", extprice);
		}
	
	

}
