package XCarTest;

import org.testng.annotations.*;
import org.testng.annotations.Test;
import java.util.ResourceBundle;
import org.openqa.selenium.By;
import io.appium.java_client.AppiumDriver;
import appiumtest.settings;
import io.appium.java_client.MobileElement;

public class resetPass extends loginMain{
	settings setting = new settings();
	static AppiumDriver<MobileElement> driver;
	ResourceBundle rb = ResourceBundle.getBundle("settings");
	String forgottenPassLink = rb.getString("forgottenPassLink");
	String resetButton = rb.getString("resetButton");
	String plateNumberReset = rb.getString("plateNumberReset");
	String emailReset = rb.getString("emailReset");
	String passwordLogin = rb.getString("passwordLogin");
	MobileElement forgottenPass;
	MobileElement buttonReset;
	MobileElement resetplateNumber;
	MobileElement resetEmail;
	
	
	
	@BeforeTest	
	public void setup () {
		setting.setup();
		
	}
	
	@Test
	public void loging() throws Exception {
		Thread.sleep(2000);
		driver = setting.driver;
		forgottenPass = driver.findElement(By.id(forgottenPassLink));
		try {		
				forgottenPass.click();
				Thread.sleep(1000);
				resetplateNumber = driver.findElement(By.id(plateNumberReset));
				resetplateNumber.sendKeys("9143cyf");
				resetEmail = driver.findElement(By.id(emailReset));
				resetEmail.sendKeys("fnoyola@hotmail.com");
				buttonReset = driver.findElement(By.id(resetButton));
				buttonReset.click();
				Thread.sleep(1000);	
				buttonReset.click();
				Thread.sleep(2000);	
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
}
