package stepDefinitions;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.PicoDependencyInjector;
import pageObjects.POM_AssignStaff;

public class StepDef_AssignStaff {
	
	PicoDependencyInjector picoDepInj;

	public StepDef_AssignStaff(PicoDependencyInjector picoDepInj) {

		this.picoDepInj = picoDepInj;

	}
	
	@When("Admin clicks Assign Staff button")
	public void admin_clicks_assign_staff_button() {
		picoDepInj.assignStaff = new POM_AssignStaff(DriverFactory.getDriver());
		picoDepInj.assignStaff.clickOnAssignStaffBtn();
	    
	}

	@Then("Admin should see a pop up open for assign staff details with empty form along with Save and Cancel button and close \\(X) icon on the top right corner of the window")
	public void admin_should_see_a_pop_up_open_for_assign_staff_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() throws InterruptedException {
	   // picoDepInj.assignStaff.checkEmptyEmail();
	    //picoDepInj.assignStaff.checkEmptySkillName();
	    //picoDepInj.assignStaff.checkEmptyProgramName();
	    //picoDepInj.assignStaff.checkEmptyBatchName();
		//picoDepInj.assignStaff.popupVerification();
		picoDepInj.assignStaff.formVerification();
		picoDepInj.assignStaff.isCancelBtndisplayed();
		assertTrue(picoDepInj.assignStaff.isCancelBtndisplayed(), "Cancel button is not present");
		picoDepInj.assignStaff.isCloseBtndisplayed();
		assertTrue(picoDepInj.assignStaff.isCloseBtndisplayed(), "Close button is not present");
		picoDepInj.assignStaff.isSaveBtndisplayed();
		assertTrue(picoDepInj.assignStaff.isSaveBtndisplayed(), "Save button is not present");
	}
	
	@Then("Admin should see User Role as R02,and other fields Student Email id,Skill,Program Name,Batch Name and Status with respective input boxes.")
	public void admin_should_see_user_role_as_r02_and_other_fields_student_email_id_skill_program_name_batch_name_and_status_with_respective_input_boxes() {
	    picoDepInj.assignStaff.userRoleField();
	    picoDepInj.assignStaff.checkEmailField();
	    assertTrue(picoDepInj.assignStaff.checkEmailField(), "Email field is not present");
	    picoDepInj.assignStaff.checkSkillField();
	    assertTrue(picoDepInj.assignStaff.checkSkillField(), "Skill field is not present");
	    picoDepInj.assignStaff.checkProgramField();
	    assertTrue(picoDepInj.assignStaff.checkProgramField(), "Program field is not present");
	    picoDepInj.assignStaff.checkBatchField();
	    assertTrue(picoDepInj.assignStaff.checkProgramField(), "Program field is not present");
	}
	
	@Then("Admin should see drop down boxes with valid datas for Student Email id,Program Name and Batch Name")
	public void admin_should_see_drop_down_boxes_with_valid_datas_for_student_email_id_program_name_and_batch_name() {
	    picoDepInj.assignStaff.dropDownVerification();
	}
	
	@Then("Admin should see two radio button for Status")
	public void admin_should_see_two_radio_button_for_status() {
	    picoDepInj.assignStaff.verifyActiveRadioButtonStatus();
	    assertTrue(picoDepInj.assignStaff.verifyActiveRadioButtonStatus(), "Active Radio Button is not present");
	    picoDepInj.assignStaff.verifyInactiveRadioButtonStatus();
	    assertTrue(picoDepInj.assignStaff.verifyInactiveRadioButtonStatus(), "Inactive Radio Button is not present");
	}
	
	@When("Admin clicks Save button without entering any data")
	public void admin_clicks_save_button_without_entering_any_data() {
	    picoDepInj.assignStaff.clickSaveBtn();
	}

	@Then("Admin gets a Error message alert")
	public void admin_gets_a_error_message_alert() {
		picoDepInj.assignStaff.emptyFormErrorMessage();
	    
	}
	
	@When("Admin clicks Save button without entering Student Email id")
	public void admin_clicks_save_button_without_entering_student_email_id() throws InterruptedException {
	    picoDepInj.assignStaff.formWithoutEmailIdErrorId();
	}

	@Then("Admin gets a Error message alert as Student Email id is required")
	public void admin_gets_a_error_message_alert_as_student_email_id_is_required() {
		picoDepInj.assignStaff.errorMsgWithoutEmailId();
		
	}
	
	@When("Admin enters all the required fields with valid values and click Save button")
	public void admin_enters_all_the_required_fields_with_valid_values_and_click_save_button() throws InterruptedException {
		picoDepInj.assignStaff.successfullAssignStaff();
	    
	}

	@Then("Admin gets a message {string} alert")
	public void admin_gets_a_message_alert(String string) {
	    picoDepInj.assignStaff.verifySuccessfulMsg();
	    Assert.assertEquals(picoDepInj.assignStaff.verifySuccessfulMsg(),"Successfully Staff Assigned");
	}
	
	/*@When("Admin clicks Cancel\\/Close\\(X) Icon on Assign Staff  form")
	public void admin_clicks_cancel_close_x_icon_on_assign_staff_form() {
	    picoDepInj.assignStaff.clickOnCloseIcon();
	}*/
	
	@When("Admin clicks Close Icon on Assign Staff  form")
	public void admin_clicks_close_icon_on_assign_staff_form() {
		 picoDepInj.assignStaff.clickOnCloseIcon();
	}


	@Then("Assign Staff popup window should be closed without saving")
	public void assign_staff_popup_window_should_be_closed_without_saving() {
		Assert.assertEquals(picoDepInj.assignStaff.getManageUserText(),"Manage User");
		
	}






}
