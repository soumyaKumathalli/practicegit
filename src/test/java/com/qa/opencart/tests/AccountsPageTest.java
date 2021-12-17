package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.searchPage;
import com.qa.opencart.utils.Constants;

public class AccountsPageTest extends BaseTest{
	
	
	//to get to account page we have to first go from login page and then account page so prequesite is to login first
	@BeforeClass
	public void accountsetup() {
		ag=	pg.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void asserttitile() {
		String apagetitle=ag.getPageTitle();
		Assert.assertEquals(apagetitle,Constants.ACCOUNTS_PAGE_TITLE );
	}
	
	@Test(priority=2)
	public void gettext() {
		String accounttext=ag.getStoretext();
		Assert.assertEquals(accounttext, Constants.ACCOUNT_TEXT);
	}
	
	
	
	@Test(priority=3)
	public void getAccountlists() {
		List<String> list=ag.getAccounts();
		//matching the text
		Assert.assertEquals(list, Constants.addtheaccounts());
	}
	
	//sometimes ew just need one data an sometimes we need more than 2 data so if excel is not used then we have to pass through 
	//dataprovider
	
	@DataProvider
	//this data provider is called as hard coded data 
	//this dataproivder need two dimensional array
	public Object[][] productdata() {
		return new Object[][] {
			
			{"MacBook"},
			{"Apple"},
			
			
		};
		
	}
	
	//so after creating dataprovider then we have to call that in method where we want to use 
	@Test(priority=4,dataProvider="productdata")
	//and create parameeter to the method which are passing in data provider
	public void search(String productname) {
		sg= ag.searchproduct(productname);//here we are giving the macbook pro,macbook etc
//	System.out.println("pp"+pp);
		//insstead of creating serch page test we are validation in acocunts page because the searchproduct method return type s search page so it will go to that page
		Assert.assertTrue(sg.Productlistcount()>0);	
	}
	
	
	
	@DataProvider
	public Object[][] productselectdata() {
		return new Object[][] {
			{"MacBook","MacBook Pro"},
			{"iMac","iMac"},
			
		};
	}
	
	@Test(priority=5,dataProvider="productselectdata")
	public void productvalidate(String productname,String mainproduct) {
		
		sg=ag.searchproduct(productname);//from account page we are entering the product
		pdpg=sg.selectproduct(mainproduct);//after entering the search page select the product
		Assert.assertEquals(pdpg.productheadername(), mainproduct);//so we are matching the product from search page and product page 
	}
//	
	
//	
//	@Test(priority=3)
//	public void logout() {
//		ag.logout();
//	}

}


//**********************************************So instead of creating the test cases for sersch page make use of account page its landing in serach page

