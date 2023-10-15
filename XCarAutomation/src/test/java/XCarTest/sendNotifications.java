package XCarTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.Random;
import java.util.ResourceBundle;
import io.appium.java_client.AppiumDriver;
import appiumtest.settings;


public class sendNotifications extends settings{
	AppiumDriver driver;
	settings setting = new settings();
	ResourceBundle rb = ResourceBundle.getBundle("settings");
	String notiIcon = rb.getString("notiIcon");
	String targetUser = rb.getString("targetUser");
	String sendNotificationFab = rb.getString("sendButtonFab");
	String subjectSel = rb.getString("subject");
	String subjectOption1 = rb.getString("subjectOption1");
	String subjectOption2 = rb.getString("subjectOption2");
	String subjectOption3 = rb.getString("subjectOption3");
	String subjectOption4 = rb.getString("subjectOption4");
	String subjectOption5 = rb.getString("subjectOption5");
	String subjectOption6 = rb.getString("subjectOption6");
	String notiMessage = rb.getString("notiMessage");
	String sendButton = rb.getString("notiSendButton");
	String plateNameField = rb.getString("plateNameField");
	String passwordField = rb.getString("passwordField");
	String buttonLogin = rb.getString("buttonLogin");
	String userLogin = rb.getString("userLogin");
	String passwordLogin = rb.getString("passwordLogin");
	String selectedOption;
	String [] optionsSelected = {subjectOption1, subjectOption2, subjectOption3, subjectOption4, subjectOption5, subjectOption6};
	WebElement plateName;
	WebElement  password;
	WebElement  loginButton;
	WebElement  sendNotiFab;
	WebElement  iconNoti;
	WebElement  userTarget;
	WebElement  optionSelect;
	WebElement  boxMessage;
	WebElement  selectList;
	WebElement  buttonSend;
	
	
	@BeforeTest	
	public void setup () {
		Random random = new Random();
		selectedOption = optionsSelected[random.nextInt(optionsSelected.length)];
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
	public void sendNotification() throws Exception {
		loging();
		Thread.sleep(1000);
		driver = setting.driver;
		iconNoti = driver.findElement(By.xpath(notiIcon));
		try {
			iconNoti.click();
			Thread.sleep(2000);
			sendNotiFab = driver.findElement(By.id(sendNotificationFab));
			sendNotiFab.click();
			Thread.sleep(1000);
			userTarget = driver.findElement(By.id(targetUser));			
			userTarget.sendKeys("9876jcx");
			Thread.sleep(1000);
			selectList = driver.findElement(By.id(subjectSel));
			selectList.click();
			Thread.sleep(1000);
			optionSelect = driver.findElement(By.xpath(selectedOption));
			optionSelect.click();
			Thread.sleep(1000);
			boxMessage = driver.findElement(By.id(notiMessage));
			boxMessage.sendKeys("This was sending as an automation script");
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