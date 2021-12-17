package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	//to get the values from the config.properties using properties method
	public Properties prop;
	public static String highlight;
	OptionsManager optionm;
	public static ThreadLocal<WebDriver> tldriver=new ThreadLocal<WebDriver>();
	
	
	//used to laucnh browsers
	public WebDriver init_driver(Properties prop) {
		
		//instead of passing the browser directly pass it form the config properties
	String browsername= prop.getProperty("browser");
		System.out.println("the browser name"+browsername);
		highlight=prop.getProperty("highlight");
		optionm =new OptionsManager(prop);
		if(browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver(optionm.getchromeoptions()));
			
		}else if(browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver(optionm.getFirefoxOptions()));
		}
		else {
			System.out.println("no browser found");
		}
		
		getDriver().manage().window().fullscreen();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));

		
		return getDriver();
		
	}
	
	
	//in order to get the driver from thread local copy of webdriver
	
	public static synchronized WebDriver getDriver() {
		return tldriver.get();//this get method returns normal webdriver. since if we use tldriver its not returnning normal driver
		//so in order to cope up with that get method is used which returns Webdriver
	}
	
	
	
	//this method used to initialize properties
	public Properties init_prop()  {
		prop=new Properties();
		FileInputStream ip;
		String environment = "qa";
		//this is to set the path of config properties in order to get the values from there
		try {
			if(environment.equals("qa")) {
				// .means from current project fetch the config properties file
				ip=new FileInputStream("./src/test/resources/Config/Config.properties");
//				so moving the values from input stream to properties file
				prop.load(ip);
			}
			else if(environment.equals("uat")) {
				ip=new FileInputStream("./src/test/resources/Config/prod.config.properties");
				prop.load(ip);
				
			}
			else if(environment.equals("prod")) {
				ip=new FileInputStream("./src/test/resources/Config/uat.config.properties");
				prop.load(ip);
				
			}
			else {
				System.out.println("Please pass correct environment");
			}
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
		
	}
	
	//to get screenshot 
	public String getScreenshot() {
		
	File src=	((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
	String path=System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
	File Destination=new File(path);
	try {
		FileUtils.copyFile(src, Destination);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return path;
	}
}
