package TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


//so for testng use before mthod isntead of before test


//we can pass parameters to any of the annotations and we can pass n number of paarmeters**********************

//if we use before method and 3 test annotations so it will call bf and test amd after method then again bm with 2nd test case and after method
//for 3 times it will open
public class Sample {
	//bout for before test only one time browser will be opened
	WebDriver driver;
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		driver.get("https://www.google.com");
	}
	
	@Parameters({"url"})
	@Test()
	public void run(String url) {
		boolean flag=driver.findElement(By.name("q")).isDisplayed();
		//Assertion
		Assert.assertTrue(flag);
		System.out.println(url);
	}
	
	
	@AfterTest
	public void quit() {
		
	}

}
