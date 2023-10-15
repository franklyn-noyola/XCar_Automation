package appiumtest;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;


public class settings {
	public static String plateName;
	public AppiumDriver driver;
	ResourceBundle rb = ResourceBundle.getBundle("settings");
	public String deviceName = rb.getString("deviceName");
	public String deviceNameT = rb.getString("deviceNameT");
	public String udid = rb.getString("udid");
	public String udidT = rb.getString("udidT");
	public String platformName = rb.getString("platformName");
	public String platformNameT = rb.getString("platformNameT");
	public String platformVersion = rb.getString("platformVersion");
	public String platformVersionT = rb.getString("platformVersionT");
	public String appPackage = rb.getString("appPackage");
	public String appPackageT = rb.getString("appPackageT");
	public String appActivity = rb.getString("appActivity");
	public String appActivityMain = rb.getString("appActivityMain");
	public String urlT = rb.getString("url");
	


	public void setup() {
		try {
			DesiredCapabilities cap = new DesiredCapabilities();
			//File appDir = new File("C:\\Users\\franklyn.noyola\\StudioProjects\\xcar\\app\\build\\outputs\\apk\\debug");
			//File app = new File(appDir, "xcar.apk");    
			cap.setCapability(deviceName, deviceNameT);
			cap.setCapability(udid,udidT);
			cap.setCapability(platformName,platformNameT);
			cap.setCapability(platformVersion,platformVersionT);
			cap.setCapability(appPackage,appPackageT);
			//cap.setCapability("app", app.getAbsolutePath());
			cap.setCapability(appActivity,appActivityMain);
			URL url = new URL(urlT);
			driver = new AppiumDriver(url, cap);
		Thread.sleep(5000);
		}catch (Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
}