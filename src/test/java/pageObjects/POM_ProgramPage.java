package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Constant;
import utilities.ElementUtil;


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
	    @FindBy(id = "program")
		WebElement programNavBtn;
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
		
		
		@FindBy(xpath = "//tbody[@class='p-datatable-tbody']/tr/td[1]//div[@role='checkbox']")
		List <WebElement> dataTableCheckBoxes;
		
		@FindBy(xpath = "//div[contains(@class,'p-datatable-wrapper')]/table//tbody/tr/td[5]//button[@id='editProgram']")
		List <WebElement> editBtnsInRow;
		
		@FindBy(xpath = "//div[contains(@class,'p-datatable-wrapper')]/table//tbody/tr/td[5]//button[@id='deleteProgram']")
		List <WebElement> deleteBtnsInRow;
		
		
		
		
	
		public String getProgramPageTitle() {
			return driver.getTitle();
		}
		
		public void clickOnNavigationProgramBtn() {
			
			 ElementUtil.clickOnElement(driver, programNavBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
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
    	   
    	   if (dataTableCheckBoxes.size()>0) 
    	     {
    		   return true;
    	     }
		    return false;
    	   
       }
    
    public int verifyCheckboxesCountInDataTable() {
        int rowCount =  dataTableCheckBoxes.size();
        return rowCount;
	
     }
  
    public boolean verifyRowEditBtnsPresenst() {
 	   
 	   if (editBtnsInRow.size()>0) 
 	     {
 		   return true;
 	     }
		    return true;
 	   
    }   
    
    public boolean verifyEditBtnsOnEachRow() {
    
    
    	for(WebElement btnInRow :editBtnsInRow) {    		
    		    		
    		if(btnInRow.isDisplayed())
    		{
    			return true;
    		}   	
    	}
		return false;
		
    }
    public boolean verifyRowDeleteBtnsPresenst() {
  	   
  	   if (deleteBtnsInRow.size()>0) 
  	     {
  		   return true;
  	     }
 		    return false;
     }	
    public boolean verifyDeleteBtnsOnEachRow() {
        
        
    	for(WebElement btnInRow :deleteBtnsInRow) {    		
    		    		
    		if(btnInRow.isDisplayed())
    		{
    			return true;
    		}   	
    	}
		return false;
		
    }
    
}
