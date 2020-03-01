package Selenium.group.project1.artifact1;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class website {
	
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","C:\\Selenium Softwares\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        
        driver.navigate().to("http://www.google.com/");
        WebElement e1 = driver.findElement(By.name("q"));
	   	e1.sendKeys("trivago");
        driver.navigate().to("https://www.trivago.in/");
        
        WebElement e2 = driver.findElement(By.id("querytext"));
        e2.sendKeys("Bengaluru");
        
        WebElement e3 = driver.findElement(By.xpath("//*[@id=\"js-fullscreen-hero\"]/div[1]/div[2]/button[2]/span[2]"));
        e3.click();
	     driver.close();
	  }
	}

 

    
   
        
        
       
        