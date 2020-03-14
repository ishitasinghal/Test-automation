package trivago;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ChromeConfigureLoginFacebook {
	
	WebDriver obj;
	
	@DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][] { { "prajjawalbanati16@gmail.com" , "u6y2IO@1" } };
    }
	
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
		element=obj.findElement(By.xpath("//*[@id=\"js_navigation\"]/div/div[1]/button/span"));
		String name=element.getText();
		Assert.assertTrue(name.contains("Log in"));
		element.click();
	}
	
	@Test (priority=1,dataProvider="data-provider")
	void signinoption(String username,String password)
	{
		WebElement element,element1,element2,element3;
		element=obj.findElement(By.xpath("//*[@id=\"unified-sign-in\"]/section/div/div/div[1]/div[2]/ul/li[3]/button/span[2]"));
		element.click();
		element1=obj.findElement(By.id("email"));
		Assert.assertTrue(element1.isDisplayed());
		element1.sendKeys(username);
		element2=obj.findElement(By.id("pass"));
		Assert.assertTrue(element2.isDisplayed());
		element2.sendKeys(password);
		element3=obj.findElement(By.id("loginbutton"));
		String name=element3.getText();
		Assert.assertTrue(name.contains("Log In"));
		element3.click();
	}
	
	@AfterTest
	void quitbrowser()
	{
		//obj.quit();		
	}

}
