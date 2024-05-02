package pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utilities.Constant;
import utilities.ElementUtil;

public class POM_AddNewUser {
private WebDriver driver ;
	
	public POM_AddNewUser(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//div/mat-card/mat-card-title/div[1]")
	WebElement manageuser ;
	@FindBy(xpath="//div/p-dialog[1]/div/div/div[1]//*[@id=\"pr_id_5-label\"]")
	WebElement userdetails ;
	@FindBy(xpath="//span[text()='Add New User']")
	WebElement Addnewuser;
	
	@FindBy(xpath="//*[@id=\"mat-form-field-label-5\"]")
	WebElement Firstnametext;
	@FindBy(xpath="//*[@id=\"mat-form-field-label-7\"]")
	WebElement Middlenametext;
	@FindBy(xpath="//*[@id=\"mat-form-field-label-9\"]")
	WebElement Lastnametext;
	@FindBy(xpath="//*[@id=\"mat-form-field-label-11\"]")
	WebElement locationtext;
	@FindBy(xpath="//*[@id=\"mat-form-field-label-13\"]")
	WebElement Phonenotext;
	@FindBy(xpath="//*[@id=\"mat-form-field-label-15\"]")
	WebElement Linkedintext;
	@FindBy(xpath="//div[3]/div[1]/div/label")
	WebElement Userroletext;
	@FindBy(xpath="//div[3]/div[2]/div/label")
	WebElement UserroleStatustext;
	@FindBy(xpath="//div[3]/div[3]/div/label")
	WebElement UservisaStatustext;
	@FindBy(xpath="//div[4]/div/mat-form-field/div/div[1]/div/span")
	WebElement Emailidtext;
	@FindBy(xpath="//*[@id=\"mat-form-field-label-19\"]/span")
	WebElement Undergraduatetext;
	@FindBy(xpath="//*[@id=\"mat-form-field-label-21\"]/span")
	WebElement Postgraduatetext;
	@FindBy(xpath="//*[@id=\"mat-form-field-label-23\"]/span")
	WebElement Timezonetext;
	@FindBy(xpath="//*[@id=\"mat-form-field-label-25\"]/span")
	WebElement Usercommentstext;
	
	
		//@FindBy(xpath="//input[@id='mat-input-136']")
		//@FindBy(xpath="/html/body/app-root/app-user/div/p-dialog[1]/div/div/div[2]/form/mat-card/mat-card-content/div[1]/div[1]/mat-form-field/div/div[1]")
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
		@FindBy(xpath="//span[text()='R01']")
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
		@FindBy(xpath="//div/div/div[2]/form/mat-card/mat-card-actions/button[1]")
		WebElement cancel;
		
		@FindBy(xpath="//*[@id=\"filterGlobal\"]")
		WebElement search;
		@FindBy(xpath ="//div/div[1]/table/tbody/tr[1]/td[3]")
		WebElement createdusername;
		
		@FindBy(xpath="//div[1]/div[1]/mat-form-field/div/div[3]/div")
		WebElement firstnamereq;
		@FindBy(xpath="//div[1]/div[2]/mat-form-field/div/div[3]/div //*[@class=\"mat-error ng-tns-c78-11 ng-star-inserted\"]")
		WebElement midnamereq;
		@FindBy(xpath="//div[1]/div[3]/mat-form-field/div/div[3]/div")
		WebElement lastnamereq;
		@FindBy(xpath="//div[2]/div[1]/mat-form-field/div/div[3]/div")
		WebElement locationreq;
		@FindBy(xpath="//div[2]/div[2]/mat-form-field/div/div[3]/div")
		WebElement phonereq;
		@FindBy(xpath="//div[2]/div[3]/mat-form-field/div/div[3]/div")
		WebElement linkedinreq;
		@FindBy(xpath="//div[4]/div/mat-form-field/div/div[3]/div")
		WebElement emailreq;
		@FindBy(xpath="//div[5]/div/mat-form-field/div/div[3]/div")
		WebElement undergradreq;
		@FindBy(xpath="//div[5]/div[2]/mat-form-field/div/div[3]/div")
		WebElement postgradreq;
		@FindBy(xpath="//div[5]/div[3]/mat-form-field/div/div[3]/div")
		WebElement timezonereq;
		@FindBy(xpath="//div[6]/mat-form-field/div/div[3]/div")
		WebElement userreq;
		@FindBy(xpath ="//div[text()='User Added Successfully']")
		WebElement userSuccessfulMsg;
		@FindBy(xpath ="//div[text()='Failed']")
		WebElement userFailMsg;
		@FindBy(xpath ="//*[@id=\"roleId\"]/div/div[3]/div/ul/p-dropdownitem")
		List <WebElement> Listdropdown;
		@FindBy(xpath ="//*[@id=\"userRoleStatus\"]/div/div[3]/div//ul/p-dropdownitem")
		List <WebElement> ListUserStatusdropdown;
		@FindBy(xpath ="//*[@id=\"userVisaStatus\"]/div/div[3]/div//ul/p-dropdownitem")
		List <WebElement> ListUserVisaStatusdropdown;
		
		
		//Edituser
		
		@FindBy(xpath="//div/div[1]/table/tbody/tr[1]/td[6]/div/span/button[1]")
		WebElement edit;
		@FindBy(xpath="//div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr/td[6]/div/span/button[1]")
		WebElement Edit1;
		@FindBy(xpath ="//div[text()='User Updated Successfully']")
		WebElement userUpdateMsg;
		@FindBy(xpath ="//div/p-toastitem/div/div/div")
		WebElement editFailMsg;
		
		//DeleteUser
		
		@FindBy(xpath="//div/div[1]/table/tbody/tr[1]/td[6]/div/span/button[2]")
		WebElement delete;
		@FindBy(xpath="//div/*[contains(text(),'Confirm')]")
		WebElement confirm;
		@FindBy(xpath="//div/p-confirmdialog/div/div/div[3]/button[1]")
		WebElement yes;
		@FindBy(xpath="//div/p-confirmdialog/div/div/div[3]/button[1]") 
		WebElement no;
		@FindBy(xpath="//div/div/div[1]/div/button")
		WebElement close;
		@FindBy(xpath ="//div[text()='User Deleted']")
		WebElement userDeleteMsg;
		
		//Delete MultipleUser
		@FindBy(xpath="//div/div[1]/table/tbody/tr[1]/td[1]/p-tablecheckbox/div/div[2]")
		WebElement checkbox1;
		@FindBy(xpath="//div/mat-card/mat-card-title/div[2]/div[1]/button")
		WebElement deletebutton;
		@FindBy(xpath="//div/div[1]/table/tbody/tr[2]/td[1]/p-tablecheckbox/div/div[2]")
		WebElement checkbox2;
		
		
		
		public String getManageUserpageTitle() {
			return manageuser.getText();
		}
		
		public void clickOnAddnewuserBtn() {
			ElementUtil.clickOnElement(driver, Addnewuser, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		} 
		
		
		public String getUserPagepopup() {
			return userdetails.getText();
			
		}
		
		
		public boolean isPopupOpen() {
	       
	        return true; 
	    }

	    public boolean isFirstNameFieldPresent() {
	        
	        return  Firstnametext.isDisplayed() ; 
	    }

	    public boolean isMiddleNameFieldPresent() {
	        
	        return Middlenametext.isDisplayed(); 
	    }

	    public boolean isLastNameFieldPresent() {
		
		return Lastnametext.isDisplayed();
	    }
	    public boolean isLocationFieldPresent() {
			
			return locationtext.isDisplayed();
		    }
	    
	    public boolean isPhonenoFieldPresent() {
			
			return Phonenotext.isDisplayed();
		    }
	    public boolean isEmailaddressFieldPresent() {
			
			return Emailid.isDisplayed();
		    }
	    public boolean isLinkedInFieldPresent() {
			
			return Linkedintext.isDisplayed();
		    }
	    public boolean isUserRoleDropdownPresent(){
			
			return Userroletext.isDisplayed();
		    }
	    public boolean isUserRoleStatusDropdownPresent() {
			
			return UserroleStatustext.isDisplayed();
		    }
	    public boolean isUserVisaStatusDropdownPresent() {
			
			return UservisaStatustext.isDisplayed();
		    }
public boolean isUndergraduateFieldPresent() {
			
			return Undergraduatetext.isDisplayed();
		    }
public boolean isPostgraduateFieldPresent() {
	
	return Postgraduatetext.isDisplayed();
    }
public boolean isTimezoneFieldPresent() {
	
	return Timezonetext.isDisplayed();
    }
public boolean isUsercommentsFieldPresent() {
	
	return Usercommentstext.isDisplayed();
    }

public boolean isFirstNameFieldpresent() {
	 
	//return ElementUtil.isElementDisplayedStatus(driver, Firstname,Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	return Firstname.isDisplayed() ;
}

public boolean isMiddleNameFieldpresent() {
    return Middlename.isDisplayed();
}

public boolean isLastNameFieldpresent() {
    return Lastname.isDisplayed();
}

public boolean isLocationFieldpresent() {
    return location.isDisplayed();
}

public boolean isPhonenoFieldpresent() {
    return Phoneno.isDisplayed();
}

public boolean isLinkedinFieldpresent() {
    return Linkedin.isDisplayed();
}
public boolean isEmailidFieldpresent() {
    return Emailid.isDisplayed();
}
public boolean isUndergraduateFieldpresent() {
    return Undergraduate.isDisplayed();
}
public boolean isPostgraduateFieldpresent() {
    return Postgraduate.isDisplayed();
}
public boolean isTimezoneFieldpresent() {
    return Timezone.isDisplayed();
}
public boolean isUsercommentsFieldpresent() {
    return Usercomments.isDisplayed();
}

public boolean getUserRoleDropdownOptions() {
	
	Userrole.click();
	List expecteddropdownValues=new ArrayList();
	 expecteddropdownValues.add("R01");
	 expecteddropdownValues.add("R02");
	 expecteddropdownValues.add("R03");
	 
	for(int i=0;i<Listdropdown.size();i++) {
		String actualdropdownValues= Listdropdown.get(i).getText();
		if(actualdropdownValues==expecteddropdownValues.get(i)) {
		return true;	
		}
}
	return false;	
}	    

public boolean getUserRoleStatusDropdownOptions() {
	
	UserroleStatus.click();
	List expecteddropdownValues=new ArrayList();
	 expecteddropdownValues.add("Active");
	 expecteddropdownValues.add("Inactive");
	 	 
	for(int i=0;i<ListUserStatusdropdown.size();i++) {
		String actualdropdownValues= ListUserStatusdropdown.get(i).getText();
		if(actualdropdownValues==expecteddropdownValues.get(i)) {
		return true;	
		}
}
	return false;	
}	    

public boolean getUserVisaStatusDropdownOptions() {
	
	UservisaStatus.click();
	List expecteddropdownValues=new ArrayList();
	 expecteddropdownValues.add("Not-Specified");
	 expecteddropdownValues.add("NA");
	 expecteddropdownValues.add("GC-EAD");
	 expecteddropdownValues.add("H4-EAD");
	 expecteddropdownValues.add("H4");
	 expecteddropdownValues.add("H1B");
	 expecteddropdownValues.add("Canada-EAD");
	 expecteddropdownValues.add("Indian-Citizen");
	 expecteddropdownValues.add("US-Citizen");
	 expecteddropdownValues.add("Canada-Citizen");
	 	 
	for(int i=0;i<ListUserVisaStatusdropdown.size();i++) {
		String actualdropdownValues= ListUserVisaStatusdropdown.get(i).getText();
		if(actualdropdownValues==expecteddropdownValues.get(i)) {
		return true;	
		}
}
	return false;	
}	    

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
		
		public void clickOnSubmitBtn() throws InterruptedException {
			ElementUtil.clickOnElement(driver, submit, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			//Thread.sleep(2000);
		}
		
		public void enterInvaliddata(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12, String string13, String string14) {
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
		
		
		public void clickOnCancelBtn() {
			ElementUtil.clickOnElement(driver, cancel, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		}
		
		public void clickOnSearchBtn() throws InterruptedException {
			ElementUtil.clickOnElement(driver, search, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementUtil.typeInputIntoElement(driver, search, "Swath", Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			
			Thread.sleep(1000);
		}
		
		public String getCreatedUserName() {
			return createdusername.getText();
		}
		
		
	
		
		public boolean isFirstNamefieldpresent() {
			 
			//return ElementUtil.isElementDisplayedStatus(driver, Firstname,Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			return firstnamereq.isDisplayed() ;
		}

		public boolean isMiddleNamefieldpresent() {
		    return midnamereq.isDisplayed();
		}

		public boolean isLastNamefieldpresent() {
		    return lastnamereq.isDisplayed();
		}

		public boolean isLocationfieldpresent() {
		    return locationreq.isDisplayed();
		}

		public boolean isPhonenofieldpresent() {
		    return phonereq.isDisplayed();
		}

		public boolean isLinkedinfieldpresent() {
		    return linkedinreq.isDisplayed();
		}
		public boolean isEmailidfieldpresent() {
		    return emailreq.isDisplayed();
		}
		public boolean isUndergraduatefieldpresent() {
		    return undergradreq.isDisplayed();
		}
		public boolean isPostgraduatefieldpresent() {
		    return postgradreq.isDisplayed();
		}
		public boolean isTimezonefieldpresent() {
		    return timezonereq.isDisplayed();
		}
		public boolean isUsercommentsfieldpresent() {
		    return userreq.isDisplayed();
		}

		public int getTotalUserIdCount() {
	        List<WebElement> userIdElementsList = driver.findElements(By.xpath("//div/div[1]/table/thead/tr/th[2]"));
	        return userIdElementsList.size();
	    }
		public boolean gettextAlert() {
			
			ElementUtil.waitForElementVisibility(driver, userSuccessfulMsg, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	    	return userSuccessfulMsg.isDisplayed();
		}
		public boolean verifyUserFailAlert() {
			   ElementUtil.waitForElementVisibility(driver, userFailMsg, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			   return userFailMsg.isDisplayed();
		}
		
		//EditUser
		
		public void clickOnEditBtn() {
		ElementUtil.clickOnElement(driver, edit, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		}
		
		public void clickOnEdit1Btn() {
			ElementUtil.clickOnElement(driver, Edit1, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			}
		
		public void clickOnEditFirstname() {
			ElementUtil.typeInputIntoElement(driver, Firstname, "ka", Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementUtil.typeInputIntoElement(driver, Emailid, "coma@gmail.com", Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			
			}	
		
		public boolean UserUpdateSuccessfullAlert() {
			   ElementUtil.waitForElementVisibility(driver, userUpdateMsg, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			   return userUpdateMsg.isDisplayed();
		}
	    		
		public void UpdateInavalidvalues() {
			
			ElementUtil.typeInputIntoElement(driver, Emailid, "com", Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementUtil.clickOnElement(driver, submit, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			
			}
		public String getErrorMessage() {
			 String text= emailreq.getText();
			 
			//return text;
			System.out.println("text");
			return text;
		}
		
    public void UpdateSpecialvalues() {
			
			ElementUtil.typeInputIntoElement(driver, Firstname, "12/?", Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementUtil.typeInputIntoElement(driver, Middlename, "$#@1", Constant.EXPLICIT_ELEMENT_WAIT_TIME); 
			ElementUtil.typeInputIntoElement(driver, Lastname, "$%23", Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementUtil.typeInputIntoElement(driver,location , "23&^", Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementUtil.typeInputIntoElement(driver, Phoneno, "^%$g678%4", Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementUtil.typeInputIntoElement(driver, Emailid, "453a@gmail.com", Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementUtil.typeInputIntoElement(driver, Usercomments, "@#1", Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementUtil.clickOnElement(driver, submit, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			
			}
		
   public boolean UserUpdateFailAlert() {
	   ElementUtil.waitForElementVisibility(driver, userUpdateMsg, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	   return userUpdateMsg.isDisplayed();
}
   public boolean verifyEditFailAlert() {
	   ElementUtil.waitForElementVisibility(driver, editFailMsg, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	   return editFailMsg.isDisplayed();
}
		
		
	//DeleteUser
		
		public void clickOnDeleteBtn() {
			ElementUtil.clickOnElement(driver, delete, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			}

		public boolean isConfirmfieldpresentornot() {
		    return confirm.isDisplayed();
		}
		    public boolean isYesfieldpresentornot() {
			    return yes.isDisplayed();
		    }
			    public boolean isNofieldpresentornot() {
				    return no.isDisplayed();
			    }
			    
			    public void clicknoBtn() {
					ElementUtil.clickOnElement(driver, no, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
					}
			    
			    public void clickyesBtn() {
					ElementUtil.clickOnElement(driver, yes, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
					}	
			    public void clickOnCloseBtn() {
					ElementUtil.clickOnElement(driver, close, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
					}    
			    public boolean UserDeleteSuccessfullAlert() {
					   ElementUtil.waitForElementVisibility(driver, userUpdateMsg, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
					   return userDeleteMsg.isDisplayed();
				}
			    
			    //Delete MultipleUser
			    
			    public void clickCheckbox() {
					ElementUtil.clickOnElement(driver, checkbox1, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
					} 
			    
			    public boolean isDeletesymbolEnabledornot() {
				    return deletebutton.isEnabled();
			    }
			    
			    public void clickOnDeleteIconBtn() {
					ElementUtil.clickOnElement(driver, deletebutton, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
					} 
			    public void clickCheckbox2() {
					ElementUtil.clickOnElement(driver, checkbox2, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
					} 
}
