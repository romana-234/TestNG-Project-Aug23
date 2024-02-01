package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CRMTEST {


WebDriver driver;
String browser;
String url;
String userName;
String password;

String dashboardValidationText = "Dashboard";

// Element list - By type
By USER_NAME_FIELD = By.xpath("//input[@id='user_name']");
By PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
By SINGIN_BUTTON_FIELD = By.xpath("//*[@id=\"login_submit\"]");
By DASHBOARD_VALIDATION_FIELD = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/header/div/strong");
By CUSTOMER_MENU_FIELD = By.xpath("/html/body/div[1]/aside[1]/div/nav/ul[2]/li[2]/a/span");
By ADD_CUSTOMER_MENU_FIELD = By.xpath("//*[@id=\"customers\"]/li[2]/a/span");
By ADD_CUSTOMER_VALIDATION_FIELD = By.xpath("/html/body/div[1]/section/div/div[2]/div/div[1]/div[1]/div/div/header/div/strong");
By FULL_NAME_FIELD = By.xpath("//*[@id=\"general_compnay\"]/div[1]/div/input");
By COMPANY_DROPWOWN_FIELD = By.xpath("//select[@name='company_name']");

@BeforeMethod
public void init() {
	System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
	driver = new ChromeDriver();
//	        
//    System.setProperty("webdriver.edge.driver", "/Users/romanaakter/Downloads/msedgedriver");
//	driver = new EdgeDriver ();
	
	driver.manage().deleteAllCookies();
	driver.get("https://codefios.com/ebilling/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@Test
public void testLogin() {
	driver.findElement(USER_NAME_FIELD).sendKeys("demo@codefios.com");
	driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
	driver.findElement(SINGIN_BUTTON_FIELD).click();

	Assert.assertEquals(driver.findElement(DASHBOARD_VALIDATION_FIELD).getText(), dashboardValidationText, "Dashboard page is not avliable!");


}
@AfterMethod
public void tearDown() {
	driver.close();
	driver.quit();
}

}