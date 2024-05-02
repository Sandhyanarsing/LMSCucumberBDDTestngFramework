package pageObjects;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.ConfigReader;


public class POM_HomePage {
	
private WebDriver driver ;
public Properties prop;

	
	public POM_HomePage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
			    
	}

	@FindBy(xpath = "//img[@class='images']") WebElement logo;
	@FindBy(xpath = "//input[@id='username']") WebElement user_txt;
	@FindBy(xpath = "//input[@id='password']") WebElement password_txt;
	@FindBy(xpath = "//span[@class='mat-placeholder-required mat-form-field-required-marker ng-tns-c78-0 ng-star-inserted']") WebElement asterisk_usertxt;
	@FindBy(xpath = "//span[@class='mat-placeholder-required mat-form-field-required-marker ng-tns-c78-1 ng-star-inserted']") WebElement asterisk_passtxt;
    @FindBy(xpath = "////*[normalize-space()='Please login to LMS application']") WebElement signin_content;
	@FindBy(xpath = "//form[@class='ng-untouched ng-pristine ng-invalid']") WebElement signinfields;
    @FindBy(xpath = "//span[@class='mat-button-wrapper']") WebElement login_Btn;
	@FindBy(xpath = "//div[@class='signin-content']") WebElement signin_body;

	
	
	
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
    
    
    //invalid url
    public void verifyInvalidAppURL() {

   	 Properties prop = ConfigReader.getPropertyObject();
   	 System.out.println("invalidurl" + prop.getProperty("invalidurl"));
   	 driver.get(prop.getProperty("invalidurl"));

   	 }
    
    
    
//Verify the text spelling in the page
    
    public void verifyTextSpelling1() {
    	
    	verifyTextSpelling(signinfields, "user");
        verifyTextSpelling(signinfields, "password");
    	
    }
    public void verifyTextSpelling(WebElement signinfields, String text) {
    	
        String pageText = signinfields.getText().toUpperCase();
        
        if (pageText.contains(text.toUpperCase())) {
            System.out.println("Spelling of '" + text + "' is correct on the page.");
        } else {
            System.out.println("Spelling of '" + text + "' is incorrect or not found on the page.");
        }
    }

    
    
 //verify company Logo
    public void LogoVisibilityCheck() {
    	 boolean isLogoDisplayed = logo.isDisplayed();

     if (isLogoDisplayed) {
        System.out.println("Left side logo is present for admin.");
    } else {
        System.out.println("Left side logo is not present for admin.");
    }

    } 
    
    
 //Verify Application name
    
    public void applicationname() {
    	text_spelling();
    	
    }
    public void text_spelling() {
        String text1 = "LEARNING";
        String text2 = "MANAGEMENT";
        String text3 = "SYSTEM";

       WebElement spell = driver.findElement(By.xpath("//img[@class='images']"));
       String altText = spell.getAttribute("alt");
       System.out.println("Alt text of the image: " + altText);
        if (spell.getText().contains(text1)) {
            System.out.println("LEARNING");
        } else if (spell.getText().contains(text2)) {
            System.out.println("MANAGEMENT");
        } else if (spell.getText().contains(text3)) {
            System.out.println("SYSTEM");
        } else {
            System.out.println("None of the predefined strings found.");
        }
    }
    
    
 //Verify Company Name
   
     public boolean isCompanyNamePresentNearLogo() {
        WebElement logoElement = driver.findElement(By.xpath("//img[@class='images']"));
        WebElement parentElement = logoElement.findElement(By.xpath("./..")); 
        String parentElementText = parentElement.getText();

        return parentElementText.contains("NumpyNinja");
    }

 //Validate sign in content  
    public void verifyHeader_text() {
    	 WebElement signin_content  = driver.findElement(By.xpath("//*[normalize-space()='Please login to LMS application']"));

        String actual_text = signin_content.getText();

        String expected_text = "Please login to LMS application";

        Assert.assertTrue(actual_text.contains(expected_text),
       "Expected text '" + expected_text + "' not found in actual text: '" + actual_text + "'");
}
    
     
 //Verify text field is present
     public void FieldPresenceVerification() {
     WebElement field1 = driver.findElement(By.xpath("//label[@id='mat-form-field-label-1']"));
     WebElement field2 = driver.findElement(By.xpath("//label[@id='mat-form-field-label-3']"));

      if (field1.isDisplayed() && field2.isDisplayed()) {
         System.out.println("Both fields are present on the page.");
     } else {
         System.out.println("One or both fields are not present on the page.");
     }
}
     
     
//Verify text on the first text field
   
     public void checkTextFieldText() {
    	 verifyTextFieldText("User");
    	 
     }
     public void verifyTextFieldText(String expectedText) {
    	    WebElement textField1 = driver.findElement(By.xpath("//label[@id='mat-form-field-label-1']"));
    	    String actualText = textField1.getText();
    	    

    	    Assert.assertTrue(actualText.contains(expectedText),
    	            "Expected text '" + expectedText + "' not found in actual text: '" + actualText + "'");
    	}

     
     
 //Verify Asterik next to User text
     public void AsteriskVerification1() {
    	 WebElement userElement = driver.findElement(By.xpath("//span[@class='ng-tns-c78-0 ng-star-inserted']"));

         WebElement asteriskElement = userElement.findElement(By.xpath("//span[@class='mat-placeholder-required mat-form-field-required-marker ng-tns-c78-0 ng-star-inserted']"));
         
         if (asteriskElement != null) {
             System.out.println("An asterisk (*) is present next to the text 'user'.");
         } else {
             System.out.println("An asterisk (*) is not present next to the text 'user'.");
         }
     }
     
     
 //Verify text on the second text field
   
     
    	 public void checkTextFieldText1() {
        	 verifyTextFieldText2("Password");
        	 
         }
         public void verifyTextFieldText2(String expectedText) {
        	    WebElement textField2 = driver.findElement(By.xpath("//label[@id='mat-form-field-label-3']"));
        	    String actualText = textField2.getText();
        	    

        	    Assert.assertTrue(actualText.contains(expectedText),
        	            "Expected text '" + expectedText + "' not found in actual text: '" + actualText + "'");
        	}

     
 //Verify Asterik next to password text
     public void AsteriskVerification2() {
    	 WebElement userElement = driver.findElement(By.xpath("//span[@class='ng-tns-c78-1 ng-star-inserted']"));

         WebElement asteriskElement = userElement.findElement(By.xpath("//span[@class='mat-placeholder-required mat-form-field-required-marker ng-tns-c78-1 ng-star-inserted']"));
         
         if (asteriskElement != null) {
             System.out.println("An asterisk (*) is present next to the text 'password'.");
         } else {
             System.out.println("An asterisk (*) is not present next to the text 'password'.");
         }
     }
     
 //Verify the alignment input field for the login
     public void InputFieldAlignmentVerification() {
     WebElement usernameInput = driver.findElement(By.xpath("//div[@class='mat-form-field-underline ng-tns-c78-0 ng-star-inserted']"));
     WebElement passwordInput = driver.findElement(By.xpath("//div[@class='mat-form-field-underline ng-tns-c78-1 ng-star-inserted']"));

     String usernameInputAlignment = usernameInput.getCssValue("text-align");
     String passwordInputAlignment = passwordInput.getCssValue("text-align");

     if (usernameInputAlignment.equals("center") && passwordInputAlignment.equals("center")) {
         System.out.println("Input fields are centered on the page.");
     } else {
         System.out.println("Input fields are not centered on the page.");
     }

     }
     
     
 //Verify Login is present
     public boolean verify_login_Btn() {
    	 
         return login_Btn.isDisplayed();

     } 
     
     
 //Verify the alignment of the login button
     public String lgCenterAlign() {
   
    	    String textAlignValue = login_Btn.getCssValue("text-align");

    	    return textAlignValue;
    	}
     

 //Verify that the color of the placeholder user text is gray
    /* public void descriptivetest1() {
     WebElement userField = driver.findElement(By.id("user"));                                                                         
     String colorValue = userField.getCssValue("color");
     String hexColorValue = Color.fromString(colorValue).asHex();
     Assert.assertEquals(hexColorValue, "#808080", "Placeholder text color is not gray.");

     }*/
    	 
    	 public void verifyUserFieldColor() {
    		 descriptivetest1("User");
    		 
    	 }
    	 public void descriptivetest1(String expectedText) {
    		    WebElement userField = driver.findElement(By.xpath("//span[@class='ng-tns-c78-0 ng-star-inserted']"));
    		    String colorValue = userField.getCssValue("color");
    		    String hexColorValue = Color.fromString(colorValue).asHex();
    		    
    		    Assert.assertEquals(hexColorValue, "#000000", "Placeholder text color is not gray.");
    		}

     
 //Verify that the color of the placeholder password  text is gray
    	 public void verifyUserFieldColor1() {
    		 descriptivetest1("Password");
    		  }
    	 
     public void descriptivetest2() {
     WebElement userField = driver.findElement(By.xpath("//span[@class='ng-tns-c78-1 ng-star-inserted']"));                                                                         
     String colorValue = userField.getCssValue("color");
     String hexColorValue = Color.fromString(colorValue).asHex();
     Assert.assertEquals(hexColorValue, "#000000", "Placeholder text color is not gray.");

     }
     
    
}
