package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Switchto {
	
	
	static WebDriver driver;
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();

	driver.get("https://profile.w3schools.com/log-in?redirect_url=https%3A%2F%2Fmy-learning.w3schools.com");
	String window=driver.getWindowHandle();
	System.out.println(window.toString());
	//driver.switchTo().newWindow(WindowType.TAB);

	//driver.navigate().to("https://www.techbeamers.com/java-coding-questions-software-testers/#q1");
	//driver.switchTo().window(window);
	
	
	
}
}
