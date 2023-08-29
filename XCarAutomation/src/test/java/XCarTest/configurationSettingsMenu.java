package XCarTest;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import java.util.ResourceBundle;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import appiumtest.settings;
import java.util.Random;

public class configurationSettingsMenu extends settings{
	AppiumDriver<MobileElement> driver;
	loginMain login = new loginMain();
	settings setting = new settings();
	ResourceBundle rb = ResourceBundle.getBundle("settings");
	String settingMenuField = rb.getString("settingMenu");
	String configurationSection = rb.getString("settingOption");
	String spanish = rb.getString("spanishOption");
	String english = rb.getString("englishOption");
	String french = rb.getString("frenchOption");
	String german = rb.getString("germanOption");
	String italian = rb.getString("italianOption");
	String portuguese = rb.getString("portugueseOption");
	String russian = rb.getString("russianOption");
	String chinese = rb.getString("chineseOption");
	String japanese = rb.getString("japaneseOption");
	String dutch = rb.getString("dutchOption");
	String poland = rb.getString("polandOption");
	String korean = rb.getString("koreanOption");
	String swedish = rb.getString("swedishOption");
	String arabic = rb.getString("arabicOption");
	String hindi = rb.getString("hindiOption");
	String urdu = rb.getString("urduOption");
	String changeLan = rb.getString("changeLanguageButton");
	String[] selectedOption = {spanish, english, italian, portuguese, russian, chinese, japanese, dutch, poland, korean, swedish, arabic, hindi, urdu};
	String optionSelected;
	String plateNameField = rb.getString("plateNameField");
	String passwordField = rb.getString("passwordField");
	String buttonLogin = rb.getString("buttonLogin");
	String userLogin = rb.getString("userLogin");
	String passwordLogin = rb.getString("passwordLogin");
	MobileElement plateName;
	MobileElement password;
	MobileElement loginButton;
	MobileElement settingMenu;
	MobileElement settingSectionOption;
	MobileElement selectedLanguage;
	MobileElement changeLanButton;
	
	@BeforeTest
	public void setUp() throws Exception {
		Random random = new Random();
		
		optionSelected = selectedOption[random.nextInt(selectedOption.length)];
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
	public void configurationMenu() throws Exception {
		loging();
		Thread.sleep(1000);
		driver = setting.driver;
		settingMenu = driver.findElement(By.xpath(settingMenuField));
		try {
			settingMenu.click();
			Thread.sleep(1000);
			settingSectionOption = driver.findElement(By.xpath(configurationSection));
			settingSectionOption.click();
			Thread.sleep(1000);
			changeLanButton = driver.findElement(By.id(changeLan));
			changeLanButton.click();
			Thread.sleep(1000);
			selectedLanguage = driver.findElement(By.id(optionSelected));
			selectedLanguage.click();
			Thread.sleep(1000);
			changeLanButton.click();
			Thread.sleep(2000);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
}