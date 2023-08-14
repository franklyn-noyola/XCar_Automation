package XCarTest;

import java.net.URL;
import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class mainLogin {

	public static String plateName;
	static AppiumDriver<MobileElement> driver;
	static ResourceBundle rb = ResourceBundle.getBundle("settings");
	public static String deviceName = rb.getString("deviceName");
	public static String deviceNameT = rb.getString("deviceNameT");
	public static String udid = rb.getString("udid");
	public static String udidT = rb.getString("udidT");
	public static String platformName = rb.getString("platformName");
	public static String platformNameT = rb.getString("platformNameT");
	public static String platformVersion = rb.getString("platformVersion");
	public static String platformVersionT = rb.getString("platformVersionT");
	public static String appPackage = rb.getString("appPackage");
	public static String appPackageT = rb.getString("appPackageT");
	public static String appActivity = rb.getString("appActivity");
	public static String appActivityMain = rb.getString("appActivityMain");
	public static String urlT = rb.getString("url");
	

	public static void main(String[] args) {
		try {
			setup();
			loginMain();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	

	public static void setup() {
		try {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(deviceName, deviceNameT);
			cap.setCapability(udid,udidT);
			cap.setCapability(platformName,platformNameT);
			cap.setCapability(platformVersion,platformVersionT);
			cap.setCapability(appPackage,appPackageT);
			cap.setCapability(appActivity,appActivityMain);
			URL url = new URL(urlT);
			driver = new AppiumDriver<MobileElement>(url, cap);
		Thread.sleep(5000);
		}catch (Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void loginMain() throws Exception{
		MobileElement plateName = driver.findElement(By.id("com.epicdeveloper.xcar:id/name_user"));
		MobileElement password = driver.findElement(By.id("com.epicdeveloper.xcar:id/password_user"));
		MobileElement loginButton = driver.findElement(By.id("com.epicdeveloper.xcar:id/loginButton"));
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
