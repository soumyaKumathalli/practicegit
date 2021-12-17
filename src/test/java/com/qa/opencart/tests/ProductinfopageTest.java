package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;

public class ProductinfopageTest extends BaseTest {
	
	
	
	@BeforeClass
	public void accountsetup() {
		ag=	pg.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@Test(priority=1)
	public void productheader() {
		
		sg=ag.searchproduct("MacBook");//from account page we are entering the product
		pdpg=sg.selectproduct("MacBook Pro");//after entering the search page select the product
		Assert.assertEquals(pdpg.productheadername(), "MacBook Pro");
}
	
	
	@Test(priority=2)
	public void getimagecount() {
	
		sg=ag.searchproduct("MacBook");//from account page we are entering the product
		pdpg=sg.selectproduct("MacBook Pro");//after entering the search page select the product
		Assert.assertEquals(pdpg.getimagescount(),Constants.IMAGE_COUNT);
	
	}
	
	@Test(priority=3)
	public void getproductinform() {
		sg=ag.searchproduct("MacBook");//from account page we are entering the product
		pdpg=sg.selectproduct("MacBook Pro");
		Map<String,String> mp=pdpg.productinfo();
		mp.forEach((k,v)->System.out.println(k+":"+v));//to print hash map using for each loop 
		//hard assertion
		softassert.assertEquals(mp.get("name"), "MacBook Pro");//suppose if the first one fails it will give chance to second soft assert isntead of termianting 
		softassert.assertEquals(mp.get("Brand"), "Apple");
		softassert.assertEquals(mp.get("price"), "$2,000.00");
		softassert.assertAll();
		
		
		//there is soft assertion in TestNG
		//to use here soft assert use it in first base test

		//**********************************for every method only one assertion should  be there that is assert and we can have multiple soft assertions"
}

}
