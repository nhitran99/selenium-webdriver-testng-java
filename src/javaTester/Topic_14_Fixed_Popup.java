package javaTester;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 

public class Topic_14_Fixed_Popup {
		WebDriver driver;
		String projectPath = System.getProperty("user.dir");
		String osName = System.getProperty("os.name");
	
		@BeforeClass
		public void beforeClass() {
				System.out.println(projectPath);
				if (osName.contains("Mac")) {
					System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
				}	
				
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().window().maximize();
		}
		
		@Test
		public void TC_01() {
		driver.get("https://ngoaingu24h.vn/"); 
		
		
		By loginPopup = By.cssSelector("div#modal-login-v1[style]");
		
		// Check popup ko hien thi
		
		Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());
		
		//Click login button
		
		driver.findElement(By.cssSelector("button.login_")).click();
		 
		// Popup login hien thi
		
		Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());
		driver.findElement(loginPopup);

		
		
 

		
		
		}
		
		@AfterClass
		public void afterClass() {
			driver.quit();
		}
		}
		