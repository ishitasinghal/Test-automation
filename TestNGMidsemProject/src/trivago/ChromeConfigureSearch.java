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
		WebElement element,element1,element2,element3;
        element=obj.findElement(By.cssSelector("#js-fullscreen-hero > div.hero__content > form > div.df_overlay.js-overlay > div.df_container_calendar > div > table > tbody > tr:nth-child(4) > td:nth-child(3) > time"));
        element.click();
        element1=obj.findElement(By.cssSelector("#js-fullscreen-hero > div.hero__content > form > div.df_overlay.js-overlay > div.df_container_calendar > div > table > tbody > tr:nth-child(4) > td:nth-child(4) > time"));
        element1.click();
        element2=obj.findElement(By.cssSelector("#js-fullscreen-hero > div.hero__content > form > button.dealform-button.dealform-button--guests.js-dealform-button-guests"));
        element2.click();
        element3=obj.findElement(By.cssSelector("#js-fullscreen-hero > div.hero__content > form > button.btn.btn--primary.btn--regular.search-button.js-search-button > span.search-button__label"));
        element3.click();
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority=3)
	void viewdeals() 
	{
		WebElement element;
		try {
			element=obj.findElement(By.cssSelector("#\\31 7405474 > article > div.pos-relative.item__wrapper > div.item__flex-column > section > div.accommodation-list__rowLast--5c118.accommodation-list__row--e335c > article > div > div > button > span > span.accommodation-list__text--bd4f5"));
			element.click();
		}
		catch(Exception ex)
		{
			element=obj.findElement(By.cssSelector("#\\31 7405474 > article > div.pos-relative.item__wrapper > div.item__flex-column > section > div.accommodation-list__rowLast--5c118.accommodation-list__row--e335c > article > div > div > button > span > span.accommodation-list__text--bd4f5"));
			element.click();			
		}
		ArrayList<String> newWindow = new ArrayList <String> (obj.getWindowHandles());
		obj.switchTo().window(newWindow.get(0));
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority=4)
	void booknow()
	{
		
		WebElement element;
		ArrayList<String> newWindow = new ArrayList <String> (obj.getWindowHandles());
		obj.switchTo().window(newWindow.get(1));
		element=obj.findElement(By.xpath("//*[@id=\"t-hdBookCTA\"]"));
		element.click();
	}
				 					       
	@AfterTest
	void quitbrowser()
	{
		//obj.quit();
	}

}