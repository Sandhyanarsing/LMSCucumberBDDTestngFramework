package stepDefinitions;

import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import pageObjects.POM_AssignStudent;
import pageObjects.POM_SortUser;
import utilities.PicoDependencyInjector;

	
	public class StepDef_SortUser {
		
		PicoDependencyInjector picoDepInj;

		public StepDef_SortUser(PicoDependencyInjector picoDepInj) {

			this.picoDepInj = picoDepInj;

		}

	@Given("Admin is on Manage User Page")
	public void admin_is_on_manage_user_page() {
		picoDepInj.sortUser= new POM_SortUser(DriverFactory.getDriver());
		Assert.assertEquals(picoDepInj.sortUser.getUserPageTitle(),"Manage User");

	    	}

	@When("Admin clicks on ID sort icon")
	public void admin_clicks_on_id_sort_icon() throws InterruptedException {
		picoDepInj.sortUser.clickIdSortIcon();
		Thread.sleep(4000);
		
	}

	@Then("Admin should see User details are sorted by id")
	public void admin_should_see_user_details_are_sorted_by_id() {
		Assert.assertEquals(picoDepInj.sortUser.UserDetailsSortedById(picoDepInj.sortUser.idSortIcon),true);
				
	}
	
	@When("Admin clicks on name sort icon")
	public void admin_clicks_on_name_sort_icon() throws InterruptedException {
		picoDepInj.sortUser.clickNameSortIcon();
		//picoDepInj.sortUser.clickNameSortIcon();
		Thread.sleep(4000);


	    
	}

	@Then("Admin should see User details are sorted by name")
	public void admin_should_see_user_details_are_sorted_by_name() throws InterruptedException {
		Assert.assertEquals(picoDepInj.sortUser.UserDetailsSortByName(picoDepInj.sortUser.NameSortIcon),true);
		Thread.sleep(4500);
	}

	@When("Admin clicks on Location sort icon")
	public void admin_clicks_on_location_sort_icon() throws InterruptedException {
		picoDepInj.sortUser.clickLocatioSortIcon();
		Thread.sleep(10000);

  
	}

	@Then("Admin should see User details are sorted by Location")
	public void admin_should_see_user_details_are_sorted_by_location() {
		Assert.assertEquals(picoDepInj.sortUser.UserDetailsSortByLocation(picoDepInj.sortUser.LocationSortIcon),true);

	}
	
	@When("Admin clicks on Phone number sort icon")
	public void admin_clicks_on_phone_number_sort_icon() throws InterruptedException {
		picoDepInj.sortUser.clickPhoneNumberSortIcon();
		
		Thread.sleep(10000);

	    
	}

	@Then("Admin should see User details are sorted by Phone number")
	public void admin_should_see_user_details_are_sorted_by_phone_number() {
		Assert.assertEquals(picoDepInj.sortUser.UserDetailsSortByPhoneNumber(picoDepInj.sortUser.PhoneNumberSortIcon),true);

	}


	
	
	
	
	
	
	
	
	
	

}
