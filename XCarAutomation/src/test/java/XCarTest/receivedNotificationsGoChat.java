package XCarTest;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import java.util.Random;
import java.util.ResourceBundle;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import appiumtest.settings;


public class receivedNotificationsGoChat extends settings{
	AppiumDriver<MobileElement> driver;
	settings setting = new settings();
	ResourceBundle rb = ResourceBundle.getBundle("settings");
	String notiList = rb.getString("notiList");
	String notiIcon = rb.getString("notiIcon");
	String notiGoChat = rb.getString("notiGoChat");
	String allowButton = rb.getString("allowButton");
	String chatBox = rb.getString("chatBox");
	String sendButton = rb.getString("sendButton");
	String plateNameField = rb.getString("plateNameField");
	String passwordField = rb.getString("passwordField");
	String buttonLogin = rb.getString("buttonLogin");
	String userLogin = rb.getString("userLogin");
	String passwordLogin = rb.getString("passwordLogin");
	MobileElement plateName;
	MobileElement password;
	MobileElement loginButton;
	MobileElement notiSectionIcon;
	MobileElement buttonSend;	
	MobileElement goChatButton;
	MobileElement boxChat;
	
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
	public void notiGoChat() throws Exception {
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
			goChatButton = driver.findElement(By.id(notiGoChat));
			goChatButton.click();
			Thread.sleep(1000);
			if (driver.findElement(By.id(allowButton)) != null) {
				driver.findElement(By.id(allowButton)).click();
				Thread.sleep(1000);
			}
			boxChat = driver.findElement(By.id(chatBox));
			boxChat.click();
			boxChat.sendKeys("Te estoy respondiendo el mensaje que me enviaste de un script de automatización");
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