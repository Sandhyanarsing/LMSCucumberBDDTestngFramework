package stepDefinitions;

import utilities.PicoDependencyInjector;
import org.testng.Assert;
import driverFactory.DriverFactory;
import pageObjects.POM_LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef_Login {
	
	
	PicoDependencyInjector picoDepInj;

	public StepDef_Login(PicoDependencyInjector picoDepInj) {

		this.picoDepInj = picoDepInj;

	}

	@Given("user is already on LMS app Login page")
	public void user_is_already_on_lms_app_login_page() {
		picoDepInj.loginPage= new POM_LoginPage(DriverFactory.getDriver());
		Assert.assertEquals(picoDepInj.loginPage.getLoginPageTitle(), "LMS");
		
	}

	@When("User enters valid {string} and valid {string}")
	public void user_enters_valid_and_valid(String username, String password) {
		picoDepInj.loginPage.enterValidCredentials(username, password);
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
		picoDepInj.loginPage.clickOnLoginBtn();
	}

	@Then("user should be redirected to LMS home page")
	public void user_should_be_redirected_to_lms_home_page() {
		Assert.assertEquals(picoDepInj.loginPage.getLoginPageTitle(), "LMS");
		
	}
	
	@Given("user is opening browser")
	public void user_is_opening_browser() {
		picoDepInj.loginPage= new POM_LoginPage(DriverFactory.getDriver());
	}
	@When("admin enters inValid app url")
	public void admin_enters_in_valid_app_url() {
		System.out.println("user entering invalid url");
		picoDepInj.loginPage.verifyInvalidAppURL();
	}

	@Then("LMS app should throw {int} error")
	public void lms_app_should_throw_error(Integer errorCode) {
	    
	}


}
