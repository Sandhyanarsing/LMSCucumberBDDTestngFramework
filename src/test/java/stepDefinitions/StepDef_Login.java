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

}
