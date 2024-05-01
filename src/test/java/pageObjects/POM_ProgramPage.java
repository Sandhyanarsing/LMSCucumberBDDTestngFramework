package pageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.Constant;
import utilities.ElementUtil;
import utilities.LoggerLoad;

public class POM_ProgramPage {

	private WebDriver driver ;
	
	public POM_ProgramPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	    @FindBy(xpath = "//div[text()=' Manage Program']")
        WebElement managePrgHeader;		
	    @FindBy(xpath = "//button[contains(@class,'p-button-danger')][@disabled]")
	    WebElement topDisabledDeleteBtn;
	    @FindBy(xpath = "//mat-card-title[contains(@class,'mat-card-title')]//button[@icon='pi pi-trash']")
	    WebElement topEnabledDeleteBtn;
	    
	    @FindBy(id = "program")
		WebElement programNavBtn;
	    
	    @FindBy(id = "batch")
		WebElement batchNavLink;
	    
	    @FindBy(id = "user")
		WebElement userNavLink;
	    
	    @FindBy(id = "logout")
		WebElement logoutNavLink;
	    
		@FindBy(xpath = "//input[@placeholder='Search...']")
		WebElement searchBox;
		@FindBy(xpath = "//button[@id='new']//span[text()='A New Program']")
		WebElement newProgramBtn;
		@FindBy(xpath = "//span[text()=' LMS - Learning Management System ']")
		WebElement dashboardHeaderTittle;
		
		@FindBy(xpath = "//p-table[@datakey='programId']")
		WebElement dataTable;
		
		@FindBy(xpath = "//th[@psortablecolumn='programName']")
		WebElement dataTableColumn1;
		
		@FindBy(xpath = "//th[@psortablecolumn='programDescription']")
		WebElement dataTableColumn2;
		
		@FindBy(xpath = "//th[@psortablecolumn='programStatus']")
		WebElement dataTableColumn3;
		
		@FindBy(xpath = "//th[text()=' Edit / Delete ']")
		WebElement dataTableColumn4;
		
		@FindBy(xpath = "//div[contains(@class,'p-datatable-wrapper')]/table//tbody/tr")
		List <WebElement> dataTableRows;
		
		@FindBy(xpath = "//tbody[@class='p-datatable-tbody']//td[2]")
		WebElement dataTablePrgmName;
		
		@FindBy(xpath = "(//tbody[@class='p-datatable-tbody']//td[2])[1]")
		WebElement FirstPrgmName;
		
		@FindBy(xpath = "(//tbody[@class='p-datatable-tbody']//td[2])[2]")
		WebElement secPrgmName;
		
		@FindBy(xpath = "//tbody[@class='p-datatable-tbody']//td[3]")
		WebElement dataTablePrgmDesc;
		
		@FindBy(xpath = "//tbody[@class='p-datatable-tbody']//tr[1]/td[4]")
		WebElement dataTableStatus;
		
		@FindBy(xpath = "(//table//tbody/tr/td[5]//button[@id='deleteProgram'])[1]")
		WebElement deleteBtnFirstPrgm;
		
		
		@FindBy(xpath = "(//table//tbody/tr/td[5]//button[@id='editProgram'])[1]")
		WebElement editBtnFirstPrgm;
		
		@FindBy(xpath = "//tbody[@class='p-datatable-tbody']/tr/td[1]//div[@role='checkbox']")
		List <WebElement> dataTableCheckBoxes;
		
		@FindBy(xpath = "(//tbody[@class='p-datatable-tbody']//td[2])[1]/preceding-sibling::td//div[@role='checkbox']")
		WebElement firstCheckBox;
		@FindBy(xpath = "(//tbody[@class='p-datatable-tbody']//td[2])[2]/preceding-sibling::td//div[@role='checkbox']")
		WebElement secCheckBox;
		
		@FindBy(xpath = "//div[contains(@class,'p-datatable-wrapper')]/table//tbody/tr/td[5]//button[@id='editProgram']")
		List <WebElement> editBtnsInRow;
		
		@FindBy(xpath = "//div[contains(@class,'p-datatable-wrapper')]/table//tbody/tr/td[5]//button[@id='deleteProgram']")
		List <WebElement> deleteBtnsInRow;
		
		@FindBy(xpath = "//span[text()='Program Details']")
		WebElement PrgPopUpTitle;
		
		
		@FindBy(xpath = "//label[text()='Name']/following-sibling::input[contains(@class,'ng-invalid')]")
		WebElement blankNameInputBox;
		
		@FindBy(xpath = "//label[text()='Name']/following-sibling::input[contains(@class,'ng-valid')]")
		WebElement editPrgInputBox;
		
		@FindBy(xpath = "//label[text()='Description']/following-sibling::input[contains(@class,'ng-valid')]")
		WebElement editDescInputBox;
	
		@FindBy(xpath = "//label[text()='Description']/following-sibling::input[contains(@class,'ng-invalid')]")
		WebElement blankDescInputBox;
		
		@FindBy(xpath = "//button[@id='saveProgram']")
		WebElement saveBtnPopUp;
		
		@FindBy(xpath = "//span[text()='Cancel']/../../button[1]")
		WebElement cancelBtnPopUp;
		
		@FindBy(xpath = "//div[text()=' Active ']/p-radiobutton")
		WebElement activeRadioBtn;		
		
		@FindBy(xpath = "//div[text()=' Inactive ']/p-radiobutton")
		WebElement inActiveRadioBtn;
		
		@FindBy(xpath = "//button[contains(@class,'p-dialog-header-close')]")
		WebElement closeIconPopUp;
		
		@FindBy(xpath = "//label[text()='Name']/following-sibling::small")
		WebElement nameRequriedAlert;
		
		@FindBy(xpath = "//label[text()='Description']/following-sibling::small")
		WebElement descRequriedAlert;
		
		@FindBy(xpath = "//div[@class='radio ng-star-inserted']/following-sibling::small")
		WebElement statusRequriedAlert;
		
		@FindBy(xpath = "//div[text()='Program Created Successfully']/..")
		WebElement prgSuccessfulMsg;
		
		@FindBy(xpath = "//div[text()='Program Updated']/..")
		WebElement prgUpdateSuccessMsg;
		
		@FindBy(xpath = "//div[text()='Program Deleted']/..")
		WebElement DeleteSuccessfulMsg;
		
		@FindBy(xpath = "//div[text()='Programs Deleted']/..")
		WebElement MultiDeleteSuccessfulMsg;
		
		
		
		@FindBy(xpath = "//div[text()='cannot create program , since already exists']/..")
		WebElement existingPrgmAlertMsg;
		
		@FindBy(xpath = "//span[text()='Confirm']")
		WebElement deletePopUpTitle;
		
		@FindBy(xpath = "//span[text()='Yes']/../../button[2]")
		WebElement deletePopUpYesBtn;
		
		@FindBy(xpath = "//span[text()='No']/../../button[1]")
		WebElement deletePopUpNoBtn;
		
		@FindBy(xpath = "//span[contains(@class,'p-confirm-dialog-message')]")
		WebElement deletePopUpText;
			
		
		
     
		
	      
        
      @FindBy(xpath="//div/mat-card/mat-card-content/p-table/div/p-paginator/div/span[1]")
	  WebElement paginatorFooterText;
	
      @FindBy(xpath="//button[normalize-space()='1'])")
      WebElement btnFirstPage;

	@FindBy(xpath="//span[@class='p-paginator-icon pi pi-angle-right']")
	WebElement btnSecondPage;
	
	@FindBy(xpath="//span[@class='p-paginator-icon pi pi-angle-double-right']")
	WebElement btnPreviousPage;
	
	@FindBy(xpath="//span[@class='p-paginator-icon pi pi-angle-left']")
	WebElement btnNextPage;
	
	@FindBy(xpath="//span[@class='p-paginator-icon pi pi-angle-double-right']")
	WebElement btnLastPage;
	
	@FindBy(xpath="//span[@class='p-paginator-icon pi pi-angle-double-left']")
	WebElement btnStartPage;
	
	@FindBy(xpath="//span[@class='p-paginator-current ng-star-inserted']")
	WebElement paginationEntriesCount;
 
    @FindBy(xpath="//span[@class='p-paginator-pages.ng-star-inserted']")
    WebElement pagesCount;	

    @FindBy(xpath="//span[@class='p-paginator-pages ng-star-inserted']//button")
    List<WebElement> PageNoButtonList;
  

    Actions action = new Actions(driver);
    
    public String GetPaginationShowEntries() {
		return paginationEntriesCount.getText();
	}
	
	public String getFooterTotalRecord() {
		return paginatorFooterText.getText();
	}
	
	public boolean IsFirstpageLoaded() {
		if (PageNoButtonList.size()>=1) 
		{
			
			action.moveToElement(btnFirstPage).click().build().perform();
			
			return btnFirstPage.isEnabled();//need to change
		}
		return false;
	}
	public boolean IsFirstpageButtonEnabled() {
		if (PageNoButtonList.size()>=1) 
			return btnFirstPage.isEnabled();
		return false;
	}
	public boolean IsSecondpageLoaded() {
		if (PageNoButtonList.size()>1) 
			return btnSecondPage.isEnabled();
		return false;
	}
	
	public boolean IsSecondPageButtonEnabled() {
		if (PageNoButtonList.size()>1) 
			return btnSecondPage.isEnabled();
		return false;
	}
	public void ClickPreviousNavigationButton() {
		if (PageNoButtonList.size()>1) 
			action.moveToElement(btnPreviousPage).click().build().perform();
	}
	public boolean IsPreviousNavigationDisabled() {
		return btnPreviousPage.isEnabled();
	}
	
	public boolean IsNextNavigationDisabled() {
		return btnNextPage.isEnabled();
	}
	public void ClickNextNavigationButton() {
		if (PageNoButtonList.size()>1) 
			action.moveToElement(btnNextPage).click().build().perform();
	}

	public void ClickStartNavigationButton() {
		if (PageNoButtonList.size()>1) 
			action.moveToElement(btnStartPage).click().build().perform();
	}
	
	public void ClickLastNavigationButton() {
		if (PageNoButtonList.size()>1) 
			action.moveToElement(btnStartPage).click().build().perform();
	}
	
	public boolean verifyPaginationButtons()
	{
	   
      if( btnStartPage.isDisplayed() &&
    		  btnPreviousPage.isDisplayed() &&
    		  btnNextPage.isDisplayed() &&
    		  btnLastPage.isDisplayed() &&
		  paginatorFooterText.isDisplayed()) {
			return true;
		}
		else{
			return false;
		}
		}      
		
		
		public String getProgramPageTitle() {
			return driver.getTitle();
		}
		
		public String getUserPageUrl() {
			return driver.getCurrentUrl();
		}
		
		public String getBatchPageUrl() {
			return driver.getCurrentUrl();
		}
		
		public String getLoginPageUrl() {
			return driver.getCurrentUrl();
		}
		public void clickOnNavigationProgramBtn() {
			
			 ElementUtil.clickOnElement(driver, programNavBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		}
		public void clickOnNavigationBatchLink() {
			
			 ElementUtil.clickOnElement(driver, batchNavLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		}
		
		public void clickOnNavigationUserLink() {
			
			 ElementUtil.clickOnElement(driver, userNavLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		}
		
		public void clickOnNavigationLogOutLink() {
			
			 ElementUtil.clickOnElement(driver, logoutNavLink, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		}
		
		 
		public void verifySearchBox() {
			
			ElementUtil.isElementDisplayedStatus(driver, searchBox, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		}
		
        public void verifyNewProgramBtn() {
			
			ElementUtil.isElementDisplayedStatus(driver, newProgramBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		}
        
		public void verifyDashbordPageTitle() {
			ElementUtil.isElementDisplayedStatus(driver, dashboardHeaderTittle, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		}
		
		public void verifyDeleteBtnStatus() {
			ElementUtil.isElementDisplayedStatus(driver, topDisabledDeleteBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		}
		
		public void verifyProgramPageHeader() {
			ElementUtil.isElementDisplayedStatus(driver, managePrgHeader, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		}
		
       public void verifyDataTablePresent() {
			
			ElementUtil.isElementDisplayedStatus(driver, dataTable, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		}
       public void verifyDataTableColumnsName() {
			
			ElementUtil.isElementDisplayedStatus(driver, dataTableColumn1, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementUtil.isElementDisplayedStatus(driver, dataTableColumn2, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementUtil.isElementDisplayedStatus(driver, dataTableColumn3, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			ElementUtil.isElementDisplayedStatus(driver, dataTableColumn4, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		}
       public boolean verifyDataTableRowsPresent() {
    	   int rowsize =dataTableRows.size();
    	   if (rowsize>0) 
    	     {
    		     return true;
    	     }
		    return false;
       }
       public int verifyNoOfRowInDataTable() {
    	        int rowCount =  dataTableRows.size();
    	        return rowCount;
		}
    public boolean verifyDataTableCheckBoxes() {
    	   if (dataTableCheckBoxes.size()>0) {
    		   return true;
    	     }
		    return false;
       }
    public int verifyCheckboxesCountInDataTable() {
        int rowCount =  dataTableCheckBoxes.size();
        return rowCount;
     }
    public boolean verifyRowEditBtnsPresenst() {
 	   if (editBtnsInRow.size()>0)   {
 		   return true;
 	     }
		    return true;
    }   
    public boolean verifyEditBtnsOnEachRow() {
    	for(WebElement btnInRow :editBtnsInRow) {    		
    		if(btnInRow.isDisplayed()){
    			return true;
    		}   	
    	}
		return false;
    }
    public boolean verifyRowDeleteBtnsPresenst() {
  	   if (deleteBtnsInRow.size()>0) {
  		   return true;
  	     }
 		    return false;
     }	
    public boolean verifyDeleteBtnsOnEachRow() {
    	for(WebElement btnInRow :deleteBtnsInRow) {    		
    		if(btnInRow.isDisplayed()){
    			return true;
    		}   	
    	}
		return false;
    }  
    
   public void verifyPrgmSuccessAlert() {
	   ElementUtil.waitForElementVisibility(driver, prgSuccessfulMsg, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
    	prgSuccessfulMsg.isDisplayed();
   }
   
   public void verifyPrgmUpdateSuccessAlert() {
	   ElementUtil.waitForElementVisibility(driver, prgUpdateSuccessMsg, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	   prgUpdateSuccessMsg.isDisplayed();
   }
   public void selectFirstPrgBtn()  {
		
		 ElementUtil.clickOnElement(driver, FirstPrgmName, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		 System.out.println("admin selected first prgm to be edited");
	}
 
   public void clickOnEditPrgBtn()  {
		
		 ElementUtil.clickOnElement(driver, editBtnFirstPrgm, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		 System.out.println("admin selected edit button for prgm to be edited");
	}
   
   public void clickOnFirstDeleteBtn()  {
		
		 ElementUtil.clickOnElement(driver, deleteBtnFirstPrgm, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		 System.out.println("admin selected delete button for first prgm ");
	}
   
   public void verifyDeletePopUpAppears() {
   	
   	ElementUtil.isElementDisplayedStatus(driver, deletePopUpTitle, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
   	ElementUtil.isElementDisplayedStatus(driver, deletePopUpYesBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
   	ElementUtil.isElementDisplayedStatus(driver, deletePopUpNoBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
   	ElementUtil.isElementDisplayedStatus(driver, closeIconPopUp, Constant.EXPLICIT_ELEMENT_WAIT_TIME);   	
   
   }
   
   public void clickOnDeleteYesBtn()  {
	   
		ElementUtil.clickOnElement(driver, deletePopUpYesBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		 
		 System.out.println("admin clicked on yes button on delete pop up");
	}
   
   public void verifyDeleteSuccessAlert() {
	   //ElementUtil.waitForElementVisibility(driver, DeleteSuccessfulMsg, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	   DeleteSuccessfulMsg.isDisplayed();
   }
   
   public void verifyMultiDeleteSuccessAlert() {
	   MultiDeleteSuccessfulMsg.isDisplayed();
   }
   
   
   
   public String verifyTextOnDeletePopUp() {
	   ElementUtil.waitForElementVisibility(driver, deletePopUpText, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	   String deleteConfirmText = deletePopUpText.getText();
	   //Are you sure you want to delete AWS1?
	   System.out.println("deleteConfirmText :--"+deleteConfirmText);
	   String prgName = deleteConfirmText.substring(32, deleteConfirmText.length()-1);	   
	   return prgName;
	   
   }
   public boolean verifyPrgDeletedFrmTableOrNot(String deletePrgName) {
	   searchBox.isDisplayed();
   	   searchBox.click();
   	   searchBox.sendKeys(deletePrgName);
   	   searchBox.click();   
   	   if(dataTablePrgmName.getText().contentEquals(deletePrgName) ) {
   		
   		return true;
   	   }
   	   else 
   		return false;
    }
   
   
   public void clickOnDeleteNoBtn()  {
		
		 ElementUtil.clickOnElement(driver, deletePopUpNoBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		 System.out.println("admin clicked on No button on delete pop up");
	}
   public boolean verifyDeletePopUpDisapper() {
	   	
	   if (!deletePopUpTitle.isDisplayed()) {
		   return true;
	   }
	return true;
   }
   
   public void verifyTopDeleteEnabledBtn() {
   
	   ElementUtil.waitForElementVisibility(driver, topEnabledDeleteBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	   topEnabledDeleteBtn.isDisplayed();
   }
   public void clickOnTopDeleteBtn()  {
		
		 ElementUtil.clickOnElement(driver, topEnabledDeleteBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		 System.out.println("admin clicked on Top delete btn");
	}
   public void selectOneCheckBox() {
	   
	   dataTableCheckBoxes.get(0).click();
	   
   }
   
  public void selecMultipleCheckBox() {
	   
	   //dataTableCheckBoxes.get(0).click();	   
	   //dataTableCheckBoxes.get(1).click();
	   
	      firstCheckBox.click();
		  secCheckBox.click();
	   
   }
  public boolean verifyMultiProgmPresentInTableOrNot() {
	   
	   
	  
	 String firstPrgm = FirstPrgmName.getText();
	 String secPrgm = secPrgmName.getText();
	  
	 System.out.println("prgname array string is :-"+firstPrgm +"  "+secPrgm);
	  String[] prgname = {firstPrgm,secPrgm};
	   
	   for(int i=0; i<=prgname.length;) {
		   
		   searchBox.isDisplayed();
	   	   searchBox.click();
	   	   searchBox.sendKeys(prgname[i]);
	   	   searchBox.click();   
	   	   if(dataTablePrgmName.getText().contentEquals(prgname[i]) ) {
	   		System.out.println("searched deleted progm found");
	   		return true;
	   	   }
	   }
	   System.out.println("searched deleted progm not found");
  		return false;
	   
  }
  
  public String getTextOnTopDeletePopUp() {
	   ElementUtil.waitForElementVisibility(driver, deletePopUpText, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	   String topDeleteConfirmText = deletePopUpText.getText();
	   System.out.println("deleteConfirmText :--"+topDeleteConfirmText);	   
	   return topDeleteConfirmText;
  }
   
    public String verifyPrgmNameInDataTable(String createdPrgName) {
    	searchBox.isDisplayed();
    	searchBox.click();
    	searchBox.sendKeys(createdPrgName);
    	searchBox.click();
    	ElementUtil.waitForElementVisibility(driver, dataTablePrgmName, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
    	dataTablePrgmName.isDisplayed();
    	String searchedPrgname = dataTablePrgmName.getText();
    	System.out.println("searched Prg name :"+searchedPrgname);
    	return searchedPrgname;
}
    
    public String verifyPrgmDescInDataTable(String updatedPrgDesc) {
    	searchBox.isDisplayed();
    	searchBox.click();
    	searchBox.sendKeys(updatedPrgDesc);
    	searchBox.click();
    	ElementUtil.waitForElementVisibility(driver, dataTablePrgmDesc, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
    	dataTablePrgmDesc.isDisplayed();
    	String searchedPrgDesc = dataTablePrgmDesc.getText();
    	System.out.println("searched Prg Desc :"+searchedPrgDesc);
    	return searchedPrgDesc;
}
    public void clickOnANewProgramBtn() throws InterruptedException {
		
		 ElementUtil.clickOnElement(driver, newProgramBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		 Thread.sleep(500);
		 
	}
    public void verifyNewProgPopUpInputFields() {
    	
    	ElementUtil.isElementDisplayedStatus(driver, PrgPopUpTitle, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
    	ElementUtil.isElementDisplayedStatus(driver, blankNameInputBox, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
    	ElementUtil.isElementDisplayedStatus(driver, blankDescInputBox, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
    }
    public void verifyNewProgramPopUpUI() {    	
    	
    	ElementUtil.isElementDisplayedStatus(driver, cancelBtnPopUp, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
    	ElementUtil.isElementDisplayedStatus(driver, saveBtnPopUp, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
    	ElementUtil.isElementDisplayedStatus(driver, activeRadioBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
    	ElementUtil.isElementDisplayedStatus(driver, inActiveRadioBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
    	ElementUtil.isElementDisplayedStatus(driver, closeIconPopUp, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		 
    }
    
   public void clickOnSaveBtn() {
    	
    	ElementUtil.clickOnElement(driver, saveBtnPopUp, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
    	
    }
   
   public void clickOnCancelBtn() {
   	
   	ElementUtil.clickOnElement(driver, cancelBtnPopUp, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
   }
   
   public void clickOnCloseIcon() {
   	
   	ElementUtil.clickOnElement(driver, closeIconPopUp, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
   }
   
   public boolean verifyNewprgPopUpDisapper() {
	   	
	   if (!PrgPopUpTitle.isDisplayed()) {
		   return true;
	   }
	return true;
   }
   public void updatePrgName(String updatedPrgName )  {
		
	   try {
		     
		   WebElement prgEditBox = ElementUtil.waitForElementVisibility(driver, editPrgInputBox, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		   
		    prgEditBox.click();
		    prgEditBox.sendKeys(updatedPrgName);
		    
		    if(nameRequriedAlert.isDisplayed()) {
		    	
		    	  LoggerLoad.error("program name reached max length.");
		    	  blankNameInputBox.sendKeys(Keys.CONTROL,"a");
		    	  blankNameInputBox.sendKeys(Keys.BACK_SPACE);
		    	  LoggerLoad.error("program name need to re-Enter.");
		    	  blankNameInputBox.sendKeys(updatedPrgName);
		    	  
		    }
 		}catch(Exception e) {
				LoggerLoad.error(" Not able to update program name: "+e.getMessage());
			}	
	}
   
   public void updatePrgDesc(String updatedPrgDesc)   {
		
	   try {
		     
		   WebElement descEditBox = ElementUtil.waitForElementVisibility(driver, editDescInputBox, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		   
		   descEditBox.click();
		   descEditBox.sendKeys(updatedPrgDesc);
		    
		    if(descRequriedAlert.isDisplayed()) {
		    	
		    	  LoggerLoad.error("program desc reached max length.");
		    	  blankDescInputBox.sendKeys(Keys.CONTROL,"a");
		    	  blankDescInputBox.sendKeys(Keys.BACK_SPACE);
		    	  LoggerLoad.error("program desc need to re-Enter.");
		    	  blankDescInputBox.sendKeys(updatedPrgDesc);
		    	  
		    }
 		}catch(Exception e) {
				LoggerLoad.error(" Not able to update program desc: "+e.getMessage());
			}	
	}
   
   public void updatePrgStatus()  {
			   
	   String currentStatus = dataTableStatus.getText(); 
	   
	   if(currentStatus.equalsIgnoreCase("Active")){
		   ElementUtil.clickOnElement(driver, inActiveRadioBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
		   
	   }
	    	else if (currentStatus.equalsIgnoreCase("InActive"))	    	
	   ElementUtil.clickOnElement(driver, activeRadioBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	 }
   
   public void enterProgamDetails(String name,String desc) {
	   ElementUtil.typeInputIntoElement(driver, blankNameInputBox, name, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	   ElementUtil.typeInputIntoElement(driver, blankDescInputBox, desc, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
   }
   
   public void updateInvalidProgamDetails(String name,String desc) {
	   
	  if(name.length()==2) {
		  
		  LoggerLoad.error("entering invalid prg name");
		   editPrgInputBox.sendKeys(Keys.CONTROL,"a");
		   editPrgInputBox.sendKeys(Keys.BACK_SPACE); 	 
	 	   blankNameInputBox.sendKeys(name);
	 	   nameRequriedAlert.isDisplayed();
	  }else {
		  LoggerLoad.error("entering valid prg name");
		  ElementUtil.typeInputIntoElement(driver, editPrgInputBox, name, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	  }
	   
      if(desc.length()==2) {
		  
		  LoggerLoad.error("entering invalid prg desc");
		  editDescInputBox.sendKeys(Keys.CONTROL,"a");
		  editDescInputBox.sendKeys(Keys.BACK_SPACE); 	 
		  blankDescInputBox.sendKeys(desc);
		  descRequriedAlert.isDisplayed();
	  }else {
		  LoggerLoad.error("entering valid prg desc");
		  ElementUtil.typeInputIntoElement(driver, editDescInputBox, desc, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	  }
   }
   
   public void sendSheetPrgDetails(String sheetPrgName,String sheetDesc,String status) {
	   
	   ElementUtil.typeInputIntoElement(driver, blankNameInputBox, sheetPrgName, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	   ElementUtil.typeInputIntoElement(driver, blankDescInputBox, sheetDesc, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
			
	   if(status.equalsIgnoreCase("Active")){
	    	
	    	ElementUtil.clickOnElement(driver, activeRadioBtn,  Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	    	}
	    	else if (status.equalsIgnoreCase("InActive"))	       
	       ElementUtil.clickOnElement(driver, inActiveRadioBtn,  Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}
   public String verifyAllAlertMsg() {
			   
   	return nameRequriedAlert.getText()+""+descRequriedAlert.getText()+""+statusRequriedAlert.getText();
   	
   }
    public void clickOnStatusRadioBtn(String status) {
    	
    	if(status.equalsIgnoreCase("Active")){
    	ElementUtil.clickOnElement(driver, activeRadioBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
    	}
    	else if (status.equalsIgnoreCase("InActive"))
    	ElementUtil.clickOnElement(driver, inActiveRadioBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
    	
    }
    public String getNameAlertMsg() {    	
    
    	return nameRequriedAlert.getText();
    }
    
   public String getDescAlertMsg() {
    	
    	return descRequriedAlert.getText();
    }
   public String getStatusAlertMsg() {
   	
   	return statusRequriedAlert.getText();
   }  
    
   
   
   
   
    
    
    
}
