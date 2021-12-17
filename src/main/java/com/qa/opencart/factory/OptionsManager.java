package com.qa.opencart.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions of;
	
	
	public OptionsManager( Properties prop) {
		//we dont create driver so here we need toget the values from config properties so use prop here
		this.prop=prop;
	}

	
	public ChromeOptions getchromeoptions() {
	co=new 	ChromeOptions();
	if(Boolean.parseBoolean(prop.getProperty("headless"))) {
		co.addArguments("--headless");
	}
	if(Boolean.parseBoolean(prop.getProperty("incognito"))) {
		co.addArguments("--incognito");

	}
	return co;
	}
	
	
	public FirefoxOptions getFirefoxOptions() {
		of=new 	FirefoxOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) {
			of.addArguments("--headless");
		}
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) {
			of.addArguments("--incognito");

		}
		return of;
		}
	
}
