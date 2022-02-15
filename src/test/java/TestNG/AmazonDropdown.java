package TestNG;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class AmazonDropdown {
		
		
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		//WebElement dropdown=driver.findElement(By.xpath("//span[@class='icp-nav-flag icp-nav-flag-in']"));
		
		
		//use this when we hover then dropdown will be shown
		//pass the driver to actions
		//Actions action=new Actions(driver);
		
		//action.moveToElement(dropdown).perform();
		
		
//		driver.findElement(By.xpath("//span[contains(text(),'KN')]")).click();

		
		
		
	}
	}



