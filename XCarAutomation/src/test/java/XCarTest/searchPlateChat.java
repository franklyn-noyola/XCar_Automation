package XCarTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.*;

import com.google.common.collect.ImmutableMap;

import java.util.ResourceBundle;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import appiumtest.settings;


public class searchPlateChat extends settings{
	AppiumDriver<MobileElement> driver;
	settings setting = new settings();
	ResourceBundle rb = ResourceBundle.getBundle("settings");
	String searchField = rb.getString("searchField");
	String gotoChat = rb.getString("gotoChat");
	String chatBox = rb.getString("chatBox");
	String sendButton = rb.getString("sendButton");
	String plateNameField = rb.getString("plateNameField");
	String passwordField = rb.getString("passwordField");
	String buttonLogin = rb.getString("buttonLogin");
	String userLogin = rb.getString("userLogin");
	String allowButton = rb.getString("allowButton");
	String passwordLogin = rb.getString("passwordLogin");
	MobileElement plateName;
	MobileElement password;
	MobileElement loginButton;
	MobileElement searchFieldButton;
	MobileElement gotoChatButton;
	MobileElement boxChat;
	MobileElement buttonSend;
	
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
	public void searchPlate() throws Exception {
		loging();
		Thread.sleep(1000);
		driver = setting.driver;
		searchFieldButton = driver.findElement(By.id(searchField));
		try {
			searchFieldButton.click();
			searchFieldButton.sendKeys("9876jcx");
			Thread.sleep(1000);
			driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
			Thread.sleep(1000);
			gotoChatButton = driver.findElement(By.id(gotoChat));
			gotoChatButton.click();
			Thread.sleep(1000);
			if (driver.findElement(By.id(allowButton)) != null) {
				driver.findElement(By.id(allowButton)).click();
				Thread.sleep(1000);
			}
			boxChat = driver.findElement(By.id(chatBox));
			boxChat.click();
			boxChat.sendKeys("Esto fue en viado por un script de automatización por el campo de búsqueda de matricula desde la pagina de inicio");
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