package pageObjects;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverFactory.DriverFactory;
import utilities.ConfigReader;
import utilities.Constant;
import utilities.ElementUtil;
import utilities.LoggerLoad;


public class POM_LoginPage {

	private WebDriver driver ;
	
	public POM_LoginPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		@FindBy(id = "username")
		WebElement LoginPage_username;
		@FindBy(id = "password")
		WebElement LoginPage_password;
		@FindBy(id = "login")
		WebElement LoginPage_loginBtn;	
		
		
	
		public String getLoginPageTitle() {
			return driver.getTitle();
		}
		
		public void enterValidCredentials(String validUserName,String validPwd) {
			ElementUtil.typeInputIntoElement(driver, LoginPage_username, validUserName, Constant.EXPLICIT_ELEMENT_WAIT_TIME); 
			ElementUtil.typeInputIntoElement(driver, LoginPage_password, validPwd, Constant.EXPLICIT_ELEMENT_WAIT_TIME); 
		}
		
		public void clickOnLoginBtn() {
			
			 ElementUtil.clickOnElement(driver, LoginPage_loginBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			 
		}
		
		public void verifyInvalidAppURL() {
			
			Properties prop = ConfigReader.getPropertyObject();			
			driver.get(prop.getProperty("invalidUrl"));
			
		}
		
		
}
