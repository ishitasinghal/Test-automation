package trivago;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ChromeConfigureLoginAmazon {
	
		WebDriver obj;
		@DataProvider(name = "data-provider")
	    public Object[][] dataProviderMethod() {
	        return new Object[][] { { "prajjawalbanati16@gmail.com" , "puneet321banati" } };
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
			void signupopt(String username,String password)
			{
				WebElement element,element1,element2,element3;
				element=obj.findElement(By.xpath("//*[@id=\"unified-sign-in\"]/section/div/div/div[1]/div[2]/ul/li[4]/button/span[2]"));
				element.click();
				element1=obj.findElement(By.id("ap_email"));
				element1.sendKeys(username);
				element2=obj.findElement(By.id("ap_password"));
				element2.sendKeys(password);
				element3=obj.findElement(By.id("signInSubmit"));
				element3.click();
				
				
			}
			@AfterTest
			void closebrowser()
			{
				obj.quit();
			}

		}
