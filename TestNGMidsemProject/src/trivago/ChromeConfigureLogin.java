package trivago;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeConfigureLogin {
	
WebDriver obj;
	
	@BeforeTest
	void configure(){
		String url="https://www.trivago.in/";
		System.setProperty("webdriver.chrome.driver", "E:\\SEM VI\\Test_Automation\\Softwares\\Drivers\\chromedriver.exe");
		obj=new ChromeDriver();
		obj.manage().window().maximize();
		obj.get(url);
	}
	@Test (priority=0)
	void clickonlogin()
	{
		WebElement element;
		element=obj.findElement(By.xpath("//*[@id=\"js_navigation\"]/div/div[1]/button"));
		String name=element.getText();
		Assert.assertTrue(name.contains("Log in"));
		element.click();
	}
	@Test (priority=1)
	void addcredentials()
	{
		WebElement element,element1;
		element=obj.findElement(By.xpath("//*[@id=\"check_email\"]"));
		element.sendKeys("prajjawalbanati16@gmail.com");
		element1=obj.findElement(By.xpath("//*[@id=\"login_email_submit\"]"));
		element1.click();
	}
	@Test (priority=2)
	void addpassword()
	{
		List <WebElement> li = obj.findElements(By.className(""));
	}

}
