package stepDefinitions;



import org.testng.Assert;
import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.POM_DashboardPage;
import pageObjects.POM_HomePage;
import utilities.PicoDependencyInjector;


public class StepDef_DashboardPage {
	
	POM_DashboardPage dashboardPage;
	
    PicoDependencyInjector picoDepInj;

	public StepDef_DashboardPage(PicoDependencyInjector picoDepInj) {

		this.picoDepInj = picoDepInj;
		picoDepInj.homepage= new POM_HomePage(DriverFactory.getDriver());		
		//picoDepInj.dashboardpage= new POM_DashboardPage(DriverFactory.getDriver());
	}
	
	
	
	@Given("Admin is on the Home Page")
	public void admin_is_on_the_home_page() {
		picoDepInj.homepage.verifyurl();
		Assert.assertTrue(picoDepInj.homepage.verifyurl().contains("/login"));

    }

	@Given("Admin has provided the correct LMS portal URL")
	public void admin_has_provided_the_correct_lms_portal_url() {
        Assert.assertTrue(picoDepInj.homepage.verifyurl().contains("https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/"));


	}

	@When("Admin enters valid credentials and clicks login button")
	public void admin_enters_valid_credentials_and_clicks_login_button() {

       picoDepInj.dashboardpage.enterValidCred_ClickLoginButton1("sdetorganizers@gmail.com", "UIHackathon@02");
		
	}
		

    @Then("Admin should see {string} as the header")
	public void admin_should_see_as_the_header(String expectedHeaderText) {
		
		Assert.assertTrue(picoDepInj.dashboardpage.isHeaderDisplayed(), "Header text '" + expectedHeaderText + "' is displayed");
	}


	

	@Then("Admin should experience a maximum navigation time of {int} seconds")
	public void admin_should_experience_a_maximum_navigation_time_of_seconds(Integer maxNavigationTimeInSeconds) {
		 long maxNavigationTimeInMillis = maxNavigationTimeInSeconds * 1000; // Convert seconds to milliseconds

	        picoDepInj.dashboardpage.startNavigationTimer();
            long navigationTime = picoDepInj.dashboardpage.getNavigationTimeInMillis();
	        Assert.assertTrue(navigationTime <= maxNavigationTimeInMillis,
	                "Navigation time should be within " + maxNavigationTimeInSeconds + " seconds");
	    }

	

	@Then("If HTTP response code is >= {int}, the link is broken")
	public void if_http_response_code_is_the_link_is_broken(Integer responseCode) {
		 boolean isBroken = responseCode >= 400;
		    Assert.assertTrue(isBroken, "The link is broken");

	}

	@Then("Admin should see {string} as the title")
	public void admin_should_see_as_the_title(String expectedTitle) {
	
	   
		picoDepInj.dashboardpage.verifyDashboardTitle(expectedTitle);
    }
		
	    
	
	@Then("LMS title should be aligned to the top left corner of the page")
	public void lms_title_should_be_aligned_to_the_top_left_corner_of_the_page() {
		
		picoDepInj.dashboardpage.isLMSTitleAlignedToTopLeft();
		
	    }

	@Then("Admin should see correct spelling in the navigation bar text")
	public void admin_should_see_correct_spelling_in_the_navigation_bar_text() throws InterruptedException {
		Assert.assertTrue(picoDepInj.dashboardpage.verifyNavigationBarText().contains( "LMS - Learning Management System"));
		//picoDepInj.dashboardpage.verifyNavigationBarText();

	}

	@Then("Admin should see correct spelling and space in the LMS title")
	public void admin_should_see_correct_spelling_and_space_in_the_lms_title() {

        
      // Assert.assertEquals(picoDepInj.dashboardpage.verifyNavigationBarText(), "LMS - Learning Management System");
      
		//picoDepInj.dashboardpage.verifyNavigationBarText();
		

		
    }
    
	

	@Then("Admin should see the navigation bar text aligned to the top right side")
	public void admin_should_see_the_navigation_bar_text_aligned_to_the_top_right_side() {
	
		//Assert.assertTrue(picoDepInj.dashboardpage.isNavigationBarAlignedToTopRight(), "Navigation bar is not aligned to the top right side");
		picoDepInj.dashboardpage.isNavigationBarAlignedToTopRight();

	}

	@Then("Admin should see {string} in the 1st place in the navigation bar")
	public void admin_should_see_in_the_1st_place_in_the_navigation_bar(String expectedText) {
		//String actualText = dashboardPage.getFirstNavigationBarItemText();
       // Assert.assertEquals(actualText, expectedText, "First navigation bar item text does not match");
		Assert.assertEquals(picoDepInj.dashboardpage.getFirstNavigationBarItemText(), "First navigation bar item text does not match");

		
    }
	    
    @Then("Admin should see {string} in the 2nd place in the navigation bar")
	public void admin_should_see_in_the_2nd_place_in_the_navigation_bar(String expectedText) {
    	String actualText = dashboardPage.getSecondNavigationBarItemText();
        Assert.assertEquals(actualText, expectedText, "First navigation bar item text does not match");
    }

	

	@Then("Admin should see {string} in the 3rd place in the navigation bar")
	public void admin_should_see_in_the_3rd_place_in_the_navigation_bar(String expectedText) {
		String actualText = dashboardPage.getThirdNavigationBarItemText();
        Assert.assertEquals(actualText, expectedText, "First navigation bar item text does not match");
    }

	

	@Then("Admin should see {string} in the 4th place in the navigation bar")
	public void admin_should_see_in_the_4th_place_in_the_navigation_bar(String expectedText) {
		String actualText = dashboardPage.getFourthNavigationBarItemText();
        Assert.assertEquals(actualText, expectedText, "First navigation bar item text does not match");
    
	}


}
