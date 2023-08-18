package XCarTest;

import org.openqa.selenium.By;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import java.util.ResourceBundle;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import appiumtest.settings;


public class loginAndLogOut extends loginMain{
	AppiumDriver<MobileElement> driver;
	loginMain login = new loginMain();
	settings setting = new settings();
	ResourceBundle rb = ResourceBundle.getBundle("settings");
	String settingMenuField = rb.getString("settingMenu");
	String logOutButton = rb.getString("logoutOption");
	String buttonOK = rb.getString("OKButton");
	MobileElement settingMenu;
	MobileElement logOutOption;
	MobileElement OKButton;
		
	@BeforeTest
	public void setUp() throws Exception {
		login.loging();
	}
	
	@Test
	public void logOut() throws Exception {
		Thread.sleep(1000);
		settingMenu = driver.findElement(By.xpath(settingMenuField));
		
		try {
			
			settingMenu.click();
			Thread.sleep(1000);
			logOutOption = driver.findElement(By.xpath(logOutButton));
			logOutOption.click();
			Thread.sleep(1000);
			OKButton = driver.findElement(By.id(buttonOK));
			OKButton.click();
			Thread.sleep(2000);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	
}
