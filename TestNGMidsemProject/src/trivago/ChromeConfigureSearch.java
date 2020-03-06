package trivago;

import org.testng.Assert;
import org.testng.annotations.*;
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
	void assertions()
	{
		WebElement element;
		element=obj.findElement(By.xpath("//*[@id=\"98422\"]/article/div[1]/div[2]/section/div[1]/article/button"));
		Assert.assertTrue(element.isDisplayed());
		element.click();
	}
	@AfterTest
	void quitbrowser()
	{
//		obj.quit();
	}

}

