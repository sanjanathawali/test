package flipcart;

import java.time.Duration;



import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class flipcart {
  @Test
  public void setup() throws InterruptedException {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://www.flipkart.com/");
	//  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  
	  driver.findElement(By.className("_2doB4z")).click();
	  driver.findElement(By.className("_3704LK")).sendKeys("milton bottle"+Keys.ENTER);
	
	  
	  
	WebElement filterminprize=driver.findElement(By.className("_2YxCDZ"));
	Select selm=new Select(filterminprize);
	selm.selectByIndex(2);
	
	WebElement productdisplay= driver.findElement(By.xpath("//a[text()='MILTON THERMO HOT & COLD BOTTLE FLIP LID 1000 1000 ml B...']"));
		System.out.println("productdisplayed="+productdisplay.isDisplayed());
		
		
	WebElement filterdisplay=driver.findElement(By.xpath("//div[text()='500-3000+']"));
	System.out.println("filterdisplay="+filterdisplay.isDisplayed());
	
	Thread.sleep(30);
	try {
	 productdisplay.click();
	}
	catch(StaleElementReferenceException e) {
		productdisplay= driver.findElement(By.xpath("//a[text()='MILTON THERMO HOT & COLD BOTTLE FLIP LID 1000 1000 ml B...']"));
		productdisplay.click();
	}
	
	System.out.println("program end");

	
  }}