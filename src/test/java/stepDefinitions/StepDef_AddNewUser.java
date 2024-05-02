package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.POM_AddNewUser;
import pageObjects.POM_UserPageValidation;
import utilities.PicoDependencyInjector;

public class StepDef_AddNewUser {
	
	PicoDependencyInjector picoDepInj;

	public StepDef_AddNewUser(PicoDependencyInjector picoDepInj) {

		this.picoDepInj = picoDepInj;

	}
	
	@Given("Admin is on Manage User Page window")
	public void admin_is_on_manage_user_page() {
		picoDepInj.addnewUser = new POM_AddNewUser(DriverFactory.getDriver());
		Assert.assertEquals(picoDepInj.addnewUser.getManageUserpageTitle(), "Manage User");
		
}

	@When("Admin clicks {string} button")
	public void admin_clicks_button(String string) {
		picoDepInj.addnewUser.clickOnAddnewuserBtn();
	}
	
	@Then("Admin should see pop up open for user details with First name, Middle name, Last name, Location, Phone no, email, Linkedn Url, User Role, User Role status, User Visa Status, Under Graduate, Post Graduate, Time Zone, User Comments along with Cancel, Submit and close buttons")
	public void admin_should_see_pop_up_open_for_user_details_with_first_name_middle_name_last_name_location_phone_no_email_linkedn_url_user_role_user_role_status_user_visa_status_under_graduate_post_graduate_time_zone_user_comments_along_with_cancel_submit_and_close_buttons() {
		
		assert picoDepInj.addnewUser.isFirstNameFieldPresent() : "First Name field is not present";
        assert picoDepInj.addnewUser.isMiddleNameFieldPresent() : "Middle Name field is not present";
        assert picoDepInj.addnewUser.isLastNameFieldPresent() : "Last Name field is not present";
        assert picoDepInj.addnewUser.isLocationFieldPresent() : "Location field is not present";
        assert picoDepInj.addnewUser.isPhonenoFieldPresent() : "Phone no field is not present";
        assert picoDepInj.addnewUser.isEmailaddressFieldPresent() : "Email address field is not present";
        assert picoDepInj.addnewUser.isLinkedInFieldPresent() : "Linked In field is not present";
        assert picoDepInj.addnewUser.isUserRoleDropdownPresent() : "User Role dropdown is not present";
        assert picoDepInj.addnewUser.isUserRoleStatusDropdownPresent() : "User Role status dropdown is not present";
        assert picoDepInj.addnewUser.isUserVisaStatusDropdownPresent() : "User Visa Status dropdown is not present";
        assert picoDepInj.addnewUser.isUndergraduateFieldPresent() : "Undergraduate field is not present";
        assert picoDepInj.addnewUser.isPostgraduateFieldPresent() : "Postgraduate field is not present";
        assert picoDepInj.addnewUser.isTimezoneFieldPresent() : "Timezone field is not present";
        assert picoDepInj.addnewUser.isUsercommentsFieldPresent() : "Usercomments field is not present";
	}

	@Then("Admin should see  text boxes for the fields First name, Middle name, Last Name, Location, phone, email, linkedin url, Undergraduate, postgraduate,time zone ,user comments")
	public void admin_should_see_text_boxes_for_the_fields_first_name_middle_name_last_name_location_phone_email_linkedin_url_undergraduate_postgraduate_time_zone_user_comments() {
	    
		assert picoDepInj.addnewUser.isFirstNameFieldpresent() ;
        //Assert.assertEquals(picoDepInj.addnewUser.isFirstNameFieldpresent(), true);
		assert picoDepInj.addnewUser.isMiddleNameFieldpresent() : "Middle Name field is not present";
        assert picoDepInj.addnewUser.isLastNameFieldpresent() : "Last Name field is not present";
        assert picoDepInj.addnewUser.isLocationFieldpresent() : "Location field is not present";
        assert picoDepInj.addnewUser.isPhonenoFieldpresent() : "Phone no field is not present";
        assert picoDepInj.addnewUser.isEmailidFieldpresent() : "Email address field is not present";
        assert picoDepInj.addnewUser.isLinkedinFieldpresent() : "Linked In field is not present";
        assert picoDepInj.addnewUser.isUndergraduateFieldpresent() : "Undergraduate field is not present";
        assert picoDepInj.addnewUser.isPostgraduateFieldpresent() : "Postgraduate field is not present";
        assert picoDepInj.addnewUser.isTimezoneFieldpresent() : "Timezone field is not present";
        assert picoDepInj.addnewUser.isUsercommentsFieldpresent() : "Usercomments field is not present";
		
	}

	@Then("Admin should see drop downs for the fields User Role, Role status, visa status on user details pop up")
	public void admin_should_see_drop_downs_for_the_fields_user_role_role_status_visa_status_on_user_details_pop_up() {
		 picoDepInj.addnewUser.getUserRoleDropdownOptions();
		 picoDepInj.addnewUser.getUserRoleStatusDropdownOptions();
		 picoDepInj.addnewUser.getUserVisaStatusDropdownOptions();
	}

	@Given("Admin is on  User details pop up window")
	public void admin_is_on_user_details_pop_up() {
		picoDepInj.addnewUser = new POM_AddNewUser(DriverFactory.getDriver());
		Assert.assertEquals(picoDepInj.addnewUser.getManageUserpageTitle(), "Manage User");
		picoDepInj.addnewUser.clickOnAddnewuserBtn();
		Assert.assertEquals(picoDepInj.addnewUser.getUserPagepopup(), "User Details");
	}
	
	@When("Admin enters mandatory fields {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}{string},{string},{string},{string}")
	public void admin_enters_mandatory_fields(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12, String string13, String string14) {
		picoDepInj.addnewUser.entermandatoryfields(string,string2,string3,string4,string5,string6,string7,string8,string9,string10,string11,string12,string13,string14);
	}

	@When("clicks on Submit button")
	public void clicks_on_submit_button() throws InterruptedException {
		picoDepInj.addnewUser.clickOnSubmitBtn();
	}

	@Then("Admin gets message {string}")
	public void admin_gets_message(String string) {
		assert picoDepInj.addnewUser.gettextAlert();
	}

	@Then("The newly added user should be present in the data table in Manage User page")
	public void the_newly_added_user_should_be_present_in_the_data_table_in_manage_user_page() throws InterruptedException {
		picoDepInj.addnewUser.clickOnSearchBtn();
		Assert.assertEquals(picoDepInj.addnewUser.getCreatedUserName(), "Swath Nin");
	}  
	
	
@When("Admin enters invalid data in all of the  fields in the form {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}{string},{string},{string},{string} and clicks on submit button")
public void admin_enters_invalid_data_in_all_of_the_fields_in_the_form_and_clicks_on_submit_button(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12, String string13, String string14) throws InterruptedException {
    	picoDepInj.addnewUser.enterInvaliddata(string,string2,string3,string4,string5,string6,string7,string8,string9,string10,string11,string12,string13,string14);
    	picoDepInj.addnewUser.clickOnSubmitBtn();
	}

	@Then("Admin gets error message and user is not created")
	public void admin_gets_error_message_and_user_is_not_created() {
		assert picoDepInj.addnewUser.verifyUserFailAlert();
	}

	@When("Admin clicks on submit button without entering data")
	public void admin_clicks_on_submit_button_without_entering_data() throws InterruptedException {
		picoDepInj.addnewUser.clickOnSubmitBtn();
	}

	@Then("user wont be created and Admin gets error message")
	public void user_wont_be_created_and_admin_gets_error_message() {
		assert picoDepInj.addnewUser.isFirstNameFieldpresent() ;
        //Assert.assertEquals(picoDepInj.addnewUser.isFirstNameFieldpresent(), true);
		assert picoDepInj.addnewUser.isMiddleNamefieldpresent();
        assert picoDepInj.addnewUser.isLastNamefieldpresent() ;
        assert picoDepInj.addnewUser.isLocationfieldpresent() ;
        assert picoDepInj.addnewUser.isPhonenofieldpresent() ;
        assert picoDepInj.addnewUser.isEmailidfieldpresent() ;
        assert picoDepInj.addnewUser.isLinkedinfieldpresent() ;
        assert picoDepInj.addnewUser.isUndergraduatefieldpresent() ;
        assert picoDepInj.addnewUser.isPostgraduatefieldpresent() ;
        assert picoDepInj.addnewUser.isTimezonefieldpresent() ;
        assert picoDepInj.addnewUser.isUsercommentsfieldpresent() ;
		
	}

	@When("Admin clicks Cancel button")
	public void admin_clicks_cancel_button() {
		picoDepInj.addnewUser.clickOnCancelBtn();
	}

	@Then("User Details popup window should be closed without saving")
	public void user_details_popup_window_should_be_closed_without_saving() {
		Assert.assertEquals(picoDepInj.addnewUser.getManageUserpageTitle(), "Manage User");
	}

	@Then("Admin can see the User details popup disappears without adding any user")
	public void admin_can_see_the_user_details_popup_disappears_without_adding_any_user() {
		Assert.assertEquals(picoDepInj.addnewUser.getManageUserpageTitle(), "Manage User");
		// assert picoDepInj.addnewUser.getTotalUserIdCount();
		 
	}

//Edit User
	
	@When("Admin clicks on the edit icon")
	public void admin_clicks_on_the_edit_icon() {
		picoDepInj.addnewUser.clickOnEditBtn();
	}

	@Then("A new pop up with User details appears")
	public void a_new_pop_up_with_user_details_appears() {
		Assert.assertEquals(picoDepInj.addnewUser.getUserPagepopup(), "User Details");   
	}

	@When("Update the fields with valid data and click submit")
	public void update_the_fields_with_valid_data_and_click_submit() throws InterruptedException {
		picoDepInj.addnewUser.clickOnSearchBtn();
		picoDepInj.addnewUser.clickOnEdit1Btn();
		picoDepInj.addnewUser.clickOnEditFirstname();
		picoDepInj.addnewUser.clickOnSubmitBtn();
		} 

	@Then("Admin gets message {string} and see the updated values in data table")
	public void admin_gets_message_and_see_the_updated_values_in_data_table(String string) {
		assert picoDepInj.addnewUser.UserUpdateSuccessfullAlert();
	}

	@When("Update the fields with invalid values and click submit")
	public void update_the_fields_with_invalid_values_and_click_submit() throws InterruptedException {
		picoDepInj.addnewUser.clickOnEditBtn();
		picoDepInj.addnewUser.UpdateInavalidvalues();
		picoDepInj.addnewUser.clickOnSubmitBtn();
	}

	@Then("Admin should get Error message")
	public void admin_should_get_error_message() {
		//Assert.assertEquals(picoDepInj.addnewUser.getErrorMessage(), "Email address is required");
		assert picoDepInj.addnewUser.isEmailidfieldpresent();
	}

	@When("Admin enters only numbers or special char in the text fields")
	public void admin_enters_only_numbers_or_special_char_in_the_text_fields() {
		picoDepInj.addnewUser.clickOnEditBtn();
		picoDepInj.addnewUser.UpdateSpecialvalues();
		
	    	}

	@Then("Admin should get Failed message")
	public void admin_should_get_failed_message() {
		assert picoDepInj.addnewUser.verifyEditFailAlert();
	}
	
//DeleteUser
	
	@When("Admin clicks on the delete icon")
	public void admin_clicks_on_the_delete_icon() throws InterruptedException {
		picoDepInj.addnewUser.clickOnDeleteBtn();
		
	}

	@Then("Admin should see a alert open with heading {string} along with  <YES> and <NO> button for deletion")
	public void admin_should_see_a_alert_open_with_heading_along_with_yes_and_no_button_for_deletion(String string) {
		assert picoDepInj.addnewUser.isConfirmfieldpresentornot();
		assert picoDepInj.addnewUser.isYesfieldpresentornot();
		assert picoDepInj.addnewUser.isNofieldpresentornot();
	}
	
	@When("Admin clicks No option")
	public void admin_clicks_no_option() {
		picoDepInj.addnewUser.clicknoBtn();
	}
	
	@Then("Admin can see the deletion alert disappears without deleting")
	public void admin_can_see_the_deletion_alert_disappears_without_deleting() {
		Assert.assertEquals(picoDepInj.addnewUser.getManageUserpageTitle(), "Manage User");
		//Assert.assertEquals(picoDepInj.addnewUser.getCreatedUserName(), "Swa");
		
	}
	
	@When("Admin clicks yes option")
	public void admin_clicks_yes_option() throws InterruptedException {
		//picoDepInj.addnewUser.clickOnSearchBtn();
		picoDepInj.addnewUser.clickOnDeleteBtn();
		picoDepInj.addnewUser.clickyesBtn();
	}
	

	@Then("Admin gets a message {string} alert and do not see that user in the data table")
	public void admin_gets_a_message_alert_and_do_not_see_that_user_in_the_data_table(String string) {
		assert picoDepInj.addnewUser.UserDeleteSuccessfullAlert();
	}

	@When("Admin clicks on close button")
	public void admin_clicks_on_close_button() {
		picoDepInj.addnewUser.clickOnDeleteBtn();
		picoDepInj.addnewUser.clickOnCloseBtn();
	}
	
	//Delete MultipleUser
	
	@When("Admin clicks any checkbox in the data table")
	public void admin_clicks_any_checkbox_in_the_data_table() {
		picoDepInj.addnewUser.clickCheckbox();
	}

	@Then("Admin should see common delete option enabled under header Manage Program")
	public void admin_should_see_common_delete_option_enabled_under_header_manage_program() {
		assert picoDepInj.addnewUser.isDeletesymbolEnabledornot(): "Delete Symbol is not Enabled";
	}

	@Then("Admin clicks the Delete button")
	public void admin_clicks_the_delete_button() {
		picoDepInj.addnewUser.clickOnDeleteIconBtn();
	}
	
	@Given("Admin is on Confirm Deletion alert")
	public void admin_is_on_confirm_deletion_alert() {
		picoDepInj.addnewUser = new POM_AddNewUser(DriverFactory.getDriver());
		assert picoDepInj.addnewUser.isConfirmfieldpresentornot();
	}

	@When("Admin clicks <NO> button on the alert")
	public void admin_clicks_no_button_on_the_alert() {
		picoDepInj.addnewUser.clicknoBtn();
	}

	@Then("Admin should land on Manage User page and can see the selected user is not deleted from the data table")
	public void admin_should_land_on_manage_user_page_and_can_see_the_selected_user_is_not_deleted_from_the_data_table() {
		Assert.assertEquals(picoDepInj.addnewUser.getManageUserpageTitle(), "Manage User");
		
	}

	@When("Admin clicks <YES> button on the alert")
	public void admin_clicks_yes_button_on_the_alert() {
		picoDepInj.addnewUser.clickyesBtn();
	}

	@Then("Admin should land on Manage User page and can see the selected user is deleted from the data table")
	public void admin_should_land_on_manage_user_page_and_can_see_the_selected_user_is_deleted_from_the_data_table() {
		Assert.assertEquals(picoDepInj.addnewUser.getManageUserpageTitle(), "Manage User");
	}
	@Given("Admin click mutiple checkboxes then admin is on Confirm Deletion alert")
	public void admin_click_mutiple_checkboxes_then_admin_is_on_confirm_deletion_alert() {
		picoDepInj.addnewUser = new POM_AddNewUser(DriverFactory.getDriver());
		picoDepInj.addnewUser.clickCheckbox();
		picoDepInj.addnewUser.clickCheckbox2();
		picoDepInj.addnewUser.clickOnDeleteIconBtn();
		assert picoDepInj.addnewUser.isConfirmfieldpresentornot();   
	}
	
	@Then("Admin should land on Manage User page and can see the selected users are not deleted from the data table")
	public void admin_should_land_on_manage_user_page_and_can_see_the_selected_users_are_not_deleted_from_the_data_table() {
		Assert.assertEquals(picoDepInj.addnewUser.getManageUserpageTitle(), "Manage User");
	}

	@Then("Admin should land on Manage User page and can see the selected users are deleted from the data table")
	public void admin_should_land_on_manage_user_page_and_can_see_the_selected_users_are_deleted_from_the_data_table() {
		Assert.assertEquals(picoDepInj.addnewUser.getManageUserpageTitle(), "Manage User");
	}
}
