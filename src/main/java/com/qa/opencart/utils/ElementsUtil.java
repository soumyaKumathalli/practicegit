package com.qa.opencart.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.opencart.factory.DriverFactory;

public class ElementsUtil {
	
	
	//here static keyword is removed because every other object need to call the driver copy this annd if we use static then all the whose are calling has to wait one after nother to call it
	
	
//	for element util class i want to use my own web driver and it should not be accessed by anyone apart from this class so it is used as private but 
//	but i want to access it so i have to use getter and setter
	//but here not using the getter and setter instead used the constructor to do that
	private  WebDriver driver;
	private JavaScriptUtil jsutil;
	
	
	
	 By username=By.id("sdfsdf");
	 
	 
	
	public ElementsUtil(WebDriver driver){
		this.driver=driver;
		jsutil=new JavaScriptUtil(driver);
	}
	
	//here we are not using getter and setter instead using constructor to intitalize the value
	
	
	
	public  WebElement getElement(By locator) {
		System.out.println("erf");
		//here we are getting the values by passing 
		WebElement ele= driver.findElement(locator);//here this driver is not fetching any value from the private web driver so we have to make it accessbile
		//after return keyword we should not write anything in method
		if(Boolean.parseBoolean(DriverFactory.highlight)) {
			jsutil.flash(ele);
		}
		return ele;
	}
	
	
	
	
	
public   void  dosendKeys(By Locator,String value) {
//so we are making use of getElement method and alojg with action for the web element so any element with send keys action
getElement(Locator).sendKeys(value);
}



public  By getBy(String LocatorType,String locatorvalue) {
	
	By locator=null;
	switch(LocatorType.toLowerCase()) {
	case "id":
		locator=By.id(locatorvalue);
		break;
	case "name":
		locator=By.name(locatorvalue);
		break;
	case "classname":
		locator=By.className(locatorvalue);
		break;
	case "xpath":
		locator=By.xpath(locatorvalue);
		break;
	case "cssselector":
		locator=By.cssSelector(locatorvalue);
		break;
	case "linktext":
		locator=By.linkText(locatorvalue);
		break;


		
	default:
		System.out.println("Pass correct locator");
	
	}
	return locator;
}


public void doclear(By locator) {
		getElement(locator).clear();
}


//overloaded method 
public  WebElement getElement(String locatorType,String locator) {
	return driver.findElement(getBy(locatorType, locator));
}

//overloaded method
//used for sendkeys action
public   void  dosendKeys(String locatorType,String locator,String locatorvalue) {
	//so we are making use of getElement method and alojg with action for the web element so any element with send keys action
	getElement(locatorType,locator).sendKeys(locatorvalue);
	}


//used for click action 
public void goClick(By Locator) {
	getElement(Locator).click();
}

public   void  dosendKeysl(By locator,String value) {
	doclear(locator);
	//so we are making use of getElement method and alojg with action for the web element so any element with send keys action
	getElement(locator).sendKeys(value);
	
}

	
	//overloaded method
	public   void  dosendKeys(String locatorType,String locator) {
		//so we are making use of getElement method and alojg with action for the web element so any element with send keys action
		getElement(locatorType,locator).click();
}
	
	
	public String getText(By Locator) {
	return	getElement(Locator).getText();

	}
	
	public  boolean doIsidisplayed(By locator) {
		return driver.findElement(locator).isDisplayed();
	}

	//to find multiple elements 
	public List<WebElement> getElements(By Locator) {
		
		return driver.findElements(Locator);
		
	}
	
	
	//to get the size of the tags
	public int getElementCount(By Locator) {
		return getElements(Locator).size();
	}
	
	//links util
	
	public  List<String> getElementsTextList(By locator) {
		List<WebElement> ll =getElements(locator);//store the any tag locators in list of web element
		List<String>  ss=new ArrayList<String>();//to storthe strings the in list of any of the locators
		for(WebElement e:ll) {
		String 	eletext=e.getText();//store the text in  string
		if(!eletext.isEmpty()) {//to remove the spaces
			ss.add(eletext);
		}
		}
		return ss;
	}
	
	
	public  List<String> getElementsAttributeList(By locator,String Attributevalue) {
		List<WebElement> ll =getElements(locator);//store the any tag locators in list of web element
		List<String>  ss=new ArrayList<String>();//to storthe strings the in list of any of the locators
		for(WebElement e:ll) {
		String 	eletext=e.getAttribute(Attributevalue);//store the text in  string
		if(!eletext.isEmpty()) {//to remove the spaces
			ss.add(eletext);
		}
		}
		return ss;
	}
	
	//so using isdisplayed method in selenkum this is another method which is customized to verify element so 
	public boolean verifyElement(By Locator) {
		int elecount=driver.findElements(Locator).size();
		if(elecount>=1) {
			System.out.println("elements is present");
			return true;
			}
		else {
			System.out.println("elements is present");
			return false;

		}
		
	}
	
	
	
	//for dropdowns
	
	public  void withoutselectDropdwon(By Locator,String value) {
		List<WebElement> list=	driver.findElements(Locator);//dont use select class so instead using findelements where it will fetch the multiple elements
		for(WebElement e:list) {
			String text=e.getText();
			//System.out.println(text);
			if(text.equals(value)) {
				e.click();
				break;
				
			}
		}
			
		}
	
	
public  void getSelectdropdownwithoutoptions(By Locator,String value) {
		
		Select select =new Select(getElement(Locator));
		List<WebElement> ele=select.getOptions();
		//System.out.println(ele.get);
		for(WebElement e:ele) {
	String text=e.getText();
	System.out.println(text);
	if(text.equals(value)) {
		e.click();
		break;
		
	}

////		count++;
	}
	
	}
	

public  void getLanguagelist(By locator,String value) {
	List<WebElement> ls=getElements(locator);
	for(WebElement e:ls) {
		String text=e.getText();
		//System.out.println(text);
		if(text.equals(value)) {
			e.click();
			break;
		}
		
	}
	}


//Actions UTil
	

public  void  goMoveElement(By Locator) {
	Actions act=new Actions(driver);
	act.moveToElement(getElement(Locator)).perform();
}

public  void ClickonElement(By parentlocator,By childlocator) {
	goMoveElement(parentlocator);//this is parent means add on dropdown
	getElement(childlocator).click();//this is child means which is option in dropdowm 
	
}

public  void ClickonElementwithActionclick(By locator,By childlocator) {
	Actions act=new Actions(driver);
	act.click(getElement(locator)).build().perform();
	
}
public  void ClickonElementwithoutActionclick(By locator) {
	Actions act=new Actions(driver);
	act.moveToElement(getElement(locator)).click().build().perform();
	
}
	
public void ActionSendkeys(By locator,String value) {
	Actions act=new Actions(driver);
	act.sendKeys(getElement(locator),value).build().perform();
}

public void ActionSendkeyswihtoutactionsendkeys(By locator,String value) {
	Actions act=new Actions(driver);
	act.click(getElement(locator)).sendKeys(value);
}


//****************************Wait Utils****************

public  WebElement presenceofElementLocated(By Locator,int timeout) {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
return 	wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
	
}

//apart from these one more generic including the presence element located method
//do this for click also

public  void doSendKeys(By Locator,int timeout,String value) {
	presenceofElementLocated(Locator,timeout).sendKeys(value);
}

public  WebElement intervalpolltime(By Locator,int timeout,long intervaltimeout) {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout),Duration.ofMillis(intervaltimeout));
	return 	wait.until(ExpectedConditions.presenceOfElementLocated(Locator));

}


public   WebElement VisibilityOfElementLocated(By Locator,int timeout) {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
return 	wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));

}



public  List<WebElement> VisibilityOfElementsLocated(By Locator,int timeout) {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
return 	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Locator));

}

public  List<String> getElementsByWait(By Locator,int timeout) {
	
	List<WebElement> ele=VisibilityOfElementsLocated( Locator, timeout);
	List<String> l=new ArrayList<String>();
	for(WebElement e:ele) {
String text=e.getText();
l.add(text);

	}
	return l;
	
}

//Non-webelement wait for url
public  void urlelementwait(String urlfraction,int timeout) {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.urlContains(urlfraction));
}

//Non-webelement wait for title

public  boolean Titletiemout(String Title,int timeout) {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return  wait.until(ExpectedConditions.titleContains(Title));
}

//we can call the method in if loop 
public  String getTitletimeout(String Title,int tiemout) {
	if(Titletiemout(Title,tiemout)) {//which is in if loop we are validating wthether title is present and returning the title
		return driver.getTitle();
	}
	return null;
}

//frame wbedrier wait
public  void WaitForFrame(String nameorID,int timeout) {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
	 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameorID));	
}

public  void WaitForFrame(int frameindex,int timeout) {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
	 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameindex));	
}

public  void WaitForFrame(By Locator,int timeout) {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
	 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Locator));	
}

public  void WaitForFrame(WebElement frameelement,int timeout) {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
	 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameelement));	
}





//fluent wait

public  void fluentwait(By Locator,int timeout,int intervaltimeout) {
	//we can add or remove the  methods in fleutn wait and we can access all these methods in webdriver wait also
	Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
			//this is timeout means waiting for the element
			.withTimeout(Duration.ofSeconds(timeout))
			//interval timeout
			.pollingEvery(Duration.ofSeconds(intervaltimeout))
			//if no such element exception comes please ignore it
			.ignoring(NoSuchElementException.class)
			//display a message for the exception 
			.withMessage(Error.ElEMENT_NOT_FOUND_ERROR_MESSAGE);
			
			wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
	
	
}


}
