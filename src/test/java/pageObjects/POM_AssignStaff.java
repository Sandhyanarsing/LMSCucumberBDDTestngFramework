package pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import driverFactory.DriverFactory;
import utilities.Constant;
import utilities.ElementUtil;

public class POM_AssignStaff {
private WebDriver driver;
	
	public POM_AssignStaff(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//div[@class='signin-content']/mat-card/mat-card-title/div[1]") WebElement ManageUser;
	@FindBy(xpath="//button[@label='Assign Staff']") WebElement AssignStaffBtn;
	@FindBy(xpath="//span[@id='pr_id_6-label']") WebElement AssignStaffText;
	@FindBy(xpath="//span[@class='p-dialog-header-close-icon ng-tns-c132-7 pi pi-times']") WebElement PopupWindow;
	@FindBy(xpath="//p-dropdown[@id='userId']") WebElement EmailidDropdown;
	@FindBy(xpath="//input[@id='skillName']") WebElement SkillName;
	@FindBy(xpath="//p-dropdown[@id='programName']") WebElement ProgramNameDropdown;
	@FindBy(xpath="//p-multiselect[@id='batchName']") WebElement BatchNameDropdown;
	//@FindBy(xpath="//input[@id='Active']") WebElement ActiveRadioBtn;
	@FindBy(xpath="//*[@id='userStatus']") WebElement ActiveRadioBtn;
	//@FindBy(xpath="//input[@id='Inactive']") WebElement InactiveRadioBtn;
	@FindBy(xpath="//*[@id='userStatus']") WebElement InactiveRadioBtn;
	@FindBy(xpath="//button[@label='Cancel']") WebElement CancelBtn;
	@FindBy(xpath="//button[@label='Save']") WebElement SaveBtn;
	@FindBy(xpath="//span[@class='p-dialog-header-close-icon ng-tns-c132-7 pi pi-times']") WebElement CloseIcon;
	@FindBy(xpath="//div[@class='ng-trigger ng-trigger-animation ng-tns-c132-7 p-fluid p-dialog p-component p-dialog-draggable p-dialog-resizable ng-star-inserted']") WebElement FormElement;
	@FindBy(xpath="//input[@id='roleId']") WebElement UserRoleInput;
	@FindBy(xpath="//li[@aria-label='SalesforceTest']") WebElement SalesforceProgram;
	//@FindBy(xpath="//li[@aria-label='Pytest']") WebElement PytestProgram;
	//@FindBy(xpath="//ul[@class='p-dropdown-items ng-tns-c101-14']") WebElement ProgramNameList;
	@FindBy(xpath="//li[@class='p-dropdown-item p-highlight p-ripple']") WebElement PytestProgram;
	@FindBy(xpath="//li[@aria-label='May Batch']") WebElement MayBatchCheckbox;
	@FindBy(xpath="//button[@class='p-multiselect-close p-link ng-tns-c152-12 p-ripple']") WebElement BatchNameCloseBtn;
	@FindBy(xpath="//div[contains(text(), 'Email Id is required.')]") WebElement EmailIdErrorMsg;
	@FindBy(xpath="//span[@class='ng-star-inserted'][text()='arunasel@gmail.com']") WebElement SelectEmailDropDown;
	@FindBy(xpath="//span[@class='ng-tns-c101-11 p-dropdown-label p-inputtext ng-star-inserted'][text()= 'AWS4']") WebElement SelectProgramDropDown;
	@FindBy(xpath="//span[@class='ng-star-inserted']")WebElement SelectBatchDropDown;
	@FindBy(xpath="//div[@class='ng-tns-c91-5 p-toast p-component p-toast-top-right']") WebElement SuccessfulMsg;
	
	
	
	public void clickOnAssignStaffBtn() {
		ElementUtil.clickOnElement(driver, AssignStaffBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}
	
	public String getManageUserText() {
		//driver.getTitle();
		String text = ElementUtil.getTextFromElement(driver, ManageUser, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		System.out.println("PRINTING MY TEXT HERE>>>> " + text);
		return text;
	}
	
	public void popupVerification() {
        AssignStaffBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.EXPLICIT_ELEMENT_WAIT_TIME));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.p-dialog-mask")));
        
        if (PopupWindow != null && PopupWindow.isDisplayed()) {
            System.out.println("Popup window is opened.");
        } else {
            System.out.println("Popup window is not opened.");
        }
	}
	
	public void formVerification() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.EXPLICIT_ELEMENT_WAIT_TIME));
        wait.until(ExpectedConditions.visibilityOf(FormElement));
		List<WebElement> inputfields = FormElement.findElements(By.tagName("input"));
		
		List<WebElement> dropdowns = FormElement.findElements(By.tagName("p-dropdown"));
		boolean isEmpty = true;
		// Check input fields
        for (WebElement inputField : inputfields) {
            String fieldValue = inputField.getAttribute("value");
            if (fieldValue != null && !fieldValue.trim().isEmpty()) {
                isEmpty = false;
                break;
            }
        }
     // Check dropdown fields
        for (WebElement dropdown : dropdowns) {
            String selectedOption = dropdown.getAttribute("value");
            if (selectedOption != null && !selectedOption.trim().isEmpty()) {
                isEmpty = false;
                break;
            }
        }
        if (isEmpty) {
            System.out.println("Form is empty.");
        } else {
            System.out.println("Form is not empty.");
        }
        
		
	}
	
	public void userRoleField() {
		String userRoleValue = UserRoleInput.getAttribute("value");
        assert userRoleValue.equals("R02") : "Admin should see User Role as R02";
	}
	
	public boolean checkEmailField() {
		
		return EmailidDropdown.isDisplayed();
		//assert EmailidDropdown.isDisplayed() : "Student Email id input box is not displayed";
		//System.out.println(emptyemail);
		//Assert.assertEquals("Select Email Id", emptyemail);
		
	}
	
	public boolean checkSkillField() {
		//String skillname = SkillName.getText();
		return SkillName.isDisplayed();
		/*if(skillname.isEmpty()) {
			System.out.println("Field is empty");
		} else {
			System.out.println("Field is not empty");
		} */
	}
	
	public boolean checkProgramField() {
		return ProgramNameDropdown.isDisplayed();
		//String programnamedropdown = ProgramNameDropdown.getText();
		//System.out.println(programnamedropdown);
		//Assert.assertEquals("Select a Program name", programnamedropdown);
		}
	
	public boolean checkBatchField() {
		return BatchNameDropdown.isDisplayed();
		//String batchnamedropdown = BatchNameDropdown.getText();
		//System.out.println(batchnamedropdown);
		//Assert.assertEquals("Select Batch Name" , batchnamedropdown);
	}
	
	public boolean isCancelBtndisplayed() {
		return CancelBtn.isDisplayed();
	}
	
	public boolean isSaveBtndisplayed() {
		return SaveBtn.isDisplayed();
	}
	
	public boolean isCloseBtndisplayed() {
		return CloseIcon.isDisplayed();
	}
	
	public void dropDownVerification() {
		 assertOptionsAreValid(EmailidDropdown);
		 assertOptionsAreValid(ProgramNameDropdown);
		 assertOptionsAreValid(BatchNameDropdown);
		
	}
	
	public void assertOptionsAreValid(WebElement dropdown) {
		List<WebElement> options = dropdown.findElements(By.tagName("li"));
		for(WebElement option : options) {
			assert option.getText()!= null && option.getText().isEmpty() : "Dropdown option is not valid" ;
		}
		System.out.println("All options in dropdown are valid");
		
	}
	
	public boolean verifyActiveRadioButtonStatus() {
		return ActiveRadioBtn.isDisplayed();
		
	}
	
	public boolean verifyInactiveRadioButtonStatus() {
		return InactiveRadioBtn.isDisplayed();
	}
	
	public void clickSaveBtn() {
		ElementUtil.clickOnElement(driver, SaveBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}
	
	public void emptyFormErrorMessage() {
		List<WebElement> errormsgelements = driver.findElements(By.xpath("//div[@class='ng-star-inserted']"));
		for(WebElement errormsg : errormsgelements) {
			String errorMsgText = errormsg.getText();
			if (errorMsgText.contains("Active") || errorMsgText.contains("Inactive")) {
	            continue; // Skip radio button messages
	        }
			/*if(errormsg.getAttribute("type")!= null && errormsg.getAttribute("type").equals("radio") ) {
				continue;
			}*/
			//String errorMsgText = errormsg.getText();
			System.out.println("Error Message :" + errorMsgText);
			
		}
		
		
	}
	
	public void formWithoutEmailIdErrorId() throws InterruptedException {
		SkillName.sendKeys("Program Skill");
		ProgramNameDropdown.click();
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.EXPLICIT_ELEMENT_WAIT_TIME));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='p-dropdown-items ng-tns-c101-14']/li")));
		WebElement optionToSelect = driver.findElement(By.xpath("//ul[@class='p-dropdown-items ng-tns-c101-14']/li[contains(text(),'Pytest')]"));
		/*Actions actions = new Actions(driver);
        actions.moveToElement(optionToSelect).perform();*/
        optionToSelect.click();

		//PytestProgram.click();
		BatchNameDropdown.click();
		MayBatchCheckbox.click();
		BatchNameCloseBtn.click();
		ActiveRadioBtn.click();
		SaveBtn.click();
		
		Thread.sleep(3000);
		
		}
	
	public void errorMsgWithoutEmailId() {
		String actualErrorMsgText = EmailIdErrorMsg.getText();
		String expectedErrorMsgText = "Email Id is required.";
		Assert.assertEquals(actualErrorMsgText, expectedErrorMsgText);
	}
	
	public void successfullAssignStaff() throws InterruptedException {
		//ElementUtil.clickOnElement(driver, EmailidDropdown, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.EXPLICIT_ELEMENT_WAIT_TIME));
       // wait.until(ExpectedConditions.visibilityOf(SelectEmailDropDown));
		//ElementUtil.clickOnElement(driver, SelectEmailDropDown, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		selectRandomOption(driver,EmailidDropdown);
		//ElementUtil.clickOnElement(driver, ProgramNameDropdown, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		//WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(Constant.EXPLICIT_ELEMENT_WAIT_TIME));
        //wait1.until(ExpectedConditions.visibilityOf(SelectProgramDropDown));
		//ElementUtil.clickOnElement(driver, SelectProgramDropDown, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		selectRandomOption(driver,ProgramNameDropdown);
		//ElementUtil.clickOnElement(driver, BatchNameDropdown, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		//ElementUtil.clickOnElement(driver, SelectBatchDropDown, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		selectRandomOption(driver,BatchNameDropdown);
		
		ElementUtil.clickOnElement(driver, BatchNameCloseBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementUtil.clickOnElement(driver, ActiveRadioBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		ElementUtil.clickOnElement(driver, SaveBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		}
	
	public String verifySuccessfulMsg() {
		String text = SuccessfulMsg.getText();
		return text;
		//Assert.assertEquals(SuccessfulMsg, "Successfully Staff Assigned");
		
	}
	
	public void selectRandomOption(WebDriver driver, WebElement dropdownElement) throws InterruptedException {
        // Locate the dropdown element and click to open the options
        dropdownElement.click();

        // Find all the options within the dropdown
        Thread.sleep(3000);
        List<WebElement> options = driver.findElements(By.xpath("//div[@class='p-dropdown-items-wrapper ng-tns-c101-19']//li"));
        
        if (!options.isEmpty()) {
            // Generate a random index within the range of available options
            Random random = new Random();
            int randomIndex = random.nextInt(options.size());

            // Select the random option
            WebElement randomOption = options.get(randomIndex);
            randomOption.click();
        } else {
            System.out.println("No options found in the dropdown.");
        }

       
	}
	
	public void clickOnCloseIcon() {
		ElementUtil.clickOnElement(driver, CloseIcon, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}
	
	public void verifyPopupClose() {
		
		/* boolean isPopupClosed = isPopupClosed(driver);
	        if (isPopupClosed) {
	            System.out.println("Popup window is closed successfully.");
	        } else {
	            System.out.println("Popup window is still open.");
	            // You can perform additional actions or assertions here if needed
	        }*/
		
		 // Check if the close icon is still visible
        boolean isPopupClosed = driver.findElements(By.xpath("//span[@class='p-dialog-header-close-icon ng-tns-c132-7 pi pi-times']")).isEmpty();
        
        // If close icon is not found, popup window is closed
        if (isPopupClosed) {
            System.out.println("Popup window is closed successfully.");
        } else {
            // If close icon is still visible, popup window is not closed
            System.out.println("Popup window is still open.");
        }
	}       

	

}
