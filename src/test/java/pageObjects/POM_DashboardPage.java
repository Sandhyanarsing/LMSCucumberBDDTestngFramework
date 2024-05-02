package pageObjects;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
//import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;

import utilities.ConfigReader;


public class POM_DashboardPage {
	
private WebDriver driver;
private long startTime;
public Properties prop;
	
	public POM_DashboardPage(WebDriver driver){
		
	this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "username") WebElement LoginPage_username;
	@FindBy(id = "password") WebElement LoginPage_password;
	@FindBy(id = "login") WebElement LoginPage_loginBtn;
	
	
	@FindBy(xpath="//span[text()='Program']") WebElement program;
	//@FindBy(xpath="/html/body//span[text()='Program']") WebElement program;
	//@FindBy(id = "program")WebElement program_Btn;
	@FindBy(id = "batch") WebElement batchNavLink;
	//@FindBy(xpath="//span[text()='Batch']") WebElement batch;	
	
	@FindBy(xpath="//span[text()='User']") WebElement user;	
	@FindBy(xpath="//span[text()='Logout']") WebElement logoutButton;	
	@FindBy(xpath="//*[@class='mat-toolbar mat-primary mat-toolbar-single-row ng-star-inserted']") WebElement navigationBar;	

     @FindBy(xpath = "//span[contains(text(),'LMS - Learning Management System')]") WebElement lmsTitle;
	 @FindBy(xpath = "//*[@class='signin-content']")WebElement header_ManageProgram;
	
	 
		
	// public String getDashboardPageTitle() {
			//return driver.getTitle();
		//} 
     
	//verify url
	    public String verifyurl() {

	        String actualUrl = driver.getCurrentUrl();
	       
	       if (actualUrl.contains("url")) {

	            System.out.println("Admin lands on the home page");

	        } else {

	            System.out.println("Admin receives 404 page not found error");
	        }
	        return actualUrl;
	    }
	    
	    
	    
	    public void enterValidCred_ClickLoginButton1(String username, String password) {
	        LoginPage_username.sendKeys(username);
	        LoginPage_password.sendKeys(password);
	        LoginPage_loginBtn.click();
	    }

     
     
     
//Header(manage Program) is displayed
     public boolean isHeaderDisplayed() {
    	 
    	 return header_ManageProgram.isDisplayed();
     }
     
     
 //LMS Title - dashboard url 
     
    public void getDashboardTitleText() {
    	Properties prop = ConfigReader.getPropertyObject();
      	 System.out.println("dashboardurl" + prop.getProperty("dashboardurl"));
      	 driver.get(prop.getProperty("dashboardurl"));
     }
     
    //LMS Title:
    public void verifyDashboardTitle(String expectedTitle) {
        driver.get("https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/");
        String actualTitle = driver.getTitle();
        String expectedTitleText = "LMS";
        Assert.assertTrue(actualTitle.contains(expectedTitleText), "Dashboard title does not contain expected title");
        System.out.println("Test completed");
    }


     
 // private long startTime;

         public void startNavigationTimer() {
             startTime = System.currentTimeMillis();
         }

         public long getNavigationTimeInMillis() {
             return System.currentTimeMillis() - startTime;
         }
     
 
     
  //LMS title top left corner of the page   
   
     public boolean isLMSTitleAlignedToTopLeft() {
        	    try {
        	        
        	        WebElement titleElement = getLMSTitleElement();
        	        if (titleElement == null) {
        	            return false;
        	        }
        	        
        	        String align = titleElement.getCssValue("text-align");
        	        String verticalAlign = titleElement.getCssValue("vertical-align");
        	        return align.equals("left") && verticalAlign.equals("top");
        	    } catch (NoSuchElementException | StaleElementReferenceException e) {
        	         e.printStackTrace();
        	        return false;
        	    }
        	}
         
         private WebElement getLMSTitleElement() {
     	    try {
     	        return driver.findElement(By.xpath("//body[@class='mat-typography']"));
     	    } catch (NoSuchElementException e) {
     	     e.printStackTrace(); 
     	        return null;
     	    }
     	}

  //correct spellings in the navigation bar 
         public String verifyNavigationBarText() throws InterruptedException {
        	 Thread.sleep(5000);
            System.out.println("navigation" + navigationBar.getText()); 
        	 return navigationBar.getText();
     		
     	}
         
   //7.           
 // public  String getLMSTitleText() {
    	 
    	 //String expectedLMSTitle = "LMS";
        // String actualLMSTitle = dashboardPage.getLMSTitleText();
          
        //  Assert.assertEquals(actualLMSTitle, expectedLMSTitle);
  		
    	 
    // }
     
       
    //Navigation Bar Aligned to the right
     public boolean isNavigationBarAlignedToTopRight() {
    			    try {
    			        WebElement navigationBarElement = getNavigationBarElement();
    			        if (navigationBarElement == null) {
    			            return false;
    			        }

    			        String align = navigationBarElement.getCssValue("text-align");
    			        String verticalAlign = navigationBarElement.getCssValue("vertical-align");
    			        return align.equals("right") && verticalAlign.equals("top");
    			    } catch (NoSuchElementException | StaleElementReferenceException e) {
    			        e.printStackTrace();
    			        return false;
    			    }
    			}

    			private WebElement getNavigationBarElement() {
    			    try {
    			    	return driver.findElement(By.xpath("//body[@class='mat-typography']"));
    			    	//return driver.findElement(By.id("program"));
    			        
    			    } catch (NoSuchElementException e) {
    			        e.printStackTrace();
    			        return null;
    			    }
    			}

 

     
     
     
     //1.
     
     public String getFirstNavigationBarItemText() {
         
         return program.getText();
    	
     }
     
     //2
     
     public String getSecondNavigationBarItemText() {
         
         return batchNavLink.getText();
     }
     
     //3
     public String getThirdNavigationBarItemText() {
    
    return user.getText();
    
     } 
     
     //4
      public String getFourthNavigationBarItemText() {
    
    return logoutButton.getText();
    
     }   
     
    
     
}
     
