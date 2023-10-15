package XCarTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import com.google.common.collect.ImmutableMap;

import java.util.Random;
import java.util.ResourceBundle;
import io.appium.java_client.AppiumDriver;
import appiumtest.settings;


public class receivdeNotificationsReply extends settings{
	AppiumDriver driver;
	settings setting = new settings();
	ResourceBundle rb = ResourceBundle.getBundle("settings");
	String notiList = rb.getString("notiList");
	String notiIcon = rb.getString("notiIcon");
	String notiReply = rb.getString("notiReply");
	String sendNotiButton = rb.getString("notiSendButton");
	String notiMessage = rb.getString("notiMessage");
	String plateNameField = rb.getString("plateNameField");
	String passwordField = rb.getString("passwordField");
	String buttonLogin = rb.getString("buttonLogin");
	String userLogin = rb.getString("userLogin");
	String passwordLogin = rb.getString("passwordLogin");
	WebElement plateName;
	WebElement password;
	WebElement loginButton;
	WebElement notiSectionIcon;
	WebElement buttonSend;
	WebElement messageNoti;
	WebElement notiReplyButton;
	
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
	public void notiReply() throws Exception {
		loging();
		Thread.sleep(1000);
		driver = setting.driver;
		notiSectionIcon = driver.findElement(By.xpath(notiIcon));
		try {
			notiSectionIcon.click();
			Thread.sleep(1000);
			if (driver.findElements(By.xpath(notiList)).size() > 0) {
				Random random = new Random();
				int selectList = random.nextInt(1,driver.findElements(By.xpath(notiList)).size());
				System.out.println(selectList);
				driver.findElement(By.xpath(notiList+"["+selectList+"]")).click();
				Thread.sleep(1000);
			}else {
				System.out.println("Chat list is empty");
				Thread.sleep(2000);
				return;
			}
			notiReplyButton = driver.findElement(By.id(notiReply));
			notiReplyButton.click();
			Thread.sleep(1000);
			messageNoti = driver.findElement(By.id(notiMessage));
			messageNoti.sendKeys("Thi is Appium automation reply notification sent");
			Thread.sleep(2000);
			buttonSend = driver.findElement(By.id(sendNotiButton));
			buttonSend.click();
			Thread.sleep(3000);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}