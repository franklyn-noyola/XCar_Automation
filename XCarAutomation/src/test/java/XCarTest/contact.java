package XCarTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.Random;
import java.util.ResourceBundle;
import io.appium.java_client.AppiumDriver;
import appiumtest.settings;


public class contact extends settings{
	AppiumDriver driver;
	settings setting = new settings();
	ResourceBundle rb = ResourceBundle.getBundle("settings");
	String settingMenuField = rb.getString("settingMenu");
	String contact = rb.getString("contact");
	String subjectSel = rb.getString("subject");
	String subjectOption1 = rb.getString("subjectOption1");
	String subjectOption2 = rb.getString("subjectOption2");
	String subjectOption3 = rb.getString("subjectOption3");
	String messageBox = rb.getString("messageBox");
	String sendButton = rb.getString("sendButtonContact");
	String plateNameField = rb.getString("plateNameField");
	String passwordField = rb.getString("passwordField");
	String buttonLogin = rb.getString("buttonLogin");
	String userLogin = rb.getString("userLogin");
	String passwordLogin = rb.getString("passwordLogin");
	String selectedOption;
	String [] optionsSelected = {subjectOption1, subjectOption2, subjectOption3};
	WebElement plateName;
	WebElement password;
	WebElement loginButton;
	WebElement settingMenu;
	WebElement contactField;
	WebElement optionSelect;
	WebElement boxMessage;
	WebElement selectList;
	WebElement buttonSend;
	
	
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
	public void contacts() throws Exception {
		loging();
		Thread.sleep(1000);
		driver = setting.driver;
		settingMenu = driver.findElement(By.xpath(settingMenuField));
		try {
			settingMenu.click();
			Thread.sleep(1000);
			contactField = driver.findElement(By.xpath(contact));
			contactField.click();
			Thread.sleep(1000);			
			selectList = driver.findElement(By.id(subjectSel));
			selectList.click();
			Thread.sleep(1000);
			optionSelect = driver.findElement(By.xpath(selectedOption));
			optionSelect.click();
			Thread.sleep(1000);
			boxMessage = driver.findElement(By.id(messageBox));
			boxMessage.sendKeys("This is a test for automation");
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