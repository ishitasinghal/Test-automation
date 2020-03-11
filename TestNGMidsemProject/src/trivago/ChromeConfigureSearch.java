package trivago;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;
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
		WebElement element;
		String state="Bengaluru";
		element=obj.findElement(By.xpath("//*[@id=\"querytext\"]"));
		element.sendKeys(state);
		List <WebElement> li = obj.findElements(By.linkText(state));
        	li.get(0).click();
	}
	
	@Test(priority=2)
	void datepicker()
	{
        obj.findElement(By.cssSelector("#js-fullscreen-hero > div.hero__content > form > div.df_overlay.js-overlay > div.df_container_calendar > div > table > tbody > tr:nth-child(4) > td:nth-child(3) > time")).click();
        obj.findElement(By.cssSelector("#js-fullscreen-hero > div.hero__content > form > div.df_overlay.js-overlay > div.df_container_calendar > div > table > tbody > tr:nth-child(4) > td:nth-child(4) > time")).click();
        obj.findElement(By.cssSelector("#js-fullscreen-hero > div.hero__content > form > button.dealform-button.dealform-button--guests.js-dealform-button-guests")).click();
	}

	
	@Test(priority=3)
	void assertions()
	{
		WebElement element;
		element=obj.findElement(By.cssSelector("#\\34 564186 > article > div.pos-relative.item__wrapper > div.item__flex-column > section > div:nth-child(2) > article.accommodation-list__cheapest--bdbcd.accommodation-list__article--6eab9 > h3"));
		Assert.assertTrue(element.isDisplayed());
		element.click();
	}
			
	@Test(priority=4)
	//assertion to check hotel names 
	void assertions2()
	{
		//WebElement element1;
		//element1=obj.findElement(By.className(""));
		//Assert.assertTrue(element1.isDisplayed());
		
	}
	@Test(priority=5)
	void showphotos()
	{
		WebElement element;
		element=obj.findElement(By.cssSelector("#\\34 564186 > article > div.pos-relative.item__wrapper > div.item__image-area > div.item__image-wrapper.pos-relative > div > img"));
		Assert.assertTrue(element.isDisplayed());
	}
	@Test(priority=6)
	void viewdeals() throws Exception  
	{
		WebElement element,element1;
		element=obj.findElement(By.cssSelector("#\\34 564186 > article > div.pos-relative.item__wrapper > div.item__flex-column > section > div.accommodation-list__rowLast--74ff5.accommodation-list__row--6a745 > article > div > div > button > span.accommodation-list__dealText--87ffb"));
		element.click();
		//obj.wait();
		ArrayList<String> newWindow = new ArrayList <String> (obj.getWindowHandles());
		obj.switchTo().window(newWindow.get(1));
		element1=obj.findElement(By.xpath("//*[@id=\"t-hdBookCTA\"]"));
		element1.click();
	}
						 
						       
	@AfterTest
	void quitbrowser()
	{
		//obj.quit();
	}

}

