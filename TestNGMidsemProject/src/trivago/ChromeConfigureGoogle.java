package Selenium.group.project1.artifact1;


import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Login1 {
		
	WebDriver obj;
		
		@BeforeTest
		void configure(){
			String url="https://www.trivago.in/";
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium Softwares\\chromedriver.exe");
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
			
		
		
//		@Test (priority=1)
//		void signupopt()
//		{
//			WebElement element,element1,element2,element3;
//			element=obj.findElement(By.xpath("//*[@id=\"unified-sign-in\"]/section/div/div/div[1]/div[2]/ul/li[4]/button/span[2]"));
//			element.click();
//			element1=obj.findElement(By.id("ap_email"));
//			element1.sendKeys("singberry31@gmail.com");
//			element2=obj.findElement(By.id("ap_password"));
//			element2.sendKeys("abcd@1234");
//			element3=obj.findElement(By.id("signInSubmit"));
//			element3.click();
//			
//			
//		}
		
		@Test (priority=1)
		void google()
		{
			WebElement element,element1,element2;
			element=obj.findElement(By.xpath("//*[@id=\"unified-sign-in\"]/section/div/div/div[1]/div[2]/ul/li[2]/button/span[2]"));
			JavascriptExecutor js = (JavascriptExecutor)obj;
			js.executeScript("arguments[0].click();", element);
			element.click();
			element1=obj.findElement(By.xpath("//*[@id=\"identifierId\"]"));
			element1.sendKeys("500060649@stu.upes.ac.in");
			element2=obj.findElement(By.className("CwaK9"));
			element2.click();
				
		}

		
	}
