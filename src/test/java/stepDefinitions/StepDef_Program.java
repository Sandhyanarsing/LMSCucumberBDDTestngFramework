package stepDefinitions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.POM_LoginPage;
import pageObjects.POM_ProgramPage;
import utilities.PicoDependencyInjector;

public class StepDef_Program {

	PicoDependencyInjector picoDepInj;

	public StepDef_Program(PicoDependencyInjector picoDepInj) {

		this.picoDepInj = picoDepInj;

	}
	
	@When("user enters valid admin username as {string} and valid password as {string}")
	public void user_enters_valid_admin_username_as_sdetorganizers_gmail_com_and_valid_password_as(String username ,String password) {
		picoDepInj.loginPage= new POM_LoginPage(DriverFactory.getDriver());
		picoDepInj.loginPage.enterValidCredentials(username, password);
	}

	@When("admin user click on login button")
	public void admin_user_click_on_login_button() {
		picoDepInj.loginPage.clickOnLoginBtn();
	}

	@Then("user should be login as admin and redirected to admin LMS dashboard page")
	public void user_should_be_login_as_admin_and_redirected_to_admin_lms_dashboard_page() {
		picoDepInj.programPage = new POM_ProgramPage(DriverFactory.getDriver());
		picoDepInj.programPage.verifyDashbordPageTitle();
		
	}

	@Given("admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
		picoDepInj.programPage.verifyDashbordPageTitle();
	}

	@When("admin clicks Program on the navigation bar")
	public void admin_clicks_program_on_the_navigation_bar() {
		picoDepInj.programPage.clickOnNavigationProgramBtn();
	}

	@Then("admin should see URL with Manage Program")
	public void admin_should_see_url_with_manage_program() {
	    
	}

	@Then("admin should see a heading with text Manage Program on program page")
	public void admin_should_see_a_heading_with_text_manage_program_on_program_page(){
		picoDepInj.programPage.verifyProgramPageHeader();
	}

	@When("admin validating the default state of Delete button")
	public void admin_validating_the_default_state_of_delete_button() {
		picoDepInj.programPage.verifyDeleteBtnStatus();
	}

	@Then("admin should see a Delete button on the top left hand side as Disabled")
	public void admin_should_see_a_delete_button_on_the_top_left_hand_side_as_disabled() {
		picoDepInj.programPage.verifyDeleteBtnStatus();
	}

	@When("admin user Validates Add New Program button")
	public void admin_user_validates_add_new_program_button() {
		picoDepInj.programPage.verifyNewProgramBtn();
	}

	@Then("admin should see a +A New Program button as enabled on the program page above the data table")
	public void admin_should_see_a_a_new_program_button_as_enabled_on_the_program_page_above_the_data_table() {
		picoDepInj.programPage.verifyNewProgramBtn();
	}

	@When("admin verifyes Search bar on the Program page above data table")
	public void admin_verifyes_search_bar_on_the_program_page_above_data_table() {
		picoDepInj.programPage.verifySearchBox();
	}

	@Then("admin should see Search bar with text as Search...")
	public void admin_should_see_search_bar_with_text_as_search() {
		picoDepInj.programPage.verifySearchBox();
	}

	@Given("admin is on program page after Login")
	public void admin_is_on_program_page_after_login() {
		picoDepInj.programPage.verifyProgramPageHeader();
	}

	@When("verify data table on the Program page")
	public void verify_data_table_on_the_program_page() {
		picoDepInj.programPage.verifyDataTablePresent();
	}

	@Then("admin should see data table on Manage Program Page with following column headers as Program Name, Program Description, Program Status, Edit,Delete")
	public void admin_should_see_data_table_on_manage_program_page_with_following_column_headers_as_program_name_program_description_program_status_edit_delete() {
		picoDepInj.programPage.verifyDataTableColumnsName();
	}

	@When("validate that number of records or rows of data displayed  in the table")
	public void validate_that_number_of_records_rows_of_data_in_the_table_displayed() {
		
		boolean rowSize = picoDepInj.programPage.verifyDataTableRowsPresent();
		Assert.assertEquals(rowSize, true);
	}

	@Then("admin should see total number of records on default page as {int} in the table")
	public void admin_should_see_total_number_of_records_on_default_page_as_in_the_table(Integer noOfRowInDatatable) {
	
		Assert.assertEquals(picoDepInj.programPage.verifyNoOfRowInDataTable(), noOfRowInDatatable);
	}

	@When("verify check box for rows on the data table")
	public void verify_check_box_for_rows_on_the_data_table() {
		Assert.assertEquals(picoDepInj.programPage.verifyDataTableCheckBoxes(), true);
	}

	@Then("admin should see check box on the left side in all rows of the data table")
	public void admin_should_see_check_box_on_the_left_side_in_all_rows_of_the_data_table() {
		Assert.assertEquals(picoDepInj.programPage.verifyCheckboxesCountInDataTable(), 5);
	}

	@When("verify Edit and Delete buttons for data table")
	public void verify_edit_and_delete_buttons_for_data_table() {
		Assert.assertTrue(picoDepInj.programPage.verifyRowEditBtnsPresenst());
		Assert.assertTrue(picoDepInj.programPage.verifyRowDeleteBtnsPresenst());
	}

	@Then("admin should see the Edit and Delete buttons on each row of the data table")
	public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table() {
		
		Assert.assertTrue(picoDepInj.programPage.verifyEditBtnsOnEachRow());
		Assert.assertTrue(picoDepInj.programPage.verifyDeleteBtnsOnEachRow());
		
	}
	
	@When("admin clicks on A New Program button")
	public void admin_clicks_on_a_new_program_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("a popup with title as Program details should get opened along with empty name and description input boxes")
	public void a_popup_with_title_as_program_details_should_get_opened_along_with_empty_name_and_description_input_boxes() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("admin verifies program details pop up UI")
	public void admin_verifies_program_details_pop_up_ui() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("program details pop up should contains Close\\(X) Icon ,SAVE, CANCEL button and Active,Inactive Status radio buttons")
	public void program_details_pop_up_should_contains_close_x_icon_save_cancel_button_and_active_inactive_status_radio_buttons() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@When("validate the text and pagination icon below the data table of program page")
	public void validate_the_text_and_pagination_icon_below_the_data_table_of_program_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("admin should see the text as Showing x to y of z entries along with pagination icon below the table")
	public void admin_should_see_the_text_as_showing_x_to_y_of_z_entries_along_with_pagination_icon_below_the_table() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("x as starting record number on that page")
	public void x_as_starting_record_number_on_that_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("y as ending record number on that page")
	public void y_as_ending_record_number_on_that_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("z as Total number of records")
	public void z_as_total_number_of_records() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("verify Sort arrow icon on the program page data table")
	public void verify_sort_arrow_icon_on_the_program_page_data_table() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("admin should see the sort arrow icon beside each column header except Edit and Delete")
	public void admin_should_see_the_sort_arrow_icon_beside_each_column_header_except_edit_and_delete() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("admin validates the footer")
	public void admin_validates_the_footer() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("admin should see the footer as In total there are z programs")
	public void admin_should_see_the_footer_as_in_total_there_are_z_programs() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
