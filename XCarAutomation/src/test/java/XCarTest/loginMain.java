package XCarTest;

import org.testng.annotations.*;
import org.testng.annotations.Test;
import java.util.ResourceBundle;
import org.openqa.selenium.By;
import io.appium.java_client.AppiumDriver;
import appiumtest.settings;
import io.appium.java_client.MobileElement;
public class loginMain extends settings{
	settings setting = new settings();
	static AppiumDriver<MobileElement> driver;
	ResourceBundle rb = ResourceBundle.getBundle("settings");
	String plateNameField = rb.getString("plateNameField");
	String passwordField = rb.getString("passwordField");
	String buttonLogin = rb.getString("buttonLogin");
	String userLogin = rb.getString("userLogin");
	String passwordLogin = rb.getString("passwordLogin");
	MobileElement plateName;
	MobileElement password;
	MobileElement loginButton;
	
	
	
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

	@Test
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
	
}

