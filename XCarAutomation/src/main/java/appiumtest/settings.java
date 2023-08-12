package appiumtest;

import java.net.URL;
import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class settings {
	public static String plateName;
	static AppiumDriver driver;
	ResourceBundle rb = ResourceBundle.getBundle("settiings");
	public String deviceName = rb.getString("deviceName");
	public String deviceNameT = rb.getString("deviceNameT");
	public String uid = rb.getString("uid");
	public String uidT = rb.getString("uidT");
	public String platformName = rb.getString("platformName");
	public String platformNameT = rb.getString("platformNameT");
	public String platformVersion = rb.getString("platformVersion");
	public String platformVersionT = rb.getString("platformVersionT");
	public String appPackage = rb.getString("appPackage");
	public String appPackageT = rb.getString("appPackageT");
	public String appActivity = rb.getString("appActivity");
	public String appActivityMain = rb.getString("appActivityMain");


	public void setup() {
		try {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(deviceName, deviceNameT);
			cap.setCapability("udid","R92W50N9Q8Z");
			cap.setCapability("platformName","Android");
			cap.setCapability("platformVersion","13");
			cap.setCapability("appPackage","com.epicdeveloper.xcar");
			cap.setCapability("appActivity","com.epicdeveloper.xcar.MainActivity");
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AppiumDriver<MobileElement>(url, cap);
		Thread.sleep(5000);
		}catch (Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
}