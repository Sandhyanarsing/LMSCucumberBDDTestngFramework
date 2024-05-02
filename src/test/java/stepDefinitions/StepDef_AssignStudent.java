package stepDefinitions;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.POM_AssignStudent;
import pageObjects.POM_LoginPage;
import utilities.PicoDependencyInjector;

public class StepDef_AssignStudent {
	
	PicoDependencyInjector picoDepInj;

	public StepDef_AssignStudent(PicoDependencyInjector picoDepInj) {

		this.picoDepInj = picoDepInj;

	}
	
	
	@Given("Admin is in manage user page")
	public void admin_is_in_manage_user_page() {
		picoDepInj.assignStudent= new POM_AssignStudent(DriverFactory.getDriver());
		//picoDepInj.assignStudent.clickOnUserBtn();
		Assert.assertEquals(picoDepInj.assignStudent.getUserPageTitle(),"Manage User");
	}

	@When("Admin clicks Assign Student button")
	public void admin_clicks_assign_student_button() {
		picoDepInj.assignStudent.clickOnAssignStudentBtn();

	}

	@Then("Admin should see a pop up open for assign student details with empty form along with Save and Cancel button")
	public void admin_should_see_a_pop_up_open_for_assign_student_details_with_empty_form_along_with_save_and_cancel_button(){
		Assert.assertEquals(picoDepInj.assignStudent.getAssignStudentTitile(),"Assign Student");
		
		Assert.assertEquals(picoDepInj.assignStudent.UserRole_GetText(),"User Role");
		
		Assert.assertEquals(picoDepInj.assignStudent.UserRole_inputBoxIsDisplayed(),true);

		Assert.assertEquals(picoDepInj.assignStudent.StudentEmailId_GetText(),"Student Email Id");

		Assert.assertEquals(picoDepInj.assignStudent.getStudentEmailIdTextBox_Text(),"Select Email ID");
		
		Assert.assertEquals(picoDepInj.assignStudent.Program_Name_GetText(),"Program Name");

		Assert.assertEquals(picoDepInj.assignStudent.textInside_Program_NameInputBox(),true);
		
		Assert.assertEquals(picoDepInj.assignStudent.Batch_Name_GetText(),"Batch Name");

		Assert.assertEquals(picoDepInj.assignStudent.textInside_Batch_NameInputBox(),true);
		
		Assert.assertEquals(picoDepInj.assignStudent.cancelBtnIsDisplyed(),true);

		Assert.assertEquals(picoDepInj.assignStudent.saveButtonIsDisplyed(),true);
		
		Assert.assertEquals(picoDepInj.assignStudent.closeButtonIsDisplyed(),true);

	}
	
	@Then("Admin should see User Role as R03,StudentEmailId,ProgramName,BatchName and Status with respective input boxes.")
	public void admin_should_see_user_role_as_r03_student_email_id_program_name_batch_name_and_status_with_respective_input_boxes() {
		
		Assert.assertEquals(picoDepInj.assignStudent.textInsideUser_RoleInputBox(),"R03");
		
		Assert.assertEquals(picoDepInj.assignStudent.getStudentEmailIdTextBox_Text(),"Select Email ID");

		Assert.assertEquals(picoDepInj.assignStudent.textInside_Program_NameInputBox(),true);

		Assert.assertEquals(picoDepInj.assignStudent.textInside_Batch_NameInputBox(),true);

		Assert.assertEquals(picoDepInj.assignStudent.StatusIsDisplyed(),true);

}
	
	@Then("Admin should see drop down boxes with valid data for Student Email id,Program Name and Batch Name")
	public void admin_should_see_drop_down_boxes_with_valid_data_for_student_email_id_program_name_and_batch_name() {
	   
		
		
	}
	
	@Then("admin should see two radio button for Status")
	public void admin_should_see_two_radio_button_for_status() {
		Assert.assertEquals(picoDepInj.assignStudent.statusRadiobuttonIsDisplayed(),true);
 
	}
	
	//from here starts Scenario 5 
	@Given("Admin is in Assign Student details pop up page")
	public void admin_is_in_assign_student_details_pop_up_page() {
		picoDepInj.assignStudent= new POM_AssignStudent(DriverFactory.getDriver());
		picoDepInj.assignStudent.clickOnAssignStudentBtn();
		
	}

	@When("Admin clicks {string} button with entering any data")
	public void admin_clicks_button_with_entering_any_data(String string)  {
		picoDepInj.assignStudent.ActiveRadioBtn.click();
		picoDepInj.assignStudent.clickOnSaveBtn();
		
	}

	@Then("Admin gets a Error message alert")
	public void admin_gets_a_error_message_alert() {
		Assert.assertEquals(picoDepInj.assignStudent.StudentEmailId_ErrMsg.getText(),"User Email Id is required.");
		Assert.assertEquals(picoDepInj.assignStudent.ProgramName_ErrMsg.getText(),"Program Name is required.");
		Assert.assertEquals(picoDepInj.assignStudent.BatchName_ErrMsg.getText(),"Batch Name is required.");			
		
	}
	
	@When("Admin clicks {string} button without entering Student Email id")
	public void admin_clicks_button_without_entering_student_email_id(String string) {
		picoDepInj.assignStudent.clickOnSaveBtn();
 
	}

	@Then("Admin gets a Error message alert as {string}")
	public void admin_gets_a_error_message_alert_as(String string) {
	Assert.assertEquals(picoDepInj.assignStudent.StudentEmailId_ErrMsg.getText(),"User Email Id is required.");

	}
	@When("Admin clicks {string} button without selecting program")
	public void admin_clicks_button_without_selecting_program(String string) {
		picoDepInj.assignStudent.clickOnSaveBtn();
		
	}

	@Then("Admin gets a Error message alert as Program is required.")
	public void admin_gets_a_error_message_alert_as_program_is_required() {
		Assert.assertEquals(picoDepInj.assignStudent.ProgramName_ErrMsg.getText(),"Program Name is required.");
	
	}
	
	@When("Admin clicks {string} button without selecting batch")
	public void admin_clicks_button_without_selecting_batch(String string) {
		picoDepInj.assignStudent.clickOnSaveBtn();

	}

	@Then("Admin gets a Error message alert as Batch is required")
	public void admin_gets_a_error_message_alert_as_batch_is_required() {
		Assert.assertEquals(picoDepInj.assignStudent.BatchName_ErrMsg.getText(),"Batch Name is required.");			

	}
	@When("Admin clicks {string} button without giving status")
	public void admin_clicks_button_without_giving_status(String string) {
		picoDepInj.assignStudent.clickOnSaveBtn();
  
	}

	@Then("Admin gets a Error message alert as Status is required")
	public void admin_gets_a_error_message_alert_as_status_is_required() {
		Assert.assertEquals(picoDepInj.assignStudent.Status_ErrMsg.getText(),"Status is required.");			

	}
	
	@When("Admin clicks Cancel\\/Close\\(X) Icon on Assign Student form")
	public void admin_clicks_cancel_close_x_icon_on_assign_student_form() {
		picoDepInj.assignStudent.clickOnCloseBtn();

	}

	@Then("Assign Student popup window should be closed without saving")
	public void assign_student_popup_window_should_be_closed_without_saving() {
		Assert.assertEquals(picoDepInj.assignStudent.getUserPageTitle(),"Manage User");			

	}
	
	@And("Admin clicks on Submit button")
	public void clicks_on_submit_button() throws InterruptedException {
		picoDepInj.assignStudent.clickOnSubmitBtn();
	}

	@Given("Admin is on  User details pop up")
	public void admin_is_on_user_details_pop_up() {
		picoDepInj.assignStudent= new POM_AssignStudent(DriverFactory.getDriver());

		Assert.assertEquals(picoDepInj.assignStudent.getUserPageTitle(),"Manage User");	
		picoDepInj.assignStudent.clickOnAddnewuserBtn();
		

	}

	@When("Admin enters mandatory fields with User role status R03  {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}{string},{string},{string},{string}")
	public void admin_enters_mandatory_fields_with_user_role_status_r03(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12, String string13, String string14) {
		picoDepInj.assignStudent.entermandatoryfields(string,string2,string3,string4,string5,string6,string7,string8,string9,string10,string11,string12,string13,string14);
  
	}
	
	@When("Enter all the required fields with valid values and  click Save button {string},{string}")
	public void enter_all_the_required_fields_with_valid_values_and_click_save_button( String string, String string2) throws InterruptedException {
	    
		picoDepInj.assignStudent.EnterMandatoryFieldsForAssignStudent(string, string2);

	}

	@Then("Admin gets a message Successfully Student Assigned alert")
	public void admin_gets_a_message_alert() {
		Assert.assertEquals(picoDepInj.assignStudent.alertmesgForAssignStudent(),"User has been successfully assigned/Updated to Program/Btch(es)");			
	    
	}
	
	

}
