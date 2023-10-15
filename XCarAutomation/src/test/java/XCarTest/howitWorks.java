package XCarTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.ResourceBundle;
import io.appium.java_client.AppiumDriver;
import appiumtest.settings;


public class howitWorks extends settings{
	AppiumDriver driver;
	settings setting = new settings();
	ResourceBundle rb = ResourceBundle.getBundle("settings");
	String settingMenuField = rb.getString("settingMenu");
	String howitworks = rb.getString("howitworks");
	String plateNameField = rb.getString("plateNameField");
	String passwordField = rb.getString("passwordField");
	String buttonLogin = rb.getString("buttonLogin");
	String userLogin = rb.getString("userLogin");
	String passwordLogin = rb.getString("passwordLogin");
	WebElement plateName;
	WebElement password;
	WebElement loginButton;
	WebElement settingMenu;
	WebElement howitwork;
	
	@BeforeTest	
	public void setup () {
		setting.setup();
	}
	
	public void setUpField() throws Exception {
		driver = setting.driver;
		plateName = driver.findElement(By.id(plateNameField));
		password = driver.findElement(By.id(passwordField));
		loginButton = driver.findElement(By.id(buttonLogin));
	}
	
	public void loging() throws Exception {
		setUpField();
		try {		
				plateName.sendKeys(userLogin);
				password.sendKeys(passwordLogin);
				loginButton.click();
				Thread.sleep(2000);		
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	@Test
	public void howitworks() throws Exception {
		loging();
		Thread.sleep(1000);
		driver = setting.driver;
		settingMenu = driver.findElement(By.xpath(settingMenuField));
		try {
			
			settingMenu.click();
			Thread.sleep(1000);
			howitwork = driver.findElement(By.xpath(howitworks));
			howitwork.click();
			Thread.sleep(2000);			
		}catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}