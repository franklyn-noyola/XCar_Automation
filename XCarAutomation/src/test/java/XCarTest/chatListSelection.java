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


public class chatListSelection extends settings{
	AppiumDriver driver;
	settings setting = new settings();
	ResourceBundle rb = ResourceBundle.getBundle("settings");
	String chatList = rb.getString("chatList");
	String chatIcon = rb.getString("chatIcon");
	String chatBox = rb.getString("chatBox");
	String sendButton = rb.getString("sendButton");
	String plateNameField = rb.getString("plateNameField");
	String passwordField = rb.getString("passwordField");
	String buttonLogin = rb.getString("buttonLogin");
	String userLogin = rb.getString("userLogin");
	String passwordLogin = rb.getString("passwordLogin");
	String allowButton = rb.getString("allowButton");
	WebElement plateName;
	WebElement password;
	WebElement loginButton;
	WebElement chatSectionIcon;
	WebElement boxChat;
	WebElement buttonSend;
	
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
	public void chatList() throws Exception {
		loging();
		Thread.sleep(1000);
		driver = setting.driver;
		chatSectionIcon = driver.findElement(By.xpath(chatIcon));
		try {
			chatSectionIcon.click();
			Thread.sleep(1000);
			if (driver.findElements(By.xpath(chatList)).size() > 0) {
				Random random = new Random();
				int selectList = random.nextInt(1,driver.findElements(By.xpath(chatList)).size());
				System.out.println(selectList);
				driver.findElement(By.xpath(chatList+"["+selectList+"]")).click();
				Thread.sleep(3000);
			}else {
				System.out.println("Chat list is empty");
				Thread.sleep(2000);
				return;
			}
			if (driver.findElement(By.id(allowButton)) != null) {
				driver.findElement(By.id(allowButton)).click();
				Thread.sleep(1000);
			}
			boxChat = driver.findElement(By.id(chatBox));
			boxChat.click();
			boxChat.sendKeys("Hola, como estás");
			Thread.sleep(1000);
			buttonSend = driver.findElement(By.id(sendButton));
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