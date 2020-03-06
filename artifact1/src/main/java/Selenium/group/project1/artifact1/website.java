package trivago;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class ChromeConfigureSearch {
WebDriver obj;
	@BeforeTest
	void configure(){
		String url="https://www.trivago.in/";
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Softwares\\chromedriver.exe");
		obj=new ChromeDriver();
		obj.manage().window().maximize();
		obj.get(url);
	}
	@Test(priority=1)
	void insertkeys()
	{
		WebElement element,element2;
		String state="Bengaluru";
		element=obj.findElement(By.xpath("//*[@id=\"querytext\"]"));
		element.sendKeys(state);
		List<WebElement> li = obj.findElements(By.linkText(state));
        	li.get(0).click();
		element2=obj.findElement(By.xpath("//*[@id=\"js-fullscreen-hero\"]/div[1]/div[2]/button[2]"));
		element2.click();
		
	}
	
	@Test(priority=2)
	void assertions1()
	{
		WebElement element;
		element=obj.findElement(By.cssSelector("#\\34 564186 > article > div.pos-relative.item__wrapper > div.item__flex-column > section > div > div.item__best-details.item__best-details--with-strikethrough.item__best-details--insights > div > strong"));
		Assert.assertTrue(element.isEnabled());
		
	}
	
	@Test(priority=3)
	//assertion to check hotel names 
	void assertions2()
	{
		WebElement element1;
		element1=obj.findElement(By.cssSelector("#\\34 564186 > article > div.pos-relative.item__wrapper > div.item__flex-column > div > div.item__name.item__name--link > h3 > span"));
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

