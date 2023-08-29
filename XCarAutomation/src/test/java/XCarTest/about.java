package XCarTest;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import java.util.ResourceBundle;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import appiumtest.settings;


public class about extends settings{
	AppiumDriver<MobileElement> driver;
	settings setting = new settings();
	ResourceBundle rb = ResourceBundle.getBundle("settings");
	String settingMenuField = rb.getString("settingMenu");
	String about = rb.getString("about");
	String plateNameField = rb.getString("plateNameField");
	String passwordField = rb.getString("passwordField");
	String buttonLogin = rb.getString("buttonLogin");
	String userLogin = rb.getString("userLogin");
	String passwordLogin = rb.getString("passwordLogin");
	MobileElement plateName;
	MobileElement password;
	MobileElement loginButton;
	MobileElement settingMenu;
	MobileElement aboutSection;
	
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
	public void about() throws Exception {
		loging();
		Thread.sleep(1000);
		driver = setting.driver;
		settingMenu = driver.findElement(By.xpath(settingMenuField));
		try {
			
			settingMenu.click();
			Thread.sleep(1000);
			aboutSection = driver.findElement(By.xpath(about));
			aboutSection.click();
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