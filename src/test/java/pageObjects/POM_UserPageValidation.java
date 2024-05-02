package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
	@FindBy(xpath="//div[@class = 'p-datatable-wrapper ng-star-inserted']") WebElement TableElement;
	//@FindBy(xpath="//div/mat-card/mat-card-title/div[2]/div[1]/button/span[1]") WebElement DeleteButton;
	@FindBy(xpath="//button[@class='p-button-danger p-button p-component p-button-icon-only']") WebElement DeleteButton;
	@FindBy(xpath="//button[@id='new']") WebElement AddNewUserBtn;
	@FindBy(xpath="//button[@label='Assign Student']") WebElement AssignStudentBtn;
	@FindBy(xpath="//button[@label='Assign Staff']") WebElement AssignStaffBtn;
	@FindBy(xpath="//input[@id='filterGlobal']") WebElement SearchTextBox;
	@FindBy(xpath="//div[@class='p-datatable-wrapper ng-star-inserted']/table/tbody") WebElement TableRowsElement;
	@FindBy(xpath="//div[@class='p-datatable-wrapper ng-star-inserted']/table/tbody/tr") WebElement TableRow;
	@FindBy(xpath="//div[@class='p-checkbox-box p-component']") WebElement Tablecheckbox;
	@FindBy(xpath="//div[@class='p-datatable-wrapper ng-star-inserted']/table/tbody/tr/td[3]") WebElement UserNameElement;
	@FindBy(xpath="//span[@class='p-paginator-current ng-star-inserted']") WebElement NoEntryText;
	@FindBy(xpath="//span[@class='p-paginator-current ng-star-inserted']") WebElement PaginationText;
	@FindBy(xpath="//span[@class='p-paginator-icon pi pi-angle-right']") WebElement NextIcon;
	@FindBy(xpath="//span[@class='p-paginator-icon pi pi-angle-double-right']") WebElement LastIcon;
	
	public void clickOnUserBtn() {
		ElementUtil.clickOnElement(driver, UserBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}
	
	public String verifyManageUserText() {
		String text = ElementUtil.getTextFromElement(driver, ManageUser, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		System.out.println("PRINTING MY TEXT HERE>>>> " + text);
		return text;
	}
	
	public String getDashboardPageTitle() {
		return driver.getTitle();
	}
	
	public String getUserPageTitle() {
		return driver.getTitle();
	}
	
	public List<String> getActualColumnNames(){
		List<String> actualColumns = new ArrayList<>();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds (Constant.EXPLICIT_ELEMENT_WAIT_TIME));
		System.out.println("PRINT SOMETHING HERE>>>>>>");
		List<WebElement> columnElements = TableElement.findElements(By.tagName("th"));
		
		for(int i=1; i<=columnElements.size()-1; i++) {
			WebElement columnElement = columnElements.get(i);
			String columnName = columnElement.getText();
			actualColumns.add(columnName);
		}
		return actualColumns;
	}
	
	public boolean checkDeleteButtonStatus(){
		
		//public boolean isDeleteButtonDisabled() 
		    return !DeleteButton.isEnabled();
		
		/*boolean isDisabled = !DeleteButton.isEnabled();
		if(isDisabled) {
			System.out.println("Delete button is disabled by default");
		} else {
			System.out.println("Delete button is enabled by default");
		}*/
	}

	public boolean isAddNewUserBtnPresent() {
		return AddNewUserBtn.isDisplayed();
	}
	
	public boolean isAssignStudentBtnPresent() {
		return AssignStudentBtn.isDisplayed();
	}
	
	public boolean isAssignStaffBtnPresent() {
		return AssignStaffBtn.isDisplayed();
	}
	
	public boolean isSearchTextBoxPresent() {
		return SearchTextBox.isDisplayed();
	}
	
	public void verifyDataRecords() throws InterruptedException {
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds (Constant.EXPLICIT_ELEMENT_WAIT_TIME));
		//Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.EXPLICIT_ELEMENT_WAIT_TIME));
        wait.until(ExpectedConditions.visibilityOf(TableRowsElement));

		List<WebElement> rows = TableRowsElement.findElements(By.tagName("tr"));
		//List<WebElement> rows = driver.findElements(By.xpath("//div[@class='p-datatable-wrapper ng-star-inserted']/table/tbody/tr"));
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds (Constant.EXPLICIT_ELEMENT_WAIT_TIME));
		//Thread.sleep(3000);
		//int rowcount = driver.findElements(By.xpath("//div[@class='p-datatable-wrapper ng-star-inserted']/table/tbody/tr")).size();
		//int totalrecords = rows.size();
		int actualtotalrecords = rows.size();
		int expectedtotalrecords = 5;
		//Thread.sleep(3000);
		//return actualtotalrecords;
		System.out.println("Total Number of Records in the data table is " + actualtotalrecords);
		Assert.assertEquals(expectedtotalrecords, actualtotalrecords);
	}
	
	public boolean verifyCheckbox() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.EXPLICIT_ELEMENT_WAIT_TIME));
        wait.until(ExpectedConditions.visibilityOf(TableRowsElement));
        List<WebElement> rows = TableRowsElement.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            // Locate the checkbox element within the row
            WebElement checkbox = row.findElement(By.tagName("input"));

            // Verify that the checkbox is present
            if (!checkbox.getAttribute("type").equalsIgnoreCase("checkbox")) {
                return false;
            } 
        
		  }
        		return true;

	}
	
	public boolean verifyEditicon() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.EXPLICIT_ELEMENT_WAIT_TIME));
		wait.until(ExpectedConditions.visibilityOf(TableRowsElement));
		List<WebElement> rows = TableRowsElement.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
            // Locate the editicon element within the row
            WebElement editIcon = row.findElement(By.xpath("//button[contains(@class, 'p-button-rounded') and contains(@class, 'p-button-success') and contains(@class, 'p-button-icon-only')]"));

            // Verify that the editicon is present
            if (editIcon.isEnabled()) {
                return true;
            } 
            	
		}
				return false;
	}
	
	public boolean verifyDeleteIcon() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.EXPLICIT_ELEMENT_WAIT_TIME));
		wait.until(ExpectedConditions.visibilityOf(TableRowsElement));
		List<WebElement> rows = TableRowsElement.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
            // Locate the editicon element within the row
            WebElement deleteIcon = row.findElement(By.xpath("//button[@class='p-button-rounded p-button-danger p-button p-component p-button-icon-only']"));

            // Verify that the editicon is present
            if (deleteIcon.isEnabled()) {
                return true;
            } 
		}
				return false;
	}
	
	public void enterValidUserName() {
		SearchTextBox.sendKeys("Tanisha");
	}
	
	public String searchuserName()  {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.EXPLICIT_ELEMENT_WAIT_TIME));
		wait.until(ExpectedConditions.visibilityOf(UserNameElement));
		//Thread.sleep(3000);
		String actualusername = UserNameElement.getText();
		//Assert.assertEquals("Tanisha Shah", actualusername);
		return actualusername;
	}
	
	public void enterInvalidUserName() {
		SearchTextBox.sendKeys("Honda");
	}
	
	public String searchInvalidName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.EXPLICIT_ELEMENT_WAIT_TIME));
		wait.until(ExpectedConditions.visibilityOf(NoEntryText));
		String actualtext = NoEntryText.getText();
		return actualtext;
		//Assert.assertEquals("Showing 0 to 0 of 0 entries" , actualtext);
	}
	
	public void verifyPaginationText() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.EXPLICIT_ELEMENT_WAIT_TIME));
		wait.until(ExpectedConditions.visibilityOf(PaginationText));
		String paginationtext = PaginationText.getText();
		String regexpattern = "^Showing\\s+\\d+\\s+to\\s+\\d+\\s+of\\s+\\d+\\s+entries$";
		boolean isMatch = paginationtext.matches(regexpattern);
		System.out.println("THIS IS MY PAGINATION TEXT********" + paginationtext);
		//Assert.assertEquals("Showing 1 to 5 of 84 entries", paginationtext);
	}
	
	public boolean verifyNextIcon() {
		return NextIcon.isDisplayed();
	}
	
	public boolean verifyLastIcon() {
		return LastIcon.isDisplayed();
	}
	
}
