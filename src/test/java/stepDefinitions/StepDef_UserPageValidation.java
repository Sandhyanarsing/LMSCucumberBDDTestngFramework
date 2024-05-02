package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

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
		//picoDepInj.userPageValidation.verifyManageUserText();
		Assert.assertEquals(picoDepInj.userPageValidation.verifyManageUserText(), "Manage User");
	   
	}

	@Then("Admin Should see the following column names")
	public void admin_should_see_the_following_column_names(io.cucumber.datatable.DataTable dataTable) {
	   List<String> expectedColumns = Arrays.asList("ID", "Name", "Location", "Phone Number", "Edit / Delete");
	   List<String> actualColumns = picoDepInj.userPageValidation.getActualColumnNames();
	   System.out.println(expectedColumns);
	   System.out.println(actualColumns);
	   for(String expectedColumn : expectedColumns) {
		   Assert.assertTrue(actualColumns.contains(expectedColumn));
	   }
	   
	}
	
	@Then("Admin should see a Delete button on the top left hand side as Disabled")
	public void admin_should_see_a_delete_button_on_the_top_left_hand_side_as_disabled() throws InterruptedException {
	    picoDepInj.userPageValidation.checkDeleteButtonStatus();
	    assertTrue(picoDepInj.userPageValidation.checkDeleteButtonStatus(), "Delete button is active");
	    
	}
	
	@Then("Admin should be able to see the + Add New User button above the data table")
	public void admin_should_be_able_to_see_the_add_new_user_button_above_the_data_table() {
	    picoDepInj.userPageValidation.isAddNewUserBtnPresent();
	    assertTrue(picoDepInj.userPageValidation.isAddNewUserBtnPresent(), "Add New User button is not present");
	    
	}
	
	@Then("Admin should be able to see the + Assign Student button above the data table")
	public void admin_should_be_able_to_see_the_assign_student_button_above_the_data_table() {
	    picoDepInj.userPageValidation.isAssignStudentBtnPresent();
	    assertTrue(picoDepInj.userPageValidation.isAssignStudentBtnPresent(), "Assign Student button is not present");
	}
	
	@Then("Admin should be able to see the + Assign Staff button above the data table")
	public void admin_should_be_able_to_see_the_assign_staff_button_above_the_data_table() {
	    picoDepInj.userPageValidation.isAssignStaffBtnPresent();
	    assertTrue(picoDepInj.userPageValidation.isAssignStaffBtnPresent(), "Assign Staff button is not present");
	}
	
	@Then("Admin should be able to see the search text box above the data table")
	public void admin_should_be_able_to_see_the_search_text_box_above_the_data_table() {
	    picoDepInj.userPageValidation.isSearchTextBoxPresent();
	    assertTrue(picoDepInj.userPageValidation.isSearchTextBoxPresent(), "Assign Staff button is not present");
	}
	
	@Then("Admin should see five records displayed on the data table")
	public void admin_should_see_five_records_displayed_on_the_data_table() throws InterruptedException {
	    picoDepInj.userPageValidation.verifyDataRecords();
	    
	    
	}
	
	@Then("Each row in the data table should have a checkbox")
	public void each_row_in_the_data_table_should_have_checkbox() {
	    picoDepInj.userPageValidation.verifyCheckbox();
	    assertTrue(picoDepInj.userPageValidation.verifyCheckbox(), "Checkboxes are not present in each row of the table");
	}
	
	@Then("Each row in the data table should have a edit icon that is enabled")
	public void each_row_in_the_data_table_should_have_a_edit_icon_that_is_enabled() {
	    picoDepInj.userPageValidation.verifyEditicon();
	    assertTrue(picoDepInj.userPageValidation.verifyEditicon(), "Edit icon not present in each row of the table");
	    
	}
	
	@Then("Each row in the data table should have a delete icon that is enabled")
	public void each_row_in_the_data_table_should_have_a_delete_icon_that_is_enabled() {
	    picoDepInj.userPageValidation.verifyDeleteIcon();
	    assertTrue(picoDepInj.userPageValidation.verifyDeleteIcon(), "Delete icon not present in each row of the table");
	}
	
	@When("Admin enters user name into search box")
	public void admin_enters_user_name_into_search_box() {
	    picoDepInj.userPageValidation.enterValidUserName();
	}

	@Then("Admin should see user displayed with the entered name")
	public void admin_should_see_user_displayed_with_the_entered_name() {
	    picoDepInj.userPageValidation.searchuserName();
	    Assert.assertEquals(picoDepInj.userPageValidation.searchuserName(), "Nike");
	    
	}
	
	@When("Admin enters the keywords not present in the data table on the Search box")
	public void admin_enters_the_keywords_not_present_in_the_data_table_on_the_search_box() {
	    picoDepInj.userPageValidation.enterInvalidUserName();
	}

	@Then("Admin should see zero entries on the data table")
	public void admin_should_see_zero_entries_on_the_data_table() {
		picoDepInj.userPageValidation.searchInvalidName();
		Assert.assertEquals(picoDepInj.userPageValidation.searchInvalidName(),"Showing 0 to 0 of 0 entries");
	    
	}
	
	@Then("Admin should see the text as Showing x to y of z entries along with Pagination icon below the table.")
	public void admin_should_see_the_text_as_showing_x_to_y_of_z_entries_along_with_pagination_icon_below_the_table() {
	    picoDepInj.userPageValidation.verifyPaginationText();
	    picoDepInj.userPageValidation.verifyNextIcon();
	    assertTrue(picoDepInj.userPageValidation.verifyNextIcon(), "Next icon not present");
	    picoDepInj.userPageValidation.verifyLastIcon();
	    assertTrue(picoDepInj.userPageValidation.verifyLastIcon(), "Last icon not present");
	}









	

}
