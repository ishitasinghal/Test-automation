package trivago;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeConfigureSearch {
	
WebDriver obj;
	
	@BeforeTest
	void configure(){
		String url="https://www.trivago.in/";
		System.setProperty("webdriver.chrome.driver", "E:\\SEM VI\\Test_Automation\\Softwares\\Drivers\\chromedriver.exe");
		obj=new ChromeDriver();
		obj.manage().window().maximize();
		obj.get(url);
	}
	@Test(priority=1)
	void insertkeys()
	{
		WebElement element,element1,element2;
		String state="Bengaluru";
		element=obj.findElement(By.xpath("//*[@id=\"querytext\"]"));
		element.sendKeys(state);
		List<WebElement> li = driver.findElements(By.linkText(state));
        	li.get(0).click();
		element2=obj.findElement(By.xpath("//*[@id=\"js-fullscreen-hero\"]/div[1]/div[2]/button[2]"));
		element2.click();
		
	}
	
	@Test(priority=2)
	void assertions()
	{
		WebElement element;
		element=obj.findElement(By.cssSelector("#\\36 481954 > article > div.pos-relative.item__wrapper > div.item__flex-column > section > div:nth-child(2) > article > 
h3"));
		Assert.assertTrue(element.isEnabled());
		
	}
			
	@Test(priority=3)
	//assertion to check hotel names 
	void assertions2()
	{
		WebElement element1;
		element1=obj.findElement(By.className("item-link name__copytext"));
		Assert.assertTrue(element1.isEnabled());
		
	}
						 
	@Test(priority=4)
	void datepicker()
	{
        obj.findElement(By.cssSelector("#js-fullscreen-hero > div.hero__content > form > div.df_overlay.js-overlay > div.df_container_calendar > div > table > tbody > tr:nth-child(4) > td:nth-child(3) > time")).click();
        obj.findElement(By.cssSelector("#js-fullscreen-hero > div.hero__content > form > div.df_overlay.js-overlay > div.df_container_calendar > div > table > tbody > tr:nth-child(4) > td:nth-child(4) > time")).click();
        obj.findElement(By.cssSelector("#js-fullscreen-hero > div.hero__content > form > button.dealform-button.dealform-button--guests.js-dealform-button-guests")).click();
	}
						       
	@AfterTest
	void quitbrowser()
	{
		obj.quit();
	}

}

