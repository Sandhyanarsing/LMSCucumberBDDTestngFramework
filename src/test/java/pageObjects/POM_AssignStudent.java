package pageObjects;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.Constant;
import utilities.ElementUtil;

public class POM_AssignStudent {
private WebDriver driver ;
	
	
public POM_AssignStudent(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);

}
	@FindBy(xpath = "//*[@id=\"user\"]")
	WebElement UserButton;
	
	//@FindBy(xpath = "//*[contains(text(),'Manage User')])")
	@FindBy(xpath = "/html/body/app-root/app-user/div/mat-card/mat-card-title/div[1]")
	WebElement  UserPageTitle;
	
	@FindBy(xpath = "//*[contains(text(),'Assign Student')]")
	WebElement  AssignStudentBtn;
	
	@FindBy(xpath = "//div/*[contains(text(),'Assign Student')]")
	WebElement  AssignStudentTitile;
	
	@FindBy(xpath = "//*[contains(text(),'User Role')]")
	WebElement  User_Role;
	
	@FindBy(xpath = "//*[@id=\"roleId\"]")
	WebElement  UserRole_inputBox;
	
	@FindBy(xpath = "//div/*[contains(text(),'Student Email Id')]")
	WebElement  StudentEmailId;
	
	@FindBy(xpath = "//*[@id=\"userId\"]/div/span")
	WebElement  StudentEmailIdTextBox;
	
	@FindBy(xpath = "//*[contains(text(),'Program Name')]")
	WebElement  Program_Name;
	
	@FindBy(xpath = "//input[@id= 'programName']")
	WebElement  Program_NameInputBox;
	
	
	@FindBy(xpath = "//*[contains(text(),'Batch Name')]")
	WebElement  Batch_Name;
	
	@FindBy(xpath = "//input[@id= 'batchName']")
	WebElement  Batch_NameInputBox;
	
	@FindBy(xpath = "/html/body/app-root/app-user/div/p-dialog[3]/div/div/div[3]/button[1]\n")
	WebElement  cancelButton;
	
	@FindBy(xpath = "/html/body/app-root/app-user/div/p-dialog[3]/div/div/div[3]/button[2]")
	WebElement  SaveButton;
	
	@FindBy(xpath = "//*[contains(text(),'Status :')]")
	WebElement  Status;
	
	
	@FindBy(xpath = "/html/body/app-root/app-user/div/p-dialog[3]/div/div/div[1]/div/button")
	WebElement CloseButton;
	
	@FindBy(xpath = "//*[@id=\"userId\"]/div")
	//@FindBy(xpath = "*[@id=\"userId\"]/div/div[2]")
	WebElement StudentEmailId_Dropdown;
	
	@FindBy(xpath = "//*[@id=\"programName\"]/div")
	WebElement ProgramName_Dropdown;
	
	@FindBy(xpath = "//*[@id=\"batchName\"]/div/div[2]")
	WebElement BatchNmae_Dropdown;
	
	//@FindBy(xpath = "//span[text()='arna12@gmail.com']")
	@FindBy(xpath = "//span[@class='ng-star-inserted'][text()='swe@gmail.com']")

	public WebElement SelectStudentEmailId_fromDRopDown;
	
	
	
	@FindBy(xpath = "/html/body/div/div/ul/p-dropdownitem[3]")
	public WebElement SelectProgramNmae_fromDRopDown;
	
	@FindBy(xpath = "/html/body/div/div/ul/p-dropdownitem")
	public WebElement SelectBatchNmae_fromDRopDown;
	
	
	@FindBy(xpath = "//*[@id=\"userStatus\"]/div/div[2]")
	public List<WebElement>  SatusRadioBtns;
	
	//@FindBy(xpath = "//div/div/div[2]/form/div[5]/div[2]")
	@FindBy(xpath = "//div[text()=' Active ']/p-radiobutton")
	public WebElement ActiveRadioBtn;
	
	@FindBy(xpath = "//*[contains(text(),'User Email Id is required.')]")
	public WebElement StudentEmailId_ErrMsg;
	
	
	
	@FindBy(xpath = "//*[contains(text(),'Program Name is required.')]")
	public WebElement ProgramName_ErrMsg;
	
	@FindBy(xpath = "//*[contains(text(),'Batch Name is required.')]")
	public WebElement BatchName_ErrMsg;
	
	@FindBy(xpath = "//*[contains(text(),'Status is required.')]")
	public WebElement Status_ErrMsg;
	
	@FindBy(xpath = "//div[text()='User has been successfully assigned/Updated to Program/Btch(es)'] ")
	public WebElement AssignStudentSuccessMsg;
	
	
	
	
	//User creation Module xpaths
	@FindBy(xpath="//span[text()='Add New User']")
	WebElement Addnewuser;
	@FindBy(xpath="//input[@data-placeholder='First name']")
	WebElement Firstname;
		@FindBy(xpath="//input[@data-placeholder='Middle name']")
		WebElement Middlename;
		@FindBy(xpath="//input[@data-placeholder='Last name']")
		WebElement Lastname;
		@FindBy(xpath="//input[@data-placeholder='Location']")
		WebElement location;
		@FindBy(xpath="//input[@data-placeholder='Phone no']")
		WebElement Phoneno;
		@FindBy(xpath="//input[@data-placeholder='LinkedIn Url']")
		WebElement Linkedin;
		@FindBy(xpath="//*[@id=\"roleId\"]")
		WebElement Userrole;
		@FindBy(xpath="//span[text()='R03']")
		WebElement UserRoleR01;
		@FindBy(xpath="//*[@id='userRoleStatus']")
		WebElement UserroleStatus;
		@FindBy(xpath="//span[text()='Active']")
		WebElement UserRoleStatusActive;
		@FindBy(xpath="//*[@id='userVisaStatus']")
		WebElement UservisaStatus;
		@FindBy(xpath="//span[text()='H4']")
		WebElement UserVisaStatusH4;
		@FindBy(xpath="//input[@data-placeholder='Email address']")
		WebElement Emailid;
		@FindBy(xpath="//input[@data-placeholder='Under Graduate']")
		WebElement Undergraduate;
		@FindBy(xpath="//input[@data-placeholder='Post Graduate']")
		WebElement Postgraduate;
		@FindBy(xpath="//input[@data-placeholder='Time Zone']")
		WebElement Timezone;
		@FindBy(xpath="//input[@data-placeholder='User Comments']")
		WebElement Usercomments;
		
		@FindBy(xpath="//span[text()='Submit']")
		WebElement submit;
		
		public void entermandatoryfields(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12, String string13, String string14) {
			ElementUtil.typeInputIntoElement(driver, Firstname, string, Constant.EXPLICIT_ELEMENT_WAIT_TIME); 
			ElementUtil.typeInputIntoElement(driver, Middlename, string2, Constant.EXPLICIT_ELEMENT_WAIT_TIME); 
			ElementUtil.typeInputIntoElement(driver, Lastname, string3, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementUtil.typeInputIntoElement(driver,location , string4, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementUtil.typeInputIntoElement(driver, Phoneno, string5, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementUtil.typeInputIntoElement(driver, Linkedin, string6, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementUtil.clickOnElement(driver, Userrole, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementUtil.clickOnElement(driver, UserRoleR01, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			
			//ElementUtil.selectDropDownOptionByVisibleText(driver, UserRoleR01, string7, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementUtil.clickOnElement(driver, UserroleStatus, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementUtil.clickOnElement(driver, UserRoleStatusActive, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			//ElementUtil.selectDropDownOptionByVisibleText(driver, UserRoleStatusActive, string8, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementUtil.clickOnElement(driver, UservisaStatus, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementUtil.clickOnElement(driver, UserVisaStatusH4, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			//ElementUtil.selectDropDownOptionByVisibleText(driver, UserVisaStatusH4, string9, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementUtil.typeInputIntoElement(driver, Emailid, string10, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementUtil.typeInputIntoElement(driver, Undergraduate, string11, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementUtil.typeInputIntoElement(driver, Postgraduate, string12, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementUtil.typeInputIntoElement(driver, Timezone, string13, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementUtil.typeInputIntoElement(driver, Usercomments, string14, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			
		}
		
		public void clickOnSubmitBtn()  {
			ElementUtil.clickOnElement(driver, submit, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		}
		
		public void clickOnAddnewuserBtn() {
			ElementUtil.clickOnElement(driver, Addnewuser, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		}

	//****************************************
		
		
	public void clickOnUserBtn() {
		 ElementUtil.clickOnElement(driver, UserButton, Constant.EXPLICIT_ELEMENT_WAIT_TIME);

		 
	}
	
	public String getUserPageTitle() {
		return UserPageTitle.getText();
		
	}
	
	public void clickOnAssignStudentBtn() {
		 ElementUtil.clickOnElement(driver, AssignStudentBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}
	
	public String getAssignStudentTitile() {
		return AssignStudentTitile.getText();
		
	}
	public String UserRole_GetText() {
		return ElementUtil.getTextFromElement( driver , User_Role , 1); 
}
	
	public String textInsideUser_RoleInputBox() {
		
		//return ElementUtil.textInsideInputBox( driver, UserRole_inputBox); 
 return UserRole_inputBox.getAttribute("value");
		}
	
	public String StudentEmailId_GetText() {
		return ElementUtil.getTextFromElement( driver , StudentEmailId , 1); 
}
	
	public String getStudentEmailIdTextBox_Text() {
		return StudentEmailIdTextBox.getText();
		
		
	}
	
	public String Program_Name_GetText() {
		return ElementUtil.getTextFromElement( driver , Program_Name , 1); 
	
}
public boolean textInside_Program_NameInputBox() {
		
		return ElementUtil.textInsideInputBox( driver, Program_NameInputBox); 

		}
	
	

	public String Batch_Name_GetText() {
		return ElementUtil.getTextFromElement( driver , Batch_Name , 1); 
	
	}
	
public boolean textInside_Batch_NameInputBox() {
		
		return ElementUtil.textInsideInputBox( driver, Batch_NameInputBox); 

		}
	
public boolean cancelBtnIsDisplyed() {
	return cancelButton.isDisplayed();
	
}

public boolean saveButtonIsDisplyed() {
	return SaveButton.isDisplayed();
	
}

public boolean closeButtonIsDisplyed() {
	return CloseButton.isDisplayed();
	
}

public String UserRole_inputBoxGetText() {
	return UserRole_inputBox.getText();
}

public boolean StatusIsDisplyed() {
	return Status.isDisplayed();
	
}

public boolean UserRole_inputBoxIsDisplayed() {
	return UserRole_inputBox.isDisplayed();
}

public void testStudentEmailId_Dropdown(WebElement StudentEmailId_Dropdown) {
	
	Select dropdown = new Select(StudentEmailId_Dropdown);
	
    //List<WebElement> options =  dropdown.getOptions();

}
 public boolean statusRadiobuttonIsDisplayed() {
	 if(SatusRadioBtns.size()==2) {
		 return true;	 
	 }
	 else return false;
	 
 }
 
 public void clickOnSaveBtn()  {
	 ElementUtil.clickOnElement(driver, SaveButton, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
}
 public String StudentEmailId_ErrMsg_GetText() {
		return StudentEmailId_ErrMsg.getText();
	}
 
 public void clickOnCloseBtn() {
	 ElementUtil.clickOnElement(driver, CloseButton, Constant.EXPLICIT_ELEMENT_WAIT_TIME);

	 
}
 

 public void selectStudentEmailId() {
	
	 ElementUtil.clickOnElement(driver, StudentEmailId_Dropdown, Constant.EXPLICIT_ELEMENT_WAIT_TIME);

	         Actions action = new Actions(driver);
	         action.moveToElement(SelectStudentEmailId_fromDRopDown).perform();
	         action.click(SelectStudentEmailId_fromDRopDown).perform();

	 
}
 
 public void selectProgramName() {
			 
	 ElementUtil.clickOnElement(driver, ProgramName_Dropdown, Constant.EXPLICIT_ELEMENT_WAIT_TIME);

	         Actions action = new Actions(driver);
	         action.moveToElement(SelectProgramNmae_fromDRopDown).perform();
	         action.click(SelectProgramNmae_fromDRopDown).perform();


	 
}
 
 public void selectBatchName() {
	 
	 ElementUtil.clickOnElement(driver, BatchNmae_Dropdown, Constant.EXPLICIT_ELEMENT_WAIT_TIME);

	         Actions action = new Actions(driver);
	         action.moveToElement(SelectBatchNmae_fromDRopDown).perform();
	         action.click(SelectBatchNmae_fromDRopDown).perform();


	 
}
 public void EnterMandatoryFieldsForAssignStudent(String string, String string2) throws InterruptedException {
	 ElementUtil.clickOnElement(driver, StudentEmailId_Dropdown, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	 //Actions action = new Actions(driver);
     //action.moveToElement(SelectStudentEmailId_fromDRopDown).perform();
     //action.click(SelectStudentEmailId_fromDRopDown).perform();
	 //ElementUtil.selectDropDownOptionByVisibleText(driver, SelectStudentEmailId_fromDRopDown, string, 5);
	 ElementUtil.clickOnElement(driver, SelectStudentEmailId_fromDRopDown, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	 
	 Thread.sleep(4000);



		ElementUtil.typeInputIntoElement(driver, Program_NameInputBox , string, Constant.EXPLICIT_ELEMENT_WAIT_TIME); 
		ElementUtil.typeInputIntoElement(driver, Batch_NameInputBox , string, Constant.EXPLICIT_ELEMENT_WAIT_TIME); 

		//ElementUtil.clickOnElement(driver, ActiveRadioBtn, 0);
		//ElementUtil.clickOnElement(driver, SaveButton, 0);

 }
public String alertmesgForAssignStudent() {
	return ElementUtil.getAlertText(driver, 5);
}


}	


