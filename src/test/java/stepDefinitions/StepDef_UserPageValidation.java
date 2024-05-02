
	package stepDefinitions;

	import org.testng.Assert;

	import driverFactory.DriverFactory;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;
	import pageObjects.POM_UserPageValidation;
	import utilities.PicoDependencyInjector;

	public class StepDef_UserPageValidation {
		
		PicoDependencyInjector picoDepInj;

		public StepDef_UserPageValidation(PicoDependencyInjector picoDepInj) {

			this.picoDepInj = picoDepInj;

		}
		
		@Given("Admin is on dashboard page after Login")
		public void admin_is_on_dashboard_page_after_login() {
			picoDepInj.userPageValidation = new POM_UserPageValidation(DriverFactory.getDriver());
			Assert.assertEquals(picoDepInj.userPageValidation.getDashboardPageTitle(), "LMS");
		    
		}
		
		@When("Admin clicks User from navigation bar")
		public void admin_clicks_user_from_navigation_bar() {
			picoDepInj.userPageValidation.clickOnUserBtn();
		}
		
		@Then("Admin should see a heading with text Manage User on the page")
		public void admin_should_see_a_heading_with_text_manage_user_on_the_page() {
			picoDepInj.userPageValidation.verifyManageUserText();
		   
		}
		

	}



