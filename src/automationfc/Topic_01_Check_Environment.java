package automationfc;
 
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
public class Topic_01_Check_Environment {
WebDriver driver;
 
@BeforeClass
public void beforeClass() {
System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/libraries/chromedriver");
driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.get("http://demo.guru99.com/v4/");
}
 
@Test
public void TC_01_ValidateCurrentUrl() {
	// Login Page Url matching
	String loginPageUrl = driver.getCurrentUrl();
	Assert.assertEquals(loginPageUrl, "https://www.facebook.com/");
}

@Test
public void TC_02_ValidatePageTitle() {
	// Login Page title
	String loginPageTitle = driver.getTitle();
	Assert.assertEquals(loginPageTitle, "Facebook – log in or sign up");
}

@Test
public void TC_03_LoginFormDisplayed() {
	// Login form displayed
	Assert.assertTrue(driver.findElement(By.xpath("//form[@data-testid='royal_login_form']")).isDisplayed());
}

@AfterClass
public void afterClass() {
	// quit
	driver.quit();
}
}