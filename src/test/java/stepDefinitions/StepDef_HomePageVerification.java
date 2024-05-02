 package stepDefinitions;


import org.testng.Assert;
import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.POM_HomePage;
import utilities.PicoDependencyInjector;

public class StepDef_HomePageVerification {
	
	
	 PicoDependencyInjector picoDepInj;

	public StepDef_HomePageVerification(PicoDependencyInjector picoDepInj) {

		this.picoDepInj = picoDepInj;
		
		picoDepInj.homepage= new POM_HomePage(DriverFactory.getDriver());
	}
	
	@Given("Admin launch the browser")
	public void admin_launch_the_browser() {
		//picoDepInj = new PicoDependencyInjector();
      
      }

	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {
		picoDepInj.homepage.verifyurl();
		Assert.assertTrue(picoDepInj.homepage.verifyurl().contains("https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/"));

	}

	@Then("Admin should land on the home page")
	public void admin_should_land_on_the_home_page() {
		picoDepInj.homepage.verifyurl();
		Assert.assertTrue(picoDepInj.homepage.verifyurl().contains("/login"));

	}
	
	@Given("user opens browser")
	public void user_opens_browser() {
	picoDepInj.homepage= new POM_HomePage(DriverFactory.getDriver());
	}
	
	@When("admin enters invalid app url")
	public void admin_enters_invalid_app_url() {
	System.out.println("user entering invalid url");
	picoDepInj.homepage.verifyInvalidAppURL();
	}

	@Then("LMS app throws {int} error")
	public void lms_app_should_throws_error(Integer errorCode) {

	}
	

	@Then("HTTP response >= {int}. then the link is broken")
	public void http_response_then_the_link_is_broken(Integer responseCode) {
		 boolean isBroken = responseCode >= 400;
		    Assert.assertTrue(isBroken, "The link is broken");

	}

    @Then("Admin should see correct spellings in all fields")
	public void admin_should_see_correct_spellings_in_all_fields() {
    	
    	 picoDepInj.homepage.verifyTextSpelling1();
   	 
    }

	@Then("Admin Should see logo on the left side")
	public void admin_should_see_logo_on_the_left_side() {
	 picoDepInj.homepage.LogoVisibilityCheck();
	// Assert.assertEquals(picoDepInj.homepage.LogoVisibilityCheck();


	}

	@Then("Admin Should see LMS-Learning Management System")
	public void admin_should_see_lms_learning_management_system() {
	  picoDepInj.homepage.applicationname();
	 

	}

	@Then("Admin Should see company name below the app name")
	public void admin_should_see_company_name_below_the_app_name() {
		picoDepInj.homepage.isCompanyNamePresentNearLogo();
	}

	

	@Then("Admin should see {string}")
	public void admin_should_see(String string) {
		picoDepInj.homepage.verifyHeader_text();
	}

	@Then("Admin should see two text field")
	public void admin_should_see_two_text_field() {
		picoDepInj.homepage.FieldPresenceVerification();


	}

	@Then("Admin should {string} in the first text field")
	public void admin_should_in_the_first_text_field(String string) {
		picoDepInj.homepage.checkTextFieldText();


	}

	@Then("Admin should see * symbol next to user text")
	public void admin_should_see_symbol_next_to_user_text() {
		picoDepInj.homepage.AsteriskVerification1();

	}

	@Then("Admin should {string} in the second text field")
	public void admin_should_in_the_second_text_field(String string) {
		picoDepInj.homepage.checkTextFieldText1();

	}

	@Then("Admin should see * symbol next to password text")
	public void admin_should_see_symbol_next_to_password_text() {
		picoDepInj.homepage.AsteriskVerification2();

	}

	@Then("Admin should see input field on the center of the page")
	public void admin_should_see_input_field_on_the_center_of_the_page() {

		picoDepInj.homepage.InputFieldAlignmentVerification();
	}

	@Then("Admin should see login button")
	public void admin_should_see_login_button() {
		picoDepInj.homepage.verify_login_Btn();

	}

	@Then("Admin should see login button on the centre of the page")
	public void admin_should_see_login_button_on_the_centre_of_the_page() {

		picoDepInj.homepage.lgCenterAlign();
	}

	@Then("Admin should see user in gray color")
	public void admin_should_see_user_in_gray_color() {
		picoDepInj.homepage.verifyUserFieldColor();

	}

	@Then("Admin should see password in gray color")
	public void admin_should_see_password_in_gray_color() {
		picoDepInj.homepage.descriptivetest2();

	}
	
	

}
