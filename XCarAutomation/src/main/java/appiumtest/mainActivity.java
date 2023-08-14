package appiumtest;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class mainActivity extends settings{

	public static AppiumDriver<MobileElement> driver;
	
	
/*	public mainActivity(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}*/
	
	@FindBy(how=How.ID, using = "com.epicdeveloper.xcar:id/name_user")	
	@CacheLookup
	public MobileElement plateName;
	
	@FindBy(how=How.ID, using = "com.epicdeveloper.xcar:id/password_user")	
	@CacheLookup
	public MobileElement password;
	
	@FindBy(how=How.ID, using = "com.epicdeveloper.xcar:id/loginButton")	
	@CacheLookup
	public MobileElement loginButton;
	
	public void mainPage() throws Exception  {
		driver = settings.driver;
		try {		
			plateName.sendKeys("9143cyf");
			password.sendKeys("Demo1234");
			loginButton.click();
			Thread.sleep(2000);
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	}

}
