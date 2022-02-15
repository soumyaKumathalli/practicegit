package TestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class selectdropdown {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
//		driver.get("https://www.amazon.in/");
		driver.navigate().to("https://www.goibibo.com/");
		
//	List<WebElement> dropdown=driver.findElements(By.xpath("//select[@id='searchDropdownBox']/option"));
//	for(WebElement ele:dropdown) {
//		System.out.println(ele.getText());
//	}
//		Select select=new Select(dropdown);
//		select.selectByVisibleText("Amazon Fashion");
	
	
	//verify element
//	these elements can include drop boxes, buttons, checkboxes, labels, and more for isselected
		
		WebElement ll=driver.findElement(By.xpath("(//span[@class='sc-jQrDum gMuQGX'])[2]"));
		Boolean so=ll.isSelected();
		if( so==false) {//if the radio is not selected then it will click
			ll.click();
			
		}
		else {
			System.out.println("false");
		}
		
		
		
		
		
	}

}
