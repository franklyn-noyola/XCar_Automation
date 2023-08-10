package appiumtest;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class XCar {

	static AppiumDriver<MobileElement> driver;
	
	public static void main(String[] args) {
		try {
			mainActivity();
		}catch (Exception e){
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();			
		}

	}
	
	public static void mainActivity() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "samsung SM-A146P");
		cap.setCapability("udid","R92W50N9Q8Z");
		cap.setCapability("platformName","Android");
		cap.setCapability("platformVersion","13");
		cap.setCapability("appPackage","com.epicdeveloper.xcar");
		cap.setCapability("appActivity","com.epicdeveloper.xcar.MainActivity");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, cap);
		
		Thread.sleep(5000);
		
		MobileElement plateName = driver.findElement(By.id("com.epicdeveloper.xcar:id/name_user"));
		MobileElement password = driver.findElement(By.id("com.epicdeveloper.xcar:id/password_user"));
		MobileElement loginButton = driver.findElement(By.id("com.epicdeveloper.xcar:id/loginButton"));
		
		plateName.sendKeys("9143cyf");
		password.sendKeys("Demo1234");
		loginButton.click();
		Thread.sleep(2000);
	}

}
