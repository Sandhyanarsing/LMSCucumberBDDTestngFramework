package pageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Constant;
import utilities.ElementUtil;

public class POM_BatchPage {
private WebDriver driver ;
	
	public POM_BatchPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[normalize-space()='Batch']")
	WebElement mainBatch;
	
	@FindBy(xpath="//span[contains(text(), 'A New Batch')]")
	WebElement addNewBatchBtn;
	
	@FindBy(xpath="//div[normalize-space()='Manage Batch']")
	WebElement batchHeaderName;
	
	@FindBy(xpath="//span[@class='p-button-icon pi pi-trash']")
	WebElement deleteBtn;
	
	@FindBy(xpath="//div[@class='p-checkbox-box']")
	WebElement checkBox;
	
	@FindBy(xpath="//th[normalize-space()='Batch Name']")
	WebElement batchNameSortable;
	
	@FindBy(xpath="//th[normalize-space()='Batch Description']")
	WebElement batchDescSortable;
	
	@FindBy(xpath="//th[normalize-space()='Batch Status']']")
	WebElement batchStatusSortable;
	
	@FindBy(xpath="//th[normalize-space()='No Of Classes']")
	WebElement noOfClassesSortable;
	
	@FindBy(xpath="//th[normalize-space()='Program Name']")
	WebElement programNameSortable;
	
	@FindBy(xpath="//th[normalize-space()='Edit / Delete']")
	WebElement editDelColumn;
	
	@FindBy(xpath="//input[@id='filterGlobal']")
	WebElement searchBox;
	
	@FindBy(xpath="//span[@class='p-button-icon pi pi-pencil']")
	WebElement batchEditBtn;
	
	@FindBy(xpath="//span[@class='p-button-icon pi pi-trash']")
	WebElement batchDeleteBtn;
	
	@FindBy(xpath="//input[@id='batchName']")
	WebElement batchName;
	
	@FindBy(xpath="//input[@id='batchDescription']")
	WebElement batchDesc;
	
	@FindBy(xpath="//input[@placeholder='Select a Program name']")
	WebElement programNameDropDown;
	
	@FindBy(xpath="//lable[@for='online']")
	WebElement Status;
	
	@FindBy(xpath="//*[@id='batchStatus']/div[1]")
	WebElement statusActive;
	
	@FindBy(xpath="//input[@*='INACTIVE']")
	WebElement statusInActive;
	
	@FindBy(xpath="//input[@id='batchNoOfClasses']")
	WebElement noOfClassesDropDown;
	
	@FindBy(xpath="//span[normalize-space()='Save']")
	WebElement saveBtn;
	
	@FindBy(xpath="//span[normalize-space()='Cancel']")
	WebElement cancelBtn;
	
	@FindBy(xpath="//div/mat-card/mat-card-content/p-table/div/p-paginator/div")
	WebElement paginatorFooter;
	
	@FindBy(xpath="//span[@class='p-paginator-icon pi pi-angle-right']")
	WebElement singleRightBtn;
	
	@FindBy(xpath="//span[@class='p-paginator-icon pi pi-angle-double-right']")
	WebElement doubleRightBtn;
	
	@FindBy(xpath="//span[@class='p-paginator-icon pi pi-angle-left']")
	WebElement singleLeftBtn;
	
	@FindBy(xpath="//span[@class='p-paginator-icon pi pi-angle-double-left']")
	WebElement doubleLeftBtn;
	
	@FindBy(xpath="//span[@class='p-paginator-current ng-star-inserted']")
	WebElement paginationText;
	
	@FindBy(xpath="//button[@class='p-button-danger p-button p-component p-button-icon-only']")
	WebElement multipleDelBtn;
	
	//table header grid
	@FindBys({@FindBy(xpath = "//thead[@class='p-datatable-thead']")}) List<WebElement> tableHeadingGrid;
	
	@FindBy(xpath="//div[@role='checkbox']")
	List<WebElement> checkboxes;
	
	@FindBy(tagName ="//tr")
	List<WebElement> rows;
	
	@FindBy(xpath ="//div[@role='dialog']")
	WebElement batchDialogBox;
	
	@FindBy(xpath="//span[normalize-space()='Yes']")
	WebElement alertYesBtn;
	
	@FindBy(xpath="//span[normalize-space()='Yes']")
	WebElement alertNoBtn;
	
	@FindBy(xpath="//span[@id='pr_id_5-label']")
    WebElement batchDialogBoxHeader;
	
	@FindBy(xpath = "//div[@*='button']/span")WebElement programNameFieldDropDownBtn;
	
	@FindBys({
		@FindBy(xpath ="//span[@class='p-button-icon pi pi-pencil']") 
	})List<WebElement> allRowsEditBtn;
		
	@FindBys({
		@FindBy(xpath ="//span[@class='p-button-icon pi pi-trash']") 
	})List<WebElement> allRowsDeleteBtn;
	
	@FindBy(xpath="")
	String successMessage="";
	String errorMessage = "";
	Actions act;
	String batchurl= "driver.get(prop.getProperty(batchexpectedurl))";
	boolean button;
	boolean pagegrid;
	
	//Methods for performing various operations
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public void clickOnBatchBtn() {
		
		 ElementUtil.clickOnElement(driver, mainBatch, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}
	public void verifySearchBox() {
		
		ElementUtil.isElementDisplayedStatus(driver, searchBox, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}
	
   public void verifyNewBatchBtn() {
		
		ElementUtil.isElementDisplayedStatus(driver, addNewBatchBtn, Constant.EXPLICIT_ELEMENT_WAIT_TIME);
	}
	
   public String batchTitle() {
	    String headername=	batchHeaderName.getText();
	    return headername;
		
    }
   
   public String checkPaginationText() {
		String pagiEntries=paginationText.getText();
		return pagiEntries;
	}
   
   public boolean verifyPaginationButtons()
	{
	   
      if( singleRightBtn.isDisplayed() &&
		  doubleRightBtn.isDisplayed() &&
          singleLeftBtn.isDisplayed() &&
		  doubleLeftBtn.isDisplayed() &&
		  paginationText.isDisplayed()) {
			return true;
		}
		else{
			return false;
		}
		}

//Need to relook this code for pagination implementation
   
   public void testPagination() {
	// Verify the presence of pagination buttons
	    boolean paginationButtonsPresent = verifyPaginationButtons();
	    Assert.assertTrue(paginationButtonsPresent, "Pagination buttons are not displayed");

	    // Test pagination navigation by clicking on pagination controls
	       singleRightBtn.click();
   }
 /*  private List<String> prepareList(List<WebElement> tbheadtitle){
   public boolean IsPageLoaded(String Page) {
       // Prepare a list of table headings
       List<String> tableHeading = new ArrayList<>();
       tableHeading = prepareList(tableHeadingGrid);
       
       System.out.println("Table Heading: " + tableHeading); // Debug statement

       if (Page.equalsIgnoreCase("Batch")) {
           return verifyBatchPageHeaders(tableHeading);
       }

       return false;
   }

   private boolean verifyBatchPageHeaders(List<String> tableHeading) {
       // Verify if all required headers are present on the Batch page
       boolean result = tableHeading.contains("Batch Name") &&
               tableHeading.contains("Batch Description") &&
               tableHeading.contains("Batch Status") &&
               tableHeading.contains("No Of Classes") &&
               tableHeading.contains("Program Name") &&
               tableHeading.contains("Edit / Delete");
       
       System.out.println("Header Verification Result: " + result); // Debug statement
       
       return result;
   }
  

   private List<String> prepareList(List<WebElement> tableHeadingGrid) {
       // Implement logic to extract table headings from tableHeadingGrid and store them in a list
       List<String> headings = new ArrayList<>();
       // Example implementation (replace with actual logic)
       for (WebElement headingElement : tableHeadingGrid) {
           headings.add(headingElement.getText().trim());
       }
       System.out.println("Header Verification Result: " + headings);
       return headings;
   }

   public boolean verifyHeadersTableGrid(String PageName) {
       return IsPageLoaded(PageName);
   }*/
   public boolean IsPageLoaded(String Page) {
	    // Prepare a list of table headings
	    List<String> tableHeading = prepareList(tableHeadingGrid);

	    System.out.println("Table Heading: " + tableHeading); // Debug statement

	    if (Page.equalsIgnoreCase("Batch")) {
	        // Define required headers for the Batch page
	        List<String> requiredHeaders = Arrays.asList(
	            "Batch Name", "Batch Description", "Batch Status",
	            "No Of Classes", "Program Name", "Edit / Delete"
	        );
	        
	        // Check if all required headers are present
	        boolean result = tableHeading.containsAll(requiredHeaders);
	        System.out.println("Header Verification Result: " + result); // Debug statement
	        return result;
	    }

	    return false;
	}

	private List<String> prepareList(List<WebElement> tableHeadingGrid) {
	    // Implement logic to extract table headings from tableHeadingGrid and store them in a list
	    List<String> headings = new ArrayList<>();
	    
	    // Example implementation (replace with actual logic)
	    for (WebElement headingElement : tableHeadingGrid) {
	    	
	        headings.add(headingElement.getText().trim());
	        System.out.println("Element Text: " + headingElement.getText().trim());
	    }
	    System.out.println("Extracted Table Headings: " + headings); // Debug statement
	    return headings;
	}

	//public boolean verifyHeadersTableGrid(String PageName) {
	  //  return IsPageLoaded(PageName);
	
public void ClickMultipleDeleteIcon()
{
	act.moveToElement(multipleDelBtn).click().build().perform();
}
public void EnterSearchText(String content) {
	searchBox.clear();
	searchBox.sendKeys(content);
}

public void ClickAddNewBatchBtn() {
	addNewBatchBtn.click();
}
	
public boolean IsAddNewBatchBtnDisplayed() {
	return addNewBatchBtn.isDisplayed();
}
public boolean IsSearchBoxDisplayed() {
	return searchBox.isDisplayed();
}

public boolean IsMultiDeleteIconEnabled() {
	return multipleDelBtn.isEnabled();
}
	
public boolean disabledMultiDeleteBtn()	{
		if(multipleDelBtn.isEnabled())
		{
			return false;
		}
		else
		{
			return true;
		}
	}
public boolean verifyDeleteIconDisabled()
{
	button = disabledMultiDeleteBtn();
	return button;
}
public boolean verifyAddNewBatchBtnEnabled()
{
	button = IsAddNewBatchBtnDisplayed();
	return button;
}
public Boolean IsCheckBoxInTableRows(int checkBoxSize,int rowSize)
{
	if(checkBoxSize == rowSize)
		return true;
	else
		return false;
}

public boolean verifyEditButtonEnabledForEachRow() {
    
    WebElement tableHeadingGrid = driver.findElement(By.xpath("//thead[@class='p-datatable-thead']"));

    boolean button = IsEditButtonEnabledInTableRows(tableHeadingGrid);
    return button;
}
public boolean verifyCheckBoxEnabledForEachRow()
{   
	button = IsCheckBoxInTableRows(checkboxes.size(),rows.size());
	return button;
}

public boolean verifyDeleteButtonEnabledForEachRow()
{   
	WebElement tableHeadingGrid = driver.findElement(By.xpath("//thead[@class='p-datatable-thead']"));
	button = IsDeleteButtonEnabledInTableRows(tableHeadingGrid);
	return button;
}
public Boolean IsDeleteButtonEnabledInTableRows(WebElement tableHeadingGrid)
{
	List<WebElement> deleteButtons = tableHeadingGrid.findElements(By.xpath("//span[@class='p-button-icon pi pi-trash']"));

    boolean allEnabled = true;
    for (WebElement button : deleteButtons) {
        if (!button.isEnabled()) {
            allEnabled = false;
            break;
        }
           }
	return allEnabled;
}

public Boolean IsEditButtonEnabledInTableRows(WebElement tableHeadingGrid)
{
	List<WebElement> editButtons = tableHeadingGrid.findElements(By.xpath("//span[@class='p-button-icon pi pi-pencil']"));

    boolean allEnabled = true;
    for (WebElement button : editButtons) {
        if (!button.isEnabled()) {
            allEnabled = false;
            break;
        }
           }
	return allEnabled;
}
public boolean isBatchDialogBoxDisplayed() {
	return batchDialogBox.isDisplayed();
}

//DELETE BATCH SCENARIOS

public void ClickSingleEditBtn(int index) {
	allRowsEditBtn.get(1).click();
	
}
/*public boolean ClickSingleDeleteBtn(int index) {
	System.out.println(index);
	allRowsDeleteBtn.get(index).click();
	
	return true;
	
}*/
public boolean clickSingleDeleteBtn(int index) {
    //System.out.println(index);
    
    if (allRowsDeleteBtn.size() > 0 && index >= 0 && index < allRowsDeleteBtn.size()) {
        allRowsDeleteBtn.get(index).click();
        return true;
    } else {
        System.out.println("The list allRowsDeleteBtn is either empty or the index is out of bounds.");
        return false;
    }
}

public void clickDelBtn()
{
	clickSingleDeleteBtn(0);
	
}
public boolean confirmationDialogBox() {
	 boolean yesButtonPresent = alertYesBtn.isDisplayed();
     boolean noButtonPresent = alertNoBtn.isDisplayed();

     return yesButtonPresent && noButtonPresent;
 }
/*public HashMap<String,String> BatchDialogBoxDetails()
{
	HashMap<String,String> batchDetails = new HashMap<String,String> ();
	batchDetails.put("batchName", batchName.getTagName());
	batchDetails.put("BatchDescription", batchDesc.getTagName());
	batchDetails.put("ProgramName", programNameDropDown.getTagName());
	batchDetails.put("status", statusActive.getTagName());
	batchDetails.put("No of Classes", noOfClassesDropDown.getTagName());
	
	return batchDetails;
}*/
public HashMap<String, String> batchDialogBoxDetails() {
    HashMap<String, String> details = new HashMap<>();
    details.put("BatchName", getFieldType(batchName));
    details.put("BatchDescription", getFieldType(batchDesc));
    details.put("ProgramName", getFieldType(programNameDropDown));
    details.put("Status", getFieldType(statusActive));
    details.put("NumberOfClasses", getFieldType(noOfClassesDropDown));
    return details;
}

private String getFieldType(WebElement element) {
    String tagName = element.getTagName().toLowerCase();
    if (tagName.equals("input") && element.getAttribute("type").equals("text")) {
        return "text box";
    } else if (tagName.equals("textarea")) {
        return "text box";
    } else if (tagName.equals("input")) {
        return "drop down";
    }
    else if (tagName.equals("input") && element.getAttribute("type").equals("number")) {
        return "text box";
    } else if (tagName.equals("input") && element.getAttribute("type").equals("radio")) {
        return "radio button";
    } else {
        return "unknown";
    }
}
public void validateInvalidValues(String batchId,String batchDes,String pgmName,String status,String  NoC)
{
	
	batchName.sendKeys(batchId);
	batchDesc.sendKeys(batchDes);
	programNameFieldDropDownBtn.click();
	   
    WebElement firstOption = driver.findElement(By.xpath("//*[@id='programName']/div/div[3]/div/ul/p-dropdownitem[1]/li"));
    firstOption.click();
    statusActive.click();
    noOfClassesDropDown.sendKeys(NoC);
    saveBtn.click();
    
}
public String geterrorMessage()
{   WebElement errorMsg = null;
	errorMsg = driver.findElement(By.xpath("//small[@id='text-danger']"));
	return errorMsg.getText();
}

public void enterValidValues(String batchnam, String batchDes, String pgmName, String status, String  NoC) {
    // Fill in text fields
    batchName.sendKeys(batchnam);
    batchDesc.sendKeys(batchDes);
    programNameFieldDropDownBtn.click();
   
    WebElement firstOption = driver.findElement(By.xpath("//*[@id='programName']/div/div[3]/div/ul/p-dropdownitem[1]/li"));
    firstOption.click();
    statusActive.click();
    noOfClassesDropDown.sendKeys(NoC);
    saveBtn.click();
    
}

public boolean isBatchCreated(String batchName) {
    try {
        // Search for the newly created batch by its name
        driver.findElement(By.xpath("//td[contains(text(), '" + batchName + "')]"));
        return true; // Batch found, return true
    } catch (Exception e) {
        return false; // Batch not found, return false
    }
}
}





      

   

	
	


	
	
	
	
	


