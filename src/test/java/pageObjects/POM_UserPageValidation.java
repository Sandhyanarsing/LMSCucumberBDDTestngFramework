package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Constant;
import utilities.ElementUtil;

public class POM_UserPageValidation {
	
	private WebDriver driver;
	
	public POM_UserPageValidation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="user") WebElement UserBtn;
	@FindBy(xpath="//div[@class='signin-content']/mat-card/mat-card-title/div[1]") WebElement ManageUser;
	@FindBy(xpath="//div[@class='signin-content']/mat-card/mat-card-title/div[1]") WebElement ManageProgram;
	@FindBy(xpath="//p-table[@datakey='userId']") WebElement TableElement;
	
	public void clickOnUserBtn() {
		ElementUtil.clickOnElement(driver, UserBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}
	
	public void verifyManageUserText() {
		ElementUtil.getTextFromElement(driver, ManageUser, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		
	}
	
	public String getDashboardPageTitle() {
		return driver.getTitle();
	}
	
	public List<String> getActualColumnNames(){
		List<String> actualColumns = new ArrayList<>();
		List<WebElement> columnElements = TableElement.findElements(By.tagName("th"));
		
		for(WebElement columnElement : columnElements) {
			String columnName = columnElement.getText();
			actualColumns.add(columnName);
		}
		return actualColumns;
	}
	

}
