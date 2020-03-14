package trivago;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeConfigureRegister {
	
	WebDriver obj;
	
	@BeforeTest
	void configure()
	{
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
	void createaccount()
	{
		WebElement element;
		element=obj.findElement(By.xpath("//*[@id=\"login_signup_link\"]"));
		String name=element.getText();
		Assert.assertTrue(name.contains("Create an account"));
		element.click();
	}
	@Test (priority=2)
	void addcredentials()
	{
		WebElement element,element1;
		element=obj.findElement(By.xpath("//*[@id=\"register_email\"]"));
		element.sendKeys("singhuser1@gmail.com");
		element1=obj.findElement(By.xpath("//*[@id=\"register_password\"]"));
		element1.sendKeys("123456");
	}
	@Test (priority=3)
	void register()
	{
		WebElement element;
		element=obj.findElement(By.xpath("//*[@id=\"register_email_submit\"]"));
		String name=element.getText();
		Assert.assertTrue(name.contains("Register"));
		element.click();
	}
	@AfterTest
	void closebrowser()
	{
		obj.quit();
	}

}
