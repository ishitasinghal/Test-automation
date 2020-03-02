package Selenium.group.project1.artifact1;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class website {
	
	WebDriver driver;
	
	@BeforeTest
	void configure(){
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Softwares\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test (priority = 0)
	void navigation() {
		
        driver.navigate().to("http://www.google.com/");
        WebElement e1 = driver.findElement(By.name("q"));
	   	e1.sendKeys("trivago");
        driver.navigate().to("https://www.trivago.in/");
	}
	
	@Test (priority = 1)
	void searchHotel() {
        
        WebElement e2 = driver.findElement(By.id("querytext"));
        e2.sendKeys("Mumbai");
        
        WebElement e3 = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[3]/div[1]/div[2]/button[2]"));
        e3.click();
        
        WebElement e4 = driver.findElement(By.xpath("//*[@id=\"js-fullscreen-hero\"]/div[1]/div[2]/div[2]/button[3]/span/span[2]/time"));
        e4.sendKeys("Sun, 08-03-2020");
        
        
      
	}
	
	@AfterTest
	void closecon() {
	     driver.close();
	  }
	}
       
